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
public class Machineorder implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 订单ID
     */
    @TableId(value = "or_id", type = IdType.AUTO)
    private Integer orId;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreattime;

    /**
     * 修改时间
     */
    private LocalDateTime gmtModified;

    /**
     * 订单颜色
     */
    private String color;

    /**
     * 单页或双页
     */
    private String singleOrDouble;

    /**
     * 设备ID
     */
    private Integer machineId;


}
