package pl.edu.pjatk.tau.domain;

import pl.edu.pjatk.tau.domain.timeStamps.*;

public class Manga {
    private static int id;
    private String autor;
    private String title;
    private String category;
    private ITimeStamp createTimeStamp = new CreateTimeStamp();
    private ITimeStamp updateTimeStamp = new UpdateTimeStamp();
    private ITimeStamp readTimeStamp = new ReadTimeStamp();

    public Manga(
            String autor,
            String title,
            String category
            ) {
        this.autor = autor;
        this.title = title;
        this.category = category;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public String getAutor() {
        return autor;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public ITimeStamp getReadTimeStamp() {
        return readTimeStamp;
    }

    public void setReadTimeStamp(ITimeStamp readTimeStamp) {
        this.readTimeStamp = readTimeStamp;
    }

    public ITimeStamp getUpdateTimeStamp() {
        return updateTimeStamp;
    }

    public void setUpdateTimeStamp(ITimeStamp updateTimeStamp) {
        this.updateTimeStamp = updateTimeStamp;
    }

    public ITimeStamp getCreateTimeStamp() {
        return createTimeStamp;
    }

    public void setCreateTimeStamp(ITimeStamp createTimeStamp) {
        this.createTimeStamp = createTimeStamp;
    }
}