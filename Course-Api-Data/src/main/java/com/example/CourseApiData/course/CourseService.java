package com.example.CourseApiData.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllTopics(String topicId){
        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(topicId).forEach(courses::add);
        return courses;
    }

    public Optional<Course> getCourseById(String courseId){
        return courseRepository.findById(courseId);
    }

    public void addCourse(Course course){
        courseRepository.save(course);
    }

    public void removeCourse(String id){
        courseRepository.deleteById(id);
    }

    public void updateCourse(Course course){
       courseRepository.save(course);
    }
}
