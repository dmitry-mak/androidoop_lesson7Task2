package ru.netology.oop.hashmap;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String country;
        String city;
        int weight;
        int totalCost = 0;
        Address inputAddress;
        Set<String> countries = new HashSet<>();

        Address address1 = new Address("Россия", "Москва");
        Address address2 = new Address("Россия", "Псков");
        Address address3 = new Address("Россия", "Химки");
        Address address4 = new Address("Вьетнам", "Ханой");
        Address address5 = new Address("Вьетнам", "Сайгон");
        Address address6 = new Address("Иран", "Тегеран");
        Address address7 = new Address("Гондор", "Минас Тирит");

        HashMap<Address, Integer> costPerAddress = new HashMap<>();

        costPerAddress.put(address1, 100);
        costPerAddress.put(address2, 150);
        costPerAddress.put(address3, 500);
        costPerAddress.put(address4, 200);
        costPerAddress.put(address5, 200);
        costPerAddress.put(address6, 350);
        costPerAddress.put(address7, 500);

        while (true) {
            System.out.println("Заполнение нового заказа");
            System.out.print("Введите страну: ");
            country = scanner.nextLine();
            if (country.equals("end")) {
                break;
            }
            System.out.print("Введите город: ");
            city = scanner.nextLine();
            System.out.print("Введите вес(кг): ");
            try{weight = Integer.parseInt(scanner.nextLine());}
            catch (NumberFormatException e){
                System.out.println("Вес не может содержать буквы или символы");
                continue;
            }
            inputAddress = new Address(country, city);
            if (costPerAddress.containsKey(inputAddress)) {
                int price = costPerAddress.get(inputAddress);
                int deliveryCost = price * weight;
                totalCost += deliveryCost;
                countries.add(country);
                System.out.printf("Стоимость доставки составит: %d \n", deliveryCost);
                System.out.printf("Общая стоимость всех доставок: %d \n", totalCost);
                System.out.printf("Количество стран для доставки: %d \n", countries.size());
                System.out.println();
            } else {
                System.out.println("Доставки по этому адресу нет");
                System.out.println();
            }
        }
    }
}
