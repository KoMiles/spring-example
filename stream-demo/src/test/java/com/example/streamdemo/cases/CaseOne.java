package com.example.streamdemo.cases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Before;
import org.junit.Test;

/**
 * @author komiles@163.com
 * @date 2020-05-19 18:56
 */
public class CaseOne {

    @Data
    @AllArgsConstructor
    class ExamStudentScore{
        private String studentName;

        private Integer score;

        private String subject;
    }

    Map<String, List<ExamStudentScore>> studentMap;

    @Before
    public void init()
    {
        studentMap = new HashMap<>();

        List<ExamStudentScore> zsScoreList = new ArrayList<>();
        zsScoreList.add(
                new ExamStudentScore(
                        "张三",
                        30,
                        "CHINESE"));
        zsScoreList.add(
                new ExamStudentScore(
                        "张三",
                        40,
                        "ENGLISH"));
        zsScoreList.add(
                new ExamStudentScore(
                        "张三",
                        50,
                        "MATHS"));
        studentMap.put("张三", zsScoreList);

        List<ExamStudentScore> lsScoreList = new ArrayList<>();
        lsScoreList.add(
                new ExamStudentScore(
                        "李四",
                        80,
                        "CHINESE"));
        lsScoreList.add(
                new ExamStudentScore(
                        "李四",
                        null,
                        "ENGLISH"));
        lsScoreList.add(
                new ExamStudentScore(
                        "李四",
                        100,
                        "MATHS"));
        studentMap.put("李四", lsScoreList);

        List<ExamStudentScore> wwScoreList = new ArrayList<>();
        wwScoreList.add(
                new ExamStudentScore(
                        "王五",
                        null,
                        "CHINESE"));
        wwScoreList.add(
                new ExamStudentScore(
                        "王五",
                        null,
                        "ENGLISH"));
        wwScoreList.add(
                new ExamStudentScore(
                        "王五",
                        70,
                        "MATHS"));
        studentMap.put("王五", wwScoreList);
    }

    @Test
    public void findStudent()
    {
        studentMap.forEach((studentName,scoreList)->{
            boolean flag = scoreList.stream().anyMatch(score->{
            // anyMatch找到任意一条符合条件的数据后就停止
                return score.getScore() == null;
            });
            if(flag) {
                System.out.println("此学生[ " + studentName + " ]有缺考情况！");
            }
        });
    }
}
