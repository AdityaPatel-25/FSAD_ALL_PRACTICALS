package com.inventory.hibernateCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.inventory.hibernateCRUD.entity.Product;
import com.inventory.hibernateCRUD.repository.ProductRepository;

@SpringBootApplication
public class HibernateCrudApplication implements CommandLineRunner {

    @Autowired
    private ProductRepository repo;

    public static void main(String[] args) {
        SpringApplication.run(HibernateCrudApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // INSERT
        Product p1 = new Product();
        p1.setName("Laptop");
        p1.setDescription("Gaming Laptop");
        p1.setPrice(70000);
        p1.setQuantity(10);

        repo.save(p1);

        System.out.println("Product inserted successfully");

        // RETRIEVE
        Product p = repo.findById(1).orElse(null);

        if (p != null) {
            System.out.println("Product Name: " + p.getName());

            // UPDATE
            p.setPrice(75000);
            repo.save(p);
            System.out.println("Product updated successfully");
        }

        // DELETE
        repo.deleteById(1);
        System.out.println("Product deleted successfully");
    }
}