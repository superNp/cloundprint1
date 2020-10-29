package com.jinqian.cloundprint.entity;

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
public class Machinestatus implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 状态ID
     */
    private Integer statusId;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreattime;

    /**
     * 修改时间
     */
    private LocalDateTime gmtModified;

    /**
     * 黑色
     */
    private Integer black;

    /**
     * 黄色
     */
    private Integer yellow;

    /**
     * 洋红色
     */
    private Integer magenta;

    /**
     * 蓝绿色
     */
    private Integer cyan;

    /**
     * 设备ID
     */
    private Integer machineId;


}
