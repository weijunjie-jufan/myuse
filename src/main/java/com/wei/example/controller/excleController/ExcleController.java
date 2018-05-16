package com.wei.example.controller.excleController;

import com.wei.example.service.excleCheak.IExcleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ProjectName: all_my_use
 * @Package: com.wei.example.controller.excleController
 * @Description: java类作用描述
 * @Author: 魏俊杰
 * @CreateDate: 2018/5/3 16:12
 * @UpdateUser: 魏俊杰
 * @Version: 1.0
 * Copyright: Copyright (c) 2018
 */
@Controller
public class ExcleController {
    @Autowired
    private IExcleService excleService;

    /**
     * 展示指定文件对应的图片、PDF文档内容
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/findOne")
    public String findOne(Integer id, Model model){
        id = id == null?1:id;
        model.addAttribute("excle",excleService.findOne(id));
        System.out.println(excleService.findOne(id).getName());
        return "photos";
    }

}
