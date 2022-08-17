package service.sweetService;

import domain.sweet.Ingredient;
import domain.sweet.Sweet;
import service.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface SweetService {
    List<Sweet> getAvailableSweets();

    Optional<Sweet>  findSweetById(String sweetId) throws ServiceException;

    Optional<Sweet> createNewSweetWithoutIngredients() throws ServiceException;

    void addIngredientToSweet(Sweet customSweet, Ingredient newIngredient, int amount) throws ServiceException;

    void addAllIngredientsToSweet(Sweet customSweet, String ingredients) throws ServiceException;
}
