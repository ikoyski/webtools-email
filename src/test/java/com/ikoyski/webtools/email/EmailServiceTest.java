package com.ikoyski.webtools.email;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.ActiveProfiles;

import com.ikoyski.webtools.email.dto.EmailDetails;
import com.ikoyski.webtools.email.service.EmailServiceImpl;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@SpringBootTest
@ActiveProfiles("test")
class EmailServiceTest {

    @InjectMocks
    private EmailServiceImpl emailServiceImpl;

    @Mock
    private JavaMailSender javaMailSender;

    //@Test
    @DisplayName("EmailServiceTest.sendMailSuccess()")
    void sendMailSuccess() throws MessagingException {
        // given
        final String SENDER = "a@a.aa";
        final String RECIPIENT = "b@b.bb";
        final String MSGBODY = "Test Msg Body";
        final String SUBJECT = "Test Subject";

        // when
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setFrom(SENDER);
        mimeMessageHelper.setTo(RECIPIENT);
        mimeMessageHelper.setText(MSGBODY);
        mimeMessageHelper.setSubject(SUBJECT);
        Mockito.when(javaMailSender.createMimeMessage()).thenReturn(mimeMessage);
        Mockito.when(new MimeMessageHelper(mimeMessage, true)).thenReturn(mimeMessageHelper);

        final EmailDetails emailDetails = new EmailDetails();
        emailDetails.setRecipient(RECIPIENT);
        emailDetails.setMsgBody(MSGBODY);
        emailDetails.setSubject(SUBJECT);

        emailServiceImpl.sendMail(emailDetails);

        // then
        Mockito.verify(javaMailSender).send(mimeMessage);
    }

}
