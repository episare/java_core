package lesson4.homework.phonebook;

public class Main {
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();

        phonebook.add(123456, "Иванов");
        phonebook.add(234567, "Петров");
        phonebook.add(345678, "Сидоров");
        phonebook.add(456789, "Иванова");
        phonebook.add(567890, "Сергеев");
        phonebook.add(678901, "Петрова");
        phonebook.add(789012, "Иванов");
        phonebook.add(890123, "Семенов");
        phonebook.add(901234, "Светлов");
        phonebook.add(987654, "Королев");
        phonebook.add(876543, "Ушаков");
        phonebook.add(765432, "Сидоров");
        phonebook.add(654321, "Иванов");
        phonebook.add(543212, "Иванов");
        phonebook.add(432109, "Поляков");
        phonebook.add(321098, "Петров");
        phonebook.add(210987, "Семенов");
        phonebook.add(109876, "Васильев");

        System.out.println(phonebook + "\n");

        String[] nameList = new String[]{"Иванов", "Петров", "Поляков", "Сорокин", "Королев"};

        for (String name : nameList) {
            if (phonebook.nameExists(name)) {
                System.out.println(name + ":" + phonebook.getPhoneToName(name));
            } else {
                System.out.println("Абонент с именем " + name + " не найден!");
            }
        }

        int intFrom = 100000;
        int intTo = 259999;
        System.out.println("\nСписок абонентов с номерами в интервале " + intFrom + "-" + intTo + " : " +
                phonebook.getListToPhoneInterval(intFrom, intTo));

        phonebook.changeNameToPhone(678901, "Петрова", "Новикова");
        System.out.println("\n" + phonebook.getNameToNumber(678901));

    }

}
