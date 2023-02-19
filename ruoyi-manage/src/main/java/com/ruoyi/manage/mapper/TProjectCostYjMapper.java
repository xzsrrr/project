package com.ruoyi.manage.mapper;

import java.util.List;
import com.ruoyi.manage.domain.TProjectCostYj;
import com.ruoyi.manage.domain.TProjectPersonCost;

/**
 * 应急项目费用申报Mapper接口
 * 
 * @author xzs
 * @date 2023-02-19
 */
public interface TProjectCostYjMapper 
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
     * 删除应急项目费用申报
     * 
     * @param id 应急项目费用申报主键
     * @return 结果
     */
    public int deleteTProjectCostYjById(Long id);

    /**
     * 批量删除应急项目费用申报
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTProjectCostYjByIds(String[] ids);

    /**
     * 批量删除人员费用明细
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTProjectPersonCostByCostIds(String[] ids);
    
    /**
     * 批量新增人员费用明细
     * 
     * @param tProjectPersonCostList 人员费用明细列表
     * @return 结果
     */
    public int batchTProjectPersonCost(List<TProjectPersonCost> tProjectPersonCostList);
    

    /**
     * 通过应急项目费用申报主键删除人员费用明细信息
     * 
     * @param id 应急项目费用申报ID
     * @return 结果
     */
    public int deleteTProjectPersonCostByCostId(Long id);
}
