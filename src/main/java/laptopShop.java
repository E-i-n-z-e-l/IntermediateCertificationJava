import java.util.*;
import java.util.function.Predicate;


public class laptopShop {

    public static void main(String[] args) {
        modelAndBrandLaptop laptop1 = new modelAndBrandLaptop("MSI", "Modern 14", 32999, 8, 256, "Intel Core i3");
        modelAndBrandLaptop laptop13 = new modelAndBrandLaptop("MSI", "Modern 14", 32999, 8, 256, "Intel Core i3");
        modelAndBrandLaptop laptop14 = new modelAndBrandLaptop("MSI", "Titan GT77", 488999, 32, 2000, "Intel Core i9");
        modelAndBrandLaptop laptop3 = new modelAndBrandLaptop("IRBIS", "NB 257", 15999, 4, 64, "Intel Celeron");
        modelAndBrandLaptop laptop4 = new modelAndBrandLaptop("IRBIS", "17NBP4500", 49999, 8, 256, "Intel Core i5");
        modelAndBrandLaptop laptop5 = new modelAndBrandLaptop("ACER", "Extensa 15", 25199, 4, 128, "Intel Celeron ");
        modelAndBrandLaptop laptop6 = new modelAndBrandLaptop("ACER", "Nitro", 109999, 8, 512, "Ryzen 5 6600H");
        modelAndBrandLaptop laptop7 = new modelAndBrandLaptop("HUAWEI", "MateBook D 15", 44999, 8, 256, "Intel Core i3");
        modelAndBrandLaptop laptop8 = new modelAndBrandLaptop("HUAWEI", "MateBook B3-410", 97999, 8, 512, "Intel Core i5");
        modelAndBrandLaptop laptop9 = new modelAndBrandLaptop("HONOR", "MagicBook X15", 52999, 8, 256, "Intel Core i3");
        modelAndBrandLaptop laptop10 = new modelAndBrandLaptop("HONOR", "MagicBook 16", 89999, 16, 512, "Ryzen 5 6600H");
        modelAndBrandLaptop laptop11 = new modelAndBrandLaptop("Apple", "MacBook Air", 81899, 8, 256, "Apple M1");
        modelAndBrandLaptop laptop12 = new modelAndBrandLaptop("Apple", "MacBook Pro", 297999, 32, 1024, "Apple M1");

        Set<modelAndBrandLaptop> laptops = new HashSet<>();

        laptops.add(laptop1);
        laptops.add(laptop14);
        laptops.add(laptop3);
        laptops.add(laptop4);
        laptops.add(laptop5);
        laptops.add(laptop6);
        laptops.add(laptop7);
        laptops.add(laptop8);
        laptops.add(laptop9);
        laptops.add(laptop10);
        laptops.add(laptop11);
        laptops.add(laptop12);
        laptops.add(laptop13);

        System.out.println(laptops);

        filterLaptopsTwo(laptops);
    }

    public static void filterLaptopsTwo(Set<modelAndBrandLaptop> laptops) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите критерий фильтрации: ");
        System.out.println("1 - по бренду");
        System.out.println("2 - по модели");
        System.out.println("3 - по цене");
        System.out.println("4 - по оперативной памяти");
        System.out.println("5 - по вместимости жесткого диска");
        System.out.println("6 - по процессору");
        int choice = scanner.nextInt();
        scanner.nextLine(); // очистка буфера

        Predicate<modelAndBrandLaptop> predicate = null;

        switch (choice) {
            case 1:
                System.out.println("Введите бренд: ");
                String brand = scanner.nextLine();
                predicate = laptop -> laptop.brand.equalsIgnoreCase(brand);
                break;
            case 2:
                System.out.println("Введите модель: ");
                String model = scanner.nextLine();
                predicate = laptop -> laptop.model.equalsIgnoreCase(model);
                break;
            case 3:
                System.out.println("Введите минимальную цену: ");
                int minPrice = scanner.nextInt();
                scanner.nextLine(); // очистка буфера
                System.out.println("Введите максимальную цену: ");
                int maxPrice = scanner.nextInt();
                scanner.nextLine(); // очистка буфера
                predicate = laptop -> laptop.price >= minPrice && laptop.price <= maxPrice;
                break;
            case 4:
                System.out.println("Введите минимальный размер оперативной памяти: ");
                int minRAM = scanner.nextInt();
                scanner.nextLine(); // очистка буфера
                System.out.println("Введите максимальный размер оперативной памяти: ");
                int maxRAM = scanner.nextInt();
                scanner.nextLine(); // очистка буфера
                predicate = laptop -> laptop.ram >= minRAM && laptop.ram <= maxRAM;
                break;
            case 5:
                System.out.println("Введите минимальный размер жесткого диска: ");
                int minHDD = scanner.nextInt();
                scanner.nextLine(); // очистка буфера
                System.out.println("Введите максимальный размер жесткого диска: ");
                int maxHDD = scanner.nextInt();
                scanner.nextLine(); // очистка буфера
                predicate = laptop -> laptop.hdd >= minHDD && laptop.hdd <= maxHDD;
                break;
            case 6:
                System.out.println("Введите названия процессора: ");
                String cpu = scanner.nextLine();
                predicate = laptop -> laptop.cpu.equalsIgnoreCase(cpu);
                break;
            default:
                System.out.println("Некорректный выбор");
                return;
        }

        laptops.stream()
                .filter(predicate)
                .forEach(System.out::println);
    }
}
