use Western Style; 

create table Customer
( c_id      char(9)     not null,
  cname     varchar(15) not null,
  caddress  varchar(30) not null,
  czip_code int         not null,
  ccity     varchar(15) not null,
  cphone_no varchar(15) not null,
  primary key (c_id),
  unique (cphone_no));

create table SalesOrder
(o_id        char(9)     not null,
 odate       datetime,
 cid         char(9)     not null,
 oDelStatus  varchar(15),
 oDelDate    varchar(15),
 primary key (o_id),
 foreign key (cid) references Customer (c_id));

create table Invoice
( inNo       char(4)   not null,
  inPayDay   varchar(15),
  price      char(9)   not null,
  oid        char(9)   not null,
  primary key (inNo),
  foreign key (oid) references SalesOrder (o_id));

create table ProductsAmount
( p_id       char(9)  not null,
  amount     int,
  order_id   char(9)  not null,
  primary key (p_id, order_id),
  foreign key (order_id) references SalesOrder (o_id)
  foreign key (p_id) references Product (pid));

create table Supplier
( sName      varchar(15)  not null,
  sAddress   varchar(30)  not null,
  scountry   varchar(15)  not null,
  sphone     varchar(15)  not null,
  semail     varchar(30)  not null,
  s_id       char(9)      not null,
  primary key (s_id));

create table Product
( pid        char(9)      not null,
  pname      varchar(15)  not null,
  purchaseP  decimal(5,1) not null,
  sellP      decimal(6,1) not null,
  rentP      decimal(5,1) not null,
  pcountry   varchar(15)  not null,
  pMinStock  int,
  supplier_id char(9)     not null,
  type       varchar(15)  not null,
  primary key (pid),
  foreign key (pid) references Clothing (product_id)
  foreign key (pid) references Equipment (product_id)
  foreign key (pid) references GunReplicas (product_id)
  foreign key (supplier_id) references Supplier (s_id));


create table Clothing
( size       char (9)    not null,
  colour     varchar(15) not null,
  product_id char(9)     not null,
  primary key (product_id));

create table Equipment
( type        varchar(15) not null,
  description varchar(40) not null,
  product_id  char(9) not null,
  primary key (product_id));

create table GunReplicas
( fabric     varchar(15)  not null,
  calibre    char(9)   not null,
  product_id char(9)  not null,
  primary key (product_id));
  


