EMPLOYEE_MASTER query->

CREATE TABLE `capstone`.`employee_master` (
  `employee_id` VARCHAR(6) NOT NULL,
  `employee_name` VARCHAR(20) NOT NULL,
  `designation` VARCHAR(25) NOT NULL,
  `department` VARCHAR(25) NOT NULL,
  `gender` CHAR(1) NOT NULL,
  `date_of_birth` DATE NOT NULL,
  `date_of_joining` DATE NOT NULL,
  PRIMARY KEY (`employee_id`));


EMPLOYEE_ISSUE_DETAILS query->

CREATE TABLE `capstone`.`employee_issue_details` (
  `issue_id` VARCHAR(6) NOT NULL,
  `employee_id` VARCHAR(6) NULL,
  `item_id` VARCHAR(6) NULL,
  `issue_date` DATE NOT NULL,
  `return_date` DATE NOT NULL,
  PRIMARY KEY (`issue_id`));

ITEM_MASTER QUERY-->

CREATE TABLE `capstone`.`item_master` (
  `item_id` VARCHAR(6) NOT NULL,
  `item_description` VARCHAR(25) NOT NULL,
  `issue_status` CHAR(1) NOT NULL,
  `item_make` VARCHAR(25) NOT NULL,
  `item_category` VARCHAR(20) NOT NULL,
  `item_valuation` INT(6) NOT NULL,
  PRIMARY KEY (`item_id`));

EMPLOYEE_CARD_DETAILS-->
CREATE TABLE `capstone`.`employee_card_details` (
  `employee_card_details` INT NULL,
  `loan_id` VARCHAR(6) NULL,
  `card_issue_date` DATE NOT NULL);

LOAN CARD MASTER-->

CREATE TABLE `capstone`.`loan_card_master` (
  `loan_id` VARCHAR(6) NOT NULL,
  `loan_type` VARCHAR(15) NOT NULL,
  `duration_in_years` INT(2) NOT NULL,
  PRIMARY KEY (`loan_id`));

EMPLOYEE_LOGIN-->

CREATE TABLE `capstone`.`employee_login` (
  `user_id` INT NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `employee_id` VARCHAR(6) NULL,
  PRIMARY KEY (`user_id`));







