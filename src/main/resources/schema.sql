create table if not exists users(
    user_id bigint primary key auto_increment,
    name varchar(255),
    age int,
    gender varchar(255),
    city varchar(255)
);

create table if not exists books(
    book_id bigint primary key auto_increment,
    name varchar(255),
    author varchar(255),
    description varchar(255),
    available bool,
    price_per_day double,
    penalty_per_day double
);

create table if not exists issued_books(
    issue_id bigint primary key auto_increment,
    book_id bigint,
    user_id bigint,
    issued_date date,
    expected_submit_date date,
    actual_submit_date date,
    issue_days int,
    total_fee double,
    total_penalty double default 0,
    returned bool default false,
    foreign key (book_id) references books(book_id),
    foreign key (user_id) references users(user_id)

);


