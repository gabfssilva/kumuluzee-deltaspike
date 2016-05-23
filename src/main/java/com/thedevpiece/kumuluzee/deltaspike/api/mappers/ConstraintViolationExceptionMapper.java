package com.thedevpiece.kumuluzee.deltaspike.api.mappers;


import com.thedevpiece.kumuluzee.deltaspike.entities.base.Envelop;
import com.thedevpiece.kumuluzee.deltaspike.entities.base.Message;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author Gabriel Francisco <gabfssilva@gmail.com>
 */
@Provider
@Produces("application/json")
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {
    @Override
    public Response toResponse(ConstraintViolationException exception) {
        final List<Message> messages = exception
                .getConstraintViolations()
                .stream()
                .map(e -> new Message("invalid_field", e.getMessage()))
                .collect(toList());

        final Envelop envelop = new Envelop();
        envelop.setMessages(messages);
        return Response.status(422).entity(envelop).build();
    }
}
