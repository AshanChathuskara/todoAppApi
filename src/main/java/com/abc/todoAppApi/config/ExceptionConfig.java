package com.abc.todoAppApi.config;

import com.abc.todoAppApi.dto.responce.CommonResponse;
import com.abc.todoAppApi.helper.GlobalConst;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;


@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<CommonResponse> handleExceptions(Exception ex) {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setCode(GlobalConst.RESPONSE_CODE_FAIL);
        commonResponse.setMessage(ex.getMessage());
        commonResponse.setDateTime(LocalDateTime.now());
        commonResponse.setData("");
        ex.printStackTrace();
        return new ResponseEntity<CommonResponse>(commonResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

