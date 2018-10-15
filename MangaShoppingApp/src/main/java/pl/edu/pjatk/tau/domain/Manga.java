package pl.edu.pjatk.tau.domain;

public class Manga {
    private static int id;
    private String autor;
    private String title;
    private String category;

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
}
