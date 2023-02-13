package com.markethub.common.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author Peter Huang
 * @date 2023/2/12 15:15
 **/
@Data
public class PassDto implements Serializable {

    @NotBlank(message = "新密码不能为空")
    private String password;

    @NotBlank(message = "旧密码不能为空")
    private String currentPass;
}