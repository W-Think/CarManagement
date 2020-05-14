package com.wthink.car_producer2.controller;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wthink.car_producer2.feigen.TestFengenClient;
import com.wthink.car_producer2.pojo.TbCar;
import com.wthink.car_producer2.pojo.TbCarType;
import com.wthink.car_producer2.service.TbCarTypeService;
import com.wthink.car_producer2.service.TbcarService;
import com.wthink.car_producer2.until.StaticFlag;
import com.wthink.car_producer2.vo.TbCarVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @描述:
 * @作者:wangshuai
 * @时间:2020/4/30 13:49
 */
@Controller
@RequestMapping("bmw")
public class TbcarC {
    @Autowired
    private TbcarService cs;
    @Autowired
    private TbCarTypeService cts;
    @Autowired
    TestFengenClient testFengenClient;


    /**
     * 模糊查询分页
     * @param tbCarVo
     * @param request
     * @param current
     * @return
     */
    @RequestMapping("/queryCarList")
    public ModelAndView queryCarList(TbCarVo tbCarVo, HttpServletRequest request,
                                     @RequestParam(defaultValue = "1")Integer current){
        ModelAndView modelAndView = new ModelAndView("car_list");
        PageHelper.startPage(current,5);
        List<TbCarVo> tbCarVoList = cs.queryCarList(tbCarVo);
        PageInfo pageInfo = new PageInfo(tbCarVoList);
        modelAndView.addObject("tbCarVoList",tbCarVoList);
        modelAndView.addObject("pageInfo",pageInfo);
        return modelAndView;
    }

    /**
     * 去添加修改
     * @param tbCar
     * @param tbCarType
     * @return
     */
    @RequestMapping("/toAdd")
    public ModelAndView toAdd(TbCar tbCar, TbCarType tbCarType){
        ModelAndView modelAndView = new ModelAndView("car_add");
        if (tbCar.getId()!=null){
            tbCar = cs.queryByCarId(tbCar.getId());
            //tbCarType = (TbCarType) cts.queryTypeAll();
        }else {
            tbCar = new TbCar();
        }
        modelAndView.addObject("tbCar",tbCar);
        modelAndView.addObject("tbCarType",tbCarType);
        List<TbCarType> tbCarTypeList = cts.queryTypeAll();
        modelAndView.addObject("tbCarTypeList",tbCarTypeList);
        return modelAndView;
    }

    @RequestMapping("/queryCarTypeByPId")
    @ResponseBody
    public List queryCarTypeByPId(int carPid){
        System.out.println("222222222222222");
        List list = testFengenClient.findCarType(carPid);
        return list;
    }

    @RequestMapping("/queryCarTypesByPId")
    @ResponseBody
    public List queryCarTypesByPId(int carPid){
        System.out.println("33333333333333333");
        List list = testFengenClient.findTypes(carPid);
        return list;
    }



    /**
     * 有ID修改没有则添加
     * @param tbCar
     * @param tbCarType
     * @param model
     * @return
     */
    @RequestMapping("/addCar")
    public String addCar(TbCar tbCar, TbCarType tbCarType,Model model){
        if (tbCar.getId()!=null){
            //修改
            tbCar.setCreateTime(new Date());
            tbCar.setCarTypeId1(tbCarType.getId());
            tbCar.setCarTypeId2(tbCarType.getCarPid());
            int flag=cs.updateCar(tbCar);
            if (flag>0){
                return "redirect:/bmw/queryCarList";
            }else {
                model.addAttribute("msg","车辆已存在,请重新核对!");
                return "car_add";
            }
        }else {
            //添加
            tbCar.setId(StaticFlag.queryUUID());
            tbCar.setCreateTime(new Date());
            tbCar.setCarTypeId1(tbCarType.getId());
            tbCar.setCarTypeId2(tbCarType.getCarPid());
            int flag=cs.addCar(tbCar);
            if (flag>0){
                return "redirect:/bmw/queryCarList";
            }else {
                model.addAttribute("msg","车辆已存在,请重新核对!");
                return "car_add";
            }
        }
    }

    /**
     * 获取id进行删除
     * @param ids
     */
    @RequestMapping("/delmore")
    @ResponseBody
    public int delmore(String ids){
        System.out.println(ids+"编号");
        //int[] array=new int[ids.length()];
        int delmore=cs.delmore(ids);
        return delmore;
    }

    /**
     * 导出
     * @param tbCarVo
     * @param response
     */
    @RequestMapping("/excelExport")
    public void  excelExport(TbCarVo tbCarVo, HttpServletResponse response){
        //获取数据
        List<TbCarVo> tbCarVoList = cs.queryCarList(tbCarVo);
        // 通过工具类创建writer，默认创建xls格式
        ExcelWriter writer = ExcelUtil.getWriter();
        // 一次性写出内容，使用默认样式，强制输出标题
        writer.addHeaderAlias("id", "编号");
        writer.addHeaderAlias("carName", "4s店");
        writer.addHeaderAlias("CarNewTime", "创建时间");
        writer.addHeaderAlias("createTime", "创建原时间");
        writer.addHeaderAlias("carColor", "车辆颜色");
        writer.addHeaderAlias("carPrice", "金额");
        writer.addHeaderAlias("rebate", "折扣比例（%）");
        writer.addHeaderAlias("CarNewName", "车辆描述");
        writer.addHeaderAlias("ActualPrice", "实际金额");
        writer.addHeaderAlias("carTypeId1", "品牌id");
        writer.addHeaderAlias("carTypeId2", "型号id");
        writer.merge(9, "汽车信息表");
        writer.write(tbCarVoList, true);

        //调用工具类
        StaticFlag.excelExportUtils(response,  writer);
    }
    /**
     * poi导入功能
     */
    @PostMapping("/excelImport")
    public String excelImport(@RequestParam("file") MultipartFile file, HttpServletRequest request)  {

        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
            ExcelReader reader = ExcelUtil.getReader(inputStream);
            List<TbCarVo> all = reader.readAll(TbCarVo.class);
            //批量插入的功能
            cs.addAll(all);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/bmw/queryCarList";
    }
}
