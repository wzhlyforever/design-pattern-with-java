package com.wx.builder.innerclass;

import lombok.Data;

/**
 * @program: design-pattern-with-java
 * @description: 使用静态内部类实现建造者模式
 * @author: Mr.Wang
 * @create: 2021-04-25 17:16
 **/

@Data
public class Course {

    private String name;
    private String ppt;
    private String video;
    private String note;

    private String homework;

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", ppt='" + ppt + '\'' +
                ", video='" + video + '\'' +
                ", note='" + note + '\'' +
                ", homework='" + homework + '\'' +
                '}';
    }

    static class CourseBuilder{
        private Course course = new Course();

        public CourseBuilder addName(String name){
            course.setName(name);
            return this;
        }

        public CourseBuilder addPpt(String ppt){
            course.setPpt(ppt);
            return this;
        }

        public CourseBuilder addVideo(String video){
            course.setVideo(video);
            return this;
        }

        public CourseBuilder addNote(String note)
        {
            course.setNote(note);
            return this;
        }

        public CourseBuilder addHomework(String homework){
            course.setHomework(homework);
            return this;
        }

        public Course build(){
            return course;
        }
    }

    public static void main(String[] args) {
        Course course = new Course.CourseBuilder()
                .addName("design")
                .addPpt("class")
                .addVideo("video")
                .build();
        System.out.println(course);
    }
}
