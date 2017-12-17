package test.test.test.mockstubspy;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

public class CarTest {

  private Car bmw = Mockito.mock(Car.class);

  @Test
  public void checkStupidThing() {
    assertTrue("BMW should be a car", bmw != null);

    doReturn(false).when(bmw).needsFuel();
    assertFalse(bmw.needsFuel());

    when(bmw.getEngineTemperature()).thenReturn(50.0);
    assertEquals(50.0, bmw.getEngineTemperature(), 0.0);
  }
}