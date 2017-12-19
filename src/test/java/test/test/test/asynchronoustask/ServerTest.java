package test.test.test.asynchronoustask;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import org.awaitility.Awaitility;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import test.test.test.asynchronoustask.Server.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ServerTest {
  ExecutorService executorService;
  @Mock TaskService taskService;
  @Mock Request request;
  @Mock Task task;
  Collection<Task> tasks;

  private Server server;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
    executorService = Executors.newSingleThreadExecutor();
    tasks = Collections.singletonList(task);
    server = new Server(executorService, taskService);
  }

  @Test
  public void serveTestUsingTryCatch() throws InterruptedException {
    when(request.getTasks()).thenReturn(tasks);

    server.serve(request);

    boolean handleMethodInvoked = false;
    for (int i = 0; i < 11; i++) {
      try {
        verify(taskService).handle(task);
        handleMethodInvoked = true;
      } catch (AssertionError error) {
        // No need to handle anything
      }
      Thread.sleep(100);
    }

    assertTrue(handleMethodInvoked);
  }

  @Test
  public void serveTestUsingAwaitility() {
    when(request.getTasks()).thenReturn(tasks);

    server.serve(request);

    Awaitility.await()
        .atMost(1100, TimeUnit.MILLISECONDS)
        .with().pollInterval(100, TimeUnit.MILLISECONDS)
        .until(() -> {
          try {
            verify(taskService).handle(task);
            return true;
          } catch (AssertionError error) {
            return false;
          }
        });
  }

  @Test
  public void serveTestUsingSynchronousExecutor() {
    executorService  = new SynchronousExecutorService();
    server = new Server(executorService, taskService);

    when(request.getTasks()).thenReturn(tasks);

    server.serve(request);

    verify(taskService).handle(task);
  }
}