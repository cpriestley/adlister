USE ymir_clayton;

DROP TABLE IF EXISTS ads;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS categories;
drop table if exists sub_categories;
DROP TABLE IF EXISTS ads_categories;

CREATE TABLE users
(
    id       INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(240) NOT NULL UNIQUE,
    email    VARCHAR(240) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE ads
(
    id          INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id     INT UNSIGNED NOT NULL,
    title       VARCHAR(240) NOT NULL,
    description TEXT         NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id)
);

# create table ads
# (
#     id          INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
#     user_id     INT UNSIGNED NOT NULL,
#     title       VARCHAR(240) NOT NULL,
#     description TEXT         NOT NULL,
#     price       DECIMAL(8, 2) NOT NULL,
#     city_neighborhood TINYTEXT NOT NULL,
#     zip_code VARCHAR(5),
#     category_id INT UNSIGNED NOT NULL,
#     make_manufacturer TINYTEXT,
#     model_name_number TINYTEXT,
#     item_condition    ENUM ('new', 'like new', 'excellent', 'good', 'fair', 'salvage') NOT NULL,
#     FOREIGN KEY (user_id) REFERENCES users (id),
#     FOREIGN KEY (category_id) REFERENCES categories (id)
# );

CREATE TABLE categories
(
    id   INT UNSIGNED       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE sub_categories
(
    id            INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name          TINYTEXT,
    categories_id INT UNSIGNED,
    FOREIGN KEY (categories_id) REFERENCES categories (id)
);

CREATE TABLE ads_categories
(
    ad_id       INT UNSIGNED,
    category_id INT UNSIGNED,
    PRIMARY KEY (ad_id, category_id),
    FOREIGN KEY (ad_id) references ads (id),
    FOREIGN KEY (category_id) REFERENCES categories (id)
);

CREATE TABLE ads_sub_categories
(
    ad_id           INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    category_id     INT UNSIGNED NOT NULL,
    sub_category_id INT UNSIGNED NOT NULL,
    FOREIGN KEY (ad_id) REFERENCES ads (id),
    FOREIGN KEY (category_id) REFERENCES categories (id),
    FOREIGN KEY (sub_category_id) REFERENCES sub_categories (id)
);

#---------------------------------------------------------------------

insert into users (email, password, username)
values ('amy@email.com', 'password', 'amy'),
       ('billy@email.com', 'password', 'billy'),
       ('cathy@email.com', 'password', 'cathy'),
       ('debbie@email.com', 'password', 'debbie'),
       ('eddie@email.com', 'password', 'eddie'),
       ('admin@email.com', 'password', 'admin');

insert into categories(name)
values ('community'),
       ('discussion forums'),
       ('for sale'),
       ('gigs'),
       ('housing'),
       ('jobs'),
       ('resumes'),
       ('services');

insert into sub_categories(categories_id, name)
values (1, 'activities'),
       (1, 'artists'),
       (1, 'childcare'),
       (1, 'classes'),
       (1, 'events'),
       (1, 'general'),
       (1, 'groups'),
       (1, 'local news'),
       (1, 'lost+found'),
       (1, 'missed connections'),
       (1, 'musicians'),
       (1, 'pets'),
       (1, 'politics'),
       (1, 'rants & raves'),
       (1, 'rideshare'),
       (1, 'volunteers'),
       (2, 'apple'),
       (2, 'arts'),
       (2, 'atheist'),
       (2, 'autos'),
       (2, 'beauty'),
       (2, 'bikes'),
       (2, 'celebs'),
       (2, 'comp'),
       (2, 'cosmos'),
       (2, 'diet'),
       (2, 'divorce'),
       (2, 'dying'),
       (2, 'eco'),
       (2, 'feedbk'),
       (2, 'film'),
       (2, 'fixit'),
       (2, 'food'),
       (2, 'frugal'),
       (2, 'gaming'),
       (2, 'garden'),
       (2, 'haiku'),
       (2, 'help'),
       (2, 'history'),
       (2, 'housing'),
       (2, 'jobs'),
       (2, 'jokes'),
       (2, 'legal'),
       (2, 'manners'),
       (2, 'marriage'),
       (2, 'money'),
       (2, 'music'),
       (2, 'open'),
       (2, 'parent'),
       (2, 'pets'),
       (2, 'philos'),
       (2, 'photo'),
       (2, 'politics'),
       (2, 'psych'),
       (2, 'recover'),
       (2, 'religion'),
       (2, 'rofo'),
       (2, 'science'),
       (2, 'spirit'),
       (2, 'sports'),
       (2, 'super'),
       (2, 'tax'),
       (2, 'travel'),
       (2, 'tv'),
       (2, 'vegan'),
       (2, 'words'),
       (2, 'writing'),
       (3, 'antiques'),
       (3, 'appliances'),
       (3, 'arts+crafts'),
       (3, 'atv/utv/sno'),
       (3, 'auto parts'),
       (3, 'aviation'),
       (3, 'baby+kid'),
       (3, 'barter'),
       (3, 'beauty+hlth'),
       (3, 'bike parts'),
       (3, 'bikes'),
       (3, 'boat parts'),
       (3, 'boats'),
       (3, 'books'),
       (3, 'business'),
       (3, 'cars+trucks'),
       (3, 'cds/dvd/vhs'),
       (3, 'cell phones'),
       (3, 'clothes+acc'),
       (3, 'collectibles'),
       (3, 'computer parts'),
       (3, 'computers'),
       (3, 'electronics'),
       (3, 'farm+garden'),
       (3, 'free'),
       (3, 'furniture'),
       (3, 'garage sale'),
       (3, 'general'),
       (3, 'heavy equip'),
       (3, 'household'),
       (3, 'jewelry'),
       (3, 'materials'),
       (3, 'motorcycle parts'),
       (3, 'motorcycles'),
       (3, 'music instr'),
       (3, 'photo+video'),
       (3, 'rvs+camp'),
       (3, 'sporting'),
       (3, 'tickets'),
       (3, 'tools'),
       (3, 'toys+games'),
       (3, 'trailers'),
       (3, 'video gaming'),
       (3, 'wanted'),
       (3, 'wheels+tires'),
       (4, 'computer'),
       (4, 'creative'),
       (4, 'crew'),
       (4, 'domestic'),
       (4, 'event'),
       (4, 'labor'),
       (4, 'talent'),
       (4, 'writing'),
       (5, 'apts / housing'),
       (5, 'housing swap'),
       (5, 'housing wanted'),
       (5, 'office / commercial'),
       (5, 'parking / storage'),
       (5, 'real estate for sale'),
       (5, 'rooms / shared'),
       (5, 'rooms wanted'),
       (5, 'sublets / temporary'),
       (5, 'vacation rentals'),
       (6, 'accounting+finance'),
       (6, 'admin / office'),
       (6, 'arch / engineering'),
       (6, 'art / media / design'),
       (6, 'biotech / science'),
       (6, 'business / mgmt'),
       (6, 'customer service'),
       (6, 'education'),
       (6, 'etc / misc'),
       (6, 'food / bev / hosp'),
       (6, 'general labor'),
       (6, 'government'),
       (6, 'human resources'),
       (6, 'legal / paralegal'),
       (6, 'manufacturing'),
       (6, 'marketing / pr / ad'),
       (6, 'medical / health'),
       (6, 'nonprofit sector'),
       (6, 'real estate'),
       (6, 'retail / wholesale'),
       (6, 'sales / biz dev'),
       (6, 'salon / spa / fitness'),
       (6, 'security'),
       (6, 'skilled trade / craft'),
       (6, 'software / qa / dba'),
       (6, 'systems / network'),
       (6, 'technical support'),
       (6, 'transport'),
       (6, 'tv / film / video'),
       (6, 'web / info design'),
       (6, 'writing / editing'),
       (8, 'automotive'),
       (8, 'beauty'),
       (8, 'cell/mobile'),
       (8, 'computer'),
       (8, 'creative'),
       (8, 'cycle'),
       (8, 'event'),
       (8, 'farm+garden'),
       (8, 'financial'),
       (8, 'health/well'),
       (8, 'household'),
       (8, 'labor/move'),
       (8, 'legal'),
       (8, 'lessons'),
       (8, 'marine'),
       (8, 'pet'),
       (8, 'real estate'),
       (8, 'skilled trade'),
       (8, 'sm biz ads'),
       (8, 'travel/vac'),
       (8, 'write/ed/tran');

insert into ads(user_id, title, description)
values (1, 'playstation for sale', 'This is a slightly used playstation'),
       (1, 'Super Nintendo', 'Get your game on with this old-school classic!'),
       (2, 'Junior Java Developer Position',
        'Minimum 7 years of experience required. You will be working in the scripting language for Java, JavaScript '),
       (2, 'JavaScript Developer needed ', 'Must have strong Java skills ');

insert into ads_sub_categories (ad_id, category_id, sub_category_id)
values (),
       (),
       (),
       (),
       ();

# Queries
# Write SQL queries to answer the following questions:
# - For a given ad, what is the email address of the user that created it?
set @ad_id := value;
select u.email
from users u
         join ads a on u.id = a.user_id
where a.id = @ad_id;

# - For a given ad, what category, or categories, does it belong to?
set @category := value;
select *
from ads a
         join ads_categories ac on a.id = ac.ad_id
         join categories c on ac.category_id = c.id
where c.name = @category;

# - For a given ad, what sub-category, or sub-categories, does it belong to?
set @ad_id := value;
select s.name
from sub_categories s
         join ads_sub_categories `asc` on s.id = `asc`.sub_category_id
where `asc`.ad_id = @ad_id;

# - For a given category, show all the ads that are in that category.
set @category := value;
select *
from ads a
         join ads_categories ac on a.id = ac.ad_id
         join categories c on ac.category_id = c.id
where c.name = @category;

# - For a given sub-category, show all the ads that are in that category.
set @category := value;
select *
from ads a
         join ads_sub_categories `asc` on a.id = `asc`.ad_id
         join sub_categories s on s.categories_id = `asc`.sub_category_id
where s.name = @category;

# - For a given user, show all the ads they have posted.
set @user_id := value;
select *
from ads
         join users u on ads.user_id = u.id
where u.id = @user_id;