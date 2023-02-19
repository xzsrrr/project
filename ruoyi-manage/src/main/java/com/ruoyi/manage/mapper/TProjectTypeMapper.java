package com.ruoyi.manage.mapper;

import java.util.List;
import com.ruoyi.manage.domain.TProjectType;

/**
 * 项目类型Mapper接口
 * 
 * @author xzs
 * @date 2023-02-19
 */
public interface TProjectTypeMapper 
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
     * 删除项目类型
     * 
     * @param id 项目类型主键
     * @return 结果
     */
    public int deleteTProjectTypeById(Long id);

    /**
     * 批量删除项目类型
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTProjectTypeByIds(String[] ids);
}
