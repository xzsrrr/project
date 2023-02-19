package com.ruoyi.manage.service.impl;

import java.util.List;
import java.util.ArrayList;
import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.manage.mapper.TProjectTypeMapper;
import com.ruoyi.manage.domain.TProjectType;
import com.ruoyi.manage.service.ITProjectTypeService;
import com.ruoyi.common.core.text.Convert;

/**
 * 项目类型Service业务层处理
 * 
 * @author xzs
 * @date 2023-02-19
 */
@Service
public class TProjectTypeServiceImpl implements ITProjectTypeService 
{
    @Autowired
    private TProjectTypeMapper tProjectTypeMapper;

    /**
     * 查询项目类型
     * 
     * @param id 项目类型主键
     * @return 项目类型
     */
    @Override
    public TProjectType selectTProjectTypeById(Long id)
    {
        return tProjectTypeMapper.selectTProjectTypeById(id);
    }

    /**
     * 查询项目类型列表
     * 
     * @param tProjectType 项目类型
     * @return 项目类型
     */
    @Override
    public List<TProjectType> selectTProjectTypeList(TProjectType tProjectType)
    {
        return tProjectTypeMapper.selectTProjectTypeList(tProjectType);
    }

    /**
     * 新增项目类型
     * 
     * @param tProjectType 项目类型
     * @return 结果
     */
    @Override
    public int insertTProjectType(TProjectType tProjectType)
    {
        tProjectType.setCreateTime(DateUtils.getNowDate());
        return tProjectTypeMapper.insertTProjectType(tProjectType);
    }

    /**
     * 修改项目类型
     * 
     * @param tProjectType 项目类型
     * @return 结果
     */
    @Override
    public int updateTProjectType(TProjectType tProjectType)
    {
        tProjectType.setUpdateTime(DateUtils.getNowDate());
        return tProjectTypeMapper.updateTProjectType(tProjectType);
    }

    /**
     * 批量删除项目类型
     * 
     * @param ids 需要删除的项目类型主键
     * @return 结果
     */
    @Override
    public int deleteTProjectTypeByIds(String ids)
    {
        return tProjectTypeMapper.deleteTProjectTypeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除项目类型信息
     * 
     * @param id 项目类型主键
     * @return 结果
     */
    @Override
    public int deleteTProjectTypeById(Long id)
    {
        return tProjectTypeMapper.deleteTProjectTypeById(id);
    }

    /**
     * 查询项目类型树列表
     * 
     * @return 所有项目类型信息
     */
    @Override
    public List<Ztree> selectTProjectTypeTree()
    {
        List<TProjectType> tProjectTypeList = tProjectTypeMapper.selectTProjectTypeList(new TProjectType());
        List<Ztree> ztrees = new ArrayList<Ztree>();
        for (TProjectType tProjectType : tProjectTypeList)
        {
            Ztree ztree = new Ztree();
            ztree.setId(tProjectType.getId());
            ztree.setpId(tProjectType.getParentId());
            ztree.setName(tProjectType.getName());
            ztree.setTitle(tProjectType.getName());
            ztrees.add(ztree);
        }
        return ztrees;
    }
}
