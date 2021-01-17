package com.example.CourseApiData.course;

import com.example.CourseApiData.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/topics/{topicId}/courses")
    public List<Course> getAllTopics(@PathVariable String topicId){
        return courseService.getAllTopics(topicId);
    }

    @GetMapping("/topics/{topicId}/courses/{id}")
    public Optional<Course> getTopicById(@PathVariable String id){
        return courseService.getCourseById(id);
    }

    @PostMapping("/topics/{topicId}/courses")
    public void addTopic(@RequestBody Course course, @PathVariable String topicId){
        course.setTopic(new Topic(topicId, "", ""));
        courseService.addCourse(course);
    }

    @PutMapping("/topics/{topicId}/courses/{id}")
    public void updateTopic(@PathVariable String id, @RequestBody Course course, @PathVariable String topicId){
        course.setTopic(new Topic(topicId, "", ""));
        courseService.updateCourse(course);
    }

    @DeleteMapping("/topics/{topicId}/courses/{id}")
    public void removeTopic(@PathVariable String id){
        courseService.removeCourse(id);
    }

}
