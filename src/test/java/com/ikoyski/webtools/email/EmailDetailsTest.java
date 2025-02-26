package com.ikoyski.webtools.email;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.ikoyski.webtools.email.dto.EmailDetails;

@SpringBootTest
@ActiveProfiles("test")
class EmailDetailsTest {

    @Test
    @DisplayName("EmailDetailsTest.emailDetailsSuccess()")
    void emailDetailsSuccess() {
        // given
        final String RECIPIENT = "a@a.aa";
        final String MSGBODY = "Test Msg Body";
        final String SUBJECT = "Test Subject";
        final String ATTACHEMENT = "test.txt";
        EmailDetails emailDetails = new EmailDetails();

        // when
        emailDetails.setRecipient(RECIPIENT);
        emailDetails.setMsgBody(MSGBODY);
        emailDetails.setSubject(SUBJECT);
        emailDetails.setAttachement(ATTACHEMENT);

        // then
        Assertions.assertEquals(emailDetails.getRecipient(), RECIPIENT);
        Assertions.assertEquals(emailDetails.getMsgBody(), MSGBODY);
        Assertions.assertEquals(emailDetails.getSubject(), SUBJECT);
        Assertions.assertEquals(emailDetails.getAttachement(), ATTACHEMENT);

    }

}
