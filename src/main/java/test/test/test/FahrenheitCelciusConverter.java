package test.test.test;

public class FahrenheitCelciusConverter {
  public static long toFahrenheit(long celcius) {
     return celcius * 9 / 5 + 32;
  }

  public static long toCelcius(long fahrenheit) {
      return (fahrenheit - 32) * 5 / 9;
  }
 }
