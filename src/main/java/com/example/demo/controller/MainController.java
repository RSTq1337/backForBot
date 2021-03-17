package com.example.demo.controller;

import com.example.demo.enity.City;
import com.example.demo.repo.CityRepos;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value="/api/city")
@CrossOrigin(origins="http://localhost:4200")
public class MainController {

    private final CityRepos cityRepos;

    public MainController(CityRepos cityRepos) {
        this.cityRepos = cityRepos;
    }

    @PostMapping
    private void createByArgs(@RequestBody City city){
        cityRepos.save(city);
    }

    @PostMapping("/{id}")
    private void change(@PathVariable("id") String id,
                        @RequestBody City city){
        city.setId(id);
        cityRepos.save(city);
    }

    @DeleteMapping("/{id}")
    private void deleteCity(@PathVariable("id") String id){
        cityRepos.deleteById(id);
    }

    @GetMapping
    private List<City> allCities(){
        return cityRepos.findAll();
    }

    @GetMapping("/{id}")
    public List<City> cityByID(@PathVariable("id") String id){
       return  (List<City>) cityRepos.findAllById(Collections.singleton(id));
    }
}
