package pl.edu.pjatk.tau.mockTimeStamp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import pl.edu.pjatk.tau.domain.timeStamps.CreateTimeStamp;
import pl.edu.pjatk.tau.domain.timeStamps.ITimeStamp;
import pl.edu.pjatk.tau.domain.timeStamps.UpdateTimeStamp;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class mockUpdateTimeStampTest {

    @Mock
    ITimeStamp timeStamp = mock(UpdateTimeStamp.class);

    @Test
    public void WhenCallGetDateThenReturnCorectLocalDate() {
        LocalDate localDate = LocalDate.now();
        when(timeStamp.getDate()).thenReturn(localDate);
        assertEquals(localDate, timeStamp.getDate());
    }

    @Test
    public void WhenCallSetDateThenReallySetDate() {
        LocalDate localDate = LocalDate.now();
        timeStamp.setDate(localDate);
        verify(timeStamp).setDate(localDate);
    }
}
