package br.com.uanderson.productManager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String brand;
    private String madein;
    private Double price;

    public Product(Long id, String name, String brand, String madein, Double price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.madein = madein;
        this.price = price;
    }

    public Product() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMadein() {
        return madein;
    }

    public void setMadein(String madein) {
        this.madein = madein;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}//class

/*
link: https://www.devmedia.com.br/jpa-como-usar-a-anotacao-generatedvalue/38592

GenerationType.AUTO - Valor padrão, deixa com o provedor de persistência a escolha da estratégia
mais adequada de acordo com o banco de dados.

GenerationType.IDENTITY- Informamos ao provedor de persistência que os valores a serem atribuídos
ao identificador único serão gerados pela coluna de auto incremento do banco de dados.
Assim, um valor para o identificador é gerado para cada registro inserido no banco.
Alguns bancos de dados podem não suportar essa opção.

GenerationType.SEQUENCE - Informamos ao provedor de persistência que os valores serão
gerados a partir de uma sequence. Caso não seja especificado um nome para a sequence,
será utilizada uma sequence padrão, a qual será global, para todas as entidades.
Caso uma sequence seja especificada, o provedor passará a adotar essa sequence para
criação das chaves primárias. Alguns bancos de dados podem não suportar essa opção.

GenerationType.TABLE - Com a opção TABLE é necessário criar uma tabela para
gerenciar as chaves primárias. Por causa da sobrecarga de consultas necessárias
para manter a tabela atualizada, essa opção é pouco recomendada.

POPULANDO A TABELA:

INSERT INTO product (name, brand, madein, price)
VALUES
    ('iPhone 12 Pro', 'Apple', 'China', 999.00),
    ('Galaxy S21 Ultra', 'Samsung', 'Vietnã', 1199.00),
    ('XPS 13', 'Dell', 'Estados Unidos', 1299.00),
    ('PlayStation 5', 'Sony', 'China', 499.00),
    ('Bose QuietComfort 35 II', 'Bose', 'Malásia', 299.00),
    ('MacBook Pro', 'Apple', 'China', 1999.00),
    ('Pixel 6', 'Google', 'Vietnã', 899.00),
    ('Surface Pro 7', 'Microsoft', 'China', 1299.00),
    ('GoPro Hero 9', 'GoPro', 'Malásia', 449.00),
    ('AirPods Pro', 'Apple', 'China', 249.00),
    ('Nikon D850', 'Nikon', 'Tailândia', 2999.00),
    ('Kindle Paperwhite', 'Amazon', 'China', 129.99),
    ('Sony A7 III', 'Sony', 'Japão', 1999.00),
    ('Samsung QLED Q90T', 'Samsung', 'Coreia do Sul', 2499.00),
    ('Dyson V11', 'Dyson', 'Malásia', 599.00),
    ('Fitbit Charge 4', 'Fitbit', 'China', 149.95),
    ('LG OLED CX', 'LG', 'Coréia do Sul', 1999.00),
    ('Canon EOS R5', 'Canon', 'Japão', 3899.00),
    ('Garmin Fenix 6', 'Garmin', 'Taiwan', 599.99),
    ('Xbox Series X', 'Microsoft', 'China', 499.00),
    ('Nintendo Switch', 'Nintendo', 'China', 299.00);



 */