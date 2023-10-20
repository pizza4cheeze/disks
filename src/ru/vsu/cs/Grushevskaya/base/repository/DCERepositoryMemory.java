package ru.vsu.cs.Grushevskaya.base.repository;

import ru.vsu.cs.Grushevskaya.base.Identifiable;
import ru.vsu.cs.Grushevskaya.base.models.DiskCategoryEntity;

import java.util.ArrayList;
import java.util.List;

public class DCERepositoryMemory implements DCERepository {
    private final List<DiskCategoryEntity> items;
    private int id = 0;

    public DCERepositoryMemory() {
        this.items = new ArrayList<>();
    }

    @Override
    public void add(DiskCategoryEntity item) {
        item.setID(id);
        items.add(item);
        id = id + 1;
    }

    @Override
    public DiskCategoryEntity getById(int id) {
        for (DiskCategoryEntity item : items) {
            if (item.getID() == id) {
                return item;
            }
        }
        return null;
    }

    @Override
    public List<DiskCategoryEntity> getAll() {
        return new ArrayList<>(items);
    }

    @Override
    public void update(int id, DiskCategoryEntity newItem) throws IllegalArgumentException {
        newItem.setID(id);
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getID() == id) {
                items.set(i, newItem);
                return;
            }
        }
        throw new IllegalArgumentException("Disk Category Entity with ID " + id + " not found.");
    }

    @Override
    public void delete(int id) throws IllegalArgumentException {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getID() == id) {
                items.remove(i);
                return;
            }
        }
        throw new IllegalArgumentException("Disk Category Entity with ID " + id + " not found.");
    }
}
