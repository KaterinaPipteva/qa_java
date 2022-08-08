package com.example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionExceptionTest {
    @Mock
    Feline feline;

    @Test(expected = Exception.class)
    public void lionConstructorGetException() throws Exception{
        try {
            Lion lion = new Lion("Интерсекс", feline);
        } catch (Exception e) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка", e.getMessage());
            throw e;
        }
    }
}
