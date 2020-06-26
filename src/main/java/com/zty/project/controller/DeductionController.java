package com.zty.project.controller;

import com.zty.project.service.DeductionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(description = "行为接口")
@RestController
@RequestMapping("Deduction")
@CrossOrigin
public class DeductionController {
    @Autowired
    private DeductionService deductionService;

    @ApiOperation(value = "增加跟进信息",notes = "")
    @PostMapping("/InsertDeduction")
    public boolean InsertDeduction(@RequestBody Map map){

        return true;
    }
}
