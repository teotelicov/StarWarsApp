package Validators;

import Utils.Check;

public class InputValidator {

    public void validateCharacter(String character) throws ValidatorException {

        if ( character == null) {
            throw new ValidatorException("Character's id must not be not null!");
        }

        if(!Check.isInteger(character))
        {
            throw new ValidatorException("Character's id has to be an integer!");
        }
        try {
            Integer id = Integer.parseInt(character);
            if (id > 7 || id < 0) {
                throw new ValidatorException("Character's id does not exist!");
            }
        }catch(NumberFormatException e)
        {
            throw new ValidatorException("Character's id does not exist!");
        }


    }

    public void validateCargo(String cargo) throws ValidatorException {

        if ( cargo == null) {
            throw new ValidatorException("Cargo must not be not null!");
        }

        if(!Check.isInteger(cargo))
        {
            throw new ValidatorException("Cargo has to be an integer!");
        }


        try {
            Integer cargo_int = Integer.parseInt(cargo);
        }catch(NumberFormatException e)
        {
            throw new ValidatorException("Cargo is too big, please insert a smaller value!");
        }

    }

    public void validatePlanet(String planet) throws ValidatorException {

        if ( planet == null) {
            throw new ValidatorException("Planet's id must not be not null!");
        }

        if(!Check.isInteger(planet))
        {
            throw new ValidatorException("Planet's id has to be an integer!");
        }


        try {
            Integer id = Integer.parseInt(planet);
            if (id > 6 || id < 0) {
                throw new ValidatorException("Planet's id does not exist!");
            }
        }catch(NumberFormatException e)
        {
            throw new ValidatorException("Planet's id does not exist!");
        }

    }
}
