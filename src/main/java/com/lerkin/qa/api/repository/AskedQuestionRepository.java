package com.lerkin.qa.api.repository;

import com.lerkin.qa.api.entity.AskedQuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AskedQuestionRepository extends JpaRepository<AskedQuestionEntity, Integer> {

    List<AskedQuestionEntity> findByChatId(long chatId);

    List<AskedQuestionEntity> findByChatIdAndTopicId(long chatId, int topicId);

    Integer countByChatIdAndTopicId(long chatId, int topicId);
}
