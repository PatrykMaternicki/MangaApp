package com.example.shdemo.service;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;

import com.example.shdemo.domain.Manga;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/beans.xml"})
@Rollback
//@Commit
@Transactional(transactionManager = "txManager")
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
                         DirtiesContextTestExecutionListener.class,
                         TransactionalTestExecutionListener.class,
                         DbUnitTestExecutionListener.class})
public class MangaServiceHibernateImplTest {

  @Autowired MangaServiceHibernateImpl service;

  @Test
  @DatabaseSetup("/fullData.xml")
  @ExpectedDatabase(value = "/MangaData.xml",
                    assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void shouldBeReturnList() throws ParseException {
    Manga manga = new Manga();
    manga.setAuthor("Tezuki Shikimura");
    manga.setCategory("Seinen");
    manga.setTitle("Super tytul");
    service.create(manga);
    assertEquals(1, service.getAllManga().size());
  }

  @Test
  @DatabaseSetup("/fullData.xml")
  @ExpectedDatabase(value = "/MangaData.xml",
          assertionMode = DatabaseAssertionMode.NON_STRICT)
  public void shouldBeRemove() throws ParseException {
    Manga manga = new Manga();
    manga.setAuthor("Tezuki Shikimura");
    manga.setCategory("Seinen");
    manga.setTitle("Super tytul");
    service.create(manga);
    assertEquals(0, service.getAllManga().size());
  }

  @Test
  @DatabaseSetup("/fullData.xml")
  @ExpectedDatabase(value = "/MangaData.xml",
          assertionMode = DatabaseAssertionMode.NON_STRICT)
  public void shouldBeUpdate() throws ParseException {
    Manga manga = new Manga();
    String testTitle = "hulululu";
    manga.setAuthor("Tezuki Shikimura");
    manga.setCategory("Seinen");
    manga.setTitle("Super tytul");
    Long id  = service.create(manga);
    Manga testManga = service.read(id);
    Long idManga = testManga.getId();
    testManga.setTitle(testTitle);
    assertEquals(testTitle, service.read(idManga).getTitle());
  }
}
