package test.test.test.threadsafe;

public class AtomicIdGenerator implements IdGenerator {
  private static Long nextId = System.currentTimeMillis();

  private static final Object lock = new Object();
  @Override public Long nextId() {
    synchronized (lock) {
      return nextId++;
    }
  }
}
