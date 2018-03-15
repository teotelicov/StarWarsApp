package Validators;

import Domain.ShipType;
import Utils.Check;
import org.json.simple.JSONObject;

public class ShipValidator {

    public void validate(JSONObject entity) throws ValidatorException {

        if (entity.get("id") == null) {
            throw new ValidatorException("Id of the ship must not be not null!");
        }

        if(!Check.isInteger(entity.get("id")))
        {
            throw new ValidatorException("Id of the ship has to be an integer!");
        }

        if (entity.get("maxCargoWeight") == null) {
            throw new ValidatorException("Maximum cargo weight of the ship must not be null!");
        }

        if(!Check.isInteger(entity.get("maxCargoWeight")))
        {
            throw new ValidatorException("Maximum cargo weigh of the ship has to be an integer!");
        }

        if (entity.get("name") == null) {
            throw new ValidatorException("Name of the ship must not be null!");
        }

        if (entity.get("speed") == null) {
            throw new ValidatorException("Speed of the ship must not be null!");
        }

        if(!Check.isInteger(entity.get("speed")))
        {
            throw new ValidatorException("Speed of the ship has to be an integer!");
        }

        if (entity.get("type") == null) {
            throw new ValidatorException("Type of the ship  must not be null!");
        }

        if(!Check.contains(ShipType.class, (String) entity.get("type")))
        {
            throw new ValidatorException("Type of the ship must be A,B,C or D!");
        }






    }
}
