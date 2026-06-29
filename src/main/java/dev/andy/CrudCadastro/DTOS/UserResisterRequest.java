package dev.andy.CrudCadastro.DTOS;

import jakarta.validation.constraints.NotEmpty;

public record UserResisterRequest(
      @NotEmpty(message = "Username para campo login obrigatório!") String login,
      @NotEmpty(message = "A senha é obrigatória!") String password,
      @NotEmpty(message = "O email é obrigatório!") String email)
{
}
