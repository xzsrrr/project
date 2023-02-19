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
import com.ruoyi.manage.domain.TProjectCostYj;
import com.ruoyi.manage.service.ITProjectCostYjService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 应急项目费用申报Controller
 * 
 * @author xzs
 * @date 2023-02-19
 */
@Controller
@RequestMapping("/manage/cost")
public class TProjectCostYjController extends BaseController
{
    private String prefix = "manage/cost";

    @Autowired
    private ITProjectCostYjService tProjectCostYjService;

    @RequiresPermissions("manage:cost:view")
    @GetMapping()
    public String cost()
    {
        return prefix + "/cost";
    }

    /**
     * 查询应急项目费用申报列表
     */
    @RequiresPermissions("manage:cost:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TProjectCostYj tProjectCostYj)
    {
        startPage();
        List<TProjectCostYj> list = tProjectCostYjService.selectTProjectCostYjList(tProjectCostYj);
        return getDataTable(list);
    }

    /**
     * 导出应急项目费用申报列表
     */
    @RequiresPermissions("manage:cost:export")
    @Log(title = "应急项目费用申报", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TProjectCostYj tProjectCostYj)
    {
        List<TProjectCostYj> list = tProjectCostYjService.selectTProjectCostYjList(tProjectCostYj);
        ExcelUtil<TProjectCostYj> util = new ExcelUtil<TProjectCostYj>(TProjectCostYj.class);
        return util.exportExcel(list, "应急项目费用申报数据");
    }

    /**
     * 新增应急项目费用申报
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存应急项目费用申报
     */
    @RequiresPermissions("manage:cost:add")
    @Log(title = "应急项目费用申报", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TProjectCostYj tProjectCostYj)
    {
        return toAjax(tProjectCostYjService.insertTProjectCostYj(tProjectCostYj));
    }

    /**
     * 修改应急项目费用申报
     */
    @RequiresPermissions("manage:cost:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TProjectCostYj tProjectCostYj = tProjectCostYjService.selectTProjectCostYjById(id);
        mmap.put("tProjectCostYj", tProjectCostYj);
        return prefix + "/edit";
    }

    /**
     * 修改保存应急项目费用申报
     */
    @RequiresPermissions("manage:cost:edit")
    @Log(title = "应急项目费用申报", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TProjectCostYj tProjectCostYj)
    {
        return toAjax(tProjectCostYjService.updateTProjectCostYj(tProjectCostYj));
    }

    /**
     * 删除应急项目费用申报
     */
    @RequiresPermissions("manage:cost:remove")
    @Log(title = "应急项目费用申报", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tProjectCostYjService.deleteTProjectCostYjByIds(ids));
    }
}
