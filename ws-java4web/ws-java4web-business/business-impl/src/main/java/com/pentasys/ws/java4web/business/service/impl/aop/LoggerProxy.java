package com.pentasys.ws.java4web.business.service.impl.aop;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;

public class LoggerProxy implements java.lang.reflect.InvocationHandler {

	private static Logger logger = Logger.getLogger(LoggerProxy.class);
	private Object obj;

	public static Object newInstance(Object obj) {
		return java.lang.reflect.Proxy.newProxyInstance(obj.getClass()
				.getClassLoader(), obj.getClass().getInterfaces(),
				new LoggerProxy(obj));
	}

	private LoggerProxy(Object obj) {
		this.obj = obj;
	}

	public Object invoke(Object proxy, Method m, Object[] args)
			throws Throwable {
		Object result;
		try {
			logger.info("before method " + m.getName() + " (by Proxy)");
			long start = System.nanoTime();
			result = m.invoke(obj, args);
			long end = System.nanoTime();
			logger.info(String.format("%s took %d ns (by Proxy)", m.getName(),
					(end - start)));
		} catch (InvocationTargetException e) {
			throw e.getTargetException();
		} catch (Exception e) {
			throw new RuntimeException("unexpected invocation exception: "
					+ e.getMessage());
		} finally {
			logger.info("after method " + m.getName() + " (by Proxy)");
		}
		return result;
	}
}
