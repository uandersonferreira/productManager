package br.com.uanderson.productManager.repository;

import br.com.uanderson.productManager.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("""
            SELECT p FROM Product p
              WHERE p.name LIKE %?1%
                OR p.brand LIKE %?1%
                OR p.madein LIKE %?1%
                OR CONCAT(p.price, '') LIKE %?1%
           """)
    Page<Product> findAll(String keyword, Pageable pageable);

}//interface
