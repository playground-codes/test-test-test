package test.test.test.mockstubspy;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * A service which sends the race results to all subscribed clients.
 */
public class RaceResultService {
  private Set<Client> clients;

  public RaceResultService() {
    clients = new LinkedHashSet<>();
  }

  public void addSubscriber(Client client) {
    clients.add(client);
  }

  public void removeSubscriber(Client client) {
    clients.remove(client);
  }

  public void send(Message message) {
    for (Client client : clients) {
      client.receive(message);
    }
  }

  public interface Client {
    void receive(Message message);
  }

  public interface Message {

  }
}
