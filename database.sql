drop schema streaming cascade ;

create schema streaming;


create table streaming.Company(
    ID serial primary key not null,
    Name varchar(255)
);

create table streaming.User
(
    ID serial primary key not null,
    FName varchar(255),
    LName varchar(255),
    Image varchar(255),
    Email varchar(255) --used as login credential
);

create table streaming.DetailLoginInfo(
    ID serial primary key not null,
    loginDate date,
    description varchar(255)
);

create table streaming.LoginInfo(
    ID serial primary key not null,
    UserID integer,
    DetailID integer,

    constraint fk_userInfo foreign key (UserID) references streaming.User(id),
    constraint fk_info foreign key (DetailID) references streaming.DetailLoginInfo(ID)
);

create table streaming.Genre(
                                ID serial primary key not null,
                                Name varchar(255)
);

create table streaming.Series(
                                 ID serial primary key not null,
                                 Image varchar(255),
                                 Name varchar(255),
                                 Description varchar(1000),
                                 Airdate date,
                                 EpisodeCount int,
                                 GenreID int,
                                 CompanyID int,
                                 Rating numeric,

                                constraint fk_company foreign key (CompanyID) references streaming.Company(id),
                                 constraint fk_Genre foreign key (GenreID) references streaming.Genre(ID)
);
create table streaming.Comments(
    ID serial primary key not null,
    UserID integer,
    SeriesID integer,
    comment varchar(2000),
    constraint UserComment foreign key (UserID) references streaming.User(id),
    constraint SeriesComment foreign key (SeriesID) references streaming.Series(id)

);
create table streaming.Episode(
                                  ID serial primary key not null,
                                  SeriesID int,
                                  Name varchar(255),
                                  Description varchar(1000),
                                  VideoLink varchar(255),

                                  constraint fk_Series foreign key (SeriesID) references streaming.Series(ID)
);

create table streaming.WatchList( /*Lists watched episodes*/
                                    ID serial primary key not null,
                                    UserID int,
                                    EpisodeID int,

                                    constraint Fk_UserW foreign key (UserID) references streaming.User(ID),
                                    constraint FK_EpisodeW foreign key (EpisodeID) references streaming.Episode(ID)
);

create table streaming.Bookmark( /*Bookmark series*/
                                   ID serial primary key not null,
                                   UserID int,
                                   SeriesID int,

                                   constraint Fk_UserB foreign key (UserID) references streaming.User(ID),
                                   constraint FK_SeriesB foreign key (SeriesID) references streaming.Series(ID)
);


alter table streaming."user"
    add password varchar(50) default 'password' not null;

