package test.test.test.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextExtractor {
  private static final String REGEX_PATTERN = "\\D(\\d{3}\\d*)\\D";

  public List<Integer> extractNumber(String text) {
    if (text == null || text.isEmpty()) {
      throw new IllegalArgumentException();
    }

    final Pattern pattern = Pattern.compile(REGEX_PATTERN);
    final Matcher matcher = pattern.matcher(text);
    List<Integer> numbers = null;
    while (matcher.find()) {
      if (numbers == null) {
        numbers = new ArrayList<>();
      }
      numbers.add(Integer.parseInt(matcher.group(1)));
    }
    return numbers;
  }
}
