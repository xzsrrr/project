package com.ruoyi.manage.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.manage.mapper.TProjectPersonCostMapper;
import com.ruoyi.manage.domain.TProjectPersonCost;
import com.ruoyi.manage.service.ITProjectPersonCostService;
import com.ruoyi.common.core.text.Convert;

/**
 * 人员费用明细Service业务层处理
 * 
 * @author xzs
 * @date 2023-02-19
 */
@Service
public class TProjectPersonCostServiceImpl implements ITProjectPersonCostService 
{
    @Autowired
    private TProjectPersonCostMapper tProjectPersonCostMapper;

    /**
     * 查询人员费用明细
     * 
     * @param id 人员费用明细主键
     * @return 人员费用明细
     */
    @Override
    public TProjectPersonCost selectTProjectPersonCostById(Long id)
    {
        return tProjectPersonCostMapper.selectTProjectPersonCostById(id);
    }

    /**
     * 查询人员费用明细列表
     * 
     * @param tProjectPersonCost 人员费用明细
     * @return 人员费用明细
     */
    @Override
    public List<TProjectPersonCost> selectTProjectPersonCostList(TProjectPersonCost tProjectPersonCost)
    {
        return tProjectPersonCostMapper.selectTProjectPersonCostList(tProjectPersonCost);
    }

    /**
     * 新增人员费用明细
     * 
     * @param tProjectPersonCost 人员费用明细
     * @return 结果
     */
    @Override
    public int insertTProjectPersonCost(TProjectPersonCost tProjectPersonCost)
    {
        tProjectPersonCost.setCreateTime(DateUtils.getNowDate());
        return tProjectPersonCostMapper.insertTProjectPersonCost(tProjectPersonCost);
    }

    /**
     * 修改人员费用明细
     * 
     * @param tProjectPersonCost 人员费用明细
     * @return 结果
     */
    @Override
    public int updateTProjectPersonCost(TProjectPersonCost tProjectPersonCost)
    {
        tProjectPersonCost.setUpdateTime(DateUtils.getNowDate());
        return tProjectPersonCostMapper.updateTProjectPersonCost(tProjectPersonCost);
    }

    /**
     * 批量删除人员费用明细
     * 
     * @param ids 需要删除的人员费用明细主键
     * @return 结果
     */
    @Override
    public int deleteTProjectPersonCostByIds(String ids)
    {
        return tProjectPersonCostMapper.deleteTProjectPersonCostByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除人员费用明细信息
     * 
     * @param id 人员费用明细主键
     * @return 结果
     */
    @Override
    public int deleteTProjectPersonCostById(Long id)
    {
        return tProjectPersonCostMapper.deleteTProjectPersonCostById(id);
    }
}
