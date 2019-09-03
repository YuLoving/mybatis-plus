package cn.nj.ccq.SpringTask;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * spring自带的定时任务功能@EnableScheduling
 * @author zty
 */
@Component
@EnableScheduling
@EnableAsync
public class ScheduledTasks {
	
	/**
	 * Spring3.0之后就实现了自己的定时任务，而且非常简单.在启动类上加 @EnableScheduling 注解开启定时任务支持
	 */
	@Scheduled(cron = "0/1 * * * * ?")//每隔1秒执行一次
	@Async
	public void task1() throws Exception {
		System.out.println("开始时间"+time()+"====开始执行第一个任务-->START");
		Thread.sleep(3000);//线程停止3s
		System.out.println("结束时间"+time()+"====结束执行第一个任务-->END");
		
	}
	
	
	
	/**
	 * 但是现在有一个问题，这个业务最少要执行3秒，可是定时是每秒执行，现在是同步执行只有等上一个定时任务执行完才会执行下一次任务，
	 * 所以现在的控制台输出是下图，前一次执行完执行下一次，会一直等着，我们如果有需求要让他异步执行，不管上次执行完没有都要执行新的任务
	 * 
	 * 
	 *  	实现定时任务的异步处理，在启动类上加 @EnableAsync 注解开启支持异步
			在需要实现异步的方法上加 @Async 开启异步即可
	 */
	
	
	
	
	private static String time() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = format.format(new Date());
		return time;
	}
	
}
