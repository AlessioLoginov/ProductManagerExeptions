package ru.netology;

public class Repository { //репозиторий

    private Product[] myProducts = new Product[0];

    public void save(Product myProd) { // сохранение продукта

        if (findById(myProd.getId()) != null) {
            throw new AlreadyExistsException(
                    "Element with id: " + myProd.getId() + " already exists"
            );
        }

        Product[] tmp = new Product[myProducts.length + 1];
        for (int i = 0; i < myProducts.length; i++) {
            tmp[i] = myProducts[i];
        }
        tmp[tmp.length - 1] = myProd;
        myProducts = tmp;
    }

    public Product[] findAll() { //Вывод всех продуктов в порядке добавления
        return myProducts;
    }

    public void removeById(int id) { //удаляет продукт из репо по идентификатору
        if (findById(id) == null) {
            throw new NotFoundException(
                    "Element with id: " + id + " not found"
            );
        }

        Product[] tmp = new Product[myProducts.length - 1];
        int j = 0;
        for (int i = 0; i < myProducts.length; i++) {
            if (myProducts[i].getId() != id) {
                tmp[j] = myProducts[i];
                j++;
            }
        }
        myProducts = tmp;
    }

    public Product findById(int id) { //поиск продукта по идентификатору
        for (int i = 0; i < myProducts.length; i++) {
            if (myProducts[i].getId() == id) {
                return myProducts[i];
            }
        }
        return null;
    }

}