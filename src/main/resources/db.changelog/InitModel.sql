-- currencies definition

-- Drop table

-- DROP TABLE currencies;

CREATE TABLE currencies (
id BIGINT NOT NULL,
short_desc varchar NOT NULL,
currency_code CHARACTER NOT NULL,
CONSTRAINT currencies_pk PRIMARY KEY (id)
);


-- brands definition

-- Drop table

-- DROP TABLE brands;

CREATE TABLE brands (
id BIGINT NOT NULL,
description varchar NOT NULL,
CONSTRAINT brands_pk PRIMARY KEY (id)
);


-- product definition

-- Drop table

-- DROP TABLE product;

CREATE TABLE product (
id BIGINT NOT NULL,
description varchar NULL,
CONSTRAINT product_pk PRIMARY KEY (id)
);


-- precios definition

-- Drop table

-- DROP TABLE precios;

CREATE TABLE precios (
id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY,
id_brand BIGINT NOT NULL,
start_date timestamp NULL,
end_date timestamp NULL,
price_list INTEGER NULL,
priority INTEGER NULL,
price numeric NULL,
id_currency BIGINT NOT NULL,
id_product BIGINT NOT NULL,
CONSTRAINT precios_pk PRIMARY KEY (id),
CONSTRAINT brands_fk FOREIGN KEY (id_brand) REFERENCES brands(id),
CONSTRAINT currency_fk FOREIGN KEY (id_currency) REFERENCES currencies(id),
CONSTRAINT product_fk FOREIGN KEY (id_product) REFERENCES product(id)
);