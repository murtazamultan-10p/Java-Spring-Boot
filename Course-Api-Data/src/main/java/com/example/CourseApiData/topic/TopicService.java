package com.example.CourseApiData.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getAllTopics(){
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Optional<Topic> getTopicById(String topicId){
        return topicRepository.findById(topicId);
    }

    public void addTopic(Topic topic){
        topicRepository.save(topic);
    }

    public void removeTopic(String id){
        topicRepository.deleteById(id);
    }

    public void updateTopic(Topic topic){
       topicRepository.save(topic);
    }
}
