package pl.edu.pjatk.tau.servicesTest;

import org.junit.*;

import org.junit.rules.ExpectedException;
import pl.edu.pjatk.tau.domain.Manga;
import pl.edu.pjatk.tau.services.MangaService;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MangaServiceTest {

    private MangaService service = new MangaService();
    private Manga manga;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Before
    public void startUp() {
        manga = new Manga("Kizouki Mangaka", "Litle witch academy", "seinen");
    }

    @After
    public void clean() {
        service.disconnect();
    }

    @Test
    public void shouldServiceIsExist() {
        assertNotNull(service);
    }

    @Test
    public void listIsInitial() {
        assertNotNull(service.readAll());
    }

    @Test
    public void shouldReturnList() {
        assertEquals(0, service.readAll().size());
    }

    @Test
    public void shouldAddToDb() {
        Assert.assertTrue("Manga doesnt add", service.create(manga));
    }

    @Test
    public void shouldReturnExceptionWhenIsNotExist() {
        exceptionRule.expect(NullPointerException.class);
        exceptionRule.expectMessage("Object in database not found");
        Manga manga = service.read(20);
    }

    @Test
    public void shouldReturnManga() {
        service.create(manga);
        int idExistedManga = service.readAll().get(0).getId();
        assertEquals(idExistedManga, service.read(idExistedManga).getId());
    }

    @Test
    public void shouldUpdateManga() {
        service.create(manga);
        Manga updatedManga = new Manga("Testsuki Umizaka", "Something title", "shoujo");
        Manga existedManga = service.readAll().get(0);
        service.update(existedManga.getId(), updatedManga);
        assertEquals(manga.getAutor(), service.read(existedManga.getId()).getAutor());
    }

    @Test
    public void shouldReturnWhenServiceNotFoundMangaToUpdate() {
        exceptionRule.expect(NullPointerException.class);
        exceptionRule.expectMessage("Object in database is not exist");
        service.create(manga);
        Manga updatedManga = new Manga("Testsuki Umizaka", "Something title", "shoujo");
        service.update(30, updatedManga);
    }

    @Test
    public void shouldReturnWhenServiceRemove() {
        service.create(manga);
        int idExistedManga = service.readAll().get(0).getId();
        service.remove(idExistedManga);
        exceptionRule.expect(NullPointerException.class);
        exceptionRule.expectMessage("Object in database not found");
        service.read(idExistedManga);
    }

    @Test
    public void shouldReturnExceptioWhenServiceDidntFindManga() {
        service.create(manga);
        exceptionRule.expect(NullPointerException.class);
        exceptionRule.expectMessage("Object in database not found");
        service.remove(30);
    }
}
