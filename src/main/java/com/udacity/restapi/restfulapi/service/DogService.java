package com.udacity.restapi.restfulapi.service;

import com.udacity.restapi.restfulapi.entity.Dog;
import com.udacity.restapi.restfulapi.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DogService {
    @Autowired
    DogRepository dogRepository;

    public List<Dog> retrieveDogs(){
        return (List<Dog>) dogRepository.findAll();
    }

    public List<String> retrieveDogBreed(){
        return dogRepository.findAllBread();
    }

    public String retrieveDogBreedById(Long id){
        Optional<String> optionalBreed = Optional.ofNullable(dogRepository.findBreedById(id));
        String breed = optionalBreed.orElseThrow(DogNotFoundException::new);
        return breed;
    }

    public List<String> retrieveDogNames() {
        return (List<String>) dogRepository.findAllName();
    }
}
