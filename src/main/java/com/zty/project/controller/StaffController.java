package com.zty.project.controller;


import com.zty.project.dao.DepartmentDao;
import com.zty.project.dao.StaffDao;
import com.zty.project.entity.Department;
import com.zty.project.entity.Staff;
import com.zty.project.entity.WorkType;
import com.zty.project.page.Page;
import com.zty.project.service.DepartmentService;
import com.zty.project.service.StaffService;
import com.zty.project.service.WorkTypeService;
import com.zty.project.util.Msg;
import com.zty.project.util.MyException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.apache.tomcat.util.codec.binary.Base64;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTMarker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.zty.project.controller.POIExcel.getPictures1;
import static com.zty.project.controller.POIExcel.getPictures2;
import static com.zty.project.controller.POIExcel.printImg;

@Api(description = "员工接口")
@RestController
@RequestMapping("staff")
@CrossOrigin
public class StaffController {
    @Autowired
    private StaffDao staffDao;

    @Autowired
    private StaffService staffService;

    @Autowired
    private DepartmentDao departmentDao;

    @Autowired
    private WorkTypeService workTypeService;

    @Autowired
    private DepartmentService departmentService;

    @ApiOperation(value = "分页模糊查询员工信息" , notes = "测试数据:{\"pageNo\": 1, \"pageSize\":10}")
    @PostMapping("/find_staff")
    public Page<Staff> find_staff(@RequestBody Map map) {
        Page<Staff> page = new Page<Staff>();
        page.setPageNo((Integer) map.get("pageNo"));
        page.setPageSize((Integer) map.get("pageSize"));
        page.setItems(staffDao.find_staff(map));
        page.setTotal(staffDao.total(map));
        return page;
    }

    @ApiOperation(value = "增加员工信" , notes = "测试数据:{\"name\":\"晋铁\",\n" +
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
        Msg msg = new Msg();
        if (staffDao.find_staff_cardcount(map) == 1) {
            msg.setMessage("增加失败,员工已存在!");
            return msg;
        } else {
            staffDao.add_staff(map);
            Department department = departmentDao.find_department_id(map);
            map.put("percount" , department.getPercount());
            map.put("id" , department.getId());
            departmentDao.upd_department_percount(map);
            msg.setMessage("增加成功!");
            return msg;
        }

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

    @ApiOperation(value = "删除员工信息" , notes = "测试数据:{\"id\":1}")
    @PostMapping("/del_staff")
    public boolean del_staff(@RequestBody Map map) {
        return staffDao.del_staff(map) == 1;
    }

    @ApiOperation(value = "修改员工在职状态" , notes = "测试数据:{\"id\":1,\"state\":\"离职\"}")
    @PostMapping("/upd_staff_state")
    public boolean upd_staff_state(@RequestBody Map map) {
        return staffDao.upd_staff_state(map) == 1;
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

    @ApiOperation(value = "修改员工信息" , notes = "测试数据:{\"name\":\"质量制度\"}")
    @PostMapping("/upd_staff")
    public boolean upd_staff(@RequestBody Map map) {
        return staffDao.upd_staff(map) == 1;
    }

    @ApiOperation(value = "base64" , notes = "测试数据:")
    @PostMapping("/base64_img")
    public static boolean GenerateImage(@RequestBody Map map) {// 对字节数组字符串进行Base64解码并生成图片
        System.out.println(map.get("imgStr"));
        String imgStr1 = (String) map.get("imgStr");
        String imgStr = imgStr1.replaceAll(" " , "+");
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
        String uuid = UUID.randomUUID().toString().replaceAll("-" , "");
        String tempFileName = uuid + suffix;
        String imgFilePath = "D:\\Images\\" + tempFileName;//新生成的图片地址
        //String imgFilePath = "/img/wisdom_site/"+tempFileName;//新生成图片的服务器地址
        System.out.println(tempFileName);
        System.out.println(imgFilePath);
        //BASE64Decoder decoder = new BASE64Decoder();
        try {
            // Base64解码
            byte[] bytes = Base64.decodeBase64(imgStr.replace("data:image/png;base64," , ""));// decoder.decodeBuffer(imgStr);
            imgStr = imgStr.replace("base64," , "");
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

    @ApiOperation(value = "app登录接口" , notes = "")
    @PostMapping("app_login")
    public Msg app_login(@RequestBody Map map) {
        Msg msg = new Msg();
        Staff staff = staffDao.find_staff_phone(map);
        if (staff == null) {
            msg.setMessage("账号不存在!");
            return msg;
        } else {
            if (staff.getPassword().equals(map.get("password"))) {
                msg.setMessage("登录成功!");
                msg.setData(staff);
                return msg;
            } else {
                msg.setMessage("密码错误,登录失败!");
                return msg;
            }
        }
    }

    @ApiOperation(value = "批量导入" , notes = "")
    @PostMapping("/import")
    public boolean addUser(@RequestParam("file") MultipartFile file) throws Exception {
        boolean notNull = false;
        String fileName = file.getOriginalFilename();
        List<Staff> staffList = new ArrayList<Staff>();
        if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
            throw new MyException("上传文件格式不正确");
        }
        boolean isExcel2003 = true;
        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }
        InputStream is = file.getInputStream();
        Workbook wb = null;
        if (isExcel2003) {
            wb = new HSSFWorkbook(is);
        } else {
            wb = new XSSFWorkbook(is);
        }
        Sheet sheet = wb.getSheetAt(0);
        if (sheet != null) {
            notNull = true;
        }

        Map<String, PictureData> maplist = null;
        sheet = wb.getSheetAt(0);
        // 判断用07还是03的方法获取图片
        if (isExcel2003) {
            maplist = getPictures1((HSSFSheet) sheet);
        } else {
            maplist = getPictures2((XSSFSheet) sheet);
        }
        try {
            printImg(maplist);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放map
            if (maplist != null) {
                maplist = null;
            }
        }
        Staff staff;
        for (int r = 1; r <= sheet.getLastRowNum(); r++) {
            Row row = sheet.getRow(r);
            if (row == null) {
                continue;
            }

            String card1 = row.getCell(3).getStringCellValue();//身份证号
            if (card1.equals("")) {
                continue;
            }
            staff = new Staff();

            String name = row.getCell(0).getStringCellValue();//姓名
            String sex = row.getCell(1).getStringCellValue();//性别
            String nation = row.getCell(2).getStringCellValue();//民族
            row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);//设置身份证号格式
            //String card1 = row.getCell(3).getStringCellValue();//身份证号
            System.out.println("card1:" + card1);
            System.out.println(card1.length());
            String card = null;
            if (card1.length() >= 18) {
                card = card1.substring(0, 18);
            }
            System.out.println("card:" + card);
            String address = row.getCell(4).getStringCellValue();//地址
            row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);//设置手机号格式
            String phone = row.getCell(5).getStringCellValue();//手机号
            String sos_name = row.getCell(6).getStringCellValue();//紧急联系人
            String sos_ship = row.getCell(7).getStringCellValue();//紧急联系人关系
            row.getCell(8).setCellType(Cell.CELL_TYPE_STRING);//设置紧急联系人号码格式
            String sos_phone = row.getCell(8).getStringCellValue();//紧急联系人电话
            //String img_url = row.getCell(9).getStringCellValue();//照片

            row.getCell(9).setCellType(Cell.CELL_TYPE_STRING);
            //int department_id = Integer.parseInt(row.getCell(9).getStringCellValue());
            String department_name = row.getCell(9).getStringCellValue();
            List<Department> department = departmentService.select_department();
            int department_id = 0;
            for (int i = 0; i < department.size(); i++) {
                Department department1 = department.get(i);
                if (department1.getName().equals(department_name)) {
                    department_id = department1.getId();
                }
            }

            row.getCell(10).setCellType(Cell.CELL_TYPE_STRING);
            //int worktype_id = Integer.parseInt(row.getCell(10).getStringCellValue());
            String worktype_name = row.getCell(10).getStringCellValue();
            List<WorkType> worktype = workTypeService.select_worktype();
            int worktype_id = 0;
            for (int j = 0; j < worktype.size(); j++) {
                WorkType worktype1 = worktype.get(j);
                if (worktype1.getName().equals(worktype_name)) {
                    worktype_id = worktype1.getId();
                }
            }


            String type = row.getCell(11).getStringCellValue();//班组

            String img = row.getCell(12).getStringCellValue();//图片
            System.out.println("img" + img);

            String img_url = null;

            if (img.equals("null")) {
                img_url = "default.jpg";

            } else {
                SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式
                //System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
                img_url = r + "." + df.format(new Date()) + ".jpg";
            }


            //添加到实体类
            staff.setName(name);
            staff.setSex(sex);
            staff.setNation(nation);
            staff.setCard(card);
            staff.setAddress(address);
            staff.setPhone(phone);
            staff.setSos_name(sos_name);
            staff.setSos_ship(sos_ship);
            staff.setSos_phone(sos_phone);
            staff.setImg_url(img_url);
            staff.setDepartment_id(department_id);
            staff.setWorktype_id(worktype_id);
            staff.setType(type);


            //添加到数组里
            staffList.add(staff);
        }
        for (Staff staff1 : staffList) {
            String card = staff1.getCard();
            System.out.println(card);
            int cnt = staffService.CountByCard(card);
            if (cnt == 0) {
                staffService.InsertStaff(staff1);
                System.out.println(" 插入 " + staff1.toString());
            } else {
                staffService.UpdateStaffByCard(staff1);
                System.out.println(" 更新 " + staff1.toString());
            }
        }
        return notNull;
    }

    /**
     * 获取图片和位置 (xls)
     *
     * @param sheet
     * @return
     * @throws IOException
     */
    public static Map<String, PictureData> getPictures1(HSSFSheet sheet) throws IOException {
        Map<String, PictureData> map = new HashMap<String, PictureData>();
        List<HSSFShape> list = sheet.getDrawingPatriarch().getChildren();
        for (HSSFShape shape : list) {
            if (shape instanceof HSSFPicture) {
                HSSFPicture picture = (HSSFPicture) shape;
                HSSFClientAnchor cAnchor = (HSSFClientAnchor) picture.getAnchor();
                PictureData pdata = picture.getPictureData();
                //String key = cAnchor.getRow1() + "-" + cAnchor.getCol1(); // 行号-列号
                String key = String.valueOf(cAnchor.getRow1());
                map.put(key, pdata);
            }
        }
        return map;
    }

    /**
     * 获取图片和位置 (xlsx)
     *
     * @param sheet
     * @return
     * @throws IOException
     */
    public static Map<String, PictureData> getPictures2(XSSFSheet sheet) throws IOException {
        Map<String, PictureData> map = new HashMap<String, PictureData>();
        List<POIXMLDocumentPart> list = sheet.getRelations();
        for (POIXMLDocumentPart part : list) {
            if (part instanceof XSSFDrawing) {
                XSSFDrawing drawing = (XSSFDrawing) part;
                List<XSSFShape> shapes = drawing.getShapes();
                for (XSSFShape shape : shapes) {
                    XSSFPicture picture = (XSSFPicture) shape;
                    XSSFClientAnchor anchor = picture.getPreferredSize();
                    CTMarker marker = anchor.getFrom();
                    //String key = marker.getRow() + "-" + marker.getCol();
                    String key = String.valueOf(marker.getRow());
                    //System.out.println(key);
                    map.put(key, picture.getPictureData());
                }
            }
        }
        return map;
    }

    //图片写出
    public static void printImg(Map<String, PictureData> sheetList) throws Exception {
        Object key[] = sheetList.keySet().toArray();
        String filePath = "";
        for (int i = 0; i < sheetList.size(); i++) {
            // 获取图片流
            PictureData pic = sheetList.get(key[i]);
            // 获取图片索引
            String picName = key[i].toString();
            // 获取图片格式
            String ext = pic.suggestFileExtension();
            byte[] data = pic.getData();
            //文件上传七牛
//            QiNiuUtils.uploadOneObject(data,"111_"+picName + "." + ext);
            //图片保存路径
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式
            //System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
            //filePath = "D:\\img\\" + picName+"."+df.format(new Date())+ "." + ext;

            filePath = "/root/img/" + picName + "." + df.format(new Date()) + "." + ext;
            System.out.println(filePath);
            FileOutputStream out = new FileOutputStream(filePath);
            out.write(data);
            out.close();
        }
    }
}
