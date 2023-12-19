package com.switchfully.parkshark;

import com.switchfully.parkshark.exception.ManagerPasswordIncorrectException;
import com.switchfully.parkshark.exception.NotAManagerException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotAManagerException.class)
    private void notAManagerException(NotAManagerException e, HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
    }

    @ExceptionHandler(ManagerPasswordIncorrectException.class)
    private void managerPasswordIncorrectException(ManagerPasswordIncorrectException e, HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
    }

}
