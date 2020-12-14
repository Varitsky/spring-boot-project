package ru.geekbrains.boot.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.boot.model.Product;
import ru.geekbrains.boot.services.ProductService;
import ru.geekbrains.boot.services.StudentService;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

//    public ProductController(ProductService productService) {
//        this.productService = productService;
//    }

//    @GetMapping("/all")
//    public String getAllProducts(Model model) {
//        model.addAttribute("frontProducts", productService.getAllProducts());
//        return "all_products";
//    } // версия без фильтра

    @GetMapping("/all")
    public String getAllProducts(Model model,
                          @RequestParam(required = false, name = "min_cost") Integer minCost,
                          @RequestParam(required = false, name = "max_cost") Integer maxCost
    ) {
        model.addAttribute("frontProducts", productService.getAllProducts(minCost, maxCost));
        return "all_products";
    }



//    @GetMapping("/one/{id}")
//    public String getProductById(@PathVariable Long id) {
//        productService.getProductById(id);
//        return "one";
//    }

    @GetMapping("/one/{id}")
    public String getProductById(Model model, @PathVariable Long id) {
        model.addAttribute("frontProduct", productService.getProductById(id));
        productService.getProductById(id);
        return "one";
    }



    @GetMapping("/remove/{id}")
    public String deleteProductById(@PathVariable Long id) {
        productService.deleteById(id);
        return "redirect:/products/all";
    }

    @PostMapping("/add")
//    public String addNewBox(@RequestParam Long id, @RequestParam String color, @RequestParam int size) {
    public String addNewProduct(@ModelAttribute Product product) {
        productService.save(product);
        return "redirect:/products/all";
    }


}
