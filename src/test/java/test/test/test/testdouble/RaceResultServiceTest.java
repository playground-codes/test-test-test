package test.test.test.testdouble;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import test.test.test.testdouble.RaceResultService.*;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

public class RaceResultServiceTest {
  @Mock
  RaceType horseRace; // a dummy object
  @Mock
  RaceType f1Race; // a dummy object
  @Mock
  Message horseRaceMessage; // a dummy object
  @Mock
  Message f1RaceMessage; // a dummy object
  @Mock
  Client clientA; // a test spy
  @Mock
  Client clientB; // a test spy
  @Mock
  Logger logger; // a test spy

  private RaceResultService raceResultService;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
    raceResultService = new RaceResultService();
  }

  // zero subscribers
  @Test
  public void notSubscribedClientShouldNotReceiveMessage() {
    raceResultService.send(horseRace, horseRaceMessage);
    raceResultService.send(f1Race, f1RaceMessage);

    verifyZeroInteractions(clientA);
    verifyZeroInteractions(clientB);
  }

  // one subscriber
  @Test
  public void subscribedClientShouldReceiveMessage() {
    raceResultService.addSubscriber(horseRace, clientA);
    raceResultService.send(horseRace, horseRaceMessage);

    verify(clientA).receive(horseRaceMessage);
  }

  // two subscribers
  @Test
  public void allSubscribedClientsShouldReceiveMessage() {
    raceResultService.addSubscriber(horseRace, clientA);
    raceResultService.addSubscriber(f1Race, clientB);
    raceResultService.send(horseRace, horseRaceMessage);
    raceResultService.send(f1Race, f1RaceMessage);

    verify(clientA).receive(horseRaceMessage);
    verify(clientB).receive(f1RaceMessage);
  }

  @Test
  public void shouldSendOnlyOneMessageToMultiSubscriber() {
    raceResultService.addSubscriber(horseRace, clientA);
    raceResultService.addSubscriber(horseRace, clientA);

    raceResultService.send(horseRace, horseRaceMessage);

    verify(clientA, times(1)).receive(horseRaceMessage);
  }

  @Test
  public void unsubscribedClientShouldNotReceiveMessage() {
    raceResultService.addSubscriber(horseRace, clientA);
    raceResultService.removeSubscriber(horseRace, clientA);

    raceResultService.send(horseRace, horseRaceMessage);

    verify(clientA, never()).receive(horseRaceMessage);
  }

  @Test
  public void shouldLogEverySentMessages() {
    raceResultService.setLogger(logger);
    raceResultService.send(horseRace, horseRaceMessage);

    verify(logger).log(horseRaceMessage);
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldThrowExceptionWhenUnsubscribedClientTryToUnsubscribe() {
    raceResultService.removeSubscriber(horseRace, clientA);
  }
}