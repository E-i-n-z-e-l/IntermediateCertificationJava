/*
1. Подумать над структурой класса Ноутбук для магазина техники — выделить поля и методы. Реализовать в Java.
2. Создать множество ноутбуков.
3. Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map.
*/

import java.util.Objects;

public class modelAndBrandLaptop {
    String brand;
    String model;
    int price;

    public modelAndBrandLaptop(String brand, String model, int price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    @Override
    public  String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(brand).append(" ").append(model);
        return builder.toString();
    }

    @Override
    public int hashCode() {

        return Objects.hash(brand, model, price);
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof modelAndBrandLaptop)) {
            return  false;
        }

        modelAndBrandLaptop temp = (modelAndBrandLaptop) obj;
        return (temp.brand.equals(this.brand) && temp.model.equals(this.model) && temp.price == this.price) ;
    }
}





