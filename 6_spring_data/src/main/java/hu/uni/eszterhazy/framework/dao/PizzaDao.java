package hu.uni.eszterhazy.framework.dao;

import hu.uni.eszterhazy.framework.model.Pizza;

import java.util.Collection;

/**
 * DAO = Data Access Object
 * CRUD Methods:
 *  - Create -> Insert
 *  - Read -> Select
 *  - Update -> Update
 *  - Delete -> Delete
 */
public interface PizzaDao {

    void create(Pizza pizza);

    Collection<Pizza> read();
}
