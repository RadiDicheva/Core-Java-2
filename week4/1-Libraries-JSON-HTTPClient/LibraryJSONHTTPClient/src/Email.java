import org.apache.commons.mail.*;

public class Email {
	
	public static void main(String[] args) throws EmailException {
		// Create the attachment
		  EmailAttachment attachment = new EmailAttachment();
		  attachment.setPath("C:/Users/Radi/Desktop/KoNe.gif");
		  attachment.setDisposition(EmailAttachment.ATTACHMENT);
		  attachment.setDescription("This is a gif of vampire horse");
		  attachment.setName("Vampire horse");

		  // Create the email message
		  MultiPartEmail email = new MultiPartEmail();
		  email.setAuthenticator(new DefaultAuthenticator("radchety", ""));
		  email.setHostName("smtp.gmail.com");
		  email.setSmtpPort(465);
		  email.setSSLOnConnect(true);
		  email.setFrom("radchety@gmail.com", "Me");
		  email.setSubject("The gif");
		  email.setMsg("Here is the gif you wanted");
		  email.addTo("radidicheva@abv.bg", "You");
		  email.setDebug(true);
		  
		  // add the attachment
		  email.attach(attachment);

		  // send the email
		  email.send();
	}
}
