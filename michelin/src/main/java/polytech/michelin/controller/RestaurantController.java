package polytech.michelin.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import polytech.michelin.dto.RestaurantDto;
import polytech.michelin.service.RestaurantService;

@RestController()
public class RestaurantController 
{
    public final RestaurantService restaurantService;

    public RestaurantController(RestaurantService rservice)
    {
        this.restaurantService = rservice;
    }

    @GetMapping("/restaurant/{id}")
    public @ResponseBody RestaurantDto getRestaurantById(@PathVariable int id)
    {
        return RestaurantDto.fromEntity(this.restaurantService.getRestaurantById(id));
    }

    @GetMapping("/restaurants")
    public @ResponseBody List<RestaurantDto> getRestaurants() 
    {
        return this.restaurantService.getAllRestaurants().stream().map(entity -> RestaurantDto.fromEntity(entity)).collect(Collectors.toList());
    }

    @PutMapping("/restaurant/{id}/adresse")
    public @ResponseBody RestaurantDto putRestaurantAdresse(@PathVariable int id, @Valid @RequestBody RestaurantDto resto)
    {
        return RestaurantDto.fromEntity(this.restaurantService.updateAdresseRestaurant(id, resto.getAdresse()));
    }

    @PutMapping("/restaurant/{id}/nom")
    public @ResponseBody RestaurantDto putRestaurantNom(@PathVariable int id, @Valid @RequestBody RestaurantDto resto)
    {
        return RestaurantDto.fromEntity(this.restaurantService.updateNomRestaurant(id, resto.getNom()));
    }

    @PostMapping("/restaurant")
    public RestaurantDto postRestaurant(@Valid @RequestBody RestaurantDto resto) 
    {
        return RestaurantDto.fromEntity(this.restaurantService.addRestaurant(resto.getNom(), resto.getAdresse()));
    }
}
