package test.test.test;

import java.util.HashMap;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HashMapTest {

  private HashMap map;

  @Before
  public void setup() {
    map = new HashMap();
  }

  @Test
  public void shouldGetValueAfterPut() {
    map.put("id123", 123);

    assertEquals(1, map.size());
    assertEquals(123, map.get("id123"));
  }

  @Test
  public void shouldReplaceOldValue() {
    map.put("id123", 123);
    map.put("id123", 456);

    assertEquals(1, map.size());
    assertEquals(456, map.get("id123"));
  }

  @Test
  public void shouldClearAllItems() {
    map.put("id123", 123);
    map.put("id456", 456);
    assertEquals(2, map.size());
    map.clear();
    assertEquals(0, map.size());
  }

  @Test
  public void keyCanBeNull() {
    map.put(null, "new object");
    assertEquals(1, map.size());
    assertEquals("new object", map.get(null));
  }
}
