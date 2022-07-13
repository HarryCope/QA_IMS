DROP TABLE IF EXISTS `customers`;

CREATE TABLE IF NOT EXISTS `customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `items`;

CREATE TABLE IF NOT EXISTS `items` (
    `item_id` INT AUTO_INCREMENT NOT NULL,
    `item_name` VARCHAR(50) NOT NULL,
    `price` decimal(6,2) NOT NULL,
    PRIMARY KEY (`item_id`)
);

DROP TABLE IF EXISTS `orders`;

CREATE TABLE IF NOT EXISTS `orders` (
    `order_id` INT AUTO_INCREMENT NOT NULL,
    `id` INT NOT NULL,
    `item_id` INT NOT NULL,
    PRIMARY KEY (`order_id`),
    FOREIGN KEY (id) references customers(id),
    FOREIGN KEY (item_id) references items(item_id)
);