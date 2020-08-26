package cn.bjfu.service;

import cn.bjfu.mapper.EcodataMapper;
import cn.bjfu.model.Ecodata;
import cn.bjfu.utils.HbaseUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

@Service
public class EcoataService {
    @Autowired
    private EcodataMapper ecodataMapper;
    @Autowired
    private HbaseUtils utils;

    public void testEcodata(){
        Ecodata ecodata = ecodataMapper.get(1L);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:MM");
        String s = sdf.format(ecodata.getDataTime());
        System.out.println(s.toString());
    }


    public void mysqlToHbase() throws Exception {
        for(long i=1;i<=50000000L;i++){
            Ecodata ecodata = ecodataMapper.get(i);
            if(ecodata!=null){
                System.out.println(i);
                utils.test1(ecodata);
            }
        }
    }
}
