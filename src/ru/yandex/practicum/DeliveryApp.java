package ru.yandex.practicum;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();
    private static ArrayList<Trackable> trackableParcels = new ArrayList<>();
    private static ParcelBox<StandardParcel> standartBox = new ParcelBox<>(20);
    private static ParcelBox<PerishableParcel> perishableBox = new ParcelBox<>(20);
    private static ParcelBox<FragileParcel> fragileBox = new ParcelBox<>(20);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    trackParcels();
                    break;
                case 5:
                    showBoxContent();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Узнать местоположение посылок");
        System.out.println("5 — Показать содержимое коробки");
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже

    private static void addParcel() {
        System.out.println("Выберите тип посылки:");
        System.out.println("1 - Стандартная посылка");
        System.out.println("2 - Скоропортящаяся посылка");
        System.out.println("3 - Хрупкая посылка");
        int command = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите описание посылки:");
        String description = scanner.nextLine();
        System.out.println("Введите массу посылки:");
        int weight = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите адрес получателя:");
        String deliveryAddress = scanner.nextLine();
        System.out.println("Введите сегодняшнее число:");
        int sendDay = Integer.parseInt(scanner.nextLine());

        switch(command) {
            case 1:
                StandardParcel standardParcel = new StandardParcel(description, weight, deliveryAddress, sendDay);
                allParcels.add(standardParcel);
                standartBox.addParcel(standardParcel);
                break;
            case 2:
                System.out.println("Введите срок хранения посылки в днях:");
                int timeToLive = Integer.parseInt(scanner.nextLine());
                PerishableParcel perishableParcel = new PerishableParcel(description, weight, deliveryAddress,
                        sendDay, timeToLive);
                allParcels.add(perishableParcel);
                perishableBox.addParcel(perishableParcel);
                break;
            case 3:
                FragileParcel fragileParcel = new FragileParcel(description, weight, deliveryAddress, sendDay);
                allParcels.add(fragileParcel);
                trackableParcels.add(fragileParcel);
                fragileBox.addParcel(fragileParcel);
                break;
        }
        // Подсказка: спросите тип посылки и необходимые поля, создайте объект и добавьте в allParcels
    }

    private static void sendParcels() {
        for (Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();
        }
        // Пройти по allParcels, вызвать packageItem() и deliver()
    }

    private static void calculateCosts() {
        int sumCost = 0;
        for (Parcel parcel : allParcels) {
            sumCost += parcel.calculateDeliveryCost();
        }
        System.out.println("Суммарная стоимость всех посылок составила: " + sumCost + " руб.");
        // Посчитать общую стоимость всех доставок и вывести на экран
    }

private static void trackParcels() {
        for (Trackable parcel : trackableParcels) {
            System.out.println("Введите новое местоположение:");
            String newLocation = scanner.nextLine();
            parcel.reportStatus(newLocation);
        }
}

private static void showBoxContent() {
    System.out.println("Коробку с какими посылками вы желаете посмотреть?");
    System.out.println("1 - Стандартные посылки");
    System.out.println("2 - Скоропортящиеся посылки");
    System.out.println("3 - Хрупкие посылки");
    int command = Integer.parseInt(scanner.nextLine());
    switch (command) {
        case 1:
            standartBox.getAllParcels();
            break;
        case 2:
            perishableBox.getAllParcels();
            break;
        case 3:
            fragileBox.getAllParcels();
            break;
        default:
            System.out.println("Неверный выбор");
    }
    }
}
