package hu.uni.eszterhazy.framework.dao;

import hu.uni.eszterhazy.framework.dao.entity.AddressEntity;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<AddressEntity, Integer> {
}
