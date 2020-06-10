package exceptions;

@SuppressWarnings("all")
public class BusinessException extends Exception {
  public BusinessException(final String msg) {
    super(("Error de negocio: " + msg));
  }
}
