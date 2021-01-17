package ru.netology.repository;

import ru.netology.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();

    Book book1 = new Book(1, "name1", 1, "a1", 100, 2001);
    // Book book2 = new Book(2, "name2", 2, "a2",200,2002);

    @Test
    public void shouldAdd() {
        repository.save(book1);

        Product[] expected = new Product[]{book1};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        repository.save(book1);

        repository.removeById(1);

        Product[] expected = new Product[0];
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByMissingId() {
        repository.save(book1);
        assertThrows(NotFoundException.class, () -> repository.removeById(2));
    }

}
