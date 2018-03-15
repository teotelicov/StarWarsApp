package Validators;

import Utils.Check;
import org.json.simple.JSONObject;

public class PlanetValidator {

    public void validate(JSONObject entity) throws ValidatorException {

        if (entity.get("id") == null) {
            throw new ValidatorException("Id of the planet must not be not null!");
        }

        if(!Check.isInteger(entity.get("id")))
        {
            throw new ValidatorException("Id of the planet has to be an integer!");
        }

        if (entity.get("name") == null) {
            throw new ValidatorException("Name of the planet must not be null!");
        }


        if (entity.get("distance") == null) {
            throw new ValidatorException("Distance to planet must not be null!");
        }

        if(!Check.isInteger(entity.get("distance")))
        {
            throw new ValidatorException("Distance to the planet has to be an integer!");
        }

    }
}
