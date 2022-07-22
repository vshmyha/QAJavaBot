CREATE TABLE topics
(
    id   integer not null auto_increment,
    name varchar(255),
    primary key (id)
);

CREATE TABLE exercises
(
    id       integer not null auto_increment,
    question text,
    answer   text,
    topic_id integer,
    primary key (id),
    foreign key (topic_id) references topics (id)
);