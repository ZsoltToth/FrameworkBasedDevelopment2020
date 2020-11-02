package hu.uni.eszterhazy.framework.service;

import hu.uni.eszterhazy.framework.dao.PizzaDao;
import hu.uni.eszterhazy.framework.model.Pizza;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class PizzaServiceImpl implements PizzaService{

    private final PizzaDao dao;

    @Override
    public void record(Pizza pizza) {
        dao.create(pizza);
    }

    @Override
    public Collection<Pizza> getPizzas() {
        return dao.read();
    }
}
