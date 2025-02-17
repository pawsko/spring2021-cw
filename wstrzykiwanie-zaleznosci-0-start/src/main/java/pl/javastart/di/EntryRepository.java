package pl.javastart.di;

import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.*;
@Repository
class EntryRepository {
    private List<Entry> entries;

    EntryRepository(FileService fileService) {
//    EntryRepository() {
//        FileService fileService = new FileService();
        try {
            this.entries = fileService.readAllFile();
        } catch (IOException e) {
            entries = new ArrayList<>();
        }
    }

    List<Entry> getAll() {
        return entries;
    }

    Set<Entry> getRandomEntries(int number) {
        Random random = new Random();
        Set<Entry> randomEntries = new HashSet<>();
        while (randomEntries.size() < number && randomEntries.size() < entries.size()) {
            randomEntries.add(entries.get(random.nextInt(entries.size())));
        }
        return randomEntries;
    }

    void add(Entry entry) {
        entries.add(entry);
    }

    int size() {
        return entries.size();
    }

    boolean isEmpty() {
        return entries.isEmpty();
    }
}