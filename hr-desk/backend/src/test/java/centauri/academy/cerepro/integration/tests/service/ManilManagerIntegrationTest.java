/**
 * 
 */
package centauri.academy.cerepro.integration.tests.service;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.proxima.common.mail.MailUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import centauri.academy.cerepro.CeReProBackendApplication;

/**
 * @author maurizio
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CeReProBackendApplication.class)
public class ManilManagerIntegrationTest {

	public static final Logger logger = LoggerFactory.getLogger(ManilManagerIntegrationTest.class);
	
	
    private static Properties props;
	
	private static String[] mailCcRecipient;
	private static String[] mailCcnRecipient;
	private static final String CHARSET = "text/html; charset=utf-8";
	private static String EMAIL_ACCOUNT_PWD;
	
	
	@Before
	public void loadProps() throws IOException {
		props = new Properties();
		props.load(MailUtility.class.getClassLoader().getResourceAsStream(MailUtility.MAILPROPS_FILENAME));
		mailCcnRecipient = (props.getProperty(MailUtility.MAIL_CCN_RECIPIENT_KEY)).split(",");
		mailCcRecipient = (props.getProperty(MailUtility.MAIL_CC_RECIPIENT_KEY)).split(",");
		EMAIL_ACCOUNT_PWD = props.getProperty(MailUtility.PWD_KEY);
		
		logger.info("loadProps - mailCcnRecipient..length: " + mailCcnRecipient.length + " - mailCcRecipient..length: " + mailCcRecipient.length);
	}
	
	@Test
	public void testSendSimpleMailSentOk(){
		
//		assertEquals(0,this.newsLetterMessageService.getAll().size());
//		
//		int numEntitiesCreated=4;
//		for(int cont=0; cont<numEntitiesCreated ;cont++) {
//			
//			this.newsLetterMessageService.create(new NewsLetterMessage(MESSAGE_SUBJECT_TEST_FIRST+cont,MESSAGE_TEXT_TEST_FIRST+cont));
//			logger.info(cont+"");
//		}
//		assertEquals(numEntitiesCreated,this.newsLetterMessageService.getAll().size());
		logger.info("testSendSimpleMailSentOk - START");
		boolean sent = MailUtility.sendSimpleMail("maurizio.franco@ymail.com", "cerepro.hr.backend integration test", "cerepro.hr.backend integration test - DESCRIPTION");
		logger.info("testSendSimpleMailSentOk - END - sent: " + sent);
		assertTrue(sent);
		
	}
	
}
