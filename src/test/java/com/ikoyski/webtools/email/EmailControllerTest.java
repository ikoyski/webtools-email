package com.ikoyski.webtools.email;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.ikoyski.webtools.email.controller.EmailController;
import com.ikoyski.webtools.email.dto.EmailDetails;
import com.ikoyski.webtools.email.service.EmailService;

import jakarta.mail.MessagingException;

@SpringBootTest
@ActiveProfiles("test")
class EmailControllerTest {
    
    @Autowired
    private EmailController emailController;

    @MockitoBean
    private EmailService emailService; 

    @Test
    @DisplayName("EmailControllerTest.sendMailSuccess()")
    void sendMailSuccess() throws MessagingException {
        // given
        final EmailDetails emailDetails = new EmailDetails();
        emailDetails.setRecipient("a@a.aa");
        emailDetails.setMsgBody("Test");
        emailDetails.setSubject("Test");
        emailDetails.setAttachement("test.txt");

        // when
        emailController.sendMail(emailDetails);

        // then
        verify(emailService).sendMail(emailDetails);
    }

}
