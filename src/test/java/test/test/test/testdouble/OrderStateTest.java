package test.test.test.testdouble;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class OrderStateTest {
  private static final String TABLE = "Wooden table";
  private Warehouse warehouse;

  @Before
  public void setup() {
    warehouse = new WarehouseImpl();
    warehouse.add(TABLE, 50);
  }

  @Test
  public void orderShouldBeFilledIfEnoughInWarehouse() {
    Order order = new Order(TABLE, 50);

    order.fill(warehouse);

    assertThat(order.isFilled(), equalTo(true));
    assertThat(warehouse.getInventory(TABLE), equalTo(0));
  }

  @Test
  public void orderDoesNotRemoveIfNotEnoughInWarehouse() {
    Order order = new Order(TABLE, 51);

    order.fill(warehouse);

    assertThat(order.isFilled(), equalTo(false));
    assertThat(warehouse.getInventory(TABLE), equalTo(50));
  }
}