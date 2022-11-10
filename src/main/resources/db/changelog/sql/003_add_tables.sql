CREATE TABLE user_topics
(
    id integer not null auto_increment,
    chat_id  bigint,
    topic_id integer,
    primary key (id),
    foreign key (topic_id) references topics (id),
    UNIQUE (chat_id, topic_id)
);

CREATE TABLE asked_questions
(
    id integer not null auto_increment,
    chat_id bigint not null,
    question_id integer not null,
    topic_id integer not null,
    primary key (id),
    foreign key (question_id) references exercises(id),
    foreign key (topic_id) references topics(id)

);

