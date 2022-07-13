package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.utils.DBUtils;

public class CustomerDAOTest {

	private final CustomerDAO DAO = new CustomerDAO();

	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schematest.sql", "src/test/resources/sql-datatest.sql");
	}

	@Test
	public void testCreate() {
		final Customer created = new Customer(31L, "chris", "perrins");
		assertEquals(created, DAO.create(created));
	}

	@Test
	public void testReadAll() {
		List<Customer> expected = new ArrayList<>();
		expected.clear();
		expected.add(new Customer(1L, "jordan", "harrison"));
		expected.add(new Customer(2L, "Harry", "Cope"));
		expected.add(new Customer(3L, "Eve", "Magowan"));
		expected.add(new Customer(4L, "jordan", "harrison"));
		expected.add(new Customer(5L, "Harry", "Cope"));
		expected.add(new Customer(6L, "Eve", "Magowan"));
		expected.add(new Customer(7L, "jordan", "harrison"));
		expected.add(new Customer(8L, "Harry", "Cope"));
		expected.add(new Customer(9L, "Eve", "Magowan"));
		assertEquals(expected, DAO.readAll());
	}

	@Test
	public void testReadLatest() {
		assertEquals(new Customer(3L, "Eve", "Magowan"), DAO.readLatest());
	}

	@Test
	public void testRead() {
		final long ID = 2L;
		assertEquals(new Customer(ID, "Harry", "Cope"), DAO.read(ID));
	}

	@Test
	public void testUpdate() {
		final Customer updated = new Customer(1L, "chris", "perrins");
		assertEquals(updated, DAO.update(updated));

	}

	@Test
	public void testDelete() {
		assertEquals(0, DAO.delete(1));
	}

}
