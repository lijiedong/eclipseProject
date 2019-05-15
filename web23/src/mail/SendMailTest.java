package mail;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public class SendMailTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			MailUtils.sendMail("lucy@dlj.com", "I'm angry,just because I felt that I'm not been respected!");
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
