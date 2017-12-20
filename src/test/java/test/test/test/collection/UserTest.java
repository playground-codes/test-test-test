package test.test.test.collection;

import java.util.List;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class UserTest {

  @Test
  public void shouldReturnUsersPhone() {
    User user = new User();
    user.addPhone("0123 456 789");
    List<String> phones = user.getPhones();
    assertThat(phones, notNullValue());
    assertThat(phones.size(), equalTo(1));
    assertThat(phones, contains("0123 456 789"));
  }
}
