package com.ikoyski.webtools.email.service;

import com.ikoyski.webtools.email.dto.EmailDetails;

import jakarta.mail.MessagingException;

public interface EmailService {

	String sendMail(EmailDetails details) throws MessagingException;

}
