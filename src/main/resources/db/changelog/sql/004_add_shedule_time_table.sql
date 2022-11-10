CREATE TABLE shedule_time
(
    id      integer not null auto_increment,
    chat_id integer not null,
    time    time,
    primary key (id)
);