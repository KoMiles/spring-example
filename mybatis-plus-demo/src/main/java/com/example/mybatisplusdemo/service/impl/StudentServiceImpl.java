package com.example.mybatisplusdemo.service.impl;

import com.example.mybatisplusdemo.entity.Student;
import com.example.mybatisplusdemo.mapper.StudentMapper;
import com.example.mybatisplusdemo.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kongming
 * @since 2020-08-25
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

}
