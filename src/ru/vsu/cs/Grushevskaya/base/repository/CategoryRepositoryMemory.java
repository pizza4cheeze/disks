package ru.vsu.cs.Grushevskaya.base.repository;

import ru.vsu.cs.Grushevskaya.base.Identifiable;
import ru.vsu.cs.Grushevskaya.base.models.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryRepositoryMemory implements CategoryRepository {
    private final List<Category> items;
    private int id = 0;

    public CategoryRepositoryMemory() {
        this.items = new ArrayList<>();
    }

    @Override
    public void add(Category item) {
        item.setID(id);
        items.add(item);
        id = id + 1;
    }

    @Override
    public Category getById(int id) {
        for (Category item : items) {
            if (item.getID() == id) {
                return item;
            }
        }
        return null;
    }

    @Override
    public List<Category> getAll() {
        return new ArrayList<>(items);
    }

    @Override
    public void update(int id, Category newItem) throws IllegalArgumentException {
        newItem.setID(id);
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getID() == id) {
                items.set(i, newItem);
                return;
            }
        }
        throw new IllegalArgumentException("Category with ID " + id + " not found.");
    }

    @Override
    public void delete(int id) throws IllegalArgumentException {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getID() == id) {
                items.remove(i);
                return;
            }
        }
        throw new IllegalArgumentException("Category with ID " + id + " not found.");
    }
}
