package com.lerkin.qa.api.repository;

import com.lerkin.qa.api.entity.UserTopicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTopicRepository extends JpaRepository<UserTopicEntity, Integer> {

    List<UserTopicEntity> findByChatId(long chatId);
    UserTopicEntity findByChatIdAndTopicId(long chatId, int topicId);
}
