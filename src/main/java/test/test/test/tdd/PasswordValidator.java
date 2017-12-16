package test.test.test.tdd;


public class PasswordValidator {

  public boolean isValid(String password) {
    if (password == null || password.length() < 8) return false;
    if (password.equals(password.toLowerCase())) return false;
    if (password.equals(password.toUpperCase())) return false;
    return true;
  }
}
