package com.zzq.controller;

import com.zzq.util.PageStatic;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author maxwell
 * @Description: TODO
 * @date 2020/1/9 15:27
 */
@Controller
public class HtmlController {

    @RequestMapping("/getDetile")
    public String getDetile(String title , String content , Model model){
        model.addAttribute("title", title);
        model.addAttribute("content", content);

        return "index";
    }

    @RequestMapping("/toStatic")
    @ResponseBody
    public String toStatic(){
        PageStatic.main(new String[]{});
        return "ok";
    }

}
