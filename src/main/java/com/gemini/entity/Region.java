package com.gemini.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.gemini.util.format.TreeFormat;


@Entity
@Table(name = "T_REGION")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Region implements TreeFormat<Region, Long> {
    /** 省级. */
    public static final int TYPE_PROVINCE = 0;
    /** 本地网. */
    public static final int TYPE_LOCAL_NET = 1;
    /** 县区. */
    public static final int TYPE_TOWN = 2;

    public static final int[] TYPES = new int[] { TYPE_PROVINCE,
            TYPE_LOCAL_NET, TYPE_TOWN };
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "REGION_ID")
    private Long id;

    @Column(name = "NAME_CN")
    private String nameCn;

    /** 区域类型. */
    @Column(name = "REGION_TYPE")
    private Integer type;

    @Column(name = "NAME_PY")
    private String namePy;

    /** 上级区域id. */
    @Column(name = "PARENT_REGION_ID")
    private Long parentId;
    /** 区号. */
    @Column(name = "REGION_CODE")
    private String code = "";

    @Column(name = "REGION_NO")
    private String no = "";

    @Column(name = "NET_TITLE")
    private String netTitle;

    @Transient
    private List<Region> children;

    @Override
    public Long getId() {
        return this.id;
    }

    public String getNameCn() {
        return this.nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }

    public String getNamePy() {
        return this.namePy;
    }

    public void setNamePy(String namePy) {
        this.namePy = namePy;
    }

    public String getNetTitle() {
        return this.netTitle;
    }

    public void setNetTitle(String netTitle) {
        this.netTitle = netTitle;
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getParentId() {
        return this.parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNo() {
        return this.no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Region> getChildren() {
        return children;
    }

    public void setChildren(List<Region> children) {
        this.children = children;
    }

    public void addChildren(Region region) {
        if (children == null) {
            this.children = new ArrayList<Region>();
        }
        children.add(region);
    }

    public boolean isRoot() {
        return this.parentId == null;
    }

    public int getDim() {
        if (this.type == Region.TYPE_LOCAL_NET) {
            return 80;
        } else if (this.type == Region.TYPE_PROVINCE) {
            return 100;
        } else if (this.type == Region.TYPE_TOWN) {
            return 50;
        }
        return -1;
    }

    @Override
    public String toString() {
        return this.nameCn;
    }

}
