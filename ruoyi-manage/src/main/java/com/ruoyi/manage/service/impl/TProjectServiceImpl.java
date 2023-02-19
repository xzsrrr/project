package com.ruoyi.manage.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.manage.mapper.TProjectMapper;
import com.ruoyi.manage.domain.TProject;
import com.ruoyi.manage.service.ITProjectService;
import com.ruoyi.common.core.text.Convert;

/**
 * 项目Service业务层处理
 * 
 * @author xzs
 * @date 2023-02-19
 */
@Service
public class TProjectServiceImpl implements ITProjectService 
{
    @Autowired
    private TProjectMapper tProjectMapper;

    /**
     * 查询项目
     * 
     * @param id 项目主键
     * @return 项目
     */
    @Override
    public TProject selectTProjectById(Long id)
    {
        return tProjectMapper.selectTProjectById(id);
    }

    /**
     * 查询项目列表
     * 
     * @param tProject 项目
     * @return 项目
     */
    @Override
    public List<TProject> selectTProjectList(TProject tProject)
    {
        return tProjectMapper.selectTProjectList(tProject);
    }

    /**
     * 新增项目
     * 
     * @param tProject 项目
     * @return 结果
     */
    @Override
    public int insertTProject(TProject tProject)
    {
        tProject.setCreateTime(DateUtils.getNowDate());
        return tProjectMapper.insertTProject(tProject);
    }

    /**
     * 修改项目
     * 
     * @param tProject 项目
     * @return 结果
     */
    @Override
    public int updateTProject(TProject tProject)
    {
        tProject.setUpdateTime(DateUtils.getNowDate());
        return tProjectMapper.updateTProject(tProject);
    }

    /**
     * 批量删除项目
     * 
     * @param ids 需要删除的项目主键
     * @return 结果
     */
    @Override
    public int deleteTProjectByIds(String ids)
    {
        return tProjectMapper.deleteTProjectByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除项目信息
     * 
     * @param id 项目主键
     * @return 结果
     */
    @Override
    public int deleteTProjectById(Long id)
    {
        return tProjectMapper.deleteTProjectById(id);
    }
}
