package com.example.mybatisplusdemo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplusdemo.entity.User;
import com.example.mybatisplusdemo.mapper.UserMapper;
import com.example.mybatisplusdemo.service.IUserService;
import java.util.List;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author komiles@163.com
 * @date 2020-08-24 18:13
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class SampleTest {

//    @Resource
//    private UserMapper userMapper;

    @Resource
    private IUserService iUserService;


    @Test
    public void testSelect()
    {
        System.out.println(("----- selectAll method test ------"));

        List<User> userList = iUserService.list();
        Assert.assertEquals(5,userList.size());
//        userList.forEach(System.out::println);
        userList.forEach(e->System.out.println(e));
    }

    @Test
    public void testOne()
    {
        User user = iUserService.getById(1);
        Assert.assertEquals("Jone",user.getName());
        System.out.println(user.toString());

    }

    @Test
    public void pageList()
    {
        Page<User> page = new Page<User>(0,2);
        IPage<User> userIPage = iUserService.page(page);

        System.out.println(userIPage);
        System.out.println("total:"+page.getTotal());
        System.out.println("total pages:" + page.getPages());
        System.out.println("page num:" + page.getSize());
        System.out.println("pre page:" + page.hasPrevious());
        System.out.println("next page:" + page.hasNext());


    }

}
