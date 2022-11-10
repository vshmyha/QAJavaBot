package com.lerkin.qa.api.repository;

import com.lerkin.qa.api.entity.ScheduleTimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleTimeRepository extends JpaRepository<ScheduleTimeEntity, Integer> {

    ScheduleTimeEntity findByChatId(long chatId);
}
