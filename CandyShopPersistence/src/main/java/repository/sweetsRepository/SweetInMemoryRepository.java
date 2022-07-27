package repository.sweetsRepository;

import domain.sweet.Ingredient;
import domain.sweet.Recipe;
import domain.sweet.Sweet;
import domain.sweet.SweetType;
import repository.exception.RepositoryException;

import java.util.ArrayList;
import java.util.List;

public class SweetInMemoryRepository implements SweetRepository {

    private List<Sweet> sweetList;

    public SweetInMemoryRepository(List<Sweet> sweetList) {
        this.sweetList = sweetList;
    }

    @Override
    public void add(Sweet elem) throws RepositoryException {
        if (!sweetList.contains(elem))
            sweetList.add(elem);
        else
            throw new RepositoryException("This element already exists!");
    }

    @Override
    public void update(Long aLong, Sweet elem) throws RepositoryException {
        boolean exists = false;
        for (Sweet sweet : sweetList) {
            if (sweet.getIdSweet() == elem.getIdSweet()) {
                sweetList.set(sweetList.indexOf(sweet), elem);
                exists = true;
                break;
            }
        }
        if (!exists)
            throw new RepositoryException("This element does not exist!");
    }

    @Override
    public void delete(Long aLong) throws RepositoryException {
        boolean exists = false;
        for (Sweet sweet : sweetList) {
            if (sweet.getIdSweet() == aLong) {
                sweetList.remove(sweet);
                exists = true;
                break;
            }
        }
        if (!exists)
            throw new RepositoryException("This element does not exist!");
    }

    @Override
    public List<Sweet> findAll() {
        return sweetList;
    }

    @Override
    public Sweet findOneSweet(Long id) {
        for (Sweet sweet : sweetList)
            if (id == sweet.getIdSweet()) return sweet;
        return null;
    }

    public static List<Sweet> generateSweets() {
        List<Sweet> sweetList = new ArrayList<>();

        sweetList.add(new Sweet(1,
                new Recipe(1, new ArrayList<>(List.of(
                        new Ingredient(1, "Sugar", 1.5),
                        new Ingredient(2, "Milk", 1),
                        new Ingredient(3, "Flour", 0.75)))),
                SweetType.DONUT, 5));

        sweetList.add(new Sweet(2,
                new Recipe(2, new ArrayList<>(List.of(
                        new Ingredient(4, "Sugar", 1.7),
                        new Ingredient(5, "Flour", 0.95)))),
                SweetType.DONUT, 5.5));

        sweetList.add(new Sweet(3,
                new Recipe(3, new ArrayList<>(List.of(
                        new Ingredient(6, "Sugar", 2.7),
                        new Ingredient(7, "Milk", 3.7),
                        new Ingredient(8, "Flour", 3.7),
                        new Ingredient(9, "Chocolate", 10)))),
                SweetType.CAKE, 23.55));

        sweetList.add(new Sweet(4,
                new Recipe(4, new ArrayList<>(List.of(
                        new Ingredient(10, "Sugar", 0.7),
                        new Ingredient(11, "Flour", 0.7),
                        new Ingredient(12, "Chocolate", 1.5)))),
                SweetType.CROISSANT, 3.99));


        sweetList.add(new Sweet(5,
                new Recipe(5, new ArrayList<>(List.of(
                        new Ingredient(13, "Sugar", 0.25),
                        new Ingredient(14, "Flour", 0.3),
                        new Ingredient(15, "Honey", 2.5)))),
                SweetType.WAFFLES, 4.99));


        sweetList.add(new Sweet(6,
                new Recipe(6, new ArrayList<>(List.of(
                        new Ingredient(16, "Sugar", 0.55),
                        new Ingredient(17, "Flour", 1),
                        new Ingredient(18, "Caramel", 1.25)))),
                SweetType.CROISSANT, 3.39));


        sweetList.add(new Sweet(7,
                new Recipe(7, new ArrayList<>(List.of(
                        new Ingredient(19, "Milk", 1.5),
                        new Ingredient(21, "Sugat", 1.2),
                        new Ingredient(22, "Chocolate", 5.5)))),
                SweetType.HOMEMADE_CHOCOLATE, 13.39));

        sweetList.add(new Sweet(8,
                new Recipe(8, new ArrayList<>(List.of(
                        new Ingredient(23, "Sugar", 0.23),
                        new Ingredient(20, "Chocolate", 2.5)))),
                SweetType.DONUT, 3.25));


        sweetList.add(new Sweet(9,
                new Recipe(9, new ArrayList<>(List.of(
                        new Ingredient(25, "Sugar", 1.2),
                        new Ingredient(98, "Whipped cream", 2.5),
                        new Ingredient(97, "Vanilla", 3.35),
                        new Ingredient(26, "Flour", 4.7),
                        new Ingredient(27, "Strawberries", 5.5)))),
                SweetType.CAKE, 49.99));


        sweetList.add(new Sweet(10,
                new Recipe(10, new ArrayList<>(List.of(
                        new Ingredient(28, "Sugar", 0.56),
                        new Ingredient(29, "Vanilla", 0.53),
                        new Ingredient(30, "Cacao", 2.2)))),
                SweetType.HOMEMADE_CHOCOLATE, 3.99));


        sweetList.add(new Sweet(11,
                new Recipe(11, new ArrayList<>(List.of(
                        new Ingredient(31, "Sugar", 0.55),
                        new Ingredient(33, "Flour", 1.03)))),
                SweetType.CROISSANT, 1.99));

        sweetList.add(new Sweet(12,
                new Recipe(12, new ArrayList<>(List.of(
                        new Ingredient(35, "Flour", 0.5),
                        new Ingredient(36, "Vanilla", 0.5)))),
                SweetType.DONUT, 2.11));

        sweetList.add(new Sweet(13,
                new Recipe(13, new ArrayList<>(List.of(
                        new Ingredient(44, "Eggs", 1.2),
                        new Ingredient(45, "Flour", 0.31),
                        new Ingredient(46, "Peanut butter", 1.33)))),
                SweetType.WAFFLES, 3.75));

        sweetList.add(new Sweet(14,
                new Recipe(14, new ArrayList<>(List.of(
                        new Ingredient(47, "Eggs", 0.5),
                        new Ingredient(55, "Flour", 0.25),
                        new Ingredient(54, "Milk", 0.15)))),
                SweetType.WAFFLES, 1.99));

        sweetList.add(new Sweet(15,
                new Recipe(15, new ArrayList<>(List.of(
                        new Ingredient(58, "Flour", 0.45),
                        new Ingredient(66, "Cheese", 0.5)))),
                SweetType.CROISSANT, 0.99));

        return sweetList;
    }

}
