package com.lerkin.qa.api.service;

import com.lerkin.qa.api.dto.DtoMapper;
import com.lerkin.qa.api.dto.TopicDto;
import com.lerkin.qa.api.dto.UserTopicDto;
import com.lerkin.qa.api.entity.AskedQuestionEntity;
import com.lerkin.qa.api.entity.TopicEntity;
import com.lerkin.qa.api.entity.UserTopicEntity;
import com.lerkin.qa.api.exception.EntryHasAddedException;
import com.lerkin.qa.api.repository.AskedQuestionRepository;
import com.lerkin.qa.api.repository.TopicRepository;
import com.lerkin.qa.api.repository.UserTopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TopicServiceImpl implements TopicService {

    private final TopicRepository repository;
    private final UserTopicRepository userTopicRepository;
    private final AskedQuestionRepository askedQuestionRepository;

    @Override
    public List<TopicDto> getAllTopics() {

        List<TopicEntity> entities = repository.findAll();
        return DtoMapper.convertTopicDto(entities);
    }

    @Override
    public List<TopicDto> getChosenTopicsByChatId(Long chatId) {

        List<UserTopicEntity> entities = userTopicRepository.findByChatId(chatId);
        List<TopicEntity> topics = new ArrayList<>();
        for (UserTopicEntity entity : entities) {
            topics.add(entity.getTopic());
        }
        return DtoMapper.convertTopicDto(topics);
    }

    @Override
    public void saveChosenTopics(UserTopicDto userTopicDto) {

        TopicEntity topic = getTopicById(userTopicDto.getTopicId());
        UserTopicEntity entity = new UserTopicEntity(userTopicDto.getChatId(), topic);
        try{
            userTopicRepository.save(entity);
        } catch (DataIntegrityViolationException e) {
            throw new EntryHasAddedException("This topic has already been added");
        }
    }

    @Override
    public void deleteTopic(UserTopicDto userTopicDto) {

        UserTopicEntity entity = userTopicRepository.findByChatIdAndTopicId(userTopicDto.getChatId(), userTopicDto.getTopicId());
        userTopicRepository.delete(entity);
        List<AskedQuestionEntity> askedQuestion = askedQuestionRepository.findByChatIdAndTopicId(userTopicDto.getChatId(), userTopicDto.getTopicId());
        askedQuestionRepository.deleteAll(askedQuestion);
    }

    @Override
    public TopicEntity getTopicById(Integer topicId) {

        Optional<TopicEntity> optionalTopic = repository.findById(topicId);
        return  optionalTopic.orElseThrow(() -> new RuntimeException());
    }

}
