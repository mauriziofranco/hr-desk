/**
 * 
 */
package franco.maurizio.hr.desk.com.integration.service;


import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.Properties;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import franco.maurizio.hr.desk.com.CeReProBackendApplication;
//import franco.maurizio.hr.desk.com.CeReProBackendApplication;
import franco.maurizio.hr.desk.com.mail.manager.MailUtility;

/**
  * @author maurizio.franco@ymail.com
 */
//@ExtendWith(SpringExtension.class)

@ExtendWith(SpringExtension.class)
@SpringBootTest (classes = MailManagerIntegrationTest.class)
public class MailManagerIntegrationTest {

	public static final Logger logger = LoggerFactory.getLogger(MailManagerIntegrationTest.class);
	
	
//    private static Properties props;
//	
//	private static String[] mailCcRecipient;
//	private static String[] mailCcnRecipient;
//	private static final String CHARSET = "text/html; charset=utf-8";
//	private static String EMAIL_ACCOUNT_PWD;
	
	
//	@BeforeEach
//	public void loadProps() throws IOException {
//		logger.info("loadProps - START");
////		props = new Properties();
////		props.load(MailUtility.class.getClassLoader().getResourceAsStream(MailUtility.MAILPROPS_FILENAME));
////		mailCcnRecipient = (props.getProperty(MailUtility.MAIL_CCN_RECIPIENT_KEY)).split(",");
////		mailCcRecipient = (props.getProperty(MailUtility.MAIL_CC_RECIPIENT_KEY)).split(",");
////		EMAIL_ACCOUNT_PWD = props.getProperty(MailUtility.PWD_KEY);
//		
////		logger.info("loadProps - mailCcnRecipient..length: " + mailCcnRecipient.length + " - mailCcRecipient..length: " + mailCcRecipient.length);
//		logger.info("loadProps - END");
//	}
	
	@Test
	void testSendSimpleMailSentOk(){		
		logger.info("testSendSimpleMailSentOk - START");
		boolean sent = false ;
//		sent = MailUtility.sendSimpleMail("maurizio.franco@ymail.com", "cerepro.hr.backend integration test", "cerepro.hr.backend integration test - DESCRIPTION");
		logger.info("testSendSimpleMailSentOk - END - sent: " + sent);
		assertTrue(sent);
		
	}
	
}
