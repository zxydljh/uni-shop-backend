package com.zxyd.pojo.entities;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 * 表名：product_item
*/
@Table(name = "product_item")
public class ProductItem {
    /**
     * 商品项ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 关联的商品ID
     */
    @Column(name = "commodity_id")
    private Long commodityId;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 库存单位（SKU）
     */
    private String sku;

    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * 产品品牌
     */
    private String brand;

    /**
     * 库存数量
     */
    private Integer stock;

    /**
     * 折扣百分比
     */
    private BigDecimal discount;

    /**
     * 是否推荐
     */
    @Column(name = "is_recommended")
    private Boolean isRecommended;

    /**
     * 创建时间
     */
    @Column(name = "created_at")
    private Date createdAt;

    /**
     * 更新时间
     */
    @Column(name = "updated_at")
    private Date updatedAt;

    /**
     * 商品图片地址
     */
    @Column(name = "image_url")
    private String imageUrl;

    /**
     * 排序
     */
    @Column(name = "sort_order")
    private Byte sortOrder;

    /**
     * 商品描述
     */
    private String description;

    /**
     * 是否在售
     */
    @Column(name = "is_active")
    private Byte isActive;

    /**
     * 商品属性
     */
    private String attributes;

    /**
     * 获取商品项ID
     *
     * @return id - 商品项ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置商品项ID
     *
     * @param id 商品项ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取关联的商品ID
     *
     * @return commodityId - 关联的商品ID
     */
    public Long getCommodityId() {
        return commodityId;
    }

    /**
     * 设置关联的商品ID
     *
     * @param commodityId 关联的商品ID
     */
    public void setCommodityId(Long commodityId) {
        this.commodityId = commodityId;
    }

    /**
     * 获取商品名称
     *
     * @return name - 商品名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置商品名称
     *
     * @param name 商品名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取库存单位（SKU）
     *
     * @return sku - 库存单位（SKU）
     */
    public String getSku() {
        return sku;
    }

    /**
     * 设置库存单位（SKU）
     *
     * @param sku 库存单位（SKU）
     */
    public void setSku(String sku) {
        this.sku = sku;
    }

    /**
     * 获取商品价格
     *
     * @return price - 商品价格
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置商品价格
     *
     * @param price 商品价格
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取产品品牌
     *
     * @return brand - 产品品牌
     */
    public String getBrand() {
        return brand;
    }

    /**
     * 设置产品品牌
     *
     * @param brand 产品品牌
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * 获取库存数量
     *
     * @return stock - 库存数量
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * 设置库存数量
     *
     * @param stock 库存数量
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * 获取折扣百分比
     *
     * @return discount - 折扣百分比
     */
    public BigDecimal getDiscount() {
        return discount;
    }

    /**
     * 设置折扣百分比
     *
     * @param discount 折扣百分比
     */
    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    /**
     * 获取是否推荐
     *
     * @return isRecommended - 是否推荐
     */
    public Boolean getIsRecommended() {
        return isRecommended;
    }

    /**
     * 设置是否推荐
     *
     * @param isRecommended 是否推荐
     */
    public void setIsRecommended(Boolean isRecommended) {
        this.isRecommended = isRecommended;
    }

    /**
     * 获取创建时间
     *
     * @return createdAt - 创建时间
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * 设置创建时间
     *
     * @param createdAt 创建时间
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * 获取更新时间
     *
     * @return updatedAt - 更新时间
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * 设置更新时间
     *
     * @param updatedAt 更新时间
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * 获取商品图片地址
     *
     * @return imageUrl - 商品图片地址
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * 设置商品图片地址
     *
     * @param imageUrl 商品图片地址
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * 获取排序
     *
     * @return sortOrder - 排序
     */
    public Byte getSortOrder() {
        return sortOrder;
    }

    /**
     * 设置排序
     *
     * @param sortOrder 排序
     */
    public void setSortOrder(Byte sortOrder) {
        this.sortOrder = sortOrder;
    }

    /**
     * 获取商品描述
     *
     * @return description - 商品描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置商品描述
     *
     * @param description 商品描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取是否在售
     *
     * @return isActive - 是否在售
     */
    public Byte getIsActive() {
        return isActive;
    }

    /**
     * 设置是否在售
     *
     * @param isActive 是否在售
     */
    public void setIsActive(Byte isActive) {
        this.isActive = isActive;
    }

    /**
     * 获取商品属性
     *
     * @return attributes - 商品属性
     */
    public String getAttributes() {
        return attributes;
    }

    /**
     * 设置商品属性
     *
     * @param attributes 商品属性
     */
    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }
}