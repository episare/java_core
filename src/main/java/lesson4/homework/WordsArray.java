package lesson4.homework;

import java.util.HashMap;

public class WordsArray {
    public static void main(String[] args) {
        String[] arrayWords = new String [] {
                "Волк", "Лиса", "Заяц", "Медведь", "Суслик", "Заяц", "Бобр", "Ослик", "Лиса",
                "Лось", "Волк", "Кабан", "Заяц", "Волк", "Лиса", "Заяц", "Медведь", "Суслик", "Заяц", "Волк"};

        HashMap<String, Integer> listOfUniqueWords = new HashMap<>();

        for (String word : arrayWords) {
            if (listOfUniqueWords.containsKey(word)) {
                listOfUniqueWords.put(word, listOfUniqueWords.get(word) + 1);
            } else {
                listOfUniqueWords.put(word, 1);
            }
        }
        System.out.println(listOfUniqueWords);
    }
}
