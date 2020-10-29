package com.jinqian.cloundprint.controller;


import com.jinqian.cloundprint.entity.Administator;
import org.junit.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chengpan
 * @since 2020-10-12
 */
@RestController

public class AdministatorController {
    @RequestMapping("/administator")
    public String test(){

        Administator administator = new Administator();
        administator.setAdminId(2);
        administator.setAdminName("SD敢达");
        System.out.println(administator);
        return "";
    }
}

