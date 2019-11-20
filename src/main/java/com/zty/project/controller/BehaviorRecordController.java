package com.zty.project.controller;

import com.zty.project.dao.BehaviorRecordDao;
import com.zty.project.dao.StaffDao;
import com.zty.project.entity.BehaviorRecord;
import com.zty.project.entity.Staff;
import com.zty.project.page.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(description = "行为记录接口")
@RestController
@RequestMapping("behaviorrecord")
@CrossOrigin
public class BehaviorRecordController {
    @Autowired
    private BehaviorRecordDao behaviorRecordDao;

    @Autowired
    private StaffDao staffDao;

    @ApiOperation(value = "分页查询行为记录", notes = "")
    @PostMapping("/find_behaviorrecord")
    public Page<BehaviorRecord> find_behaviorrecord(@RequestBody Map map) {
        Page<BehaviorRecord> page = new Page<BehaviorRecord>();
        page.setPageNo((Integer) map.get("pageNo"));
        page.setPageSize((Integer) map.get("pageSize"));
        page.setItems(behaviorRecordDao.find_behaviorrecord(map));
        page.setTotal(behaviorRecordDao.total());
        return page;
    }

    @ApiOperation(value = "增加行为记录", notes = "")
    @PostMapping("/add_behaviorrecord")
    public String add_behaviorrecord(@RequestBody Map map) {
        System.out.println(map.size());
        Staff staff = staffDao.find_staff_card(map);
        System.out.println(staff);
        map.put("staff_id", staff.getId());
        if (staff.getName().equals(map.get("name"))) {
            map.put("staff_id", staffDao.find_staff_card(map).getId());
            behaviorRecordDao.add_behaviorrecord(map);
            return "true";
        }
        return "false";
    }

    @ApiOperation(value = "删除行为记录", notes = "")
    @PostMapping("/del_behaviorrecord")
    public boolean del_behaviorrecord(@RequestBody Map map) {
        return behaviorRecordDao.del_behaviorrecord(map) == 1;
    }

    @ApiOperation(value = "修改行为记录", notes = "")
    @PostMapping("/upd_behaviorrecord")
    public boolean upd_behaviorrecord(@RequestBody Map map) {
        return behaviorRecordDao.upd_behaviorrecord(map) == 1;
    }
}
