package Repository;

import Domain.BaseEntity;
import Validators.ValidatorException;

import java.util.Optional;

//Interface for generic CRUD operations on a repository for a specific type.

public interface Repository<ID, T extends BaseEntity<ID>> {

    Optional<T> findOne(ID id);

    Iterable<T> findBy(T t);

    Iterable<T> findAll();

    Optional<T> save(T entity) throws ValidatorException;

}
