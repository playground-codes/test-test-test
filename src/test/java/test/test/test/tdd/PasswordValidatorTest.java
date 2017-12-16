package test.test.test.tdd;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PasswordValidatorTest {

  private PasswordValidator passwordValidator;

  @Before
  public void setup() {
    passwordValidator = new PasswordValidator();
  }

  @Test
  public void passwordShouldNotBeNull() {
    assertFalse(passwordValidator.isValid(null));
  }

  @Test
  public void passwordShouldHaveAtLeastEightCharacters() {
    String password6 = "abcdEF";
    String password8 = "abcdefGH";
    String password10 = "abcdefghIK";

    assertFalse(passwordValidator.isValid(password6));
    assertTrue(passwordValidator.isValid(password8));
    assertTrue(passwordValidator.isValid(password10));
  }

  @Test
  public void passwordShouldHaveAtLeastUppercase() {
    String allLowerCase = "abcdefghik";
    String oneUpperCase = "abcdefghiK";
    String moreUpperCase = "abcdefgHIK";

    assertFalse(passwordValidator.isValid(allLowerCase));
    assertTrue(passwordValidator.isValid(oneUpperCase));
    assertTrue(passwordValidator.isValid(moreUpperCase));
  }

  @Test
  public void passwordShouldHaveAtLeastLowercase() {
    String allUpperCase = "ABCDEFGHIK";
    String oneLowerCase = "aBCDEFGHIK";
    String moreLowerCase = "abCDEFGHIK";

    assertFalse(passwordValidator.isValid(allUpperCase));
    assertTrue(passwordValidator.isValid(oneLowerCase));
    assertTrue(passwordValidator.isValid(moreLowerCase));
  }
}
