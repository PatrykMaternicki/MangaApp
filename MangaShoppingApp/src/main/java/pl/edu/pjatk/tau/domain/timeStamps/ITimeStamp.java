package pl.edu.pjatk.tau.domain.timeStamps;

import java.time.LocalDate;

public interface ITimeStamp {
    Boolean isBlock();
    void setBlock(Boolean state);
    LocalDate getDate();
    void setDate(LocalDate date);
}
