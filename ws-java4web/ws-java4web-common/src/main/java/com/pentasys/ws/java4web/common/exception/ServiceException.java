package com.pentasys.ws.java4web.common.exception;

import com.pentasys.ws.java4web.common.ErrorCode;

public class ServiceException extends AbstractRuntimeException {

	private static final long serialVersionUID = 1L;
	private final ErrorCode errorCode;

	/**
	 * @return the errorCode
	 */
	public ErrorCode getErrorCode() {
		return this.errorCode;
	}

	/**
	 * Instantiates a new service exception.
	 */
	public ServiceException(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * Instantiates a new service exception.
	 *
	 * @param message
	 *            the message
	 */
	public ServiceException(ErrorCode errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	/**
	 * Instantiates a new service exception.
	 *
	 * @param message
	 *            the message
	 * @param cause
	 *            the cause
	 */
	public ServiceException(ErrorCode errorCode, String message, Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
	}

	/**
	 * Instantiates a new service exception.
	 *
	 * @param message
	 *            the message
	 * @param cause
	 *            the cause
	 * @param enableSuppression
	 *            the enable suppression
	 * @param writableStackTrace
	 *            the writable stack trace
	 */
	public ServiceException(ErrorCode errorCode, String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.errorCode = errorCode;
	}

	/**
	 * Instantiates a new service exception.
	 *
	 * @param errorCode
	 * @param cause
	 *            the cause
	 */
	public ServiceException(ErrorCode errorCode, Throwable cause) {
		super(cause);
		this.errorCode = errorCode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		return "Error: " + errorCode + ": " + super.getMessage();
	}

}
