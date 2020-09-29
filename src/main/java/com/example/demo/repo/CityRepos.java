package com.example.demo.repo;


import com.example.demo.enity.City;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepos extends MongoRepository<City,String> {

    Optional<City> findByName(String name);

    void deleteById(String id);

    Optional<City> findById(String id);
}
