package service.ingredientService;

import domain.sweet.Ingredient;
import repository.ingredientRepository.IngredientRepository;
import service.exception.ServiceException;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

public class IngredientServiceImpl implements IngredientService {

    private IngredientRepository ingredientRepository;

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }


    @Override
    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    @Override
    public Ingredient findIngredientById(String ingredientId) throws ServiceException {
        long id;
        try {
            id = Long.parseLong(ingredientId);
        } catch (Exception e) {
            throw new ServiceException("Invalid ingredient id!");
        }
        return ingredientRepository.findIngredientById(id);
    }

    @Override
    public List<String> showAllIngredientsInStock() {
        return ingredientRepository.findAll()
                .stream()
                .filter(ingredient -> ingredient.getAmount() > 0)
                .map(ingredient -> String.valueOf(getIngredientDetails(ingredient)))
                .collect(Collectors.toList());
    }

    private StringBuilder getIngredientDetails(Ingredient ingredient) {
        StringBuilder ingredientDetails = new StringBuilder(ingredient.getId() + ". " +
                ingredient.getName() +
                ",\tPrice: " + df.format(ingredient.getPrice()) + "$" +
                "\tStock: " + ingredient.getAmount());

        if (ingredient.getAmount() > 10)
            return ingredientDetails;
        else
            return ingredientDetails.append("\t(reduced quantity in shop stock)");
    }
}
