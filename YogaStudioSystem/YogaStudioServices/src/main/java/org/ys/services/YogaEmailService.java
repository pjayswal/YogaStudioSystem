package org.ys.services;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.ys.clientservices.IEmailService;
import org.ys.commons.Registration;
import org.ys.dao.RegistrationDAO;

@Service
public class YogaEmailService implements IEmailService {
	@Autowired
	private SimpleMailMessage emailTemplate;
	@Autowired
	private JavaMailSenderImpl javaMailSender;
	@Autowired
	private RegistrationDAO registrationDAO;
	
	public void sendMail(String dear, String content, String[] to) {
		String fromEmail = emailTemplate.getFrom();
		String[] toEmail = to;
		String emailSubject = emailTemplate.getSubject();
		String emailBody = String
				.format(emailTemplate.getText(), dear, content);
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
			helper.setFrom(fromEmail);
			helper.setTo(toEmail);
			helper.setSubject(emailSubject);
			helper.setText(emailBody);
			/*
			 * uncomment the following lines for attachment FileSystemResource
			 * file = new FileSystemResource("attachment.jpg");
			 * helper.addAttachment(file.getFilename(), file);
			 */
			javaMailSender.send(mimeMessage);
			System.out.println("Mail sent successfully.");
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

	public void addRegistration(Registration registration) {
		registrationDAO.create(registration);
		
	}

	public void enableUser(String registrationId) {
		Registration registraion =registrationDAO.get(registrationId);
		registraion.getUser().setEnabled(true);
		registrationDAO.update(registraion);
	}

}