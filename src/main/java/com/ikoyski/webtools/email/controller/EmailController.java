package com.ikoyski.webtools.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ikoyski.webtools.email.dto.EmailDetails;
import com.ikoyski.webtools.email.service.EmailService;

import jakarta.mail.MessagingException;

@RestController
@RequestMapping("/email")
public class EmailController {

	@Autowired
	private EmailService emailService;

	@PostMapping("/v1")
	public String sendMail(@RequestBody EmailDetails details) throws MessagingException {
		String status = emailService.sendMail(details);
		return status;
	}

}
