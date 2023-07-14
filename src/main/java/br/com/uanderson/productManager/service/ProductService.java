package br.com.uanderson.productManager.service;

import br.com.uanderson.productManager.model.Product;
import br.com.uanderson.productManager.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductService {
    //- Class reponsavel pela implementação da regra de negócio da aplicação!
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> listAllProduct(){
        return productRepository.findAll();
    }

    public void save(Product product){
        productRepository.save(product);
    }

    public Product findByIdOrThrowNoSuchElementException(long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Product não encontrado pelo ID[" + id + "]"));//exception customizada
    }

    public void deleteProduct(Long id) {
        productRepository.delete(findByIdOrThrowNoSuchElementException(id));
    }

    public Page<Product> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
                : Sort.by(sortField).descending();

        PageRequest pageRequest = PageRequest.of((pageNo - 1), pageSize, sort);
        return productRepository.findAll(pageRequest);
    }

}//class
