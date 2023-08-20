package br.com.uanderson.productManager.repository;

import br.com.uanderson.productManager.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {

    @Query("{$or: ["
            + "{'name': {$regex: ?0, $options: 'i'}},"
            + "{'brand': {$regex: ?0, $options: 'i'}},"
            + "{'madein': {$regex: ?0, $options: 'i'}},"
            + "{'price': ?0}"
            + "]}")
    List<Product> findAll(String keyword);

}//interface
