CREATE TABLE notification
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    notifier BIGINT NOT NULL,
    receiver bigint not null,
    outerid bigint not null,
    type int not null,
    gmt_create bigint not null,
    status int default 0 not null,
    notifier_name varchar(100) null,
    outer_title varchar(256) null
);
/*
加入outerTitle原因是在插入查找过程中一般会搜过相应的，这样可以避免显示的时候得通过outerID查找
对象浪费资源，算是一种优化
notifierName同理
*/