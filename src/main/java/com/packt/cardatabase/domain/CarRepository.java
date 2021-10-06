package com.packt.cardatabase.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// CarRepository sera el repositorio de la Clase Car y un id tipo Long
public interface CarRepository extends CrudRepository <Car, Long>{
    /* Definir consultas a partir de parametros especificos */
    // Encuentra carros por la marca
    List<Car> findByBrand(String brand);

    // Encuentra carros por el color
    List<Car> findByColor(String color);

    // Encuentra carros por el año
    List<Car> findByYear(int year);

    // Encuentra carros por marca y modelos
    List<Car> findByBrandAndModel(String brand, String model);

    // Encuentra carros por marca o color
    List<Car> findByBrandOrColor(String brand, String color1);

    /* Las consultas se pueden ordenar utilizando la palabra clave OrderBy */
    // Encuentra carros por la marca y los organiza por año
    List<Car> findByBrandOrderByYearAsc(String brand);

    // Encuentra carros por el modelo y los organiza por precio
    List<Car> findByModelOrderByPriceDesc(String model);

    /* Consultas utilizando sentencias SQL a traves de la anotacion @Query */
    // Encuentra carros por modelo usando SQL
    @Query("select c from Car c where c.model = ?1")
    List<Car> findByModel(String model);

    // Busca autos por color usando SQL
    @Query("select c from Car c where c.color like %?1")
    List<Car> findByColorEndsWith(String color);
}