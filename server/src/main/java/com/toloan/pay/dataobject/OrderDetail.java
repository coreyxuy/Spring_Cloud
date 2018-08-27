package com.toloan.pay.dataobject;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by 廖师兄
 * 2017-12-10 16:07
 */
@Data
public class OrderDetail {

    private String detailId;

    /** 订单id. */
    private String orderId;

    /** 商品id. */
    private String productId;

    /** 商品名称. */
    private String productName;

    /** 商品单价. */
    private BigDecimal productPrice;

    /** 商品数量. */
    private Integer productQuantity;

    /** 商品小图. */
    private String productIcon;
}
