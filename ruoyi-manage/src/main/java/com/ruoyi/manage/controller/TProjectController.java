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
import com.ruoyi.manage.domain.TProject;
import com.ruoyi.manage.service.ITProjectService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 项目Controller
 * 
 * @author xzs
 * @date 2023-02-19
 */
@Controller
@RequestMapping("/manage/project")
public class TProjectController extends BaseController
{
    private String prefix = "manage/project";

    @Autowired
    private ITProjectService tProjectService;

    @RequiresPermissions("manage:project:view")
    @GetMapping()
    public String project()
    {
        return prefix + "/project";
    }

    /**
     * 查询项目列表
     */
    @RequiresPermissions("manage:project:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TProject tProject)
    {
        startPage();
        List<TProject> list = tProjectService.selectTProjectList(tProject);
        return getDataTable(list);
    }

    /**
     * 导出项目列表
     */
    @RequiresPermissions("manage:project:export")
    @Log(title = "项目", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TProject tProject)
    {
        List<TProject> list = tProjectService.selectTProjectList(tProject);
        ExcelUtil<TProject> util = new ExcelUtil<TProject>(TProject.class);
        return util.exportExcel(list, "项目数据");
    }

    /**
     * 新增项目
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存项目
     */
    @RequiresPermissions("manage:project:add")
    @Log(title = "项目", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TProject tProject)
    {
        return toAjax(tProjectService.insertTProject(tProject));
    }

    /**
     * 修改项目
     */
    @RequiresPermissions("manage:project:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TProject tProject = tProjectService.selectTProjectById(id);
        mmap.put("tProject", tProject);
        return prefix + "/edit";
    }

    /**
     * 修改保存项目
     */
    @RequiresPermissions("manage:project:edit")
    @Log(title = "项目", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TProject tProject)
    {
        return toAjax(tProjectService.updateTProject(tProject));
    }

    /**
     * 删除项目
     */
    @RequiresPermissions("manage:project:remove")
    @Log(title = "项目", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tProjectService.deleteTProjectByIds(ids));
    }
}
