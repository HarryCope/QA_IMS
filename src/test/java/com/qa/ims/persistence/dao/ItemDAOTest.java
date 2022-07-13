package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class ItemDAOTest {

	private final ItemDAO DAO = new ItemDAO();

	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schematest.sql", "src/test/resources/sql-datatest.sql");
	}

	@Test
	public void testCreate() {
		final Item created = new Item("TestItemCreate", 50L, 17L);
		assertEquals(created, DAO.create(created));
	}

	@Test
	public void testReadAll() {
		List<Item> expected = new ArrayList<>();
		expected.add(new Item("TestItem", 50L, 1L));
		expected.add(new Item("TestItem", 50L, 2L));
		expected.add(new Item("TestItem", 50L, 3L));
		assertEquals(expected, DAO.readAll());
	}

	@Test
	public void testReadLatest() {
		assertEquals(new Item("TestItem", 50L, 13L), DAO.readLatest());
	}

	@Test
	public void testRead() {
		final long itemId = 1L;
		assertEquals(new Item("TestItem", 50L, itemId), DAO.read(itemId));
	}

	@Test
	public void testUpdate() {
		final Item updated = new Item("TestItemUpdated", 40L, 1L);
		assertEquals(updated, DAO.update(updated));

	}

	@Test
	public void testDelete() {
		assertEquals(0, DAO.delete(1));
	}
}
