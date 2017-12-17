package test.test.test.mockstubspy;

import org.junit.Test;
import test.test.test.mockstubspy.UserServiceImpl.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserServiceImplTest {

  @Test
  public void shouldUserGetNewPasswordAfterBeingAssigned() {
    User user = mock(User.class); // spy
    UserDAO userDAO = mock(UserDAO.class); // dummy
    SecurityService securityService = mock(SecurityService.class); // stub
    UserServiceImpl userService = new UserServiceImpl(userDAO, securityService);

    when(user.getPassword()).thenReturn("current");
    when(securityService.md5(user.getPassword())).thenReturn("new md5");

    userService.assignPassword(user);

    verify(user).setPassword("new md5");
  }

  @Test
  public void shouldUserDAOUpdateUserAfterPasswordIsAssigned() {
    User user = mock(User.class); // dummy
    UserDAO userDAO = mock(UserDAO.class); // spy
    SecurityService securityService = mock(SecurityService.class); // dummy
    UserServiceImpl userService = new UserServiceImpl(userDAO, securityService);

    userService.assignPassword(user);

    verify(userDAO).updateUser(user);
  }
}