package cn.mysj.center.domain.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author: KaelviHN
 * @created: 2024/10/5
 * @description:
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String message;
    private Integer code;
    public T data;

    public static <T> Result<T> fail(Integer code, String message) {
        return Result.<T>builder()
                .message(message).code(code)
                .build();
    }

    public static <T> Result<T> success(T data) {
        return Result.<T>builder()
                .data(data).code(HttpStatus.OK.value()).message("success")
                .build();
    }
}
