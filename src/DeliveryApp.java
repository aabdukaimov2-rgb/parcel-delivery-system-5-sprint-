import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private final static Scanner scanner = new Scanner(System.in);
    private final static List<Parcel> allParcels = new ArrayList<>();
    private final static List<Trackable> trackableItems = new ArrayList<>();

    private final static ParcelBox<StandardParcel> standardBox = new ParcelBox<>(60);
    private final static ParcelBox<FragileParcel> fragileBox = new ParcelBox<>(20);
    private final static ParcelBox<PerishableParcel> perishableBox = new ParcelBox<>(40);

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
                    reportStatus();
                    break;
                case 5:
                    showBoxContents();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    //скорректировал выводы, для удобства и красоты!
    private static void showMenu() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("Выберите действие:");
        System.out.println("1 — 📦 Добавить посылку"); //скопировал эмодзи из источников
        System.out.println("2 — 🚚 Отправить все посылки");
        System.out.println("3 — 💰 Посчитать стоимость доставки");
        System.out.println("4 — 📍 Отчет о статусе");
        System.out.println("5 — 📦 Показать содержимое коробки");
        System.out.println("0 — ❌ Завершить работу");
        System.out.println("-".repeat(40));
        System.out.print("👉 Ваш выбор: ");
    }

    // реализуйте методы ниже

    private static void addParcel() {
        // Подсказка: спросите тип посылки и необходимые поля, создайте объект и добавьте в allParcels
        System.out.println("\n" + "*".repeat(40));
        System.out.println("Выберите тип посылки: ");
        System.out.println("1 — 📄 Стандартная");
        System.out.println("2 — 🫙 Хрупкая");
        System.out.println("3 — 🍰 Скоропортящаяся");
        System.out.print("👉 Тип: ");

        int type = Integer.parseInt(scanner.nextLine());

        System.out.println("\n📝 Введите данные посылки:");
        System.out.print(" Описание: ");
        String description = scanner.nextLine();

        System.out.print(" Вес: ");
        int weight = Integer.parseInt(scanner.nextLine());

        System.out.print(" Адрес доставки: ");
        String deliveryAddress = scanner.nextLine();

        System.out.print(" День отправки: ");
        int sendDay = Integer.parseInt(scanner.nextLine());

        switch (type) {
            case 1:
                StandardParcel standardParcel = new StandardParcel(description, weight,
                        deliveryAddress, sendDay);
                allParcels.add(standardParcel);
                standardBox.addParcel(standardParcel);
                System.out.println("✅ Стандартная посылка добавлена!");
                break;

            case 2:
                FragileParcel fragileParcel = new FragileParcel(description, weight,
                        deliveryAddress, sendDay); // отдельная переменная,потому что trackableItems другой тип
                allParcels.add(fragileParcel);
                trackableItems.add(fragileParcel);
                fragileBox.addParcel(fragileParcel);
                System.out.println("✅ Хрупкая посылка добавлена!");
                break;

            case 3:
                System.out.print("Срок хранения (дней): ");
                int timeToLive = Integer.parseInt(scanner.nextLine());
                PerishableParcel perishableParcel = new PerishableParcel(description, weight,
                        deliveryAddress, sendDay, timeToLive);
                allParcels.add(perishableParcel);
                perishableBox.addParcel(perishableParcel);
                System.out.println("✅ Скоропортящаяся посылка добавлена!");
                break;
            default:
                System.out.println("\n❌ Неверный тип посылки!");
        }
    }

    private static void sendParcels() {
        // Пройти по allParcels, вызвать packageItem() и deliver()
        for (Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();
        }
        System.out.println("✅ Все посылки отправлены!");
    }

    private static void calculateCosts() {
        // Посчитать общую стоимость всех доставок и вывести на экран

        System.out.println("Расчет стоимости: ");

        int totalCost = 0;

        for (Parcel parcel : allParcels) {
            int cost = parcel.calculateDeliveryCost();
            totalCost += cost;
            System.out.println("• " + parcel.getDescription() + ": " + cost + "💵");
        }

        System.out.println("Общая стоимость: " + totalCost + "💵");

    }

    private static void reportStatus() {
        if (trackableItems.isEmpty()) {
            System.out.println("Нет посылок с поддержкой трекинга");
            return;
        }

        System.out.print("Введите новое местоположение: ");
        String location = scanner.nextLine();

        System.out.println("Отчет о статусе!");
        for (Trackable item : trackableItems) {
            item.reportStatus(location);
        }

    }

    private static void showBoxContents() {
        System.out.println("Выберите коробку:");
        System.out.println("1 — Стандартные");
        System.out.println("2 — Хрупкие");
        System.out.println("3 — Скоропортящиеся");

        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                System.out.println("\nКоробка со стандартными посылками:");
                standardBox.showContents();
                break;
            case 2:
                System.out.println("\nКоробка с хрупкими посылками:");
                fragileBox.showContents();
                break;
            case 3:
                System.out.println("\nКоробка со скоропортящимися посылками:");
                perishableBox.showContents();
                break;
            default:
                System.out.println("Неверный выбор!");
        }
    }
}
