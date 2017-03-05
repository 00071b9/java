package com.ssm.jobs;

/*
 * JOB 任务
 */
public class MyFirstJob {
	
	public void testJob(){
		String username = this.printMsg();
		System.out.println("this is a job!!" + username + ":最近太菜，开黑把把输");
	}
	
	public String printMsg(){
		return "吴日天";
	}
}
