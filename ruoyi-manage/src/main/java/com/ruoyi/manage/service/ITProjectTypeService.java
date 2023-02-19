package com.ruoyi.manage.service;

import java.util.List;
import com.ruoyi.manage.domain.TProjectType;
import com.ruoyi.common.core.domain.Ztree;

/**
 * 项目类型Service接口
 * 
 * @author xzs
 * @date 2023-02-19
 */
public interface ITProjectTypeService 
{
    /**
     * 查询项目类型
     * 
     * @param id 项目类型主键
     * @return 项目类型
     */
    public TProjectType selectTProjectTypeById(Long id);

    /**
     * 查询项目类型列表
     * 
     * @param tProjectType 项目类型
     * @return 项目类型集合
     */
    public List<TProjectType> selectTProjectTypeList(TProjectType tProjectType);

    /**
     * 新增项目类型
     * 
     * @param tProjectType 项目类型
     * @return 结果
     */
    public int insertTProjectType(TProjectType tProjectType);

    /**
     * 修改项目类型
     * 
     * @param tProjectType 项目类型
     * @return 结果
     */
    public int updateTProjectType(TProjectType tProjectType);

    /**
     * 批量删除项目类型
     * 
     * @param ids 需要删除的项目类型主键集合
     * @return 结果
     */
    public int deleteTProjectTypeByIds(String ids);

    /**
     * 删除项目类型信息
     * 
     * @param id 项目类型主键
     * @return 结果
     */
    public int deleteTProjectTypeById(Long id);

    /**
     * 查询项目类型树列表
     * 
     * @return 所有项目类型信息
     */
    public List<Ztree> selectTProjectTypeTree();
}
