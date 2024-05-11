CREATE DATABASE pasteldb;

use pasteldb;

CREATE TABLE pastel(
id int auto_increment primary key,
sabor varchar(120)
);

SELECT * FROM pasteldb.pastel;

insert into pastel (sabor) values ('calamussa');
insert into pastel (sabor) values ('peixe');
insert into pastel (sabor) values ('hot-dog');

