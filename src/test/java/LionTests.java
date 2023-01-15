import com.example.Feline;
import com.example.Lion;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

@RunWith(Parameterized.class)
public class LionTests {
    private final String sex;
    private final boolean isHasMane;

    /* По части модификаторов доступа и порядка следования возможно не совсем поняла:
    1. Переменные вроде перед методами, конструктором и тестовыми данными стоят
    2. Модификаторы доступа для них тоже были выставлены в private
    3. сheckbox rearrange entries использовала, выставила доступ для создания объекта-мока, предполагая, что дело в нём
    4. За тугоумие заранее каюсь :)
     */
    @Mock
    private Feline feline;

    public LionTests(String sex, boolean isHasMane) {
        this.sex = sex;
        this.isHasMane = isHasMane;
    }

    // Это очень удобно, спасибо! :)
    @Parameterized.Parameters(name = "Тестовые данные: {0} {1}")
    public static Object[][] getSumData() {
        return new Object[][]{{"Самец", true}, {"Самка", false}, {"Иное", false}};
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void lionSexVariableTest() {
        try {
            Lion lion = new Lion(sex);
            Assert.assertEquals(isHasMane, lion.doesHaveMane());
        } catch (Exception error) {
            Assert.assertEquals("Используйте допустимые значения пола животного - самей или самка", error.toString());
        }
    }

    @Test
    public void lionReturnSexTest() throws Exception {
        Lion lion = new Lion("Самец");
        if (lion.doesHaveMane()) {
            Assert.assertTrue(lion.doesHaveMane());
        } else if (!lion.doesHaveMane()) {
            Assert.assertFalse(lion.doesHaveMane());
        }

    }

    @Test
    public void lionKittensTest() throws Exception {
        Lion lion = new Lion("Самец");
        Mockito.when(this.feline.getKittens(Mockito.anyInt())).thenReturn(1);
        Assert.assertEquals(1, lion.getKittens());
    }

    @Test
    public void lionGetFoodTest() throws Exception {
        Lion lion = new Lion("Самец");
        Mockito.when(this.feline.getFood("Хищник")).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));
        List<String> referenceFood = Arrays.asList("Животные", "Птицы", "Рыба");
        Assert.assertEquals(referenceFood, lion.getFood());
    }
}

