package br.com.vechiato.donnacida_api.utils;

import br.com.vechiato.donnacida_api.utils.anotation.ValidCPF;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CPFValidator implements ConstraintValidator<ValidCPF, String> {
    @Override
    public boolean isValid(String cpf, ConstraintValidatorContext context) {
        if (cpf == null || !cpf.matches("\\d{11}")) {
            return false; // Garante que só aceita números
        }
        return isValidCPF(cpf);
    }

    private boolean isValidCPF(String cpf) {
        // Remove caracteres não numéricos
        cpf = cpf.replaceAll("\\D", "");

        // CPF inválidos conhecidos
        if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        // Cálculo dos dígitos verificadores
        int sum = 0, weight = 10;
        for (int i = 0; i < 9; i++) {
            sum += (cpf.charAt(i) - '0') * weight--;
        }
        int firstDigit = (sum * 10) % 11;
        if (firstDigit == 10) firstDigit = 0;

        if (firstDigit != (cpf.charAt(9) - '0')) return false;

        sum = 0;
        weight = 11;
        for (int i = 0; i < 10; i++) {
            sum += (cpf.charAt(i) - '0') * weight--;
        }
        int secondDigit = (sum * 10) % 11;
        if (secondDigit == 10) secondDigit = 0;

        return secondDigit == (cpf.charAt(10) - '0');
    }
}