package step27PerformingBatchOperations;

import org.springframework.dao.DataAccessException;

public class UpdateFailedException extends DataAccessException {
    private static final long serialVersionUID = 1L;
    public UpdateFailedException(String msg) {
        super(msg);
    }
}
