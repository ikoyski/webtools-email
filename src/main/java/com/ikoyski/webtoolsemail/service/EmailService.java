package com.ikoyski.webtoolsemail.service;

import com.ikoyski.webtoolsemail.dto.EmailDetails;

public interface EmailService {

	String sendSimpleMail(EmailDetails details);

	String sendMailWithAttachment(EmailDetails details);

}
