package test.test.test.mockstubspy;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import test.test.test.mockstubspy.Messenger.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MessengerTest {
  private static final String EMAIL_ADDRESS = "customer@email.com";
  private static final String EMAIL_MSG_CONTENT = "Dear beloved customer.....";

  @Mock
  TemplateEngine templateEngine; //stub

  @Mock
  MailServer mailServer; //stub

  private Messenger messenger;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    messenger = new Messenger(templateEngine, mailServer);
  }

  @Test
  public void constructor() {
    assertNotNull(messenger);
  }

  @Test
  public void sendMessage() {
    Client client = mock(Client.class); // dummy object
    Template template = mock(Template.class); // dummy object
    doReturn(EMAIL_ADDRESS).when(client).getEmail();
    doReturn(EMAIL_MSG_CONTENT).when(templateEngine).prepareMessage(template, client); // specify stub behavior to provide input

    messenger.sendMessage(client, template);

    verify(mailServer).send(EMAIL_ADDRESS, EMAIL_MSG_CONTENT); // test spy to check output
  }
}