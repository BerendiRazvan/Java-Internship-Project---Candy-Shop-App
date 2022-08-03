package service.sweetService;

import domain.sweet.Ingredient;
import domain.sweet.Sweet;
import domain.sweet.SweetType;
import org.junit.jupiter.api.*;
import repository.sweetsRepository.SweetInMemoryRepository;
import repository.sweetsRepository.SweetRepository;
import service.exception.ServiceException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SweetServiceImplTest {

    private static SweetService sweetService;

    @BeforeAll
    static void setUpAll() {
        System.out.println("Tests for SweetServiceImpl");

        SweetRepository sweetRepository =
                new SweetInMemoryRepository(SweetInMemoryRepository.generateSweets());
        sweetService = new SweetServiceImpl(sweetRepository);
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("Tests passed");
    }

    @Test
    void testGetAvailableSweets() {
        assertEquals(sweetService.getAvailableSweets().size(), 15);
    }

    @Test
    void testValidFindSweetById() throws ServiceException {
        Sweet sweet = sweetService.findSweetById(String.valueOf(1L));
        assertEquals(sweet.getId(), 1L);
        assertEquals(sweet.getSweetType(), SweetType.DONUT);
        assertEquals(sweet.getPrice(), 5);
        assertEquals(sweet.getIngredientsList().toString(), new ArrayList<>(List.of(
                new Ingredient(1, "Sugar", 1.5),
                new Ingredient(2, "Milk", 1),
                new Ingredient(3, "Flour", 0.75))).toString());
        assertEquals(sweet.getExtraIngredients(), new ArrayList<>());
    }

    @Test
    void testInvalidFindSweetById() throws ServiceException {
        assertThrowsExactly(ServiceException.class,
                () -> sweetService.findSweetById("abcd"),
                "Invalid sweet id!");

        Sweet sweet = sweetService.findSweetById("777");
        assertNull(sweet);
    }

}