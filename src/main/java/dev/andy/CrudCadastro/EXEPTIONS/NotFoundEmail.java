package dev.andy.CrudCadastro.EXEPTIONS;

public class NotFoundEmail extends RuntimeException {
    public NotFoundEmail(String message) {
        super(message);
    }
}
