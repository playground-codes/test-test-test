package test.test.test.tdd;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.converters.Nullable;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class TextExtractorTest {

  private TextExtractor textExtractor;

  @Before
  public void setup() {
    textExtractor = new TextExtractor();
  }

  @Test(expected = IllegalArgumentException.class)
  @Parameters({"null", ""})
  public void extractNumberShouldThrowExceptionWithIllegalInput(@Nullable String illegalInputText) {
    textExtractor.extractNumber(illegalInputText);
  }

  @Test
  @Parameters({"abc 12", "12adb", "12 34 56dbd"})
  public void extractNumberShouldReturnNullIfThereIsNoNumberHavingAtLeastThreeDigits(
      String notFoundText) {
    List<Integer> numbers = textExtractor.extractNumber(notFoundText);
    assertNull(numbers);
  }

  @Test
  @Parameters(method = "data")
  public void shouldExtractCorrectListOfNumbers(String text, List<Integer> expectedNumbers) {

    List<Integer> numbers = textExtractor.extractNumber(text);
    assertEquals("Number is extracted from " + text + " should be " + expectedNumbers,
        expectedNumbers,
        numbers);
  }

  public Object[][] data() {
    return new Object[][] {
        {"abc 12", null},
        {"12adb", null},
        {"12 34 56dbd", null},
        {"cdefg 345 12bb23", Arrays.asList(345)},
        {"cdefg345678 12bb23", Arrays.asList(345678)},
        {"cdefg 345 12bbb33 678tt", Arrays.asList(345, 678)}};
  }
}