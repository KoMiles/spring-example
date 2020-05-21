package com.example.streamdemo.oop;

import org.junit.Test;

/**
 * @author komiles@163.com
 * @date 2020-05-21 19:20
 */
public class oop0521 {

    class Animal{
        public void breathe(String animal){
            System.out.println(animal+"呼吸空气");
        }
    }

    @Test
    public void test()
    {
        Animal animal = new Animal();
        animal.breathe("牛");
        animal.breathe("羊");
        animal.breathe("猪");
    }
}
