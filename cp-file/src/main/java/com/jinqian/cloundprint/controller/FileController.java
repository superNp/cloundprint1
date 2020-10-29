package com.jinqian.cloundprint.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;

@Controller
public class FileController {
    @RequestMapping("/savefile")
    public String saveFile(File file){

        return "";
    }
}
