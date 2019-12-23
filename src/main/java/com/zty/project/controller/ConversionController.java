package com.zty.project.controller;

import com.zty.project.dao.ConversionDao;
import com.zty.project.dao.StaffDao;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "兑换接口")
@RestController
@RequestMapping("conversion")
@CrossOrigin
public class ConversionController {
    @Autowired
    private ConversionDao conversionDao;

    @Autowired
    private StaffDao staffDao;


}
