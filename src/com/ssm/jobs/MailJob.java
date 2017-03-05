package com.ssm.jobs;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssm.email.MailUtil;


public class MailJob {
	@Autowired
	MailUtil mailUtil;
	
	public void test001(){
		try {
			String from = "xiaochen@mail.com";
			String[] tos = new String[]{"wuritian@mail.com"};
			String subject = "吴日天，今天开黑吗？";
			String text = "晚上solo，谁输了叫爹，然后带儿子开黑。";
			
			mailUtil.sendSimpleMail(from, subject, tos, text);
			System.out.println("发送完成");
		} catch (Exception e) {
			System.out.println("发送失败");
			e.printStackTrace();
		}
		
	}
}
