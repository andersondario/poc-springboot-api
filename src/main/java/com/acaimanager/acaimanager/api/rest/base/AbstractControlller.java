package com.acaimanager.acaimanager.api.rest.base;

import com.acaimanager.acaimanager.business.exceptions.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

public abstract class AbstractControlller<ReqDTO extends Serializable, ResDTO extends Serializable, Service extends RestService<ReqDTO, ResDTO>> {

    protected ResponseEntity<Serializable> processRequest(Service service, ReqDTO reqDTO) {
        ResDTO response = null;

        try {
            preExecutionCheck(reqDTO);
            response = service.dispatch(reqDTO);
            posExecutionCheck(response);
        } catch (BusinessException e) {
            return buildErrorResponse(UNPROCESSABLE_ENTITY, e);
        } catch (Exception e) {
            return buildErrorResponse(INTERNAL_SERVER_ERROR, e);
        }

        return buildSuccessResponse(response);
    }

    private ResponseEntity<Serializable> buildErrorResponse(HttpStatus httpStatus, Exception e) {
        return new ResponseEntity<>(new ErrorDTO(e.getMessage()), httpStatus);
    }

    private ResponseEntity<Serializable> buildSuccessResponse(ResDTO resDTO) {
        return new ResponseEntity<>(resDTO, getSuccessCode());
    }

    protected abstract void preExecutionCheck(ReqDTO reqDTO) throws Exception;
    protected abstract void posExecutionCheck(ResDTO resDTO) throws Exception;
    protected abstract HttpStatus getSuccessCode();

}
