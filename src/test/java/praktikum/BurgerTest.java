package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static praktikum.IngredientType.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger = new Burger();

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Test
    public void setBunsOneBunBurgerBunNotNullTest() {
        burger.bun = null;
        burger.setBuns(bun);
        assertNotNull(burger.bun);
    }

    @Test
    public void addIngredientOneElementBurgerSizeLargeByOneTest() {
        burger.ingredients = new ArrayList<>(List.of(ingredient));
        int ingredientCount = burger.ingredients.size();
        burger.addIngredient(ingredient);
        assertEquals(ingredientCount, burger.ingredients.size() - 1);
    }

    @Test
    public void removeIngredientFirstIndexBurgerSizeLessByOneTest() {
        burger.ingredients = new ArrayList<>(List.of(ingredient, ingredient));
        int ingredientCount = burger.ingredients.size();
        burger.removeIngredient(0);
        assertEquals(ingredientCount, burger.ingredients.size() + 1);
    }

    @Test
    public void moveIngredientSwapSecondToFirstTest() {
        burger.ingredients = new ArrayList<>(List.of(new Ingredient(SAUCE, "1_ingredient", 24F)
                , new Ingredient(SAUCE, "2_ingredient", 24F)));
        burger.moveIngredient(1, 0);
        assertEquals("2_ingredient", burger.ingredients.get(0).name);
    }

    @Test
    public void getPrice1Bun3IngredientReturnSumOfAllPriceTest() {
        burger.bun = bun;
        burger.ingredients = new ArrayList<>(List.of(ingredient, ingredient, ingredient));
        Mockito.when(bun.getPrice()).thenReturn(10F);
        Mockito.when(ingredient.getPrice()).thenReturn(15F);
        assertEquals(65F,burger.getPrice() , 0.0F);
    }
}