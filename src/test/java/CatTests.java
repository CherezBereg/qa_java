import com.example.Cat;
import com.example.Feline;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class CatTests {
    public CatTests() {
    }

    @Test
    public void catGetSoundTest() {
        Feline feline = new Feline();
        Cat cat = new Cat(feline);
        String referenceSound = "Мяу";
        Assert.assertEquals(referenceSound, cat.getSound());
    }

    @Test
    public void catGetEatMeatTest() throws Exception {
        Feline feline = new Feline();
        Cat cat = new Cat(feline);
        List<String> expectedEatMeat = Arrays.asList("Животные", "Птицы", "Рыба");
        Assert.assertEquals(expectedEatMeat, cat.getFood());
    }
}
