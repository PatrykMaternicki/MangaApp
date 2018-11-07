package pl.edu.pjatk.tau.services;

import pl.edu.pjatk.tau.domain.Manga;
import pl.edu.pjatk.tau.utils.FieldResolver;
import pl.edu.pjatk.tau.utils.RegexFilter;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class MangaService {

    private ArrayList<Manga> mangaList = new ArrayList<Manga>();
    private static int id = 0;

    public boolean create(Manga manga) {
        id++;
        manga.setId(id);
        manga.getCreateTimeStamp().setDate(LocalDate.now());
        manga.getUpdateTimeStamp().setDate(LocalDate.now());
        mangaList.add(manga);
        return true;
    }

    public void disconnect() {
        mangaList.clear();
    }

    public ArrayList<Manga> readAll() {
        return mangaList;
    }

    public Manga read(int id) {
        for (Manga manga : mangaList) {
            if (id == manga.getId()) {
                manga.getReadTimeStamp().setDate(LocalDate.now());
                return manga;
            }
        }
        throw new NullPointerException("Object in database not found");
    }

    public boolean update(int id, Manga updatedManga) {
        for (Manga manga : mangaList) {
            if (id == manga.getId()) {
                manga.setAutor(updatedManga.getAutor());
                manga.setCategory(updatedManga.getAutor());
                manga.setTitle(updatedManga.getTitle());
                manga.getUpdateTimeStamp().setDate(LocalDate.now());
                manga.getCreateTimeStamp().setDate(manga.getCreateTimeStamp().getDate());
                manga.getReadTimeStamp().setDate(manga.getReadTimeStamp().getDate());
                return true;
            }
        }
        throw new NullPointerException("Object in database is not exist");
    }

    public void remove(int id) {
            try {
                read(id);
            } catch(NullPointerException e) {
                throw e;
            }

        mangaList = (ArrayList) mangaList.stream()
                .filter(manga -> manga.getId() != id)
                .collect(Collectors.toList());
    }

    public Manga findMangaLikeAs(String wantedString, String keyCategory) {
        if (isFieldExist(keyCategory)) {
            if (RegexFilter.match(mangaList, keyCategory, wantedString)) {
                return RegexFilter.getFoundedManga();
            } else {
                throw new NullPointerException("Manga doesnt exist");
            }
        }
        throw new NullPointerException("Category doesnt exist");
    }

    public Boolean removeMangaLikeAs(String wantedString, String keyCategory) {
        if (isFieldExist(keyCategory)) {
            if (RegexFilter.match(mangaList, keyCategory, wantedString)) {
               remove(RegexFilter.getFoundedManga().getId());
               return true;
            } else {
                throw new NullPointerException("Manga doesnt exist");
            }
        }
        throw new NullPointerException("Category doesnt exist");
    }

    private Boolean isFieldExist(String keyCategory) {
        return new FieldResolver().resolve(keyCategory);
    }
}
