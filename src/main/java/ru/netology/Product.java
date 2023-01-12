package ru.netology;

public class Product { //базовый класс продукта
    public Product(int id, String productName, int productPrice) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    protected int id; //уникальный идектификатор товара
    protected String productName; //наименование товара
    protected int productPrice; // цена товара

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public boolean matches (String search) { // определяет, подходит ли продукт запросу исходя из названия
        return this.getProductName().contains(search);
    }
}

