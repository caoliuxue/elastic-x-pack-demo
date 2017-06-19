package com.adsp.demo.lenovo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

/**
 * Created by caoliuxue on 2017/6/19.
 */
@Controller
public class TestController {

    @Autowired
    AdspDemoRepository adspDemoRepository;

    @RequestMapping("write")
    @ResponseBody
    public Object write(){
        SampleOrder sampleOrder = new SampleOrder();
        sampleOrder.setOrderNo(new Random().nextLong());
        sampleOrder.setPrice(new Random().nextLong());
        return adspDemoRepository.write();
    }


    @RequestMapping("read")
    @ResponseBody
    public Object read(){
        return adspDemoRepository.read();
    }
}
