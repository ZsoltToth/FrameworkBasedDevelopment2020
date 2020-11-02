package hu.uni.eszterhazy.framework.dao;

import hu.uni.eszterhazy.framework.dao.entity.PizzaEntity;
import org.springframework.data.repository.CrudRepository;

public interface PizzaRepository extends CrudRepository<PizzaEntity, Integer> {
}
