package com.zxyd.pojo.entities;

import java.util.Date;
import javax.persistence.*;

/**
 * 表名：commodity
*/
@Table(name = "commodity")
public class Commodity {
    /**
     * 分类数据ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 分类ID
     */
    @Column(name = "category_id")
    private Long categoryId;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 图片地址
     */
    @Column(name = "image_url")
    private String imageUrl;

    /**
     * 排序字段
     */
    @Column(name = "sort_order")
    private Integer sortOrder;

    /**
     * 是否启用
     */
    @Column(name = "is_active")
    private Boolean isActive;

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
     * 商品描述
     */
    private String description;

    /**
     * 获取分类数据ID
     *
     * @return id - 分类数据ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置分类数据ID
     *
     * @param id 分类数据ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取分类ID
     *
     * @return categoryId - 分类ID
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * 设置分类ID
     *
     * @param categoryId 分类ID
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
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
     * 获取图片地址
     *
     * @return imageUrl - 图片地址
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * 设置图片地址
     *
     * @param imageUrl 图片地址
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * 获取排序字段
     *
     * @return sortOrder - 排序字段
     */
    public Integer getSortOrder() {
        return sortOrder;
    }

    /**
     * 设置排序字段
     *
     * @param sortOrder 排序字段
     */
    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    /**
     * 获取是否启用
     *
     * @return isActive - 是否启用
     */
    public Boolean getIsActive() {
        return isActive;
    }

    /**
     * 设置是否启用
     *
     * @param isActive 是否启用
     */
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
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
}