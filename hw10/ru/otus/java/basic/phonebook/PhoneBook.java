package hw10.ru.otus.java.basic.phonebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private Map<String, String> data;

    public PhoneBook() {
        data = new HashMap<>();
    }

    public void add(String name, String phone) {
        data.put(phone, name);
    }

    public List<String> find(String name) {
        List<String> phones = new ArrayList<>();
        for (Map.Entry<String, String> entry : data.entrySet()) {
            if (entry.getValue().equals(name)) {
                phones.add(entry.getKey());
            }
        }
        return phones;
    }

    public boolean containsPhoneNumber(String phone) {
        return data.containsKey(phone);
    }

    @Override
    public String toString() {
        return "PhoneBook{data=" + data + "}";
    }
}
