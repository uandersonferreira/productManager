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



 */