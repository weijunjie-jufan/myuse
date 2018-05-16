package com.wei.example;

import com.wei.example.bean.excleBean.ExcleSheet;
import com.wei.example.service.excleCheak.IExcleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AllMyUseApplicationTests {
	@Autowired
	private IExcleService excleService;
	@Test
	public void contextLoads() {
        List<ExcleSheet> allUrl = excleService.findAllUrl();
        for(ExcleSheet e : allUrl){
            System.out.println(e.getBackUrl()+"---"+e.getName());
        }
    }


}
