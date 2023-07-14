package br.com.uanderson.productManager.controller;

import br.com.uanderson.productManager.model.Product;
import br.com.uanderson.productManager.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public String viewHomePage(@Param("keyword") String keyword, Model model){
        List<Product> productList = productService.listAllProduct(keyword);

        model.addAttribute("productList", productList);
        model.addAttribute("keyword", keyword);
        return  "index";
    }

//    @GetMapping()
//    public String viewHomePage(Model model) {
//        return findPaginated(1, "name", "asc", model);
//    }

//    @GetMapping()
//    public String viewHomePage(Model model) {
//        List<Product> productList = productService.listAllProduct();
//        model.addAttribute("productList", productList);
//        return "index";
//    }

   @GetMapping("/new")
    public String showNewProductForm(Model model){
        final Product product = new Product();
        model.addAttribute("product", product);
        return "new_product";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("product") Product newProduct){
        productService.save(newProduct);
        return "redirect:/";
        /*
        Quando é feito o submit do formulário da página
        "new_product" é enviado um objeto "product" com
        os dados preenchidos para o endereço "/save",
        onde será recebido pelo method "saveProduct()" como parametro
        e convertido para um product e assim chama-se o method save vindo
        da classe ProductService para salvar na base de dados.
        Após isso é feito um redirecionamento automatico para a página
        principal para que seja visto o produto já adicioando.
        */

    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditProductForm(@PathVariable(name = "id") Long id){
        ModelAndView modelAndView = new ModelAndView("edit_product");
        Product product = productService.findByIdOrThrowNoSuchElementException(id);

        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String deleteProductForm(@PathVariable(name = "id") Long id) {
        productService.deleteProduct(id);
        return "redirect:/";
    }

    @GetMapping(path = "/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page<Product> page = productService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Product> listPageContent = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        model.addAttribute("productList", listPageContent);

        return "index";
    }


}//class
