package pl.edu.pjatk.tau.BDD.MangaServiceStepsTest.LikeAsScenarioTest;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Rule;
import pl.edu.pjatk.tau.domain.Manga;
import pl.edu.pjatk.tau.services.MangaService;
import pl.edu.pjatk.tau.utils.FieldResolver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.rules.ExpectedException;
import pl.edu.pjatk.tau.utils.RegexFilter;

public class MangaServiceStepsTest {

    private MangaService service;
    private FieldResolver resolver = new FieldResolver();
    private RegexFilter regexFilter = new RegexFilter();
    private Manga stubManga = new Manga("Kizouki Mangaka", "Litle witch academy", "seinen");

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Before
    public void setUp() {
        service = new MangaService();
        service.create(stubManga);
    }

    @Given("^a manga list")
    public void there_is_a_manga_list() throws Throwable {
        assertNotNull(service.readAll());
    }

    @When("^user write category \\\"([^\\\"]*)\\\" and \\\"([^\\\"]*)\\\" autor is exist$")
    public void user_write_category_autor_and_is_exist(String tag, String value) throws Exception {
        assertEquals(true , resolver.resolve(tag));
        assertEquals(true , regexFilter.match(service.readAll(), tag, value));
    }

    @Then("^then result should be manga")
    public void then_result_should_be() throws Throwable {
        assertEquals( stubManga.getAutor(),
                service.findMangaLikeAs("Kizouki Mangaka", "autor").getAutor());
    }

    @When("^user write category \"([^\"]*)\" and is doesnt exist$")
    public void user_write_category_and_is_doesnt_exist(String tag) throws Exception {
        assertEquals(false , resolver.resolve(tag));
    }

    @When("^user use \"([^\"]*)\" category, but value \"([^\"]*)\" doesnt exist$")
    public void user_use_category_but_value_doesnt_exist(String tag, String value) throws Exception {
        assertEquals(true , resolver.resolve(tag));
        assertEquals(false, regexFilter.match(service.readAll(), tag, value));
    }

    @Then("^result should be return exception")
    public void then_should_be_return_exception() throws Throwable {
        try {
            service.findMangaLikeAs("kizoku", "test");
        }
        catch (Exception e) {
            assertEquals( "Category doesnt exist", e.getMessage() );
        }
    }

    @Then("^result should be return not found value")
    public void then_should_be_return_not_value_exception() throws Throwable {
        try {
            service.findMangaLikeAs("kizoku", "autor");
        }
        catch (Exception e) {
            assertEquals( "Manga doesnt exist", e.getMessage() );
        }
    }
}
