package com.pentasys.ws.java4web.business.service.impl.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggerAspect {

	private static Logger logger = Logger.getLogger(LoggerAspect.class);

	@Pointcut("execution(* de.pentasys.ws.java4web.business.service.impl.aop.AopService.*(..))")
	public void serviceMethods() {

	}

	@Before("serviceMethods()")
	public void beforeMethod() {
		logger.info("before method (by AOP)");
	}

	@Around("serviceMethods()")
	public Object aroundMethod(ProceedingJoinPoint joinpoint) {
		try {
			long start = System.nanoTime();
			Object result = joinpoint.proceed();
			long end = System.nanoTime();
			logger.info(String.format("%s took %d ns (by AOP)", joinpoint.getSignature(), (end - start)));
			return result;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	@After("serviceMethods()")
	public void afterMethod() {
		logger.info("after method (by AOP)");
	}
}
