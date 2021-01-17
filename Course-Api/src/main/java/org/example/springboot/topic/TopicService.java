package org.example.springboot.topic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {
    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("1", "Topic1", "Topic1 Description"),
            new Topic("2", "Topic2", "Topic2 Description"),
            new Topic("3", "Topic3", "Topic3 Description")
    ));

    public List<Topic> getAllTopics(){
        return topics;
    }

    public Topic getTopicById(String topicId){
        return topics.stream()
                .filter(t -> t.getId().equals(topicId))
                .findFirst()
                .get();
    }

    public void addTopic(Topic topic){
        topics.add(topic);
    }

    public void removeTopic(String id){
        topics.remove(getTopicById(id));
    }

    public void updateTopic(String id, Topic topic){
        for(Topic t: topics){
            if(t.getId().equals(topic.getId())){
                t.setName(topic.getName());
                t.setDescription(topic.getDescription());
                return;
            }
        }
    }
}
