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
public class Distributor implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 用户ID
     */
    @TableId(value = "di_id", type = IdType.AUTO)
    private Integer diId;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreattime;

    /**
     * 修改时间
     */
    private LocalDateTime gmtModified;

    /**
     * 用户电话
     */
    private String userTel;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 经销商地址
     */
    private String address;


}
