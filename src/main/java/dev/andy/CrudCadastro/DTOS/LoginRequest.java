package dev.andy.CrudCadastro.DTOS;

import jakarta.validation.constraints.NotEmpty;

public record LoginRequest(
        @NotEmpty(message = "O campo email é obrigatório") String email,
        @NotEmpty(message = "A senha é obrigatória") String password) {

}
