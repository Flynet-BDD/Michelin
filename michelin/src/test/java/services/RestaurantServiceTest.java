package services;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import polytech.michelin.exception.RessourceInexistante;
import polytech.michelin.exception.ValeurIncorrecte;
import polytech.michelin.repository.RestaurantRepository;
import polytech.michelin.service.RestaurantService;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RestaurantServiceTest
{
    @InjectMocks
    private RestaurantService restaurantService;

    @Mock
    private RestaurantRepository restaurantRepository;

    @Test()
    public void shouldThrowValeurIncorrecte()
    {
        assertThrows(ValeurIncorrecte.class, () -> this.restaurantService.updateNomRestaurant(92, null));
    }

    @Test()
    public void shouldThrownRessourceInexistante() 
    {
        when(restaurantRepository.findById(any())).thenReturn(Optional.empty());
        assertThrows(RessourceInexistante.class, () -> this.restaurantService.updateNomRestaurant(1, "nouveau nom"));
    }
}
