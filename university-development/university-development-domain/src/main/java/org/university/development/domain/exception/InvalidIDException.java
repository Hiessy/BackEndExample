package org.university.development.domain.exception;

import java.util.List;

import org.university.development.commons.exception.BusinessException;
import org.university.development.commons.model.Cause;


public class InvalidIDException
    extends BusinessException {

    private static final long serialVersionUID = 1L;

    public InvalidIDException(List<Cause> causes) {
        super(causes);
    }

    public InvalidIDException(Cause... causes) {
        super(causes);
    }

    public InvalidIDException(String message, List<Cause> causes) {
        super(message, causes);
    }
}
