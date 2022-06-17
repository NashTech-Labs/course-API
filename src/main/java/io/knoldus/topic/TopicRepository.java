package io.knoldus.topic;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TopicRepository extends MongoRepository<Topic, String> {
    List<Topic> findByCourseId(String topicId);
}
