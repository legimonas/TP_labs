insert into user(id, login, password, role)
values (1, 'davill02', '1359', 'PRODUCT_MANAGER'),
       (2, 'legimonas100', '1234', 'CATALOG_MANAGER'),
       (4, 'sale', '1234', 'SALESMAN'),
       (3, 'cralia', '8888', 'TRANSPORT_MANAGER');
insert into ordered(id, lastname, address, price, delivery)
values (1, 'Krus', 'Minsk', 230, ''),
       (2, 'Bliatz', 'Rome', 240, ''),
       (4, 'K.', 'Minsk', 230, ''),
       (5, 'Ivanich', 'Minsk', 230, '');
insert into deliveryCompany(id, name)
values (1, 'HellDelivery'),
       (3, 'Post'),
       (6, 'HelDelivery');