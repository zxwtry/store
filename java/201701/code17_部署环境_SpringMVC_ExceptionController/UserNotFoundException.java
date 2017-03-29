package step17ExceptionController;

public class UserNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;
    public UserNotFoundException(String name) {
        super("User Not Found Exception! Details is \"" + name + "\"");
    }
}
