package dev.andy.CrudCadastro.exeptions;

public class NotFoundEmail extends RuntimeException {
    public NotFoundEmail(String message) {
        super(message);
    }
}
