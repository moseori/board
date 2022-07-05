package me.light.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component	
public class FileCheckTask {
	@Scheduled(cron="0 * * * * *")
	public void checkFile() {
		System.out.println("FileCheckTask 실행중....");
		
	}

}
