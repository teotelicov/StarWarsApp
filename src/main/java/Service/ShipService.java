package Service;


import Domain.Ship;
import Domain.ShipType;
import Repository.Repository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ShipService {

    private Repository<Long, Ship> repository;

    public ShipService(Repository<Long, Ship> repository) {
        this.repository = repository;
    }

    public Set<Ship> getAllShips() {
        Iterable<Ship> ships = repository.findAll();
        return StreamSupport.stream(ships.spliterator(), false).collect(Collectors.toSet());
    }

    public List<Ship> getAllShipsByType(ShipType st) {
        Iterable<Ship> ships = repository.findAll();
        return StreamSupport.stream(ships.spliterator(), false).filter(entry -> st.equals(entry.getType())).collect(Collectors.toList());

    }

}
