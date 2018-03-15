package Utils;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

public class Check {

    public static boolean isInteger(Object object) {

        if(object instanceof Integer) {
            return true;
        } else {
            Character[] valid = new Character[]{
                    '0',
                    '1',
                    '2',
                    '3',
                    '4',
                    '5',
                    '6',
                    '7',
                    '8',
                    '9'};

            List<Character> list = Arrays.asList(valid);

            String string = object.toString();
            char[] characters = string.toCharArray();

            for(char c : characters) {
                if(!list.contains(c)) return false;
            }
        }

        return true;
    }

    public static <E extends Enum<E>> boolean contains(Class<E> enumClass,
                                                       String value) {
        try {
            return EnumSet.allOf(enumClass)
                    .contains(Enum.valueOf(enumClass, value));
        } catch (Exception e) {
            return false;
        }
    }

}
