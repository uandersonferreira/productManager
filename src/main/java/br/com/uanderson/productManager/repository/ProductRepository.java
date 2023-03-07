package br.com.uanderson.productManager.repository;

import br.com.uanderson.productManager.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}//interface
