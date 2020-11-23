package hu.uni.eszterhazy.framework.exceptions;

public class UnknownCountryException extends Exception {

    public UnknownCountryException() {
    }

    public UnknownCountryException(String message) {
        super(message);
    }
}
