package polytech.michelin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import polytech.michelin.entity.RestaurantEntity;
import polytech.michelin.exception.RessourceInexistante;
import polytech.michelin.exception.ValeurIncorrecte;
import polytech.michelin.repository.RestaurantRepository;

@Service
@RequiredArgsConstructor
public class RestaurantService 
{
    private final RestaurantRepository restaurantRepository;

    public List<RestaurantEntity> getAllRestaurants() 
    {
        return this.restaurantRepository.findAll();
    }

    public RestaurantEntity getRestaurantById(int id) 
    {
        return this.restaurantRepository.findById(id)
            .orElseThrow(() -> new RessourceInexistante("Le restaurant qui possède l'id : " + id + " n'existe pas. Assurez vous d'avoir renseigné le bon id."));
    }

    public RestaurantEntity addRestaurant(final String nom, final String adresse) 
    {
        final RestaurantEntity nouveauRestaurant = RestaurantEntity.builder().nom(nom).adresse(adresse).evaluations(new ArrayList<>()).build();
        return this.restaurantRepository.save(nouveauRestaurant);
    }

    public RestaurantEntity updateNomRestaurant(int id, String nouveauNom) 
    {
        if (nouveauNom == null) 
        {
            throw new ValeurIncorrecte("Le nouveau nom ne doit pas être vide");
        }

        final RestaurantEntity restaurantToUpdate = this.restaurantRepository.findById(id).orElseThrow(() -> new RessourceInexistante("le restaurant avec l'id " + id + " n'existe pas. Assurez vous d'avoir renseigné le bon id."));
        restaurantToUpdate.setNom(nouveauNom);
        restaurantRepository.save(restaurantToUpdate);
        return restaurantToUpdate;
    }

    public RestaurantEntity updateAdresseRestaurant(int id, String nouvelleAdresse) 
    {
        if (nouvelleAdresse == null) 
        {
            throw new ValeurIncorrecte("La nouvelle adresse ne doit pas être vide");
        }

        final RestaurantEntity restaurantToUpdate = this.restaurantRepository.findById(id).orElseThrow(() -> new RessourceInexistante("le restaurant avec l'id " + id + " n'existe pas. Assurez vous d'avoir renseigné le bon id."));
        restaurantToUpdate.setAdresse(nouvelleAdresse);
        restaurantRepository.save(restaurantToUpdate);
        return restaurantToUpdate;
    }

}
