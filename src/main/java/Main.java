import Domain.Character;
import Domain.Planet;
import Domain.Ship;
import Repository.Repository;
import Repository.ShipRepository;
import Repository.CharacterRepository;
import Repository.PlanetRepository;
import Service.CharacterService;
import Service.PlanetService;
import Service.ShipService;
import UI.Console;
import Validators.CharacterValidator;
import Validators.PlanetValidator;
import Validators.ShipValidator;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String args[]) {

        try {
            System.out.println(new File(".").getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }


        ShipValidator shipValidator = new ShipValidator();
        Repository<Long, Ship> shipRepository = new ShipRepository(shipValidator, "./Resources/ships.json");
        ShipService shipService = new ShipService(shipRepository);

        CharacterValidator characterValidator = new CharacterValidator();
        Repository<Long, Character> characterRepository = new CharacterRepository(characterValidator, "./Resources/characters.json");
        CharacterService characterService = new CharacterService(characterRepository);

        PlanetValidator planetValidator = new PlanetValidator();
        Repository<Long, Planet> planetRepository = new PlanetRepository(planetValidator, "./Resources/planets.json");
        PlanetService planetService = new PlanetService(planetRepository);

        Console console = new Console(shipService, characterService, planetService);
        console.runConsole();


    }
}
