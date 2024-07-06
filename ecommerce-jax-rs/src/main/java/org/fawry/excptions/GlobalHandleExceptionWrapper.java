package org.fawry.excptions;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.fawry.model.errors.ResponseErrorModel;
import org.fawry.excptions.CustomExceptions.ResourceNotFoundException;
import org.fawry.excptions.CustomExceptions.NotAuthorizedException;

import java.sql.Timestamp;

@Provider
public class GlobalHandleExceptionWrapper implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable throwable) {
        ResponseErrorModel errorModel = new ResponseErrorModel();
        errorModel.setOccurredAt(new Timestamp(System.currentTimeMillis()));

        if (findRootCause(throwable) instanceof ResourceNotFoundException) {

            errorModel.setMessage(throwable.getMessage());
            return Response.status(Response.Status.NOT_FOUND).entity(errorModel).build();
        } else if (findRootCause(throwable) instanceof NotAuthorizedException) {
            errorModel.setMessage(throwable.getMessage());
            return Response.status(Response.Status.UNAUTHORIZED).entity(errorModel).build();
        } else {
            errorModel.setMessage( throwable.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorModel).build();
        }
    }

    private Throwable findRootCause(Throwable throwable) {
        Throwable rootCause = throwable;
        while (rootCause.getCause() != null) {
            rootCause = rootCause.getCause();
        }
        return rootCause;
    }
}
