package com.ssm.email;

import java.io.IOException;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;

@Component
// 使用Spring继承Javamail发送简单邮件
//
public class MailUtil {
	@Autowired
	private MailSender mailSender;
	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	private Configuration configuration;
	
	// 简单邮件
	public void sendSimpleMail(String from, String subJect, String[] tos, String text) {
		try {
			// 1.创建邮件对象
			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

			// 2.写邮件
			// simpleMailMessage.setSubject("赵日天，今天开黑吗？");//Subject是标题
			// simpleMailMessage.setTo("zhaoritian@ygz.com");//To：收件人；From：发件人
			// simpleMailMessage.setText("晚上solo，谁输了叫爹，然后带儿子开黑。");//Text：邮件主体内容
			simpleMailMessage.setFrom(from);// 发件人
			simpleMailMessage.setSubject(subJect);// Subject是标题
			simpleMailMessage.setTo(tos);// To：收件人；From：发件人
			simpleMailMessage.setText(text);// Text：邮件主体内容

			// 3.发邮件
			mailSender.send(simpleMailMessage);
			System.out.println("发送简单邮件成功！");
		} catch (MailException e) {
			System.out.println("发送简单邮件失败！");
			e.printStackTrace();
		}
	}
	
	public void sendSimpleMail(String from, String[] tos, String subject, String text){
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setTo(tos);
		message.setSubject(subject);
		message.setText(text);
		mailSender.send(message);
	}

	// 附件邮件
	public void sendAttachMail(String from, String[] tos, String subject, String text, String[] attachFiles)
			throws MessagingException, IOException {
		try {
			// 创建多媒体邮件对象
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			// 创建多媒体邮件助手，true：支持多媒体
			MimeMessageHelper mmHelper = new MimeMessageHelper(mimeMessage, true);
			// 设置邮件属性
			mmHelper.setFrom(from);
			mmHelper.setTo(tos);
			mmHelper.setSubject(subject);
			mmHelper.setText(text);
			for (String filePath : attachFiles) {
				ClassPathResource cpr = new ClassPathResource(filePath);// Spring提供的资源操作类
				mmHelper.addAttachment(cpr.getFilename(), cpr.getFile());// 添加附件
			}
			javaMailSender.send(mimeMessage);
			System.out.println("发送附件（媒体）邮件成功！");
		} catch (MailException e) {
			System.out.println("发送附件（媒体）邮件失败！");
			e.printStackTrace();
		}
	}

	// html样式的邮件
	public void sendHtmlMail(String from, String[] tos, String subject, String htmlText) {
		try {
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper mmHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
			mmHelper.setFrom(from);
			mmHelper.setTo(tos);
			mmHelper.setSubject(subject);
			mmHelper.setText(htmlText, true);// true：发送内容为html
			javaMailSender.send(mimeMessage);
			System.out.println("发送HTML邮件成功！");
		} catch (Exception e) {
			System.out.println("发送HTML邮件失败！");
			e.printStackTrace();
		}
	}

	// html样式的邮件,通过Freemarker模板来构建HTML文本
	public void sendHtmlMailByFreemarkerTemple(String from, String[] tos, String subject, String templeName,
			Map<String, Object> date) {
		try {
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper mmHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
			mmHelper.setFrom(from);
			mmHelper.setTo(tos);
			mmHelper.setSubject(subject);
			mmHelper.setText(this.parseTemple(templeName, date), true);// true：发送内容为html
			javaMailSender.send(mimeMessage);
			System.out.println("发送HTMLByFreemark邮件成功！");
		} catch (Exception e) {
			System.out.println("发送HTMLByFreemark邮件失败！");
			e.printStackTrace();
		}
	}

	// 通过ftl模板来构建html字符串
	public String parseTemple(String templeName, Map<String, Object> templeDate) {
		String returnText = "";
		try {
			Template template = configuration.getTemplate(templeName);
			returnText = FreeMarkerTemplateUtils.processTemplateIntoString(template, templeDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnText;
	}

}
