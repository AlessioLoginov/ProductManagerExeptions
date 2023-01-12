package ru.netology;

public class ProductManager { //мэнеджер продуктов

    public Repository getRepo() {
        return repo;
    }

    public void setRepo(Repository repo) {
        this.repo = repo;
    }

    public ProductManager(Repository repo) {
        this.repo = repo;
    }

    private Repository repo;

    public void add(Product myProd) { //Добавление продукта
        repo.save(myProd);
    }

    public Product[] searchBy(String text) { //поиск продукта
        Product[] result = new Product[0];
        for (Product prod : repo.findAll()) {
            if (prod.matches(text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = prod;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) { //соответствие товара запросу
        return product.getProductName().contains(search);
    }

}
