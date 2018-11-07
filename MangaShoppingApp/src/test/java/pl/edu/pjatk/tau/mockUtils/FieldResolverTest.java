package pl.edu.pjatk.tau.mockUtils;

import org.junit.*;

import org.junit.rules.ExpectedException;
import pl.edu.pjatk.tau.utils.FieldResolver;
import static org.junit.Assert.assertEquals;

public class FieldResolverTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    private FieldResolver fieldResolver;

    @Before
    public void Setup() {
        fieldResolver = new FieldResolver();
    }

    @Test
    public void shouldReturnExceptionWhenCateogryDoenstFound(){
        assertEquals(false, fieldResolver.resolve("test"));
    }

    @Test
    public void shouldReturnExistCategory(){
        assertEquals(true, fieldResolver.resolve("autor"));
    }
}
