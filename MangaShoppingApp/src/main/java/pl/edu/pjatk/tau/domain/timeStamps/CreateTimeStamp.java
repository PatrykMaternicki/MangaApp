package pl.edu.pjatk.tau.domain.timeStamps;

import java.time.LocalDate;

public class CreateTimeStamp extends TimeStamp implements ITimeStamp{

    @Override
    public Boolean isBlock() {
        return super.getBlock();
    }

    @Override
    public void setBlock(Boolean state) {
        super.setBlock(state);
    }

    @Override
    public LocalDate getDate() {
        return super.getDate();
    }

    @Override
    public void setDate(LocalDate date) {
        super.setDate(date);
    }
}
