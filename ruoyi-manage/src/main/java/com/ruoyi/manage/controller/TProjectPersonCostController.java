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
import com.ruoyi.manage.domain.TProjectPersonCost;
import com.ruoyi.manage.service.ITProjectPersonCostService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 人员费用明细Controller
 * 
 * @author xzs
 * @date 2023-02-19
 */
@Controller
@RequestMapping("/manage/person")
public class TProjectPersonCostController extends BaseController
{
    private String prefix = "manage/person";

    @Autowired
    private ITProjectPersonCostService tProjectPersonCostService;

    @RequiresPermissions("manage:person:view")
    @GetMapping()
    public String person()
    {
        return prefix + "/person";
    }

    /**
     * 查询人员费用明细列表
     */
    @RequiresPermissions("manage:person:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TProjectPersonCost tProjectPersonCost)
    {
        startPage();
        List<TProjectPersonCost> list = tProjectPersonCostService.selectTProjectPersonCostList(tProjectPersonCost);
        return getDataTable(list);
    }

    /**
     * 导出人员费用明细列表
     */
    @RequiresPermissions("manage:person:export")
    @Log(title = "人员费用明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TProjectPersonCost tProjectPersonCost)
    {
        List<TProjectPersonCost> list = tProjectPersonCostService.selectTProjectPersonCostList(tProjectPersonCost);
        ExcelUtil<TProjectPersonCost> util = new ExcelUtil<TProjectPersonCost>(TProjectPersonCost.class);
        return util.exportExcel(list, "人员费用明细数据");
    }

    /**
     * 新增人员费用明细
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存人员费用明细
     */
    @RequiresPermissions("manage:person:add")
    @Log(title = "人员费用明细", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TProjectPersonCost tProjectPersonCost)
    {
        return toAjax(tProjectPersonCostService.insertTProjectPersonCost(tProjectPersonCost));
    }

    /**
     * 修改人员费用明细
     */
    @RequiresPermissions("manage:person:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TProjectPersonCost tProjectPersonCost = tProjectPersonCostService.selectTProjectPersonCostById(id);
        mmap.put("tProjectPersonCost", tProjectPersonCost);
        return prefix + "/edit";
    }

    /**
     * 修改保存人员费用明细
     */
    @RequiresPermissions("manage:person:edit")
    @Log(title = "人员费用明细", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TProjectPersonCost tProjectPersonCost)
    {
        return toAjax(tProjectPersonCostService.updateTProjectPersonCost(tProjectPersonCost));
    }

    /**
     * 删除人员费用明细
     */
    @RequiresPermissions("manage:person:remove")
    @Log(title = "人员费用明细", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tProjectPersonCostService.deleteTProjectPersonCostByIds(ids));
    }
}
