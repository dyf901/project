package com.zty.project.controller;

import com.zty.project.entity.Commodity;
import com.zty.project.page.Page;
import com.zty.project.service.CommodityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
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

    @ApiOperation(value = "分页模糊查询商品信息" , notes = "")
    @PostMapping("/FindCommodity")
    public Page<Commodity> FindCommodity(@RequestBody Map map) {
        Page<Commodity> page = new Page<Commodity>();
        page.setPageNo((Integer) map.get("pageNo"));
        page.setPageSize((Integer) map.get("pageSize"));
        page.setTotal(commodityService.total());
        page.setItems(commodityService.FindCommodity(map));
        return page;
    }

    @ApiOperation(value = "分页模糊查询商品信息" , notes = "")
    @PostMapping("find_commodity")
    public Page<Commodity> find_commodity(@RequestBody Map map) {
        Page<Commodity> page = new Page<Commodity>();
        page.setPageNo((Integer) map.get("pageNo"));
        page.setPageSize((Integer) map.get("pageSize"));
        page.setTotal(commodityService.total());
        page.setItems(commodityService.find_commodity(map));
        return page;
    }

    @ApiOperation(value = "修改商品" , notes = "")
    @PostMapping("UpdateCommodity")
    public boolean UpdateCommodity(@RequestBody Map map) {
        return commodityService.UpdateCommodity(map) == 1;
    }

    @ApiOperation(value = "增加商品" , notes = "")
    @PostMapping("add_commodity")
    public boolean add_commodity(@RequestBody Map map) {
        return commodityService.add_commodity(map) == 1;
    }

    @ApiOperation(value = "修改商品状态  上架" , notes = "")
    @PostMapping("update_commodity_active0")
    public boolean update_commodity_active0(@RequestBody Map map) {
        return commodityService.update_commodity_active0(map) == 1;
    }

    @ApiOperation(value = "修改商品状态  下架" , notes = "")
    @PostMapping("update_commodity_active1")
    public boolean update_commodity_active1(@RequestBody Map map) {
        return commodityService.update_commodity_active1(map) == 1;
    }

    @ApiOperation(value = "下拉框查询商品信息" , notes = "")
    @PostMapping("select_commodity")
    public List<Commodity> select_commodity() {
        return commodityService.select_commodity();
    }

    @ApiOperation(value = "查找商品照片" , notes = "测试数据:{\"name\":\"安全行为之星系统.pdf\"}")
    @GetMapping("/find_img")
    public void find_img(@RequestParam String img_url, HttpServletResponse response) {
        try {
            BufferedInputStream bis =
                    new BufferedInputStream(
                            new FileInputStream(
                                    new File("/root/img/" + img_url)));///root/img/
            int num;
            byte[] b = new byte[1024];

            while ((num = bis.read(b)) != -1) {
                response.getOutputStream().write(b, 0, num);
            }
            response.getOutputStream().flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ApiOperation(value = "上传" , notes = "")
    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) {
        String oldFileName = file.getOriginalFilename();
        int lastDotIndex = oldFileName.lastIndexOf(".");
        String extName = oldFileName.substring(lastDotIndex);
        String newName = UUID.randomUUID() + extName;
        //String newName="http://localhost:8800/staff/find_img?img_url="+oldFileName;

        File excelFile =
                new File("/root/img/"//   /root/img/
                        + newName);
        try {
            file.transferTo(excelFile);

            return newName;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "false";
    }
}
