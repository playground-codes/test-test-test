package test.test.test.mockstubspy;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
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

  @Test(expected = RuntimeException.class)
  public void doNotDriveIfFuelIsNotEnough() {
    // When we need fuel
    when(bmw.needsFuel()).thenReturn(true);
    doThrow(new RuntimeException()).when(bmw).driveTo(anyString());

    // Actually execute
    bmw.driveTo("Some where");
  }

  @Test
  public void interactionTestUsingVerification() {
    final String DESTINATION = "Future";
    bmw.driveTo(DESTINATION);
    bmw.needsFuel();

    verify(bmw).driveTo(DESTINATION);
    verify(bmw).needsFuel();
    verifyNoMoreInteractions(bmw);
  }
}