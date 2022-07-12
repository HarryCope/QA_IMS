package com.qa.ims;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.controller.Action;
import com.qa.ims.controller.CrudController;
import com.qa.ims.controller.CustomerController;
import com.qa.ims.controller.ItemController;
import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Domain;
import com.qa.ims.utils.DBUtils;
import com.qa.ims.utils.Utils;

public class IMS {

	public static final Logger LOGGER = LogManager.getLogger();

	private final CustomerController customers;
	private final ItemController items;
	private final Utils utils;

	public IMS() {
		this.utils = new Utils();
		final CustomerDAO custDAO = new CustomerDAO();
		this.customers = new CustomerController(custDAO, utils);

		final ItemDAO iteDAO = new ItemDAO();
		this.items = new ItemController(iteDAO, utils);
	}

	public void imsSystem() {

		try {
			Connection con = DriverManager.getConnection(DBUtils.getBaseDbUrl(), DBUtils.getDbUser(),
					DBUtils.getDbPassword());
			Statement state = con.createStatement();
			state.execute("CREATE DATABASE IF NOT EXISTS `ims`");

		} catch (SQLException e) {
			LOGGER.error(e);
			System.out.println(DBUtils.getDbUrl());
			System.out.println(e.getStackTrace());
		}

		try {
			Connection con = DriverManager.getConnection(DBUtils.getDbUrl(), DBUtils.getDbUser(),
					DBUtils.getDbPassword());
			Statement state = con.createStatement();
			state.execute("CREATE TABLE IF NOT EXISTS `customers`(" + "first_name varchar(30) not null, "
					+ "surname varchar(30) not null, " + "id int auto_increment not null, " + "primary key (id))");

		} catch (SQLException e) {
			LOGGER.error(e);
			System.out.println(e.getStackTrace());
		}

		try {
			Connection con = DriverManager.getConnection(DBUtils.getDbUrl(), DBUtils.getDbUser(),
					DBUtils.getDbPassword());
			Statement state = con.createStatement();
			state.execute("CREATE TABLE IF NOT EXISTS `items`(" + "item_name varchar(50) not null, "
					+ "price int not null, " + "item_id int auto_increment not null, " + "primary key (item_id))");

		} catch (SQLException e) {
			LOGGER.error(e);
			System.out.println(e.getStackTrace());
		}

		try {
			Connection con = DriverManager.getConnection(DBUtils.getDbUrl(), DBUtils.getDbUser(),
					DBUtils.getDbPassword());
			Statement state = con.createStatement();
			state.execute("CREATE TABLE IF NOT EXISTS `orders`(" + "order_id int auto_increment not null, "
					+ "id int not null, " + "item_id int not null, " + "primary key (order_id), "
					+ "foreign key (id) references customers(id), "
					+ "foreign key (item_id) references items(item_id))");

		} catch (SQLException e) {
			LOGGER.error(e);
			System.out.println(e.getStackTrace());
		}

		LOGGER.info("Welcome to the Inventory Management System!");
		DBUtils.connect();

		Domain domain = null;
		do {
			LOGGER.info("Which entity would you like to use?");
			Domain.printDomains();

			domain = Domain.getDomain(utils);

			domainAction(domain);

		} while (domain != Domain.STOP);
	}

	private void domainAction(Domain domain) {
		boolean changeDomain = false;
		do {

			CrudController<?> active = null;
			switch (domain) {
			case CUSTOMER:
				active = this.customers;
				break;
			case ITEM:
				active = this.items;
				break;
			case ORDER:
				break;
			case STOP:
				return;
			default:
				break;
			}

			LOGGER.info(() -> "What would you like to do with " + domain.name().toLowerCase() + ":");

			Action.printActions();
			Action action = Action.getAction(utils);

			if (action == Action.RETURN) {
				changeDomain = true;
			} else {
				doAction(active, action);
			}
		} while (!changeDomain);
	}

	public void doAction(CrudController<?> crudController, Action action) {
		switch (action) {
		case CREATE:
			crudController.create();
			break;
		case READ:
			crudController.readAll();
			break;
		case UPDATE:
			crudController.update();
			break;
		case DELETE:
			crudController.delete();
			break;
		case RETURN:
			break;
		default:
			break;
		}
	}

}
