import com.example.Feline;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class FelineTests {
    public FelineTests() {
    }

    @Test
    public void felineGetEatMeatTest() throws Exception {
        Feline feline = new Feline();
        List<String> referenceMeat = Arrays.asList("Животные", "Птицы", "Рыба");
        Assert.assertEquals(referenceMeat, feline.eatMeat());
    }

    @Test
    public void familyTest() {
        Feline feline = new Feline();
        String actualFamily = feline.getFamily();
        Assert.assertEquals("Кошачьи", actualFamily);
    }

    @Test
    public void kittensCountTest() {
        Feline feline = new Feline();
        Assert.assertEquals(0, feline.getKittens(0));
    }

    @Test
    public void kittensTest() {
        Feline feline = new Feline();
        Assert.assertEquals(1, feline.getKittens());
    }
}

