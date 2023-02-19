package com.ruoyi.manage.service;

import java.util.List;
import com.ruoyi.manage.domain.TProject;

/**
 * 项目Service接口
 * 
 * @author xzs
 * @date 2023-02-19
 */
public interface ITProjectService 
{
    /**
     * 查询项目
     * 
     * @param id 项目主键
     * @return 项目
     */
    public TProject selectTProjectById(Long id);

    /**
     * 查询项目列表
     * 
     * @param tProject 项目
     * @return 项目集合
     */
    public List<TProject> selectTProjectList(TProject tProject);

    /**
     * 新增项目
     * 
     * @param tProject 项目
     * @return 结果
     */
    public int insertTProject(TProject tProject);

    /**
     * 修改项目
     * 
     * @param tProject 项目
     * @return 结果
     */
    public int updateTProject(TProject tProject);

    /**
     * 批量删除项目
     * 
     * @param ids 需要删除的项目主键集合
     * @return 结果
     */
    public int deleteTProjectByIds(String ids);

    /**
     * 删除项目信息
     * 
     * @param id 项目主键
     * @return 结果
     */
    public int deleteTProjectById(Long id);
}
