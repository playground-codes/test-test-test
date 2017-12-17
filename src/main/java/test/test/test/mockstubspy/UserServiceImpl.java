package test.test.test.mockstubspy;

public class UserServiceImpl {

  private UserDAO userDAO;
  private SecurityService securityService;

  public UserServiceImpl(UserDAO userDAO, SecurityService securityService) {
    this.userDAO = userDAO;
    this.securityService = securityService;
  }

  public void assignPassword(User user) {
    String passwordMd5 = securityService.md5(user.getPassword());
    user.setPassword(passwordMd5);
    userDAO.updateUser(user);
  }

  interface User {
    String getPassword();

    void setPassword(String password);
  }

  interface UserDAO {
    void updateUser(User user);
  }

  interface SecurityService {
    String md5(String password);
  }
}
