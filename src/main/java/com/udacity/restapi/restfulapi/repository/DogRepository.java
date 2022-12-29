package com.udacity.restapi.restfulapi.repository;

import com.udacity.restapi.restfulapi.entity.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DogRepository extends CrudRepository<Dog, Long> {
    @Query("select d.id, d.breed from Dog d")
    List<String> findAllBread();

    @Query("select d.id, d.name from Dog d")
    List<String> findAllName();

    @Query("select d.id, d.breed from Dog d where d.id=:id")
    String findBreedById(Long id);
}
