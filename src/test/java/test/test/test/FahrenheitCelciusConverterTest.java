package test.test.test;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized.Parameter;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FahrenheitCelciusConverterTest {

  @Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][] {
        {32, 0}, {41, 5}, {212, 100}
    });
  }

  @Parameter()
  public long fahrenheit;

  @Parameter(1)
  public long celcius;

  @Test
  public void shouldConvertCelciusToFahrenheit() {
    assertEquals(fahrenheit, FahrenheitCelciusConverter.toFahrenheit(celcius));
  }

  @Test
  public void shouldConvertFahrenheitToCelcius() {
    assertEquals(celcius, FahrenheitCelciusConverter.toCelcius(fahrenheit));
  }
}