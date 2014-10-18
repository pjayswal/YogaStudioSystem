package org.ys.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAdvice {
	private static Logger logger=Logger.getLogger(LoggingAdvice.class);
	@Before("execution(* org.ys.services.*Service.*(..))")
	public void logCustomerServiceMethod(JoinPoint joinPoint){
		logger.info(joinPoint.getSignature().getName());
	}
}

