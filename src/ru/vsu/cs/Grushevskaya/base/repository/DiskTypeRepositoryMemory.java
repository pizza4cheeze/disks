package ru.vsu.cs.Grushevskaya.base.repository;

import ru.vsu.cs.Grushevskaya.base.Identifiable;
import ru.vsu.cs.Grushevskaya.base.models.DiskType;

import java.util.ArrayList;
import java.util.List;

public class DiskTypeRepositoryMemory implements DiskTypeRepository {
    private final List<DiskType> items;
    private int id = 0;

    public DiskTypeRepositoryMemory() {
        this.items = new ArrayList<>();
    }

    @Override
    public void add(DiskType item) {
        item.setID(id);
        items.add(item);
        id = id + 1;
    }

    @Override
    public DiskType getById(int id) {
        for (DiskType item : items) {
            if (item.getID() == id) {
                return item;
            }
        }
        return null;
    }

    @Override
    public List<DiskType> getAll() {
        return new ArrayList<>(items);
    }

    @Override
    public void update(int id, DiskType newItem) throws IllegalArgumentException {
        newItem.setID(id);
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getID() == id) {
                items.set(i, newItem);
                return;
            }
        }
        throw new IllegalArgumentException("Type with ID " + id + " not found.");
    }

    @Override
    public void delete(int id) throws IllegalArgumentException {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getID() == id) {
                items.remove(i);
                return;
            }
        }
        throw new IllegalArgumentException("Type with ID " + id + " not found.");
    }
}
