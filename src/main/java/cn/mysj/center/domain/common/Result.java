package cn.mysj.center.domain.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: anran.ma
 * @created: 2024/10/5
 * @description:
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    private String message;
    private Integer code;
    public T data;

    public static <T> Result<T> fail(String message, Integer code) {
        return Result.<T>builder().message(message).code(code).build();
    }
}
