package org.iesfm.Generic.Serializer;

import org.iesfm.Generic.Animal;
import org.iesfm.Generic.Deserializer.Deserializer;
import org.iesfm.Generic.Serializer.Serializer;
import org.iesfm.Generic.User;

import java.util.HashMap;
import java.util.Map;

public class UserSerializer implements Serializer<User>, Deserializer<User> {

    @Override
    public String serialString(User user) {
        return "username: " + user.getUserName() + ", password: " + user.getPassword() + ", level: " + user.getLevel();
    }

    @Override
    public User deserialString(String serial) {
        Map<String, String> fieldsMap = new HashMap<>();

        String[] fields = serial.split(", ");

        for (String field : fields) {
            String[] fieldValues = field.split(": ");
            fieldsMap.put(fieldValues[0], fieldValues[1]);
        }
        return new User(fieldsMap.get("username"), fieldsMap.get("password"), fieldsMap.get("level"));
    }
}
