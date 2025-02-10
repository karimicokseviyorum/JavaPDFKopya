package com.ilovemygf.pdfupload.exception;

public class SignatureException extends RuntimeException {
    public SignatureException(String message) {
        super(message);
    }

    public SignatureException(String message, Throwable cause) {
        super(message, cause);
    }
} 