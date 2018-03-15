package Service;

import Domain.Planet;
import Repository.Repository;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class PlanetService {

    private Repository<Long, Planet> repository;

    public PlanetService(Repository<Long, Planet> repository) {
        this.repository = repository;
    }

    public Set<Planet> getAllPlanets() {
        Iterable<Planet> planets = repository.findAll();
        return StreamSupport.stream(planets.spliterator(), false).collect(Collectors.toSet());
    }

    public Planet getById(Long id ) {

        return repository.findOne(id).get();
    }

}
