package polytech.michelin.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import polytech.michelin.dto.ErrorMessagesDto;
import polytech.michelin.exception.RessourceInexistante;

public class ExceptionsConfig
{
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorMessagesDto internalServerError(Exception ex) 
    {
        ex.printStackTrace();
        return new ErrorMessagesDto("INTERNAL_ERROR", null);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMessagesDto internalServerError(MethodArgumentNotValidException ex) 
    {
        ex.printStackTrace();
        return new ErrorMessagesDto("BAD_REQUEST", null);
    }

    @ExceptionHandler(value = RessourceInexistante.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorMessagesDto notFoundError(RessourceInexistante ex) 
    {
        ex.printStackTrace();
        return new ErrorMessagesDto("NOT_FOUND", ex.getMessage());
    }
}
