package Service;

import Domain.Character;
import Domain.ShipType;
import Repository.Repository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class CharacterService {
    private Repository<Long, Character> repository;

    public CharacterService(Repository<Long, Character> repository) {
        this.repository = repository;
    }

    public Set<Character> getAllCharacters() {
        Iterable<Character> characters = repository.findAll();
        return StreamSupport.stream(characters.spliterator(), false).collect(Collectors.toSet());
    }

    public List<ShipType> getCharacterShipTypeById(Long id) {

        return repository.findOne(id).get().getShips_type();
    }

}
