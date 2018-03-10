package com.spring.app.utils;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;

@Controller
public class EmailController {
    
    @Autowired
    private JavaMailSender sender;
    
    public void sendEmail(String emailId,String text) {

    	try {

    		MimeMessage message = sender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);
            
            helper.setTo(emailId);
            helper.setText(text);
            helper.setSubject("Patiyati Team Notification");
            
            sender.send(message);
		
    	}catch(Exception e) {
    		e.printStackTrace();
		}
	}
    
    public void sendEmailWithAttachment(String emailId,String text) throws Exception{

    	try {
    	   	MimeMessage message = sender.createMimeMessage();
            // Enable the multipart flag!
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            helper.setTo(emailId);
            helper.setText(text);
            helper.setSubject("Hi");
           // String file = "logo.png";
            //helper.addAttachment("cat.jpg", file);
            sender.send(message);   		
    	} catch(Exception e) {
    		
    	}
 
    }
}