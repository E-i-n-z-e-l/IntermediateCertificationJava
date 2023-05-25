/*
Не для проверки. В будущем для расширения магазина.
 */


public class characteristicLaptop extends modelAndBrandLaptop {

    String gpu;
    String operatingSystem;

    public characteristicLaptop(String brand, String model, int price, int ram, int hdd, String cpu, String gpu, String operatingSystem) {
        super(brand, model, price, ram, hdd, cpu);

        this.gpu = gpu;
        this.operatingSystem = operatingSystem;
    }


}
