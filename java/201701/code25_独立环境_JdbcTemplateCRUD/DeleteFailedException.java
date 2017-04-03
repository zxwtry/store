package step25JdbcTemplateCRUD;

import org.springframework.dao.DataAccessException;

public class DeleteFailedException extends DataAccessException {
    private static final long serialVersionUID = 1L;
    public DeleteFailedException(String msg) {
        super(msg);
    }
}
