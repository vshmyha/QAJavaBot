package com.lerkin.qa.api.repository;

import com.lerkin.qa.api.entity.ExerciseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseRepository extends JpaRepository<ExerciseEntity, Integer> {

    List<ExerciseEntity> findAllByTopic_id(Integer topicId);

    @Query(value = "SELECT * FROM Exercises e JOIN User_Topics ut ON e.topic_id = ut.topic_id WHERE ut.chat_Id = ?1 AND e.id NOT IN (?2) ORDER BY rand() LIMIT 1", nativeQuery = true)
    ExerciseEntity findNotAsked(long chatId, List<Integer> askedExercisesId);

    @Query(value = "SELECT * FROM Exercises e JOIN User_Topics ut ON e.topic_id = ut.topic_id ORDER BY rand() LIMIT 1", nativeQuery = true)
    ExerciseEntity findFirstNotAsked(long chatId);

    Integer countByTopicId(int topicId);
}
