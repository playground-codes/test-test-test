package test.test.test.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {

  private Set<String> phones;

  public User() {
    phones = new HashSet<>();
  }

  void addPhone(String phoneNumber) {
    phones.add(phoneNumber);
  }

  List<String> getPhones() {
    return new ArrayList<>(phones);
  }
}
