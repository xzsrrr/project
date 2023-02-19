package com.ruoyi.manage.service;

import java.util.List;
import com.ruoyi.manage.domain.TProjectPersonCost;

/**
 * 人员费用明细Service接口
 * 
 * @author xzs
 * @date 2023-02-19
 */
public interface ITProjectPersonCostService 
{
    /**
     * 查询人员费用明细
     * 
     * @param id 人员费用明细主键
     * @return 人员费用明细
     */
    public TProjectPersonCost selectTProjectPersonCostById(Long id);

    /**
     * 查询人员费用明细列表
     * 
     * @param tProjectPersonCost 人员费用明细
     * @return 人员费用明细集合
     */
    public List<TProjectPersonCost> selectTProjectPersonCostList(TProjectPersonCost tProjectPersonCost);

    /**
     * 新增人员费用明细
     * 
     * @param tProjectPersonCost 人员费用明细
     * @return 结果
     */
    public int insertTProjectPersonCost(TProjectPersonCost tProjectPersonCost);

    /**
     * 修改人员费用明细
     * 
     * @param tProjectPersonCost 人员费用明细
     * @return 结果
     */
    public int updateTProjectPersonCost(TProjectPersonCost tProjectPersonCost);

    /**
     * 批量删除人员费用明细
     * 
     * @param ids 需要删除的人员费用明细主键集合
     * @return 结果
     */
    public int deleteTProjectPersonCostByIds(String ids);

    /**
     * 删除人员费用明细信息
     * 
     * @param id 人员费用明细主键
     * @return 结果
     */
    public int deleteTProjectPersonCostById(Long id);
}
