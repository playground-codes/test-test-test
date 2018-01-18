package test.test.test.testdouble;

import java.security.InvalidParameterException;
import java.util.HashMap;

public class WarehouseImpl implements Warehouse {
  /**
   * A map contains all products in warehouse and the corresponding number of each product.
   */
  private HashMap<String, Integer> products;

  public WarehouseImpl() {
    products = new HashMap<>();
  }

  @Override public void add(String productName, int quantity) {
    if (products.containsKey(productName)) {
      int currentNumber = products.get(productName);
      currentNumber += quantity;
      products.replace(productName, currentNumber);
    } else {
      products.put(productName, quantity);
    }
  }

  @Override public void remove(String productName, int quantity) throws InvalidParameterException {
    if (products.containsKey(productName)) {
      int currentNumber = products.get(productName);
      if (currentNumber < quantity) {
        throw new InvalidParameterException(String.format(
            "Not enough number of product %s in warehouse. Only has %d, but require %d",
            productName, currentNumber, quantity));
      } else {
        currentNumber -= quantity;
        products.replace(productName, currentNumber);
      }
    } else {
      throw new NoProductException(productName);
    }
  }

  @Override public int getInventory(String productName) {
    if (products.containsKey(productName)) {
      return products.get(productName);
    } else {
      throw new NoProductException(productName);
    }
  }

  public class NoProductException extends InvalidParameterException {
    public NoProductException(String productName) {
      super(String.format("There is no product %s  in warehouse", productName));
    }
  }
}
