package com.thedevpiece.kumuluzee.deltaspike.api.mappers;

import com.thedevpiece.kumuluzee.deltaspike.api.exceptions.GenericHttpException;
import com.thedevpiece.kumuluzee.deltaspike.entities.base.Envelop;

import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * @author Gabriel Francisco <gabfssilva@gmail.com>
 */
@Provider
@Produces("application/json")
public class GenericHttpExceptionMapper implements ExceptionMapper<GenericHttpException> {
    @Override
    public Response toResponse(GenericHttpException exception) {
        return Response.status(exception.getCode()).entity(new Envelop().addMessage(exception.getMessage())).build();
    }
}
