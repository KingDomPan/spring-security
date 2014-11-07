package com.gemini.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 操作日志实体类.
 */
@Entity
@Table(name = "T_SM_OPERATE_LOG")
public class Log implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SM_OPERATE_LOG_ID")
    private Long smOperateLogId;

    @Basic(optional = false)
    @Column(name = "MODULE_TYPE")
    private Integer moduleType;

    @Column(name = "OPERATE_ACTION")
    private String operateAction;

    @Column(name = "OPERATE_COMMENT")
    private String operateComment;

    @Column(name = "OPERATE_RESULT_STATUS")
    private Integer operateResultStatus;

    @Basic(optional = false)
    @Column(name = "HANDLE_USER_NAME")
    private String handleUserName;

    @Column(name = "REMARKS")
    private String remarks;

    @Basic(optional = false)
    @Column(name = "OPERATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date operateTime;

    public Log() {
    }

    public Log(Long smOperateLogId) {
        this.smOperateLogId = smOperateLogId;
    }

    public Log(Long smOperateLogId, Integer moduleType, String handleUserName,
            Date operateTime) {
        this.smOperateLogId = smOperateLogId;
        this.moduleType = moduleType;
        this.handleUserName = handleUserName;
        this.operateTime = operateTime;
    }

    public Long getSmOperateLogId() {
        return smOperateLogId;
    }

    public void setSmOperateLogId(Long smOperateLogId) {
        this.smOperateLogId = smOperateLogId;
    }

    public Integer getModuleType() {
        return moduleType;
    }

    public void setModuleType(Integer moduleType) {
        this.moduleType = moduleType;
    }

    public String getOperateAction() {
        return operateAction;
    }

    public void setOperateAction(String operateAction) {
        this.operateAction = operateAction;
    }

    public String getOperateComment() {
        return operateComment;
    }

    public void setOperateComment(String operateComment) {
        this.operateComment = operateComment;
    }

    public Integer getOperateResultStatus() {
        return operateResultStatus;
    }

    public void setOperateResultStatus(Integer operateResultStatus) {
        this.operateResultStatus = operateResultStatus;
    }

    public String getHandleUserName() {
        return handleUserName;
    }

    public void setHandleUserName(String handleUserName) {
        this.handleUserName = handleUserName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getOperateTime() {
        return this.operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.smOperateLogId != null ? this.smOperateLogId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Log)) {
            return false;
        }
        Log other = (Log) object;
        if ((this.smOperateLogId == null && other.smOperateLogId != null)
                || (this.smOperateLogId != null && !this.smOperateLogId
                        .equals(other.smOperateLogId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ffcs.itm.oops.web.domain.Log[smOperateLogId="
                + smOperateLogId + "]";
    }

}
