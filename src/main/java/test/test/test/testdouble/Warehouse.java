package test.test.test.testdouble;

public interface Warehouse {
  /**
   * Adds a number of a specific product into warehouse.
   * @param productName product name
   * @param quantity the number of products
   * For example, you want to put 40 wooden tables into warehouse.
   * warehouse.add("Wooden Table", 40).
   */
  void add(String productName, int quantity);

  /**
   * Removes a number of a specific product from ware house.
   * @param productName product name
   * @param quantity the number of products
   */
  void remove(String productName, int quantity);

  /**
   * Retrieves the current number of a specific product.
   * @param productName product name
   * @return how many the product quantity is in warehouse
   */
  int getInventory(String productName);
}
