package lc.cds.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 
 * Spring will create task executor to process the scheudling tasks
 *
 */
@Component
public class ScheduledTasks {
	
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    /**
     * fixedRate = 5000 : every 5000ms
     * fixedDelay = 5000: run again after 5000ms when the task is completed
       cron job style: cron = "5 * * * * *"/ : run every 5 seconds 
     */
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        System.out.println(String.format("Scheduler Running >>> The time is now [%s]", dateFormat.format(new Date())));
    }
    
    @Scheduled(cron = "*/5 * * * * *")
    public void reportCurrentTime2() {
        System.out.println(String.format("Scheduler Running 2 >>> The time is now [%s]", dateFormat.format(new Date())));
    }    

}
