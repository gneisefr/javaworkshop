package de.pentasys.ws.java4web.common;

import de.pentasys.ws.java4web.common.exception.ServiceException;

public class ErrorMessage {

    private final String message;
    private final String code;

    public ErrorMessage(Exception e) {
        this.message = e.getMessage();
        if(e instanceof ServiceException) {
            this.code = ((ServiceException)e).getErrorCode().name();
        } else {
            this.code = "";
        }
    }

    public ErrorMessage(ServiceException e) {
        this(e.getMessage(), e.getErrorCode().name());
    }

    public ErrorMessage(String message, String code) {
        this.message = message;
        this.code = code;
    }

    /**
     * 
     */
    public ErrorMessage(String message) {
        this(message, "");
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return this.message;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return code + ": " + message;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

}
