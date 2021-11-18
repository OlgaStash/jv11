package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductManager manager = new ProductManager(new ProductRepository());
    Product book1 = new Book(1, "Лори", 1000, "Стивен Кинг");
    Product book2 = new Book(2, "Предел", 990, "Сергей Лукьяненко");
    Product book3 = new Book(3, "Алхимик", 780, "Пауло Коэльо");
    Product book4 = new Book(8, "Оно", 2000, "Стивен Кинг");
    Product smartphone1 = new Smartphone(4, "S-987", 10000, "Samsung");
    Product smartphone2 = new Smartphone(5, "LG", 14000, "LG");
    Product smartphone3 = new Smartphone(6, "LG", 24000, "LG");
    Product smartphone4 = new Smartphone(7, "LG", 2400, "LG");

    @BeforeEach
    public void setAll() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);
    }

    @Test
    public void shouldSearchByNameOne(){
        Product[] expected = {book3};
        Product[] actual = manager.searchBy("Алхимик");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByNameSome(){
        Product[] expected = {smartphone3, smartphone2, smartphone4};
        Product[] actual = manager.searchBy("LG");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByAuthorOne(){
        Product[] expected = {book2};
        Product[] actual = manager.searchBy("Сергей Лукьяненко");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByAuthorSome(){
        Product[] expected = {book1, book4};
        Product[] actual = manager.searchBy("Стивен Кинг");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByProducerOne(){
        Product[] expected = {smartphone1};
        Product[] actual = manager.searchBy("Samsung");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByProducerSome(){
        Product[] expected = {smartphone3, smartphone2, smartphone4};
        Product[] actual = manager.searchBy("LG");

        assertArrayEquals(expected, actual);
    }
}




