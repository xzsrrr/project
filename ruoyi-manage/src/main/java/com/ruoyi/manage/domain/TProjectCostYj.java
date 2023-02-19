package com.ruoyi.manage.domain;

import java.math.BigDecimal;
import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 应急项目费用申报对象 t_project_cost_yj
 * 
 * @author xzs
 * @date 2023-02-19
 */
public class TProjectCostYj extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 项目id */
    @Excel(name = "项目id")
    private Long projId;

    /** 项目类别 */
    @Excel(name = "项目类别")
    private String projType;

    /** 费用所在月份 */
    @Excel(name = "费用所在月份")
    private Integer costMonth;

    /** 项目收入 */
    @Excel(name = "项目收入")
    private BigDecimal xmsr;

    /** 消费外包服务费 */
    @Excel(name = "消费外包服务费")
    private BigDecimal xfwbfwf;

    /** 人工成本 */
    @Excel(name = "人工成本")
    private BigDecimal rgcb;

    /** 劳动保护费 */
    @Excel(name = "劳动保护费")
    private BigDecimal ldbhf;

    /** 物资消耗 */
    @Excel(name = "物资消耗")
    private BigDecimal wzxh;

    /** 保险费用 */
    @Excel(name = "保险费用")
    private BigDecimal bxfy;

    /** 财务费用 */
    @Excel(name = "财务费用")
    private BigDecimal cwfy;

    /** 业务费用 */
    @Excel(name = "业务费用")
    private BigDecimal ywfy;

    /** 折旧费 */
    @Excel(name = "折旧费")
    private BigDecimal zjf;

    /** 其他费用 */
    @Excel(name = "其他费用")
    private BigDecimal qtfy;

    /** 消防人员数量 */
    @Excel(name = "消防人员数量")
    private Integer xfrysl;

    /** 员工数量 */
    @Excel(name = "员工数量")
    private Integer ygsl;

    /** 状态_中文 */
    @Excel(name = "状态_中文")
    private String statusCn;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 人员费用明细信息 */
    private List<TProjectPersonCost> tProjectPersonCostList;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setProjId(Long projId) 
    {
        this.projId = projId;
    }

    public Long getProjId() 
    {
        return projId;
    }
    public void setProjType(String projType) 
    {
        this.projType = projType;
    }

    public String getProjType() 
    {
        return projType;
    }
    public void setCostMonth(Integer costMonth) 
    {
        this.costMonth = costMonth;
    }

    public Integer getCostMonth() 
    {
        return costMonth;
    }
    public void setXmsr(BigDecimal xmsr) 
    {
        this.xmsr = xmsr;
    }

    public BigDecimal getXmsr() 
    {
        return xmsr;
    }
    public void setXfwbfwf(BigDecimal xfwbfwf) 
    {
        this.xfwbfwf = xfwbfwf;
    }

    public BigDecimal getXfwbfwf() 
    {
        return xfwbfwf;
    }
    public void setRgcb(BigDecimal rgcb) 
    {
        this.rgcb = rgcb;
    }

    public BigDecimal getRgcb() 
    {
        return rgcb;
    }
    public void setLdbhf(BigDecimal ldbhf) 
    {
        this.ldbhf = ldbhf;
    }

    public BigDecimal getLdbhf() 
    {
        return ldbhf;
    }
    public void setWzxh(BigDecimal wzxh) 
    {
        this.wzxh = wzxh;
    }

    public BigDecimal getWzxh() 
    {
        return wzxh;
    }
    public void setBxfy(BigDecimal bxfy) 
    {
        this.bxfy = bxfy;
    }

    public BigDecimal getBxfy() 
    {
        return bxfy;
    }
    public void setCwfy(BigDecimal cwfy) 
    {
        this.cwfy = cwfy;
    }

    public BigDecimal getCwfy() 
    {
        return cwfy;
    }
    public void setYwfy(BigDecimal ywfy) 
    {
        this.ywfy = ywfy;
    }

    public BigDecimal getYwfy() 
    {
        return ywfy;
    }
    public void setZjf(BigDecimal zjf) 
    {
        this.zjf = zjf;
    }

    public BigDecimal getZjf() 
    {
        return zjf;
    }
    public void setQtfy(BigDecimal qtfy) 
    {
        this.qtfy = qtfy;
    }

    public BigDecimal getQtfy() 
    {
        return qtfy;
    }
    public void setXfrysl(Integer xfrysl) 
    {
        this.xfrysl = xfrysl;
    }

    public Integer getXfrysl() 
    {
        return xfrysl;
    }
    public void setYgsl(Integer ygsl) 
    {
        this.ygsl = ygsl;
    }

    public Integer getYgsl() 
    {
        return ygsl;
    }
    public void setStatusCn(String statusCn) 
    {
        this.statusCn = statusCn;
    }

    public String getStatusCn() 
    {
        return statusCn;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    public List<TProjectPersonCost> getTProjectPersonCostList()
    {
        return tProjectPersonCostList;
    }

    public void setTProjectPersonCostList(List<TProjectPersonCost> tProjectPersonCostList)
    {
        this.tProjectPersonCostList = tProjectPersonCostList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("projId", getProjId())
            .append("projType", getProjType())
            .append("costMonth", getCostMonth())
            .append("xmsr", getXmsr())
            .append("xfwbfwf", getXfwbfwf())
            .append("rgcb", getRgcb())
            .append("ldbhf", getLdbhf())
            .append("wzxh", getWzxh())
            .append("bxfy", getBxfy())
            .append("cwfy", getCwfy())
            .append("ywfy", getYwfy())
            .append("zjf", getZjf())
            .append("qtfy", getQtfy())
            .append("xfrysl", getXfrysl())
            .append("ygsl", getYgsl())
            .append("statusCn", getStatusCn())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .append("remark", getRemark())
            .append("tProjectPersonCostList", getTProjectPersonCostList())
            .toString();
    }
}
