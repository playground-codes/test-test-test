package test.test.test.testdouble;

import java.security.InvalidParameterException;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class WarehouseImplTest {
  private static final String TABLE = "Wooden table";
  private Warehouse warehouse;

  @Before
  public void setup() {
    warehouse = new WarehouseImpl();
  }

  @Test
  public void addNewProduct() {
    warehouse.add(TABLE, 20);

    assertThat(warehouse.getInventory(TABLE), equalTo(20));
  }

  @Test
  public void addMoreToExistingProduct() {
    // Given
    warehouse.add(TABLE, 20);

    // When
    warehouse.add(TABLE, 30);

    // Then
    assertThat(warehouse.getInventory(TABLE), equalTo(50));
  }

  @Test(expected = WarehouseImpl.NoProductException.class)
  public void getInventoryShouldThrowExceptionIfProductDoesNotExist(){
    warehouse.getInventory(TABLE);
  }

  @Test(expected = WarehouseImpl.NoProductException.class)
  public void removeProductShouldThrowExceptionIfProductDoesNotExist() {
    warehouse.remove(TABLE, 10);
  }

  @Test(expected = InvalidParameterException.class)
  public void removeProductShouldThrowExceptionIfProductNumberIsNotEnough() {
    warehouse.add(TABLE, 20);

    warehouse.remove(TABLE, 21);
  }

  @Test
  public void removeProduct() {
    warehouse.add(TABLE, 20);

    warehouse.remove(TABLE, 15);

    assertThat(warehouse.getInventory(TABLE), equalTo(5));
  }
}