package UI;

import Domain.Character;
import Domain.Planet;
import Domain.Ship;
import Domain.ShipType;
import Service.CharacterService;
import Service.PlanetService;
import Service.ShipService;
import Validators.InputValidator;
import Validators.ValidatorException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Console {

    private ShipService shipService;
    private CharacterService characterService;
    private PlanetService planetService;
    private InputValidator inputValidator = new InputValidator();
    private long character_id;
    private long max_cargo;
    private long planet_id;


    public Console(ShipService shipService, CharacterService characterService, PlanetService planetService) {
        this.shipService = shipService;
        this.characterService = characterService;
        this.planetService = planetService;
    }

    public void runConsole() {

        printCharacterMenu();
        printCargoMenu();
        printPlanetMenu();
        printOptions();

    }

    private void printAllShips() {
        Set<Ship> ships = shipService.getAllShips();
        ships.stream().forEach(System.out::println);
    }

    private void printAllCharacters() {
        Set<Character> characters = characterService.getAllCharacters();
        characters.stream().forEach(System.out::println);
    }

    private void printAllPlanets() {
        Set<Planet> planets = planetService.getAllPlanets();
        planets.stream().forEach(System.out::println);
    }

    private void printCharacterMenu() {
        System.out.println("Please select character :" + '\n' +
                "1 for Han Solo" +'\n' +
                "2 for Yoda" +'\n' +
                "3 for Luke Skywalker" +'\n' +
                "4 for Darth Vader" +'\n' +
                "5 for Kylo Ren" +'\n' +
                "6 for R2D2" +'\n' +
                "7 for Chewbaca" +'\n' +
                "Character = ");

        BufferedReader bufferRead=new BufferedReader(new InputStreamReader(System.in));
        try{
            String char_str=bufferRead.readLine();
            inputValidator.validateCharacter(char_str);
            character_id=Long.parseLong(char_str);

        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (ValidatorException e) {
            System.out.println(e.getMessage());
            printCharacterMenu();
        }
    }

    private void printCargoMenu()
    {
        BufferedReader bufferRead=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please insert a cargo weight" + '\n' +
                "Cargo weight = ");

        try {
            String cargo_str=bufferRead.readLine();
            inputValidator.validateCargo(cargo_str);
            max_cargo=Long.parseLong(cargo_str);

        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (ValidatorException e) {
            System.out.println(e.getMessage());
            printCargoMenu();
        }
    }

    private void printPlanetMenu()
    {
        System.out.println("Please select planet :" + '\n' +
                "1 for Corellia" +'\n' +
                "2 for Coruscant" +'\n' +
                "3 for Dantooine" +'\n' +
                "4 for Hoth" +'\n' +
                "5 for Jakku" +'\n' +
                "6 for Naboo" +'\n' +
                "Planet = ");

        BufferedReader bufferRead=new BufferedReader(new InputStreamReader(System.in));
        try{
            String planet_str=bufferRead.readLine();
            inputValidator.validatePlanet(planet_str);
            planet_id=Long.parseLong(planet_str);


        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (ValidatorException e) {
            System.out.println(e.getMessage());
            printPlanetMenu();
        }
    }

    void printOptions()
    {
        HashMap<Ship, Long> ships_time = new HashMap<Ship, Long>();
        Planet planet = planetService.getById(planet_id);
        Long distance = planet.getDistance();
        List<ShipType> shipsType = characterService.getCharacterShipTypeById(character_id);
        for (ShipType st : shipsType) {

                List<Ship> ships = shipService.getAllShipsByType(st);
                for(Ship s : ships)
                {
                    int no_trips = (int)(Math.ceil((double)max_cargo / s.getMaxCargoWeight()));
                    long time_all_trips = (no_trips+1) * ((distance/s.getSpeed()));
                    ships_time.putIfAbsent(s,time_all_trips);

                }
        }

        Object[] a = ships_time.entrySet().toArray();
        Arrays.sort(a, new Comparator() {
            public int compare(Object o1, Object o2) {
                return (-1) * ((Map.Entry<Ship, Long>) o2).getValue()
                        .compareTo(((Map.Entry<Ship, Long>) o1).getValue());
            }
        });
        for (Object e : a) {

            int no_trips = (int)(Math.ceil((double)max_cargo / ((Map.Entry<Ship, Long>) e).getKey().getMaxCargoWeight()));
            System.out.println("Ship: " + ((Map.Entry<Ship, Long>) e).getKey().getName() + "; Number of trips: "
                    + String.valueOf(no_trips)  + "; Time: " + String.valueOf(((Map.Entry<Ship, Long>) e).getValue()) + " hours;");

        }
    }
}
