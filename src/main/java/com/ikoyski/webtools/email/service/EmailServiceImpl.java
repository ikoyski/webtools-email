package com.ikoyski.webtools.email.service;

import java.io.File;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.ikoyski.webtools.email.dto.EmailDetails;

@Service
public class EmailServiceImpl implements EmailService {

	@Value("${email.from}")
	private String sender;

	private JavaMailSender javaMailSender;
	private ObservationRegistry observationRegistry;

	public EmailServiceImpl(JavaMailSender javaMailSender, ObservationRegistry observationRegistry) {
		this.javaMailSender = javaMailSender;
		this.observationRegistry = observationRegistry;
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

		Observation.createNotStarted("resend.smtp.send", observationRegistry)
				.contextualName("send email via Resend SMTP")
				.lowCardinalityKeyValue("mail.provider", "resend")
				.observe(() -> javaMailSender.send(message));

		return "Mail Sent Successfully";

	}

}