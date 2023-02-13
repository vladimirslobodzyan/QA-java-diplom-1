import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;

import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger = new Burger();

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient1;
    @Mock
    Ingredient ingredient2;


    @Test
    public void setBunTest(){
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest(){
        burger.addIngredient(ingredient1);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest(){
        burger.addIngredient(ingredient1);
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredient(){
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        assertEquals(1, burger.ingredients.indexOf(ingredient1));
    }


}
