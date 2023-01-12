package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;


public class ProductManagerTest {
    Repository repo = Mockito.mock(Repository.class);
    ProductManager manager = new ProductManager(repo);

    Product myProduct1 = new Product(1, "Название товара", 100);
    Book myBook1 = new Book(2, "Моя книга", 50, "Писатель");
    Smartphone myPhone1 = new Smartphone(3, "Мой смартфон", 40_000, "Яблоко");

    Smartphone myPhone2 = new Smartphone(4, "Другой мой смартфон", 60_000, "Гугл");

    @Test

    public void shouldSearchByExist() { //тест поиска существующего продукта
        Product[] myProducts = {myProduct1, myBook1, myPhone1};
        doReturn(myProducts).when(repo).findAll();
        Product[] expected = {myPhone1};
        Product[] actual = manager.searchBy("смартфон");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test

    public void shouldSearchByNotExist() { //тест поиска несуществующего продукта
        Product[] myProducts = {myProduct1, myBook1, myPhone1};
        doReturn(myProducts).when(repo).findAll();
        Product[] expected = {};
        Product[] actual = manager.searchBy("андроид");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test

    public void shouldSearchByTwoExist() { //тест поиска двух продуктов
        Product[] myProducts = {myProduct1, myBook1, myPhone1, myPhone2};
        doReturn(myProducts).when(repo).findAll();
        Product[] expected = {myPhone1, myPhone2};
        Product[] actual = manager.searchBy("смартфон");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test

    public void testAddProduct() { //тест добавления продукта
        Product[] myProducts = {myProduct1, myBook1, myPhone1, myPhone2};
        doReturn(myProducts).when(repo).findAll();
        manager.add(myProduct1);
        manager.add(myBook1);
        manager.add(myPhone1);
        manager.add(myPhone2);
        Product[] expected = {myProduct1, myBook1, myPhone1, myPhone2};
        Product[] actual = manager.getRepo().findAll();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test

    public void shouldSearchByExistBook() { //тест поиска книги по автору
        Product[] myProducts = {myProduct1, myBook1, myPhone1};
        doReturn(myProducts).when(repo).findAll();
        Product[] expected = {myBook1};
        Product[] actual = manager.searchBy("Писатель");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test

    public void shouldSearchByExistSmart() { //тест поиска смартфона по производителю
        Product[] myProducts = {myProduct1, myBook1, myPhone1};
        doReturn(myProducts).when(repo).findAll();
        Product[] expected = {myPhone1};
        Product[] actual = manager.searchBy("Яблоко");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchByBook() { //тест поиска книги по названию
        Product[] myProducts = {myProduct1, myBook1, myPhone1};
        doReturn(myProducts).when(repo).findAll();
        Product[] expected = {myBook1};
        Product[] actual = manager.searchBy("Моя книга");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchBySmart() { //тест поиска смартфона по названию
        Product[] myProducts = {myProduct1, myBook1, myPhone1};
        doReturn(myProducts).when(repo).findAll();
        Product[] expected = {myPhone1};
        Product[] actual = manager.searchBy("Мой смартфон");
        Assertions.assertArrayEquals(expected, actual);

    }



}
