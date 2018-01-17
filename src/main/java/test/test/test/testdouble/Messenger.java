package test.test.test.testdouble;

public class Messenger {

  private TemplateEngine templateEngine;
  private MailServer mailServer;

  public Messenger(TemplateEngine templateEngine, MailServer mailServer) {
    this.templateEngine = templateEngine;
    this.mailServer = mailServer;
  }

  public void sendMessage(Client client, Template template) {
    String msgContent = templateEngine.prepareMessage(template, client);
    mailServer.send(client.getEmail(), msgContent);
  }

  public interface Client {
    String getEmail();
  }

  public interface Template {
  }

  public interface TemplateEngine {
    String prepareMessage(Template template, Client client);
  }

  public interface MailServer {
    void send(String email, String msgContent);
  }
}
