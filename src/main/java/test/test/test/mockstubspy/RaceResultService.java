package test.test.test.mockstubspy;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * A service which sends the race results to all subscribed clients.
 */
public class RaceResultService {

  private Map<RaceType, Set<Client>> subscribeList;
  private Logger logger;

  public RaceResultService() {
    subscribeList = new HashMap<>();
  }

  public void setLogger(Logger logger) {
    this.logger = logger;
  }

  public void addSubscriber(RaceType raceType, Client client) {
    if (subscribeList.containsKey(raceType)) {
      subscribeList.get(raceType).add(client);
    } else {
      Set<Client> clients = new LinkedHashSet<>();
      clients.add(client);
      subscribeList.put(raceType, clients);
    }
  }

  public void removeSubscriber(RaceType raceType, Client client) {
    if (subscribeList.containsKey(raceType)) {
      if (subscribeList.get(raceType).contains(client)) {
        subscribeList.get(raceType).remove(client);
      } else {
        throw new IllegalArgumentException(client + " is not subscribed yet.");
      }
    } else {
      throw new IllegalArgumentException(client + " is not subscribed yet.");
    }
  }

  public void send(RaceType raceType, Message message) {
    if (subscribeList.containsKey(raceType)) {
      for (Client client : subscribeList.get(raceType)) {
        client.receive(message);
      }
    }
    if (logger != null) {
      logger.log(message);
    }
  }

  public interface RaceType {

  }

  public interface Client {
    void receive(Message message);
  }

  public interface Message {

  }

  public interface Logger {
    void log(Message message);
  }
}
