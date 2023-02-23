import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.Ingredient;
import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

public class IngredientTypeTest {
    @Mock
    Ingredient ingredient;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetPrice() {
        Mockito.when(ingredient.getPrice()).thenReturn(100F);
        assertEquals(ingredient.getPrice(), 100F, 0F);
    }

    @Test
    public void testGetName() {
        Mockito.when(ingredient.getName()).thenReturn("cutlet");
        assertEquals(ingredient.getName(), "cutlet");
    }

    @Test
    public void testGetType() {
        Mockito.when(ingredient.getType()).thenReturn(SAUCE);
        assertEquals(ingredient.getType(), SAUCE);
    }
}
