package hu.uni.eszterhazy.framework.dao;

import hu.uni.eszterhazy.framework.dao.entity.PizzaEntity;
import hu.uni.eszterhazy.framework.model.Pizza;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class PizzaDaoImpl implements PizzaDao{

    private final PizzaRepository repository;

    @Override
    public void create(Pizza pizza) {
        PizzaEntity entity = PizzaEntity.builder()
                .name(pizza.getName())
                .price(pizza.getPrice())
                .isAllergen(pizza.isAllergen())
                .build();
        repository.save(entity);
    }

    @Override
    public Collection<Pizza> read() {
        return StreamSupport.stream(repository.findAll().spliterator(),false)
                .map(entity -> new Pizza(
                        entity.getName(),
                        entity.getPrice(),
                        entity.isAllergen()))
                .collect(Collectors.toList());
    }

}
