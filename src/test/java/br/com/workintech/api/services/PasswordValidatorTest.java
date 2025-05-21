package br.com.workintech.api.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class PasswordValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"abcABC123", "ABC123!@#", "abc!@#123ACB"})
    public void deveTestarUmaSenhaValida(String password) {
        boolean resultado = PasswordValidator.isValid(password);
        assertThat(resultado).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "abc123", "ABCabc!@#", "ABC", "hAS12fshjkfsdhjkfdsjk"})
    public void deveTestarUmaSenhaInvalida(String password) {
        boolean resultado = PasswordValidator.isValid(password);
        assertThat(resultado).isFalse();
    }

    public void deveTestarUmaSenhaCurta() {
        assertThatThrownBy(() -> PasswordValidator.isValid(""))
                .isInstanceOf(Exception.class)
                .hasMessageContaining("senha curta");
    }
}
