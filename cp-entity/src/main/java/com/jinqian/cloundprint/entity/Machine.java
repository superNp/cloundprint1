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
public class Machine implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 设备ID
     */
    @TableId(value = "machine_id", type = IdType.AUTO)
    private Integer machineId;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreatetime;

    /**
     * 过期时间
     */
    private LocalDateTime gmtModified;

    /**
     * 本地IP
     */
    private String localIp;

    /**
     * 服务器IP
     */
    private String serverIp;

    /**
     * 邮件地址
     */
    private String emaliAddress;

    /**
     * 设备所在地
     */
    private String machineAddress;

    /**
     * 设备收入
     */
    private Integer income;

    /**
     * 经销商ID
     */
    private Integer diId;


}
