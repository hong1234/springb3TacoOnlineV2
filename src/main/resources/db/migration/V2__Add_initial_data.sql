
-- delete from taco_ingredient;
-- delete from ingredient;
-- delete from taco;
-- delete from order; 

-- insert into cart (uuid, placed_at) 
-- values ('510a0d7e-8e83-4193-b483-e27e09ddc34d', '2026-02-04 20:00:44'); 

-- insert into orders (delivery_name, delivery_street, delivery_city, cc_number, placed_at) 
-- values ('Hong Le', 'Green Str.5', '81737 Munich', 'RAA556677', '2026-02-04 20:00:44');
-- insert into orders (delivery_name, delivery_street, delivery_city, cc_number, placed_at) 
-- values ('Muster Man', 'Hansa Str.5', '80636 Munich', 'RA556677', '2026-01-30 10:00:56');

insert into ingredient (mark, name, unit_price, ingredient_type) values ('FLTO', 'Flour Tortilla', 3.99, 'WRAP');
insert into ingredient (mark, name, unit_price, ingredient_type) values ('COTO', 'Corn Tortilla', 3.99, 'WRAP');

insert into ingredient (mark, name, unit_price, ingredient_type) values ('GRBF', 'Ground Beef', 1.99, 'PROTEIN');
insert into ingredient (mark, name, unit_price, ingredient_type) values ('CARN', 'Carnitas', 1.99, 'PROTEIN');

insert into ingredient (mark, name, unit_price, ingredient_type) values ('TMTO', 'Diced Tomatoes', 0.99, 'VEGGIES');
insert into ingredient (mark, name, unit_price, ingredient_type) values ('LETC', 'Lettuce', 0.99, 'VEGGIES');

insert into ingredient (mark, name, unit_price, ingredient_type) values ('CHED', 'Cheddar', 0.99, 'CHEESE');
insert into ingredient (mark, name, unit_price, ingredient_type) values ('JACK', 'Monterrey Jack', 0.99, 'CHEESE');

insert into ingredient (mark, name, unit_price, ingredient_type) values ('SLSA', 'Salsa', 0.99, 'SAUCE');
insert into ingredient (mark, name, unit_price, ingredient_type) values ('SRCR', 'Sour Cream', 0.99, 'SAUCE'); 

insert into ingredient (mark, name, unit_price, ingredient_type) values ('BEER', 'Beer', 1.99, 'DRINKS');
insert into ingredient (mark, name, unit_price, ingredient_type) values ('COCA', 'Coca Cola', 1.99, 'DRINKS'); 

-- insert into taco (id, name, created_at) values (1, 'My Taco', '2025-12-31 10:00:56');

-- insert into taco_ingredient (taco_id, ingredient_id) values (1, 1); 
-- insert into taco_ingredient (taco_id, ingredient_id) values (1, 2);
-- insert into taco_ingredient (taco_id, ingredient_id) values (1, 3);
