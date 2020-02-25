package ro.eduardharis.scheduled.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTasks {
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void logCurrentTime() {
        final long memory = Runtime.getRuntime().freeMemory() / 1000000;
        final String os = String.format("%s v%s", System.getProperty("os.name"), System.getProperty("os.version"));
        log.info(String.format("The time is %s | available memory is %s MB | operating system is %S", dateFormat.format(new Date()), memory, os));
    }
}
