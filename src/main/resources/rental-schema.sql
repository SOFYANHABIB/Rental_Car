DROP TABLE IF EXISTS `rental` CASCADE;
CREATE TABLE rental (
      id BIGINT AUTO_INCREMENT,
      clien_id BIGINT NOT NULL,
      car_id BIGINT NOT NULL,
      client_name VARCHAR(255) NOT NULL,
      car_type VARCHAR(255) NOT NULL,
      car_brand VARCHAR(255) NOT NULL,
      rental_period INTEGER NOT NULL,
      car_back BOOLEAN NOT NULL,
      rental_cost FLOAT NOT NULL,
      PRIMARY KEY (id)
      );