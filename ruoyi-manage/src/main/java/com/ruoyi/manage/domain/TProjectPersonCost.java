package com.ruoyi.manage.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 人员费用明细对象 t_project_person_cost
 * 
 * @author xzs
 * @date 2023-02-19
 */
public class TProjectPersonCost extends BaseEntity
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

    /** 费用申报id */
    @Excel(name = "费用申报id")
    private Long costId;

    /** 人员类别编码 */
    @Excel(name = "人员类别编码")
    private String lylbbm;

    /** 人员类别名称 */
    @Excel(name = "人员类别名称")
    private String lylbmc;

    /** 薪资标准 */
    @Excel(name = "薪资标准")
    private BigDecimal xzbz;

    /** 数量 */
    @Excel(name = "数量")
    private Integer sl;

    /** 合计 */
    @Excel(name = "合计")
    private BigDecimal hj;

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
    public void setCostId(Long costId) 
    {
        this.costId = costId;
    }

    public Long getCostId() 
    {
        return costId;
    }
    public void setLylbbm(String lylbbm) 
    {
        this.lylbbm = lylbbm;
    }

    public String getLylbbm() 
    {
        return lylbbm;
    }
    public void setLylbmc(String lylbmc) 
    {
        this.lylbmc = lylbmc;
    }

    public String getLylbmc() 
    {
        return lylbmc;
    }
    public void setXzbz(BigDecimal xzbz) 
    {
        this.xzbz = xzbz;
    }

    public BigDecimal getXzbz() 
    {
        return xzbz;
    }
    public void setSl(Integer sl) 
    {
        this.sl = sl;
    }

    public Integer getSl() 
    {
        return sl;
    }
    public void setHj(BigDecimal hj) 
    {
        this.hj = hj;
    }

    public BigDecimal getHj() 
    {
        return hj;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("projId", getProjId())
            .append("projType", getProjType())
            .append("costId", getCostId())
            .append("lylbbm", getLylbbm())
            .append("lylbmc", getLylbmc())
            .append("xzbz", getXzbz())
            .append("sl", getSl())
            .append("hj", getHj())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .toString();
    }
}
