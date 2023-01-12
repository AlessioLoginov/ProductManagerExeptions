package ru.netology;

public class Smartphone extends Product { //класс смартфонов

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Smartphone(int id, String productName, int productPrice, String producer) {
        super(id, productName, productPrice);
        this.producer = producer;
    }

    private String producer; //производитель

    public boolean matches(String search) {
        if (super.matches(search)) { // вызов метода matches в версии описанной в Product
            return true;
        } else {
            return this.getProducer().contains(search);
        }
    }

}
