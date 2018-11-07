package pl.edu.pjatk.tau.mockDomain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import pl.edu.pjatk.tau.domain.Manga;
import pl.edu.pjatk.tau.domain.timeStamps.CreateTimeStamp;
import pl.edu.pjatk.tau.domain.timeStamps.ITimeStamp;
import pl.edu.pjatk.tau.domain.timeStamps.ReadTimeStamp;
import pl.edu.pjatk.tau.domain.timeStamps.UpdateTimeStamp;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MangaTest {

    @Mock
    Manga manga = mock(Manga.class);

    @Test
    public void whenCallMethodGetCreateTimeStampThenShouldBeReturnCreateTimeStamp() {
        ITimeStamp exceptCreateTimeStamp = new CreateTimeStamp();
        exceptCreateTimeStamp.setDate(LocalDate.now());
        when(manga.getCreateTimeStamp()).thenReturn(exceptCreateTimeStamp);
        assertEquals(exceptCreateTimeStamp, manga.getCreateTimeStamp());
    }

    @Test
    public void whenCallMethodGetReadTimeStampThenShouldBeReturnReadTimeStamp() {
        ITimeStamp exceptReadTimeStamp = new ReadTimeStamp();
        exceptReadTimeStamp.setDate(LocalDate.now());
        when(manga.getReadTimeStamp()).thenReturn(exceptReadTimeStamp);
        assertEquals(exceptReadTimeStamp.getClass(), manga.getReadTimeStamp().getClass());
    }

    @Test
    public void whenCallMethodGetUpdateTimeStampThenShouldBeReturnUpdateTimeStamp() {
        ITimeStamp exceptUpdateTimeStamp = new UpdateTimeStamp();
        exceptUpdateTimeStamp.setDate(LocalDate.now());
        when(manga.getUpdateTimeStamp()).thenReturn(exceptUpdateTimeStamp);
        assertEquals(exceptUpdateTimeStamp.getClass(), manga.getUpdateTimeStamp().getClass());
    }

    @Test
    public void whenCallMethodSetBlockInFalseReadTimeStampThenWillUnblock() {
        ITimeStamp exceptReadTimeStamp = new ReadTimeStamp();
        when(manga.getReadTimeStamp()).thenReturn(exceptReadTimeStamp);
        manga.getReadTimeStamp().setBlock(false);
        assertEquals(false , manga.getReadTimeStamp().isBlock());
    }

    @Test
    public void whenCallMethodSetBlockInTrueReadTimeStampThenWillBlock() {
        ITimeStamp exceptReadTimeStamp = new ReadTimeStamp();
        when(manga.getReadTimeStamp()).thenReturn(exceptReadTimeStamp);
        manga.getReadTimeStamp().setBlock(true);
        assertEquals(true , manga.getReadTimeStamp().isBlock());
    }


    @Test
    public void whenCallMethodSetBlockInFalseUpdateTimeStampThenWillUnblock() {
        ITimeStamp exceptUpdateTimeStamp = new UpdateTimeStamp();
        when(manga.getUpdateTimeStamp()).thenReturn(exceptUpdateTimeStamp);
        manga.getUpdateTimeStamp().setBlock(false);
        assertEquals(false , manga.getUpdateTimeStamp().isBlock());
    }

    @Test
    public void whenCallMethodSetBlockInTrueCreateTimeStampThenWillBlock() {
        ITimeStamp exceptUpdateTimeStamp = new UpdateTimeStamp();
        when(manga.getUpdateTimeStamp()).thenReturn(exceptUpdateTimeStamp);
        manga.getUpdateTimeStamp().setBlock(true);
        assertEquals(true , manga.getUpdateTimeStamp().isBlock());
    }
}
