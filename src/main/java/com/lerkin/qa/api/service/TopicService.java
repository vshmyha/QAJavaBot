package com.lerkin.qa.api.service;

import com.lerkin.qa.api.dto.TopicDto;
import com.lerkin.qa.api.dto.UserTopicDto;
import com.lerkin.qa.api.entity.TopicEntity;

import java.util.List;

public interface TopicService {

    List<TopicDto> getAllTopics();

    List<TopicDto> getChosenTopicsByChatId(Long chatId);

    void saveChosenTopics(UserTopicDto userTopicDto);

    void deleteTopic(UserTopicDto userTopicDto);

    TopicEntity getTopicById(Integer topicId);

}
