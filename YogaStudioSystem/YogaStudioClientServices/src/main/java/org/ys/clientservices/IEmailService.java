package org.ys.clientservices;

import org.ys.commons.Registration;

public interface IEmailService {
	public void sendMail(String dear, String content,String[] to);
	public void addRegistration(Registration registration);
	public void enableUser(String registrationID);
}