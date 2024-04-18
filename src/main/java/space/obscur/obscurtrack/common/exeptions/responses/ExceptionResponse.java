package space.obscur.obscurtrack.common.exeptions.responses;

import lombok.Data;

@Data
public class ExceptionResponse {
    private final String massage;
    private final String exception;
}
