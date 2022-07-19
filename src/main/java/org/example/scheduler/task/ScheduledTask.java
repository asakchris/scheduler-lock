package org.example.scheduler.task;

import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.core.LockAssert;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ScheduledTask {

  @Scheduled(initialDelayString = "PT15S", fixedDelayString = "PT1M")
  @SchedulerLock(name = "task1", lockAtMostFor = "PT2M", lockAtLeastFor = "PT10S")
  public void task1() {
    LockAssert.assertLocked();
    log.info("Task 1 started");
    try {
      Thread.sleep(61 * 1000);
    } catch (InterruptedException e) {
      log.error("InterruptedException", e);
    }
    log.info("Task 1 completed");
  }
}
