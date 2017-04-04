package de.pentasys.ws.java4web.common.exception;


public abstract class AbstractRuntimeException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  /**
   * Instantiates a new runtime exception.
   */
  public AbstractRuntimeException() {
    super();
  }

  /**
   * Instantiates a new runtime exception.
   *
   * @param msg the msg
   */
  public AbstractRuntimeException(String msg) {
    super(msg);
  }

  /**
   * Instantiates a new runtime exception.
   *
   * @param msg the msg
   * @param cause the cause
   */
  public AbstractRuntimeException(String msg, Throwable cause) {
    super(msg, cause);
  }

  /**
   * Instantiates a new runtime exception.
   *
   * @param msg the msg
   * @param cause the cause
   * @param arg2 the arg2
   * @param arg3 the arg3
   */
  public AbstractRuntimeException(String msg, Throwable cause, boolean arg2, boolean arg3) {
    super(msg, cause, arg2, arg3);
  }

  /**
   * Instantiates a new runtime exception.
   *
   * @param cause the cause
   */
  public AbstractRuntimeException(Throwable cause) {
    super(cause);
  }

}
