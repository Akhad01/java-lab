import java.util.*;

class Flower {
    private String name;
    private int freshnessLevel;
    private double price;
    private double stemLength;

    public Flower(String name, int freshnessLevel, double price, double stemLength) {
        this.name = name;
        this.freshnessLevel = freshnessLevel;
        this.price = price;
        this.stemLength = stemLength;
    }

    public String getName() {
        return name;
    }

    public int getFreshnessLevel() {
        return freshnessLevel;
    }

    public double getPrice() {
        return price;
    }

    public double getStemLength() {
        return stemLength;
    }
}

class Bouquet {
    private ArrayList<Flower> flowers = new ArrayList<>();
    public void addFlower(Flower flower) {
        flowers.add(flower);
    }

    public void printFlowers() {
        for (Flower fl : flowers) {
            System.out.println("fl: " + fl.getName());
        }
    }


    public double calculatePrice() {
        double price = 0;

        for (Flower flower : flowers) {
            System.out.println("flow" + flower);
            price += flower.getPrice();
        }

        return price;
    }

    public void sortByFreshness() {
        Collections.sort(flowers, Comparator.comparingInt(Flower::getFreshnessLevel));
    }

    public Flower findFlowerByStemLength(double minLength, double maxLength) {
        for (Flower flower : flowers) {
            if (flower.getStemLength() >= minLength && flower.getStemLength() <= maxLength) {
                return flower;
            }
        }

        return null;
    }

    // Public getter method for the flowers field
    public ArrayList<Flower> getFlowers() {
        return flowers;
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bouquet bouquet = new Bouquet();



        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить цветок");
            System.out.println("2. Сортировка по уровню свежести");
            System.out.println("3. Найти цветок по диапазону длин стебля");
            System.out.println("4. Цена букета");
            System.out.println("5. Выход");

            bouquet.printFlowers();

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline left-over

            switch (choice) {
                case 1:
                    System.out.println("Введите название цветка: ");
                    String name = scanner.nextLine();

                    System.out.println("Введите уровень свежести цветка: ");
                    int freshnessLevel = scanner.nextInt();

                    System.out.println("Введите цену цветка: ");
                    double price = scanner.nextDouble();

                    System.out.println("Введите длину стебля цветка: ");
                    double stemLength = scanner.nextDouble();

                    Flower flower = new Flower(name, freshnessLevel, price, stemLength);
                    bouquet.addFlower(flower);

                    break;
                case 2:
                    bouquet.sortByFreshness();
                    System.out.println("Сортировка цветов по свежести: ");
                    for (Flower f : bouquet.getFlowers()) {
                        System.out.println(f.getName() + " - Уровень свежести: " + f.getFreshnessLevel());
                    }
                    break;
                case 3:
                    System.out.println("Введите минимальную длину стебля для поиска цветка: ");
                    double minLength = scanner.nextDouble();

                    System.out.println("Введите максимальную длину стебля для поиска цветка: ");
                    double maxLength = scanner.nextDouble();

                    Flower foundFlower = bouquet.findFlowerByStemLength(minLength, maxLength);

                    if (foundFlower != null) {
                        System.out.println("Найденный цветок: " + foundFlower.getName());
                    } else {
                        System.out.println("Цветок в заданном диапазоне не найден.");
                    }
                    break;
                case 4:
                    System.out.println("Цена букета: " + bouquet.calculatePrice());
                    break;
                case 5:
                    System.exit(0);

            }
        }
    }
}

