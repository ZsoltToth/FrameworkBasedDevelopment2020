package hu.uni.eszterhazy.framework.service;

import hu.uni.eszterhazy.framework.model.Pizza;

import java.util.Collection;

public interface PizzaService {

    void record(Pizza pizza);
    Collection<Pizza> getPizzas();
}
