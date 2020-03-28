package com.acaimanager.acaimanager.api.rest.base;

import com.acaimanager.acaimanager.business.exceptions.BusinessException;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

public abstract class AbstractControlller<ReqDTO extends Serializable, ResDTO extends Serializable, Service extends RestService<ReqDTO, ResDTO>> {

    protected ResDTO processRequest(Service service, ReqDTO reqDTO) {
        ResDTO response = null;

        try {
            preExecutionCheck(reqDTO);
            response = service.dispatch(reqDTO);
            posExecutionCheck(response);
        } catch (BusinessException e) {
            response = buildErrorMessage(UNPROCESSABLE_ENTITY);
        } catch (Exception e) {
            response = buildErrorMessage(INTERNAL_SERVER_ERROR);
        }

        return response;
    }

    private ResDTO buildErrorMessage(HttpStatus unprocessableEntity) {
        return null;
    }

    protected abstract void preExecutionCheck(ReqDTO reqDTO) throws Exception;
    protected abstract void posExecutionCheck(ResDTO resDTO) throws Exception;
}
