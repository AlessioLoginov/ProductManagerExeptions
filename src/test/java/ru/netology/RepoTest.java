package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

public class RepoTest {

    Product myProduct1 = new Product(1, "Название товара", 100);
    Book myBook1 = new Book(2, "Моя книга", 50, "Писатель");
    Book myBook2 = new Book(2, "Моя вторая книга", 500, "Писатель гений");
    Smartphone myPhone1 = new Smartphone(3, "Мой смартфон", 40_000, "Яблоко");

    @Test

    public void testSaveProduct() { //тест сохранения продукта
        Repository repo = new Repository();
        repo.save(myProduct1);
        repo.save(myBook1);
        repo.save(myPhone1);
        Product[] expected = {myProduct1, myBook1, myPhone1};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testSaveEx() {  //тест появления исключения при попытке добавления элемента с занятым id.
        Repository repo = new Repository();
        repo.save(myBook1);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.save(myBook2);;
        });
    }


    @Test

    public void testRemoveByIdExists() { //тест функции удаления продукта по ID
        Repository repo = new Repository();
        repo.save(myProduct1);
        repo.save(myBook1);
        repo.save(myPhone1);
        repo.removeById(2);
        Product[] expected = {myProduct1, myPhone1};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testViewEx() {  //тест появления исключения при попытке удаления несуществующего элемента.
        Repository repo = new Repository();
        repo.save(myProduct1);
        repo.save(myBook1);
        repo.save(myPhone1);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(100);
        });
    }
}