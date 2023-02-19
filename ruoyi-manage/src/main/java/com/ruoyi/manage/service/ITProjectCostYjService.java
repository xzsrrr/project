package com.ruoyi.manage.service;

import java.util.List;
import com.ruoyi.manage.domain.TProjectCostYj;

/**
 * 应急项目费用申报Service接口
 * 
 * @author xzs
 * @date 2023-02-19
 */
public interface ITProjectCostYjService 
{
    /**
     * 查询应急项目费用申报
     * 
     * @param id 应急项目费用申报主键
     * @return 应急项目费用申报
     */
    public TProjectCostYj selectTProjectCostYjById(Long id);

    /**
     * 查询应急项目费用申报列表
     * 
     * @param tProjectCostYj 应急项目费用申报
     * @return 应急项目费用申报集合
     */
    public List<TProjectCostYj> selectTProjectCostYjList(TProjectCostYj tProjectCostYj);

    /**
     * 新增应急项目费用申报
     * 
     * @param tProjectCostYj 应急项目费用申报
     * @return 结果
     */
    public int insertTProjectCostYj(TProjectCostYj tProjectCostYj);

    /**
     * 修改应急项目费用申报
     * 
     * @param tProjectCostYj 应急项目费用申报
     * @return 结果
     */
    public int updateTProjectCostYj(TProjectCostYj tProjectCostYj);

    /**
     * 批量删除应急项目费用申报
     * 
     * @param ids 需要删除的应急项目费用申报主键集合
     * @return 结果
     */
    public int deleteTProjectCostYjByIds(String ids);

    /**
     * 删除应急项目费用申报信息
     * 
     * @param id 应急项目费用申报主键
     * @return 结果
     */
    public int deleteTProjectCostYjById(Long id);
}
