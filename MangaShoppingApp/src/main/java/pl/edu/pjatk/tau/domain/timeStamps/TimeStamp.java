package pl.edu.pjatk.tau.domain.timeStamps;

import java.time.LocalDate;

abstract public class TimeStamp {
    public Boolean isBlock = false;
    public LocalDate date = LocalDate.now();

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Boolean getBlock() {
        return isBlock;
    }

    public void setBlock(Boolean block) {
        isBlock = block;
    }
}
