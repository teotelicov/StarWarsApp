package Repository;

import Domain.BaseEntity;
import Validators.ValidatorException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class JSONRepository <ID, T extends BaseEntity<ID>> implements Repository<ID, T> {

    private Map<ID, T> entities;

    public JSONRepository() {
        entities = new HashMap<>();
    }

    @Override
    public Optional<T> findOne(ID id) {
        if (id == null) {
            throw new IllegalArgumentException("Id must not be not null!");
        }
        return Optional.ofNullable(entities.get(id));
    }

    @Override
    public Iterable<T> findBy(T t) {
        if (t == null) {
            throw new IllegalArgumentException("Criteria must not be not null!");
        }
        Set<T> allEntities = entities.entrySet().stream().map(entry -> entry.getValue()).filter(entry -> t.equals(entry)).collect(Collectors.toSet());
        return allEntities;
    }

    @Override
    public Iterable<T> findAll() {
        Set<T> allEntities = entities.entrySet().stream().map(entry -> entry.getValue()).collect(Collectors.toSet());
        return allEntities;
    }

    @Override
    public Optional<T> save(T entity) throws ValidatorException {
        if (entity == null) {
            throw new IllegalArgumentException("Entity must not be null");
        }
        return Optional.ofNullable(entities.putIfAbsent(entity.getId(), entity));
    }
}
