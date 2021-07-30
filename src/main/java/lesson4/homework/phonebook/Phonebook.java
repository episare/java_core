package lesson4.homework.phonebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public class Phonebook {
    private final HashMap<Integer, String> phonebook;

    public Phonebook() {
        phonebook = new HashMap<>();
    }

    @Override
    public String toString() {
        return "Phonebook(Phone=Name): " + phonebook;
    }

    public void add(Integer phone, String name) {
        phonebook.put(phone, name);
    }

    public String getNameToNumber(Integer phone) {
        return phonebook.get(phone);
    }

    public ArrayList<Integer> getPhoneToName(String name) {
        ArrayList<Integer> phoneList = new ArrayList<>();
        for (Integer key : phonebook.keySet()) {
            if ((phonebook.get(key)).equals(name)) {
                phoneList.add(key);
            }
        }
        return phoneList;
    }

    public Hashtable<Integer, String> getListToPhoneInterval(Integer listFrom, Integer listTo) {
        Hashtable<Integer, String> list = new Hashtable<>();
        for (Integer phone : phonebook.keySet()) {
            if (phone >= listFrom && phone <= listTo) {
                list.put(phone, getNameToNumber(phone));
            }
        }
        return list;
    }

    public boolean phoneExists(Integer phone) {
        return phonebook.containsKey(phone);
    }

    public boolean nameExists(String name) {
        return phonebook.containsValue(name);
    }

    public boolean phoneAndNameExist(Integer phone, String name) {
        if (phoneExists(phone)) {
            return nameExists(name);
        }
        return false;
    }

    public void deleteEntryToPhone(Integer phone) {
        phonebook.remove(phone);
    }

    public void changeNameToPhone(Integer phone, String oldName, String newName) {
        phonebook.replace(phone, oldName, newName);
    }
}
