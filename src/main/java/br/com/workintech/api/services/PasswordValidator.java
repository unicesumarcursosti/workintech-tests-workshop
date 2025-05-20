package br.com.workintech.api.services;

public class PasswordValidator {
    public static boolean isValid(String password) {
        // return password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
        if (password == null) return false;

        int tamanho = password.length();
        if (tamanho < 6 || tamanho > 12) return false;

        boolean temMaiuscula = false;
        boolean temNumero = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) temMaiuscula = true;
            if (Character.isDigit(c)) temNumero = true;
        }

        return temMaiuscula && temNumero;
    }
}
