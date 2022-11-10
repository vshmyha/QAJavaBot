package com.lerkin.qa.api.repository;

import com.lerkin.qa.api.entity.TopicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TopicRepository extends JpaRepository<TopicEntity, Integer> {


}
