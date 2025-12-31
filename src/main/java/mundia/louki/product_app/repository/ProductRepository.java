package mundia.louki.product_app.repository;

import mundia.louki.product_app.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // Méthode pour la recherche
    Page<Product> findByNameContains(String kw, Pageable pageable);
}