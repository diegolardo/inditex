--PRODUCT
INSERT INTO product (id,description) VALUES
(35455,'Camiseta');


--BRANDS

INSERT INTO brands (id,description) VALUES
(1,'ZARA'),
(2,'LEFTIES');

--CURRENCY

INSERT INTO currencies (id,short_desc,currency_code) VALUES
(1,'EUR','€'),
(2,'GBP','£');

--PRECIOS
INSERT INTO precios (id_brand,start_date,end_date,price_list,priority,price,id_currency,id_product) VALUES
(1,'2020-06-14 00:00:00','2020-12-31 23:59:59',1,0,35.50,1,35455),
(1,'2020-06-14 15:00:00','2020-06-14 18:30:00',2,1,25.45,1,35455),
(1,'2020-06-15 00:00:00','2020-06-15 11:00:00',3,1,30.50,1,35455),
(1,'2020-06-15 16:00:00','2020-12-31 23:59:59',4,1,38.95,1,35455);

