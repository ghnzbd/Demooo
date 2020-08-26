package cn.bjfu.controller;

import cn.bjfu.service.EcoataService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EcodataController {
    @Autowired
    private EcoataService ecoataService;

    @ApiOperation("测试test")
    @RequestMapping("/test")
    public void testEcodata(){
        ecoataService.testEcodata();
    }

    @ApiOperation("mysqlToHbase")
    @RequestMapping("/mysqlToHbase")
    public void mysqlToHbase() throws Exception{
        ecoataService.mysqlToHbase();
    }

}
