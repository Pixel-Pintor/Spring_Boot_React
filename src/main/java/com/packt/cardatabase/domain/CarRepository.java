package com.packt.cardatabase.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CarRepository extends CrudRepository <Car, Long> {
    // busca autos por marca
    List<Car> findByBrand(@Param("brand") String brand);

    // busca autos por color
    List<Car> findByColor(@Param("color") String color);

    // busca autos por modelo
    List<Car> findByModel(@Param("model") String model);
}
