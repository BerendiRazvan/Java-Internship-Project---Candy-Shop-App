package domain.sweet;


import java.util.ArrayList;
import java.util.List;

public class Sweet {
    private long id;
    private final SweetType sweetType;

    private List<Ingredient> ingredientsList;

    private List<Ingredient> extraIngredients;
    private double price;

    public Sweet(long id, List<Ingredient> ingredientsList, SweetType sweetType, double price) {
        this.id = id;
        this.sweetType = sweetType;
        this.ingredientsList = ingredientsList;
        this.extraIngredients = new ArrayList<>();
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Ingredient> getIngredientsList() {
        return ingredientsList;
    }

    public List<Ingredient> getExtraIngredients() {
        return extraIngredients;
    }

    public void setIngredientsList(List<Ingredient> ingredientsList) {
        this.ingredientsList = ingredientsList;
    }

    public void setExtraIngredients(List<Ingredient> extraIngredients) {
        this.extraIngredients = extraIngredients;
    }

    public SweetType getSweetType() {
        return sweetType;
    }

    public double getPrice() {
        return getOriginalPrice() + getExtraPrice();
    }

    public double getOriginalPrice() {
        return price;
    }

    public double getExtraPrice() {
        return getExtraIngredients()
                .stream()
                .mapToDouble(Ingredient::getPrice)
                .sum();
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "\n\n" + sweetType +
                "\nPrice: " + price + "$ " +
                "\n" + "Recipe:" +
                "\nIngredients: " + ingredientsList +
                "\nExtra ingredients to add: " + extraIngredients;
    }
}