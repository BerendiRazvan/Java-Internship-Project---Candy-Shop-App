package repository.sweetRepository;


import domain.sweet.Sweet;
import repository.Repository;
import repository.ingredientRepository.IngredientRepository;

import java.util.Optional;

public interface SweetRepository extends Repository<Long, Sweet> {
    Optional<Sweet> findSweetById(Long id);

    void generateSweets(IngredientRepository ingredientRepository);

    Optional<Long> generateSweetId();
}