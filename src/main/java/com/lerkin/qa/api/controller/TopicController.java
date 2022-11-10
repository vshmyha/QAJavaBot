package com.lerkin.qa.api.controller;

import com.lerkin.qa.api.dto.UserTopicDto;
import com.lerkin.qa.api.dto.TopicDto;
import com.lerkin.qa.api.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(Navigation.TOPIC)
public class TopicController {

    private final TopicService service;

    @GetMapping
    public ResponseEntity<?> getAllTopics() {

        List<TopicDto> topicDtos = service.getAllTopics();
        return ResponseEntity.ok(topicDtos);
    }

    @GetMapping(Navigation.CHOSE_BY_CHAT_ID)
    public ResponseEntity<?> getChosenTopics(@PathVariable(Navigation.CHAT_ID) Long chatId) {

        List<TopicDto> entities = service.getChosenTopicsByChatId(chatId);
        return ResponseEntity.ok(entities);
    }

    @PostMapping(Navigation.CHOSE)
    public ResponseEntity<?> chooseTopic(@RequestBody UserTopicDto userTopicDto) {

        service.saveChosenTopics(userTopicDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(Navigation.DELETE)
    public ResponseEntity<?> deleteTopic(@RequestBody UserTopicDto userTopicDto) {

        service.deleteTopic(userTopicDto);
        List<TopicDto> dtos = service.getChosenTopicsByChatId(userTopicDto.getChatId());
        return ResponseEntity.ok(dtos);
    }
}
