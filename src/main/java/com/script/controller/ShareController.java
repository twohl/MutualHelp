package com.script.controller;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/share")
public class ShareController {

    @RequestMapping("/write")
    public String shareNearBy(){

        return "";
    }

    @RequestMapping("/getList")
    public String getShareNearBy(){

        return "";
    }

    @RequestMapping("/del")
    public String delShare(){

        return "";
    }
}
