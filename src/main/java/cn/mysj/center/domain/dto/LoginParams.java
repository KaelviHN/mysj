package cn.mysj.center.domain.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author: KaelviHN
 * @created: 2024/10/7
 * @description:
 **/
@Data
public class LoginParams implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String account;

    private String password;

}
