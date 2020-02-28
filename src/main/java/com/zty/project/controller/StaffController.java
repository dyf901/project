package com.zty.project.controller;


import com.zty.project.dao.DepartmentDao;
import com.zty.project.dao.StaffDao;
import com.zty.project.entity.Department;
import com.zty.project.entity.Staff;
import com.zty.project.page.Page;
import com.zty.project.util.Msg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Api(description = "员工接口")
@RestController
@RequestMapping("staff")
@CrossOrigin
public class StaffController {
    @Autowired
    private StaffDao staffDao;

    @Autowired
    private DepartmentDao departmentDao;

    @ApiOperation(value = "分页模糊查询员工信息", notes = "测试数据:{\"pageNo\": 1, \"pageSize\":10}")
    @PostMapping("/find_staff")
    public Page<Staff> find_staff(@RequestBody Map map) {
        Page<Staff> page = new Page<Staff>();
        page.setPageNo((Integer) map.get("pageNo"));
        page.setPageSize((Integer) map.get("pageSize"));
        page.setItems(staffDao.find_staff(map));
        page.setTotal(staffDao.total(map));
        return page;
    }

    @ApiOperation(value = "增加员工信", notes = "测试数据:{\"name\":\"晋铁\",\n" +
            "\"sex\":\"男\",\n" +
            "\"nation\":\"汉\",\n" +
            "\"address\":\"上海市静安区\",\n" +
            "\"card\":\"340000000000000000\",\n" +
            "\"phone\":\"13000000000\",\n" +
            "\"sos_name\":\"杭州\",\n" +
            "\"sos_ship\":\"朋友\",\n" +
            "\"sos_phone\":\"13000000000\",\n" +
            "\"department_id\":3,\n" +
            "\"worktype_id\":1}")
    @PostMapping("/add_staff")
    public Msg add_staff(@RequestBody Map map) {
        Msg msg =new Msg();
        if(staffDao.find_staff_cardcount(map)==1){
            msg.setMessage("增加失败,员工已存在!");
            return msg;
        }else {
            staffDao.add_staff(map);
            Department department = departmentDao.find_department_id(map);
            map.put("percount",department.getPercount());
            map.put("id",department.getId());
            departmentDao.upd_department_percount(map);
            msg.setMessage("增加成功!");
            return msg;
        }

    }

    @ApiOperation(value = "查找员工照片", notes = "测试数据:{\"name\":\"安全行为之星系统.pdf\"}")
    @GetMapping("/find_img")
    public void find_img(@RequestParam String img_url, HttpServletResponse response) {
        try {
            BufferedInputStream bis =
                    new BufferedInputStream(
                            new FileInputStream(
                                    new File("E:\\Test\\" + img_url)));///root/img/
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

    @ApiOperation(value = "删除员工信息", notes = "测试数据:{\"id\":1}")
    @PostMapping("/del_staff")
    public boolean del_staff(@RequestBody Map map) {
        return staffDao.del_staff(map) == 1;
    }

    @ApiOperation(value = "修改员工在职状态", notes = "测试数据:{\"id\":1,\"state\":\"离职\"}")
    @PostMapping("/upd_staff_state")
    public boolean upd_staff_state(@RequestBody Map map) {
        return staffDao.upd_staff_state(map) == 1;
    }

    @ApiOperation(value = "上传", notes = "")
    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) {
        String oldFileName = file.getOriginalFilename();
        int lastDotIndex = oldFileName.lastIndexOf(".");
        String extName = oldFileName.substring(lastDotIndex);
        String newName = UUID.randomUUID() + extName;
        //String newName="http://localhost:8800/staff/find_img?img_url="+oldFileName;

        File excelFile =
                new File("E:\\Test\\"//   /root/img/
                        + newName);
        try {
            file.transferTo(excelFile);

            return newName;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "false";
    }

    @ApiOperation(value = "修改员工信息", notes = "测试数据:{\"name\":\"质量制度\"}")
    @PostMapping("/upd_staff")
    public boolean upd_staff(@RequestBody Map map) {
        return staffDao.upd_staff(map)==1;
    }

    @ApiOperation(value = "base64", notes = "测试数据:")
    @PostMapping("/base64_img")
    public static boolean GenerateImage(@RequestBody Map map) {// 对字节数组字符串进行Base64解码并生成图片
        System.out.println(map.get("imgStr"));
        String imgStr1 = (String) map.get("imgStr");
        String imgStr = imgStr1.replaceAll(" ", "+");
        System.out.println("asd:" + imgStr);
        String dataPrix = ""; //base64格式前头
        String data = "";//实体部分数据
        //String imgFilePath="D:\\wangyc.png";
        if (imgStr == null) {// 图像数据为空
            return false;
        } else {
            String[] d = imgStr.split("base64,");//将字符串分成数组
            if (d != null && d.length == 2) {
                dataPrix = d[0];
                data = d[1];
            } else {
                return false;
            }
        }
        String suffix = "";//图片后缀，用以识别哪种格式数据
        //data:image/jpeg;base64,base64编码的jpeg图片数据
        if ("data:image/jpeg;".equalsIgnoreCase(dataPrix)) {
            suffix = ".jpg";
        } else if ("data:image/x-icon;".equalsIgnoreCase(dataPrix)) {
            //data:image/x-icon;base64,base64编码的icon图片数据
            suffix = ".ico";
        } else if ("data:image/gif;".equalsIgnoreCase(dataPrix)) {
            //data:image/gif;base64,base64编码的gif图片数据
            suffix = ".gif";
        } else if ("data:image/png;".equalsIgnoreCase(dataPrix)) {
            //data:image/png;base64,base64编码的png图片数据
            suffix = ".png";
        } else {
            return false;
        }
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String tempFileName = uuid + suffix;
        String imgFilePath = "D:\\Images\\" + tempFileName;//新生成的图片地址
        //String imgFilePath = "/img/wisdom_site/"+tempFileName;//新生成图片的服务器地址
        System.out.println(tempFileName);
        System.out.println(imgFilePath);
        //BASE64Decoder decoder = new BASE64Decoder();
        try {
            // Base64解码
            byte[] bytes = Base64.decodeBase64(imgStr.replace("data:image/png;base64,", ""));// decoder.decodeBuffer(imgStr);
            imgStr = imgStr.replace("base64,", "");
            for (int i = 0; i < bytes.length; ++i) {
                if (bytes[i] < 0) {// 调整异常数据
                    bytes[i] += 256;
                }
            }
            // 生成jpeg图片
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(bytes);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @ApiOperation(value = "app登录接口",notes = "")
    @PostMapping("app_login")
    public Msg app_login(@RequestBody Map map){
        Msg msg = new Msg();
        Staff staff = staffDao.find_staff_phone(map);
        if(staff==null){
            msg.setMessage("账号不存在!");
            return msg;
        }else {
            if(staff.getPassword().equals(map.get("password"))){
                msg.setMessage("登录成功!");
                msg.setData(staff);
                return msg;
            }else {
                msg.setMessage("密码错误,登录失败!");
                return msg;
            }
        }
    }
}
