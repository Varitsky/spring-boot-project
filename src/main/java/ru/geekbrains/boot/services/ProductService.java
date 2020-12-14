package ru.geekbrains.boot.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.boot.model.Product;
import ru.geekbrains.boot.model.Student;
import ru.geekbrains.boot.repositories.ProductInMemoryRepository;

import java.util.List;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductInMemoryRepository ProductInMemoryRepository;
//
//    @Autowired
//    public void setProductInMemoryRepository(ProductInMemoryRepository productInMemoryRepository) {
//        this.ProductInMemoryRepository = productInMemoryRepository;
//    }

    public List<Product> getAllProducts() {
        return ProductInMemoryRepository.getAllProducts();
    } // обычная версия без фильтра

    public List<Product> getAllProducts(Integer minCost, Integer maxCost) {
        List<Product> out = getAllProducts();
        if (minCost != null) {
            out = out.stream().filter(s -> s.getCost() >= minCost).collect(Collectors.toList());
        }
        if (maxCost != null) {
            out = out.stream().filter(s -> s.getCost() <= maxCost).collect(Collectors.toList());
        }
        return out;
    }


//    public List<Student> findAll(Integer minScore, Integer maxScore) {
//        List<Student> out = findAll();
//        if (minScore != null) {
//            out = out.stream().filter(s -> s.getScore() >= minScore).collect(Collectors.toList());
//        }
//        if (maxScore != null) {
//            out = out.stream().filter(s -> s.getScore() <= maxScore).collect(Collectors.toList());
//        }
//        return out;
//    }









    public Product getProductById(Long id){
        return ProductInMemoryRepository.getProductById(id);
    }


    public void save(Product product) {
        ProductInMemoryRepository.save(product);
    }

    public void deleteById(Long id) {
        ProductInMemoryRepository.deleteById(id);
    }
}
