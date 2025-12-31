package mundia.louki.product_app;

import mundia.louki.product_app.entities.Product;
import mundia.louki.product_app.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TpSpringMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(TpSpringMvcApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository){
        return args -> {
            productRepository.save(Product.builder().name("Computer").price(4500).quantity(12).build());
            productRepository.save(Product.builder().name("Printer").price(1200).quantity(5).build());
            productRepository.save(Product.builder().name("Smartphone").price(3200).quantity(30).build());
            productRepository.save(Product.builder().name("Mouse").price(120).quantity(100).build());

            productRepository.findAll().forEach(p -> {
                System.out.println(p.getName());
            });
        };
    }
}