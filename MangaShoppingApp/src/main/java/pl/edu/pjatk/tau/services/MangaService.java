package pl.edu.pjatk.tau.services;

import pl.edu.pjatk.tau.domain.Manga;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MangaService {

    private ArrayList<Manga> mangaList = new ArrayList<Manga>();
    private static int id = 0;

    public boolean create(Manga manga) {
        id++;
        manga.setId(id);
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
}
