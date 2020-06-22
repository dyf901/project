package com.zty.project.controller;

import com.zty.project.dao.CommodityDao;
import com.zty.project.dao.ConversionDao;
import com.zty.project.dao.StaffDao;
import com.zty.project.entity.Commodity;
import com.zty.project.entity.Conversion;
import com.zty.project.entity.Staff;
import com.zty.project.page.Page;
import com.zty.project.util.Msg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(description = "兑换接口")
@RestController
@RequestMapping("conversion")
@CrossOrigin
public class ConversionController {
    @Autowired
    private ConversionDao conversionDao;

    @Autowired
    private StaffDao staffDao;

    @Autowired
    private CommodityDao commodityDao;

    @ApiOperation(value = "分页模糊查询兑换记录")
    @PostMapping("find_conversion")
    public Page<Conversion> find_conversion(@RequestBody Map map) {
        Page<Conversion> page = new Page<Conversion>();
        page.setPageNo((Integer) map.get("pageNo"));
        page.setPageSize((Integer) map.get("pageSize"));
        page.setItems(conversionDao.find_conversion(map));
        page.setTotal(conversionDao.total());
        return page;
    }

    @ApiOperation(value = "增加兑换记录" , notes = "")
    @PostMapping("add_conversion")
    public Msg add_conversion(@RequestBody Map map) {
        Msg msg = new Msg();
        Staff staff = staffDao.find_id(map);
        Commodity commodity = commodityDao.select_commodity_id(map);
        map.put("type" , staff.getType());
        map.put("did" , staff.getDepartment_id());
        map.put("cid" , commodity.getId());
        if (staff.getEnd() >= commodity.getPrice()) {
            int i = conversionDao.add_conversion(map);
            if (i == 1) {
                map.put("price" , commodity.getPrice());
                staffDao.upd_end(map);
                msg.setMessage("兑换成功!");
                return msg;
            } else {
                msg.setMessage("兑换失败!");
                return msg;
            }
        } else {
            msg.setMessage("积分不足兑换失败!");
            return msg;
        }
    }

    @ApiOperation(value = "查找个人兑换记录" , notes = "")
    @PostMapping("find_conversion_sid")
    public List<Conversion> find_conversion_sid(@RequestBody Map map) {
        return conversionDao.find_conversion_sid(map);
    }
}
