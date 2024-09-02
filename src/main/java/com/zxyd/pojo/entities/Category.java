package com.zxyd.pojo.entities;

import java.util.Date;
import javax.persistence.*;

/**
 * 表名：category
*/
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 分类图标的URL
     */
    @Column(name = "icon_url")
    private String iconUrl;

    /**
     * 跳转链接
     */
    @Column(name = "link_url")
    private String linkUrl;

    /**
     * 是否激活
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
     * 分类描述
     */
    private String description;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取分类名称
     *
     * @return name - 分类名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置分类名称
     *
     * @param name 分类名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取分类图标的URL
     *
     * @return iconUrl - 分类图标的URL
     */
    public String getIconUrl() {
        return iconUrl;
    }

    /**
     * 设置分类图标的URL
     *
     * @param iconUrl 分类图标的URL
     */
    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    /**
     * 获取跳转链接
     *
     * @return linkUrl - 跳转链接
     */
    public String getLinkUrl() {
        return linkUrl;
    }

    /**
     * 设置跳转链接
     *
     * @param linkUrl 跳转链接
     */
    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    /**
     * 获取是否激活
     *
     * @return isActive - 是否激活
     */
    public Boolean getIsActive() {
        return isActive;
    }

    /**
     * 设置是否激活
     *
     * @param isActive 是否激活
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
     * 获取分类描述
     *
     * @return description - 分类描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置分类描述
     *
     * @param description 分类描述
     */
    public void setDescription(String description) {
        this.description = description;
    }
}