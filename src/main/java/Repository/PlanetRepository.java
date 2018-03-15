package Repository;

import Domain.Planet;

import Validators.PlanetValidator;
import Validators.ValidatorException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PlanetRepository extends JSONRepository<Long, Planet> {

    private String fileName;
    public PlanetValidator validator;

    public PlanetRepository(PlanetValidator validator, String fileName) {
        this.validator = validator;
        this.fileName = fileName;

        loadData();
    }

    private void loadData() {

        JSONParser parser = new JSONParser();
        try {

            Object obj = parser.parse(new FileReader(fileName));

            JSONArray array = (JSONArray) obj;


            for (int i = 0; i < array.size(); i++) {

                JSONObject jsonObject = (JSONObject) array.get(i);
                validator.validate(jsonObject);


                Long id = (Long) jsonObject.get("id");
                String name = (String) jsonObject.get("name");
                Long distance = (Long) jsonObject.get("distance");

                Planet planet = new Planet(name,distance);
                planet.setId(id);

                try {
                    super.save(planet);
                } catch (ValidatorException e) {
                    e.printStackTrace();
                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        catch(ValidatorException e)
        {
            System.out.println(e.getMessage());
        }

    }
}