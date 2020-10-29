package com.jinqian.cloundprint.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author chengpan
 * @since 2020-10-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Administator implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 管理员ID
     */
    @TableId(value = "admin_id", type = IdType.AUTO)
    private Integer adminId;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreattime;


    /**
     * 修改时间
     */
    private LocalDateTime gmtModifiedtime;

    /**
     * 管理员用户名
     */
    private String adminName;

    /**
     * 管理员密码
     */
    private String password;


}
