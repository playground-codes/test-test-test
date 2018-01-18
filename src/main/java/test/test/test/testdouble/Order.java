package test.test.test.testdouble;

import java.security.InvalidParameterException;

public class Order {
  private String productName;
  private int quantity;
  private boolean isFilled;

  public Order(String productName, int quantity) {
    this.productName = productName;
    this.quantity = quantity;
    this.isFilled = false;
  }

  public void fill(Warehouse warehouse) {
    try {
      warehouse.remove(productName, quantity);
      isFilled = true;
    } catch (InvalidParameterException ex) {
      ex.printStackTrace();
    }
  }

  public boolean isFilled() {
    return isFilled;
  }
}
