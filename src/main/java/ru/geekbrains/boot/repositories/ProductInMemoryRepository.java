package ru.geekbrains.boot.repositories;

import org.springframework.stereotype.Component;
import ru.geekbrains.boot.exceptions.ResourceNotFoundException;
import ru.geekbrains.boot.model.Product;
import ru.geekbrains.boot.model.Student;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class ProductInMemoryRepository {
    private List<Product> products;

//    @PostConstruct
//    public void init() {
//        products = new ArrayList<>();
//        products.add(new Product(1L, "FirstTitle", 25));
//        products.add(new Product(2L, "SecondTitle", 15));
//        products.add(new Product(3L, "ThirdTitle", 25));
//        products.add(new Product(4L, "FourthTitle", 22));
//    }

    @PostConstruct
    public void init() {
        this.products = new ArrayList<>(Arrays.asList(
                new Product(1L, "FirstTitle", 25, "Description"),
                new Product(2L, "SecondTitile", 30, "Description"),
                new Product(3L, "ThirdTitle", 35, "Description"),
                new Product(4L, "FourthTitle", 40, "Description")
        ));
    }


    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(products);
    }

    public Product getProductById(Long id){
        for (Product product : products) {
            if (id == product.getId())
                return product;
        }
        return null;
    }

//
//    public Optional<Student> getProductById(Long id) {
//        return products.stream().filter(product -> product.getId().equals(id)).findFirst();
//    }


    public void save(Product product) {
        products.add(product);
    }

    public void deleteById(Long id) {
        products.removeIf(b -> b.getId().equals(id));
    }
}





