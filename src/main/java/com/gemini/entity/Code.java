package com.gemini.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Table
@Entity(name = "T_CODE")
public class Code implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CODE_ID")
    private long id;

    @Column(name = "TABLE_NAME")
    private String table;

    @Column(name = "VALUE")
    private String value;

    @Transient
    private int valueInt;

    @Column(name = "DESC_NAME")
    private String description;

    @Column(name = "COL_NAME")
    private String column;

    @Column(name = "REMARK")
    private String remark;

    public static Code newCodeDef(String table, String column) {
        Code code = new Code();
        code.setTable(table);
        code.setColumn(column);
        return code;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String tableName) {
        this.table = tableName;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String colName) {
        this.column = colName;
    }

    public long getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String descname) {
        this.description = descname;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setCodeId(long id) {
        this.id = id;
    }

    public void setValueInt(Integer valueInt) {
        if (valueInt != null) {
            this.value = valueInt.toString();
        } else {
            this.value = null;
        }
    }

    public int getValueInt() {
        try {
            valueInt = Integer.parseInt(this.value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return valueInt;
    }
}
