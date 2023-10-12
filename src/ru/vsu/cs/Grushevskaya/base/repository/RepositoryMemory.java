package ru.vsu.cs.Grushevskaya.base.repository;

import ru.vsu.cs.Grushevskaya.base.Identifiable;

import java.util.ArrayList;
import java.util.List;

public class RepositoryMemory<T extends Identifiable> implements Repository<T> {
    private final List<T> items;
    private int id = 0;

    public RepositoryMemory() {
        this.items = new ArrayList<>();
    }

    @Override
    public void add(T item) {
        item.setID(id);
        items.add(item);
        id = id + 1;
    }

    @Override
    public T getById(int id) {
        for (T item : items) {
            if (item.getID() == id) {
                return item;
            }
        }
        return null;
    }

    @Override
    public List<T> getAll() {
        return new ArrayList<>(items);
    }

    @Override
    public void update(int id, T newItem) throws IllegalArgumentException {
        newItem.setID(id);
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getID() == id) {
                items.set(i, newItem);
                return;
            }
        }
        throw new IllegalArgumentException("Object with ID " + id + " not found.");
    }

    @Override
    public void delete(int id) throws IllegalArgumentException {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getID() == id) {
                items.remove(i);
                return;
            }
        }
        throw new IllegalArgumentException("Object with ID " + id + " not found.");
    }
}
