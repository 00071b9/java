package com.ssm.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ssm.email.MailUtil;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-mybatis.xml")
public class MailTest {
	@Autowired
	MailUtil mailUtil;
	
	@Test
	public void test01(){
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
	
	@Test
	public void testSendAttachMail(){
		try {
			String from = "xiaochen@mail.com";
			String[] tos = new String[]{"wuritian@mail.com"};
			String subject = "赵日天，今天开黑吗？";
			String text = "晚上solo，谁输了叫爹，然后带儿子开黑。";
			String[] attachFiles = new String[]{"6528班12月月考.docx"};
			mailUtil.sendAttachMail(from, tos, subject, text, attachFiles);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSendHtmlMail(){
		try {
			String from = "xiaochen@mail.com";
			String[] tos = new String[]{"wuritian@mail.com","fourg@mail.com"};
			String subject = "4g，今天开黑吗？";
			StringBuffer htmlText = new StringBuffer("<!DOCTYPE html><html><head><meta charset=\"UTF-8\"><title>Insert title here</title></head><body>");
			htmlText.append("这是一个HTML邮件，请点击<a href=\"www.baidu.com\">进行查看详情</a>");
			htmlText.append("</body></html>");
			mailUtil.sendHtmlMail(from, tos, subject, htmlText.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testSendHtmlMailByFreemakerTemple(){
		try {
			String from = "xiaochen@mail.com";
			String[] tos = new String[]{"wuritian@mail.com"};
			String subject = "4g，今天开黑吗？";
			String templeName = "template.ftl";
			Map<String, Object> date = new HashMap<String, Object>();
			date.put("username", "4g");
			mailUtil.sendHtmlMailByFreemarkerTemple(from, tos, subject, templeName, date);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
