DROP TABLE taco_ingredient IF EXISTS;
DROP TABLE item_ingredient IF EXISTS;
DROP TABLE ingredient IF EXISTS;
DROP TABLE taco IF EXISTS;
DROP TABLE cart IF EXISTS;
DROP TABLE item IF EXISTS;
DROP TABLE orders IF EXISTS; 

CREATE TABLE cart (
  id INT AUTO_INCREMENT PRIMARY KEY,
  uuid VARCHAR(50) NOT NULL,
  placed_at timestamp NOT NULL
);

CREATE TABLE taco (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  unit_price DECIMAL(10, 2) NOT NULL,
  qty INT NOT NULL,
  created_at timestamp NOT NULL,
  cart_id INT NOT NULL,
  CONSTRAINT fk_cart FOREIGN KEY (cart_id) REFERENCES cart(id)
);

CREATE TABLE ingredient (
  id INT AUTO_INCREMENT PRIMARY KEY,
  mark VARCHAR(4) NOT NULL,
  name VARCHAR(25) NOT NULL,
  unit_price DECIMAL(10, 2) NOT NULL,
  ingredient_type enum('WRAP', 'PROTEIN', 'VEGGIES', 'CHEESE', 'SAUCE', 'DRINKS') NOT NULL
);

CREATE TABLE taco_ingredient (
  id INT AUTO_INCREMENT PRIMARY KEY,
  taco_id INT NOT NULL,
  ingredient_id INT NOT NULL,
  -- PRIMARY KEY (taco_id, ingredient_id),
  CONSTRAINT fk_taco FOREIGN KEY (taco_id) REFERENCES taco(id),
  CONSTRAINT fk_ingredient FOREIGN KEY (ingredient_id) REFERENCES ingredient(id)
);

CREATE TABLE orders (
  id INT AUTO_INCREMENT PRIMARY KEY, 
  uuid VARCHAR(50) NOT NULL,
  delivery_name VARCHAR(50) NOT NULL,
  delivery_street VARCHAR(50) NOT NULL,
  delivery_city VARCHAR(50) NOT NULL,
  -- delivery_state VARCHAR(2) NOT NULL,
  -- delivery_zip VARCHAR(10) NOT NULL,
  cc_number VARCHAR(16) NOT NULL,
  -- cc_expiration VARCHAR(5) NOT NULL,  
  -- cc_cvv VARCHAR(3) NOT NULL,
  placed_at timestamp NOT NULL,
  items_price DECIMAL(10, 2) NOT NULL,
  shipment_price DECIMAL(10, 2) NOT NULL,
  total_price DECIMAL(10, 2) NOT NULL
);

CREATE TABLE item (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  unit_price DECIMAL(10, 2) NOT NULL,
  sum_price DECIMAL(10, 2) NOT NULL,
  qty INT NOT NULL,
  created_at timestamp NOT NULL,
  order_id INT NOT NULL,
  CONSTRAINT fk_orders FOREIGN KEY (order_id) REFERENCES orders(id)
);

CREATE TABLE item_ingredient (
  id INT AUTO_INCREMENT PRIMARY KEY,
  item_id INT NOT NULL,
  ingredient_id INT NOT NULL,
  -- PRIMARY KEY (taco_id, ingredient_id),
  CONSTRAINT fk_item FOREIGN KEY (item_id) REFERENCES item(id),
  CONSTRAINT fk_ingredient2 FOREIGN KEY (ingredient_id) REFERENCES ingredient(id)
);

-- alter table taco
--     add foreign key (order_id) references order(id);
-- alter table taco_ingredient
--     add foreign key (ingredient) references Ingredient(id);

