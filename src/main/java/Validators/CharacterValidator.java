package Validators;

import Domain.ShipType;
import Utils.Check;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Iterator;

public class CharacterValidator {

    public void validate(JSONObject entity) throws ValidatorException {

        if (entity.get("id") == null) {
            throw new ValidatorException("Id of the character must not be not null!");
        }

        if(!Check.isInteger(entity.get("id")))
        {
            throw new ValidatorException("Id of the character has to be an integer!");
        }

        if (entity.get("name") == null) {
            throw new ValidatorException("Name of the character must not be null!");
        }


        if (entity.get("shipsType") == null) {
            throw new ValidatorException("Ships types of the character must not be null!");
        }


        JSONArray ships = (JSONArray) entity.get("shipsType");
        Iterator<String> iterator = ships.iterator();
        while (iterator.hasNext()) {

            if(!Check.contains(ShipType.class, iterator.next()))
            {
                throw new ValidatorException("Ships types must be A,B,C or D!");
            }

        }

    }
}
