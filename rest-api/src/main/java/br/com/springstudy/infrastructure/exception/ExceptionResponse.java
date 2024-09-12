package br.com.springstudy.infrastructure.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse implements Serializable {

    private static final long SerialVersionUID = 1L;
    private Date timestamp;
    private String message;
    private String details;
}
