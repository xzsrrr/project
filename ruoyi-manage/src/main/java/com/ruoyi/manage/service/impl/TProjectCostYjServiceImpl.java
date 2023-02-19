package com.ruoyi.manage.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.manage.domain.TProjectPersonCost;
import com.ruoyi.manage.mapper.TProjectCostYjMapper;
import com.ruoyi.manage.domain.TProjectCostYj;
import com.ruoyi.manage.service.ITProjectCostYjService;
import com.ruoyi.common.core.text.Convert;

/**
 * 应急项目费用申报Service业务层处理
 * 
 * @author xzs
 * @date 2023-02-19
 */
@Service
public class TProjectCostYjServiceImpl implements ITProjectCostYjService 
{
    @Autowired
    private TProjectCostYjMapper tProjectCostYjMapper;

    /**
     * 查询应急项目费用申报
     * 
     * @param id 应急项目费用申报主键
     * @return 应急项目费用申报
     */
    @Override
    public TProjectCostYj selectTProjectCostYjById(Long id)
    {
        return tProjectCostYjMapper.selectTProjectCostYjById(id);
    }

    /**
     * 查询应急项目费用申报列表
     * 
     * @param tProjectCostYj 应急项目费用申报
     * @return 应急项目费用申报
     */
    @Override
    public List<TProjectCostYj> selectTProjectCostYjList(TProjectCostYj tProjectCostYj)
    {
        return tProjectCostYjMapper.selectTProjectCostYjList(tProjectCostYj);
    }

    /**
     * 新增应急项目费用申报
     * 
     * @param tProjectCostYj 应急项目费用申报
     * @return 结果
     */
    @Transactional
    @Override
    public int insertTProjectCostYj(TProjectCostYj tProjectCostYj)
    {
        tProjectCostYj.setCreateTime(DateUtils.getNowDate());
        int rows = tProjectCostYjMapper.insertTProjectCostYj(tProjectCostYj);
        insertTProjectPersonCost(tProjectCostYj);
        return rows;
    }

    /**
     * 修改应急项目费用申报
     * 
     * @param tProjectCostYj 应急项目费用申报
     * @return 结果
     */
    @Transactional
    @Override
    public int updateTProjectCostYj(TProjectCostYj tProjectCostYj)
    {
        tProjectCostYj.setUpdateTime(DateUtils.getNowDate());
        tProjectCostYjMapper.deleteTProjectPersonCostByCostId(tProjectCostYj.getId());
        insertTProjectPersonCost(tProjectCostYj);
        return tProjectCostYjMapper.updateTProjectCostYj(tProjectCostYj);
    }

    /**
     * 批量删除应急项目费用申报
     * 
     * @param ids 需要删除的应急项目费用申报主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteTProjectCostYjByIds(String ids)
    {
        tProjectCostYjMapper.deleteTProjectPersonCostByCostIds(Convert.toStrArray(ids));
        return tProjectCostYjMapper.deleteTProjectCostYjByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除应急项目费用申报信息
     * 
     * @param id 应急项目费用申报主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteTProjectCostYjById(Long id)
    {
        tProjectCostYjMapper.deleteTProjectPersonCostByCostId(id);
        return tProjectCostYjMapper.deleteTProjectCostYjById(id);
    }

    /**
     * 新增人员费用明细信息
     * 
     * @param tProjectCostYj 应急项目费用申报对象
     */
    public void insertTProjectPersonCost(TProjectCostYj tProjectCostYj)
    {
        List<TProjectPersonCost> tProjectPersonCostList = tProjectCostYj.getTProjectPersonCostList();
        Long id = tProjectCostYj.getId();
        if (StringUtils.isNotNull(tProjectPersonCostList))
        {
            List<TProjectPersonCost> list = new ArrayList<TProjectPersonCost>();
            for (TProjectPersonCost tProjectPersonCost : tProjectPersonCostList)
            {
                tProjectPersonCost.setCostId(id);
                list.add(tProjectPersonCost);
            }
            if (list.size() > 0)
            {
                tProjectCostYjMapper.batchTProjectPersonCost(list);
            }
        }
    }
}
