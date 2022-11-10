package com.lerkin.qa.api.controller;

public interface Navigation {

    //Parameter
    String CHAT_ID = "chatId";
    String CHAT_ID_PARAMETER = "{" + CHAT_ID + "}";
    String TOPIC_ID = "topicId";
    String TOPIC_ID_PARAMETER = "{" + TOPIC_ID + "}";
    String ID = "id";
    String ID_PARAMETER = "{" + ID + "}";

    String QUESTION_NAME = "question";
    String QUESTION_PARAM = "{" + QUESTION_NAME + "}";

    //Controller
    String TOPIC = "/topic";
    String EXERCISE = "/exercise";
    String SCHEDULE_TIME = "/scheduletime";

    //Endpoint
    String BY_CHAT_ID = "/" + CHAT_ID_PARAMETER;
    String BY_TOPIC_ID = TOPIC + "/" + TOPIC_ID_PARAMETER;
    String BY_ID = "/" + ID_PARAMETER;
    String BY_QUESTION = "/" + QUESTION_PARAM;
    String QUESTION = "/question";
    String ASK = "/ask";
    String QUESTION_ASK_BY_CHAT_ID = QUESTION + ASK + BY_CHAT_ID;
    String QUESTION_BY_TOPIC_ID = QUESTION + BY_TOPIC_ID;
    String QUESTION_BY_NAME = QUESTION + BY_QUESTION;
    String CHOSE = "/chose";
    String CHOSE_BY_CHAT_ID = CHOSE + BY_CHAT_ID;
    String CHOSE_BY_TOPIC_ID = CHOSE + BY_TOPIC_ID;
    String DELETE = "/delete";
    String NAME = "/name";
    String STATISTIC = "/statistic";
    String STATISTIC_BY_CHAT_ID = STATISTIC + BY_CHAT_ID;
}
