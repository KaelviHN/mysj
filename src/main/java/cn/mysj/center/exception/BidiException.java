package cn.mysj.center.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.io.Serial;

/**
 * @author: KaelviHN
 * @created: 2024/10/5
 * @description: Customize Exception
 **/

@Getter
@AllArgsConstructor
public class BidiException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    private final HttpStatus status;

    private final String message;


}
