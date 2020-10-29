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
public class Machineprice implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 价格ID
     */
    @TableId(value = "price_id", type = IdType.AUTO)
    private Integer priceId;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreattime;

    /**
     * 修改时间
     */
    private LocalDateTime gmtModified;

    /**
     * 黑白或彩色
     */
    private String color;

    /**
     * 单面或双面
     */
    private String singleOrDouble;

    /**
     * 订单ID
     */
    private Integer orderId;

    /**
     * 价格
     */
    private Integer price;


}
