package com.zty.project.controller;

import com.zty.project.entity.Riskshow;
import com.zty.project.entity.Staff;
import com.zty.project.page.Page;
import com.zty.project.service.RiskshowService;
import com.zty.project.service.StaffService;
import com.zty.project.util.Msg;
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

@Api(description = "隐患风险信息记录")
@RestController
@RequestMapping("riskshow")
@CrossOrigin
public class RiskshowController {
    @Autowired
    private RiskshowService riskshowService;

    @Autowired
    private StaffService staffService;

    @ApiOperation(value = "分页查询隐患风险信息" , notes = "测试数据:{\"pageNo\": 1,\n" +
            "  \"pageSize\": 10}")
    @PostMapping("/find_riskshow")
    public Page<Riskshow> find_riskshow(@RequestBody Map map) {
        Page<Riskshow> page = new Page<Riskshow>();
        page.setPageNo((Integer) map.get("pageNo"));
        page.setPageSize((Integer) map.get("pageSize"));
        page.setItems(riskshowService.find_riskshow(map));
        page.setTotal(riskshowService.total(map));
        return page;
    }

    @ApiOperation(value = "增加隐患信息" , notes = "")
    @PostMapping("add_riskshow")
    public Msg add_riskshow(@RequestParam("files") MultipartFile[] files, Riskshow riskshow) {
        Msg msg = new Msg();
        Map map = new HashMap();
        map.put("sid" , riskshow.getSid());
        map.put("risk_id" , riskshow.getRisk_id());
        map.put("station_id" , riskshow.getStation_id());
        map.put("project_id" , riskshow.getProject_id());
        map.put("description" , riskshow.getDescription());
        FileOutputStream fout = null;
        InputStream in = null;
        String path = "/root/img/";
        try {
            int count = 1;
            for (MultipartFile file : files) {
                //获取文件名
                String oldFileName = file.getOriginalFilename();
                //获取文件的后缀
                int lastDotIndex = oldFileName.lastIndexOf(".");
                String extName = oldFileName.substring(lastDotIndex);
                //判断文件后缀名
                if (extName.equals(".jpg")) {
                    extName = ".jpg";
                } else if (extName.equals(".png")) {
                    extName = ".png";
                } else if (extName.equals("jpeg")) {
                    extName = ".jpg";
                } else {
                    extName = ".jpg";
                }
                //拼成新名字
                String newName = path + UUID.randomUUID() + extName;

                String url = UUID.randomUUID() + extName;
                //这些if else是为了判断文件类型，并把文件名字存到实体类中去，并通过实体类存到数据库。
                if (count == 1) {
                    map.put("url" , url);
                    System.out.println(map.get("url"));
                } else if (count == 2) {
                    map.put("url1" , url);
                    System.out.println(map.get("url1"));
                } else if (count == 3) {
                    map.put("url2" , url);
                    System.out.println(map.get("url2"));
                } else if (count == 4) {
                    map.put("url3" , url);
                    System.out.println(map.get("url3"));
                } else if (count == 5) {
                    map.put("url4" , url);
                    System.out.println(map.get("url4"));
                } else if (count == 6) {
                    map.put("url5" , url);
                    System.out.println(map.get("url5"));
                } else if (count == 7) {
                    map.put("url6" , url);
                    System.out.println(map.get("url6"));
                } else if (count == 8) {
                    map.put("url7" , url);
                    System.out.println(map.get("url7"));
                } else if (count == 9) {
                    map.put("url8" , url);
                    System.out.println(map.get("url8"));
                }

                fout = new FileOutputStream(new File(newName));//把文件保存到新的文件夹下，newName就是上面拼凑的新的文件夹名字
                //fout.write(file.getBytes());//这样做也可以
                in = file.getInputStream();
                int len;
                byte[] byt = new byte[1024];
                while ((len = in.read(byt)) != -1) {
                    fout.write(byt, 0, len);
                }
                //  如果使用上面的fout.write(file.getBytes());可以如下关闭流
                //  fout.close();
                //  in.close();
                count++;
            }
            riskshowService.add_riskshow(map);
            msg.setMessage("上传成功!");
            return msg;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != fout) {
                try {
                    fout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        msg.setMessage("上传失败!");
        return msg;
    }


    @ApiOperation(value = "整改上报" , notes = "")
    @PostMapping("upd_riskshow")
    public Msg upd_riskshow(@RequestParam("files") MultipartFile[] files, Riskshow riskshow) {
        Msg msg = new Msg();
        Map map = new HashMap();
        map.put("remake" , riskshow.getRemark());
        FileOutputStream fout = null;
        InputStream in = null;
        String path = "/root/img/";// /root/img/
        try {
            int count = 1;
            for (MultipartFile file : files) {
                //获取文件名
                String oldFileName = file.getOriginalFilename();
                //获取文件的后缀
                int lastDotIndex = oldFileName.lastIndexOf(".");
                String extName = oldFileName.substring(lastDotIndex);
                //判断文件后缀名
                if (extName.equals(".jpg")) {
                    extName = ".jpg";
                } else if (extName.equals(".png")) {
                    extName = ".png";
                } else if (extName.equals("jpeg")) {
                    extName = ".jpg";
                } else {
                    extName = ".jpg";
                }
                //拼成新名字
                String newName = path + UUID.randomUUID() + extName;

                String url = UUID.randomUUID() + extName;
                //这些if else是为了判断文件类型，并把文件名字存到实体类中去，并通过实体类存到数据库。
                if (count == 1) {
                    map.put("url_rectify" , url);
                    System.out.println(map.get("url"));
                } else if (count == 2) {
                    map.put("url_rectify1" , url);
                    System.out.println(map.get("url1"));
                } else if (count == 3) {
                    map.put("url_rectify2" , url);
                    System.out.println(map.get("url2"));
                } else if (count == 4) {
                    map.put("url_rectify3" , url);
                    System.out.println(map.get("url3"));
                } else if (count == 5) {
                    map.put("url_rectify4" , url);
                    System.out.println(map.get("url4"));
                } else if (count == 6) {
                    map.put("url_rectify5" , url);
                    System.out.println(map.get("url5"));
                } else if (count == 7) {
                    map.put("url_rectify6" , url);
                    System.out.println(map.get("url6"));
                } else if (count == 8) {
                    map.put("url_rectify7" , url);
                    System.out.println(map.get("url7"));
                } else if (count == 9) {
                    map.put("url_rectify8" , url);
                    System.out.println(map.get("url8"));
                }

                fout = new FileOutputStream(new File(newName));//把文件保存到新的文件夹下，newName就是上面拼凑的新的文件夹名字
                //fout.write(file.getBytes());//这样做也可以
                in = file.getInputStream();
                int len;
                byte[] byt = new byte[1024];
                while ((len = in.read(byt)) != -1) {
                    fout.write(byt, 0, len);
                }
                //  如果使用上面的fout.write(file.getBytes());可以如下关闭流
                //  fout.close();
                //  in.close();
                count++;
            }
            riskshowService.upd_riskshow(map);
            msg.setMessage("上传成功!");
            return msg;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != fout) {
                try {
                    fout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        msg.setMessage("上传失败!");
        return msg;
    }

    @ApiOperation(value = "删除隐患信息" , notes = "")
    @PostMapping("del_riskshow")
    public boolean del_riskshow(@RequestBody Map map) {
        return riskshowService.del_riskshow(map) == 1;
    }

    @ApiOperation(value = "查找个人隐患记录" , notes = "")
    @PostMapping("find_riskshow_sid")
    public List<Riskshow> find_riskshow_sid(@RequestBody Map map) {
        return riskshowService.find_riskshow_sid(map);
    }

    @ApiOperation(value = "查找员工照片" , notes = "测试数据:{\"name\":\"安全行为之星系统.pdf\"}")
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

    @ApiOperation(value = "修改隐患信息审核状态有效/无效(同时给予积分)" , notes = "")
    @PostMapping("/upd_state")
    public boolean upd_state(@RequestBody Map map) {
        System.out.println(map);
        int i = riskshowService.upd_state(map);
        int p = staffService.upd_end_history(map);
        if (i == 1 && p == 1) {
            return true;
        } else {
            return false;
        }

    }
}
