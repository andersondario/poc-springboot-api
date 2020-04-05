package com.acaimanager.app.functional;

import org.junit.Assert;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;

public abstract class AbstractFunctionalTest<ReqDTO extends Serializable, ResDTO extends Serializable> {

    private static final String BASE_URL = "http://localhost:";

    private TestRestTemplate restTemplate = new TestRestTemplate();

    @LocalServerPort
    private int port;

    protected ResponseEntity<String> doPostRequest(ReqDTO reqDTO) {
        final HttpEntity<ReqDTO> entity = new HttpEntity<ReqDTO>(reqDTO, null);
        return restTemplate.exchange(getURL(), HttpMethod.POST, entity, String.class);
    }

    protected void doPostAndAssertStatusCode(ReqDTO reqDTO, HttpStatus httpStatus) {
        final ResponseEntity<String> responseEntity = doPostRequest(reqDTO);
        Assert.assertEquals(httpStatus, responseEntity.getStatusCode());
    }

    private String getURL() {
        return BASE_URL + port + "/api/" + getServiceVersion() + "/" + getServiceName();
    }

    protected abstract String getServiceVersion();
    protected abstract String getServiceName();
}
