/**
 * 
 */
package com.common.core.framework.exception;

/**
 * @author umangkumar
 *
 */
public class AutomationException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5381731375476235561L;

	/**
     * Instantiates a new AutomationException.
     */
    public AutomationException() {
        super();
    }

    /**
     * Instantiates a new AutomationException.
     *
     * @param message the message
     */
    public AutomationException(final String message) {
        super(message);
    }

}
