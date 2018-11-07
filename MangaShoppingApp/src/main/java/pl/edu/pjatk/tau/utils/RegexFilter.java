package pl.edu.pjatk.tau.utils;

import pl.edu.pjatk.tau.domain.Manga;

import java.util.List;

public class RegexFilter {
    private static Manga foundedManga;
    public static Boolean match(List<Manga> mangaList, String keyCategory, String value) {
        Boolean isFoundManga = false;
        for (Manga manga : mangaList) {
            String regex = keyCategory + "=" + value;
            if (manga.toString().matches("(.*)" + regex + "(.*)")) {
                foundedManga = manga;
                isFoundManga = true;
            }
        }
        return isFoundManga;
    }

    public static Manga getFoundedManga() {
        return foundedManga;
    }
}
