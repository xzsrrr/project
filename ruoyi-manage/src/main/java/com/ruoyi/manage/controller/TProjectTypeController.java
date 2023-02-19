package com.ruoyi.manage.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.manage.domain.TProjectType;
import com.ruoyi.manage.service.ITProjectTypeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.core.domain.Ztree;

/**
 * 项目类型Controller
 * 
 * @author xzs
 * @date 2023-02-19
 */
@Controller
@RequestMapping("/manage/type")
public class TProjectTypeController extends BaseController
{
    private String prefix = "manage/type";

    @Autowired
    private ITProjectTypeService tProjectTypeService;

    @RequiresPermissions("manage:type:view")
    @GetMapping()
    public String type()
    {
        return prefix + "/type";
    }

    /**
     * 查询项目类型树列表
     */
    @RequiresPermissions("manage:type:list")
    @PostMapping("/list")
    @ResponseBody
    public List<TProjectType> list(TProjectType tProjectType)
    {
        List<TProjectType> list = tProjectTypeService.selectTProjectTypeList(tProjectType);
        return list;
    }

    /**
     * 导出项目类型列表
     */
    @RequiresPermissions("manage:type:export")
    @Log(title = "项目类型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TProjectType tProjectType)
    {
        List<TProjectType> list = tProjectTypeService.selectTProjectTypeList(tProjectType);
        ExcelUtil<TProjectType> util = new ExcelUtil<TProjectType>(TProjectType.class);
        return util.exportExcel(list, "项目类型数据");
    }

    /**
     * 新增项目类型
     */
    @GetMapping(value = { "/add/{id}", "/add/" })
    public String add(@PathVariable(value = "id", required = false) Long id, ModelMap mmap)
    {
        if (StringUtils.isNotNull(id))
        {
            mmap.put("tProjectType", tProjectTypeService.selectTProjectTypeById(id));
        }
        return prefix + "/add";
    }

    /**
     * 新增保存项目类型
     */
    @RequiresPermissions("manage:type:add")
    @Log(title = "项目类型", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TProjectType tProjectType)
    {
        return toAjax(tProjectTypeService.insertTProjectType(tProjectType));
    }

    /**
     * 修改项目类型
     */
    @RequiresPermissions("manage:type:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TProjectType tProjectType = tProjectTypeService.selectTProjectTypeById(id);
        mmap.put("tProjectType", tProjectType);
        return prefix + "/edit";
    }

    /**
     * 修改保存项目类型
     */
    @RequiresPermissions("manage:type:edit")
    @Log(title = "项目类型", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TProjectType tProjectType)
    {
        return toAjax(tProjectTypeService.updateTProjectType(tProjectType));
    }

    /**
     * 删除
     */
    @RequiresPermissions("manage:type:remove")
    @Log(title = "项目类型", businessType = BusinessType.DELETE)
    @GetMapping("/remove/{id}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("id") Long id)
    {
        return toAjax(tProjectTypeService.deleteTProjectTypeById(id));
    }

    /**
     * 选择项目类型树
     */
    @GetMapping(value = { "/selectTypeTree/{id}", "/selectTypeTree/" })
    public String selectTypeTree(@PathVariable(value = "id", required = false) Long id, ModelMap mmap)
    {
        if (StringUtils.isNotNull(id))
        {
            mmap.put("tProjectType", tProjectTypeService.selectTProjectTypeById(id));
        }
        return prefix + "/tree";
    }

    /**
     * 加载项目类型树列表
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData()
    {
        List<Ztree> ztrees = tProjectTypeService.selectTProjectTypeTree();
        return ztrees;
    }
}
