package com.zty.project.controller;

import com.zty.project.entity.Commodity;
import com.zty.project.page.Page;
import com.zty.project.service.CommodityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Api(description = "商品接口")
@RestController
@RequestMapping("commodity")
@CrossOrigin
public class CommodityController {
    @Autowired
    private CommodityService commodityService;

    @ApiOperation(value = "分页模糊查询商品信息",notes = "")
    @PostMapping("find_commodity")
    public Page<Commodity> find_commodity(@RequestBody Map map){
        Page<Commodity> page =new Page<Commodity>();
        page.setPageNo((Integer) map.get("pageNo"));
        page.setPageSize((Integer) map.get("pageSize"));
        page.setTotal(commodityService.total());
        page.setItems(commodityService.find_commodity(map));
        return page;
    }

    @ApiOperation(value = "增加商品",notes = "")
    @PostMapping("add_commodity")
    public boolean add_commodity(@RequestParam("file") MultipartFile file,Commodity commodity){
        Map map =new HashMap();
        map.put("commodity_name",commodity.getCommodity_name());
        map.put("price",commodity.getPrice());
        String oldFileName = file.getOriginalFilename();
        int lastDotIndex = oldFileName.lastIndexOf(".");
        String extName = oldFileName.substring(lastDotIndex);
        String newName = UUID.randomUUID() + extName;
        map.put("url",newName);
        File excelFile =
                new File("E:\\Test\\"//   /root/img/
                        + newName);
        try {
            file.transferTo(excelFile);
            return commodityService.add_commodity(map)==1;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @ApiOperation(value = "修改商品状态  上架",notes = " ")
    @PostMapping("update_commodity_active0")
    public boolean update_commodity_active0(@RequestBody Map map){
        return commodityService.update_commodity_active0(map)==1;
    }

    @ApiOperation(value = "修改商品状态  下架",notes = "")
    @PostMapping("update_commodity_active1")
    public boolean update_commodity_active1(@RequestBody Map map){
        return commodityService.update_commodity_active1(map)==1;
    }

    @ApiOperation(value = "下拉框查询商品信息",notes = "")
    @PostMapping("select_commodity")
    public List<Commodity> select_commodity(){
        return commodityService.select_commodity();
    }
}
