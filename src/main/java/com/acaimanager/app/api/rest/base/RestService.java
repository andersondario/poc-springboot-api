package com.acaimanager.app.api.rest.base;

import java.io.Serializable;

public interface RestService<ReqDTO extends Serializable, ResDTO extends Serializable> {

    ResDTO dispatch(ReqDTO reqDTO) throws Exception;
}
