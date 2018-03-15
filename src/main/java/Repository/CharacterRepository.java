package Repository;

import Domain.Character;
import Domain.ShipType;
import Validators.CharacterValidator;
import Validators.ValidatorException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CharacterRepository extends JSONRepository<Long, Character> {

    private String fileName;
    public CharacterValidator validator;

    public CharacterRepository(CharacterValidator validator, String fileName) {
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
                JSONArray jsonArray = (JSONArray) jsonObject.get("shipsType");
                List<ShipType> shipsType = new ArrayList<ShipType>();
                Iterator<String> iterator = jsonArray.iterator();
                while (iterator.hasNext()) {

                    shipsType.add(ShipType.valueOf((iterator.next())));
                }

                Character character = new Character(name,shipsType);
                character.setId(id);

                try {
                    super.save(character);
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
