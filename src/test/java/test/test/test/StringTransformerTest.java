package test.test.test;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class StringTransformerTest {

  @Parameters
  public static Collection<String[]> getStrings() {
    return Arrays.asList(new String[][] {
        {"Hello World!", "!dlroW olleH"},
        {"Funny 102", "201 ynnuF"}
    });
  }

  private String text;
  private String reverseText;

  public StringTransformerTest(String text, String reverseText) {
    this.text = text;
    this.reverseText = reverseText;
  }

  @Test
  public void shouldReverseWithoutError() {
    String reverse = StringTransformer.reverse(text);
    assertEquals(reverseText, reverse);
  }
}