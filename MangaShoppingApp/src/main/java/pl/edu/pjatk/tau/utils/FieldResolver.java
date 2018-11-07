package pl.edu.pjatk.tau.utils;

import pl.edu.pjatk.tau.domain.Manga;

public class FieldResolver {
    private Manga manga = new Manga("", "", "");

    public Boolean resolve(String keyCategory) {
        return manga.toString().matches("(.*)" + keyCategory + "(.*)");
    }
}