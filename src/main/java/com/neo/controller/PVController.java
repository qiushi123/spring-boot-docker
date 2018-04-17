package com.neo.controller;

import com.neo.model.Pv2048;
import com.neo.service.IPService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import javax.annotation.Resource;

@Controller
public class PVController {

    @Resource
    IPService ipService;


    /**
     * 操作完成以后重定向到用户列表页
     *
     * @return
     */
    @RequestMapping("/pv")
    public String index() {
        //重定向到／list接口
        return "redirect:/pvlist";
    }

    @RequestMapping("/pvlist")
    public String list(Model model) {
        List<Pv2048> pv2048s = ipService.getIPList();
        model.addAttribute("pvs", pv2048s);
        return "view_ip/list";
    }
}
