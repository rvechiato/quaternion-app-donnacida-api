package br.com.vechiato.donnacida_api.application.exceptions;

public class TenantNotFoundException extends RuntimeException {
    public TenantNotFoundException(String message) {
        super(message);
    }
}