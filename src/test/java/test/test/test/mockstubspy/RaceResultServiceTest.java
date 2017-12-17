package test.test.test.mockstubspy;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import test.test.test.mockstubspy.RaceResultService.*;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class RaceResultServiceTest {
  @Mock
  Message message; // a dummy object
  @Mock
  Client clientA; // a test spy
  @Mock
  Client clientB; // a test spy

  private RaceResultService raceResultService;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
    raceResultService = new RaceResultService();
  }

  // zero subscribers
  @Test
  public void notSubscribedClientShouldNotReceiveMessage() {
    raceResultService.send(message);

    verify(clientA, never()).receive(message);
    verify(clientB, never()).receive(message);
  }

  // one subscriber
  @Test
  public void subscribedClientShouldReceiveMessage() {
    raceResultService.addSubscriber(clientA);
    raceResultService.send(message);

    verify(clientA).receive(message);
  }

  // two subscribers
  @Test
  public void allSubscribedClientsShouldReceiveMessage() {
    raceResultService.addSubscriber(clientA);
    raceResultService.addSubscriber(clientB);

    raceResultService.send(message);

    verify(clientA).receive(message);
    verify(clientB).receive(message);
  }

  @Test
  public void shouldSendOnlyOneMessageToMultiSubscriber() {
    raceResultService.addSubscriber(clientA);
    raceResultService.addSubscriber(clientA);

    raceResultService.send(message);

    verify(clientA, times(1)).receive(message);
  }

  @Test
  public void unsubscribedClientShouldNotReceiveMessage() {
    raceResultService.addSubscriber(clientA);
    raceResultService.removeSubscriber(clientA);

    raceResultService.send(message);

    verify(clientA, never()).receive(message);
  }
}