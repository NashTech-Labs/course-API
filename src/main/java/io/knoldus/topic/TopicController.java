package io.knoldus.topic;

import io.knoldus.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TopicController {

  @Autowired
  private TopicService topicService;

  @RequestMapping("/courses/{id}/topics")
  public List<Topic> getAllTopics(@PathVariable String id) {
    return topicService.getAllTopics(id);
  }

  @RequestMapping("/courses/{courseId}/topics/{id}")
  public Optional<Topic> getTopic(@PathVariable String id) {
    return topicService.getTopic(id);
  }

  @RequestMapping(method = RequestMethod.POST, value = "/courses/{courseId}/topics")
  public void addTopic(@RequestBody Topic topic, @PathVariable String courseId) {
    topic.setCourse(new Course(courseId, "", ""));
    topicService.addTopic(topic);
  }

  @RequestMapping(method = RequestMethod.PUT, value = "/courses/{courseId}/topics/{id}")
  public void updateTopic(@RequestBody Topic topic, @PathVariable String courseId) {
    topic.setCourse(new Course(courseId, "", ""));
    topicService.updateTopic(topic);
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/courses/{courseId}/topics/{id}")
  public void deleteTopic(@PathVariable String id) {
    topicService.deleteTopic(id);
  }
}
