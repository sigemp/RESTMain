/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.server.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sigemp.gestion.server.exception.NotAuthorizedException;
import java.io.IOException;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotAcceptableException;
import javax.ws.rs.NotAllowedException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.NotSupportedException;
import javax.ws.rs.ServiceUnavailableException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import org.eclipse.persistence.jpa.rs.exceptions.ErrorResponse;

/**
 *
 * @author sigem
 */
@Provider
public class ErrorResponseFilter implements ClientResponseFilter {

    private static ObjectMapper _MAPPER = new ObjectMapper();

    @Override
    public void filter(ClientRequestContext requestContext, ClientResponseContext responseContext) throws IOException {
        // for non-200 response, deal with the custom error messages
        if (responseContext.getStatus() != Response.Status.OK.getStatusCode()) {
            if (responseContext.hasEntity()) {
                // get the "real" error message
                ErrorResponse error = _MAPPER.readValue(responseContext.getEntityStream(), ErrorResponse.class);
                String message = error.getDetail();

                Response.Status status = Response.Status.fromStatusCode(responseContext.getStatus());
                WebApplicationException webAppException;
                switch (status) {
                    case BAD_REQUEST:
                        webAppException = new BadRequestException(message);
                        break;
                    case UNAUTHORIZED:
                        webAppException = new NotAuthorizedException(message);
                        break;
                    case FORBIDDEN:
                        webAppException = new ForbiddenException(message);
                        break;
                    case NOT_FOUND:
                        webAppException = new NotFoundException(message);
                        break;
                    case METHOD_NOT_ALLOWED:
                        webAppException = new NotAllowedException(message);
                        break;
                    case NOT_ACCEPTABLE:
                        webAppException = new NotAcceptableException(message);
                        break;
                    case UNSUPPORTED_MEDIA_TYPE:
                        webAppException = new NotSupportedException(message);
                        break;
                    case INTERNAL_SERVER_ERROR:
                        webAppException = new InternalServerErrorException(message);
                        break;
                    case SERVICE_UNAVAILABLE:
                        webAppException = new ServiceUnavailableException(message);
                        break;
                    default:
                        webAppException = new WebApplicationException(message);
                }

                throw webAppException;
            }
        }
    }
}