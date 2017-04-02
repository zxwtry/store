package step25JdbcTemplateCRUD;

import org.springframework.dao.DataAccessException;

public class InsertFailedException extends DataAccessException {
    private static final long serialVersionUID = 1L;
    public InsertFailedException(String msg) {
        super(msg);
    }
}
