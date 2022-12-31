create table Client(
    id int IDENTITY not null,
    First_Name varchar(50) not null,
    Last_Name varchar(50) not null,
    DNI int not null,
    primary key(id)
);

insert into Client
    (First_Name, Last_Name, DNI) values
    ("Alan", "Sanchez", 123456789);

create table Sell(
    id int IDENTITY not null,
    Name varchar(50) not null,
    Quantity int not null,
    Total_Price int not null,
    primary key(id)
);

insert into Sell
    (Name, Quantity, Total_Price) values
    ("Candies", 10, 20);

create table Product(
    id int IDENTITY not null,
    Name varchar(50) not null;
    Code int not null;
    Price int not null;
);

insert into Product
    (Name, Code, Price) values
    ("KitKat", 987654321, 2.00);