package com.zty.project.controller;

import com.zty.project.page.Page;
import com.zty.project.service.DeductionService;
import com.zty.project.service.StaffService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(description = "减分接口")
@RestController
@RequestMapping("Deduction")
@CrossOrigin
public class DeductionController {
    @Autowired
    private DeductionService deductionService;

    @Autowired
    private StaffService staffService;

    @ApiOperation(value = "增加减分信息",notes = "")
    @PostMapping("/InsertDeduction")
    public boolean InsertDeduction(@RequestBody Map map){
        System.out.println("map:"+map);
        int i = staffService.UpdateEndHistory(map);
        map.put("staff_id",map.get("id"));
        if(i==1){
            int j=deductionService.InsertDeduction(map);
            if(j==1){
                return true;
            }else {
                return false;
            }
        }
        return true;
    }

    @ApiOperation(value = "分页查询减分信息",notes = "")
    @PostMapping("/FindDeduction")
    public Page FindDeduction(@RequestBody Map map){
        Page page = new Page();
        page.setPageNo((Integer) map.get("pageNo"));
        page.setPageSize((Integer) map.get("pageSize"));
        page.setTotal(deductionService.Total());
        page.setItems(deductionService.FindDeduction(map));
        return page;
    }

    @ApiOperation(value = "删除减分信息",notes = "")
    @PostMapping("/DeleteDeduction")
    public boolean DeleteDeduction(@RequestBody Map map){
        return deductionService.DeleteDeduction(map)==1;
    }
}
