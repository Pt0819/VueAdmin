package com.markethub.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * @author Peter Huang
 * @date 2023/2/6 12:24
 **/
@Data
public class BaseEntity implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private LocalDateTime created;
    private LocalDateTime updated;

    private Integer statu;
}
