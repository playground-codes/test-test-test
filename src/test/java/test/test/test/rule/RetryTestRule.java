package test.test.test.rule;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * A custom rule to retry a failing test.
 */
public class RetryTestRule implements TestRule {

  @Override public Statement apply(Statement base, Description description) {
    return new Statement() {
      @Override public void evaluate() throws Throwable {
        try {
          base.evaluate();
          return;
        } catch (AssertionError e) {
          base.evaluate();
          return;
        }
      }
    };
  }
}
