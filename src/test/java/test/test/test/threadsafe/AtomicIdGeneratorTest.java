package test.test.test.threadsafe;

import com.google.code.tempusfugit.concurrency.ConcurrentRule;
import com.google.code.tempusfugit.concurrency.RepeatingRule;
import com.google.code.tempusfugit.concurrency.annotations.Concurrent;
import com.google.code.tempusfugit.concurrency.annotations.Repeating;
import java.util.HashSet;
import java.util.Set;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class AtomicIdGeneratorTest {
  @Rule
  public ConcurrentRule concurrentRule = new ConcurrentRule();
  @Rule
  public RepeatingRule repeatingRule = new RepeatingRule();

  private Set<Long> ids = new HashSet<>(100);
  private IdGenerator idGenerator = new AtomicIdGenerator();

  @Test
  @Concurrent(count = 7)
  @Repeating(repetition = 100)
  public void idsShouldBeUnique() {
    assertTrue(ids.add(idGenerator.nextId()));
  }
}