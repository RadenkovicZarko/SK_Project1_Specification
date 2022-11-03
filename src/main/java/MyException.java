public class MyException extends RuntimeException {
  private String message;
  private boolean successful;

  public MyException(String message) {
    this.message = message;
  }

  public MyException(String message, boolean successful) {
    this.message = message;
    this.successful = successful;
  }
}