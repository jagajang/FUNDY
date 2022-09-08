create database FUNDY;
use FUNDY;

# Objects
create table account(
    uuid int auto_increment,
    budget int,

    primary key(uuid)
);

create table user (
    uuid int auto_increment,
    id varchar(20) not null unique,
    password varchar(200) not null,
    account_uuid int unique,

    primary key(uuid),
    foreign key(account_uuid) references account(uuid)
);

create table studyGroup (
    uuid int auto_increment,
    groupName varchar(20) not null unique,
    account_uuid int not null unique,
    leader_uuid int not null,

    primary key(uuid),
    foreign key(account_uuid) references account(uuid),
    foreign key(leader_uuid) references user(uuid)
);

create table studyLog (
    uuid int auto_increment,
    createdTime datetime not null,
    content varchar(10000) not null,
    group_uuid int not null,

    primary key(uuid),
    foreign key(group_uuid) references studyGroup(uuid)
);

# Relations
create table member (
    uuid int auto_increment,
    group_uuid int not null,
    user_uuid int not null,

    primary key(uuid),
    foreign key(group_uuid) references studyGroup(uuid),
    foreign key(user_uuid) references user(uuid)
);

create table invitation(
    uuid int auto_increment,
    createdTime datetime not null,

    inviter_uuid int not null,
    invited_uuid int not null,
    group_uuid int not null,

    primary key(uuid),
    foreign key(group_uuid) references studyGroup(uuid),
    foreign key(inviter_uuid) references user(uuid),
    foreign key(invited_uuid) references user(uuid)
);