package test.test.test;

public class StringTransformer {

  public static String reverse(String s) {
    StringBuilder reversedString = new StringBuilder(s.length());
    for (int i = s.length() - 1; i >= 0; i--) {
      reversedString.append(s.charAt(i));
    }
    return reversedString.toString();
  }
}
