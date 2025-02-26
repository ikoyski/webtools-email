package com.ikoyski.webtools.email.service;

import java.io.File;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.ikoyski.webtools.email.dto.EmailDetails;

@Service
public class EmailServiceImpl implements EmailService {

	@Value("${spring.mail.username}")
	private String sender;

	private JavaMailSender javaMailSender;

	public EmailServiceImpl(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public String sendMail(EmailDetails details) throws MessagingException {

		MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setFrom(sender);
		helper.setTo(details.getRecipient());
		helper.setText(details.getMsgBody());
		helper.setSubject(details.getSubject());
		if (details.getAttachement() != null && !"".equals(details.getAttachement().trim())) {
			FileSystemResource file = new FileSystemResource(new File(details.getAttachement()));
			helper.addAttachment(file.getFilename(), file);
		}
		javaMailSender.send(message);
		return "Mail Sent Successfully";

	}

}
