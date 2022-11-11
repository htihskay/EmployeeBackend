package com.example.handler;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ControllerAdvice
//public class Exceptionn {
////	@ExceptionHandler(value= InvalidUrl.class);
//	@ExceptionHandler(value=InvalidUrl.class)
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//    public @ResponseBody ErrorResponse
//    handleException(InvalidUrl ex)
//    {
//        return new ErrorResponse(
//            HttpStatus.NOT_FOUND.value(), ex.getMessage());
//    }
//}
