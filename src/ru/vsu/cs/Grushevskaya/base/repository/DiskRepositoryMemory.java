package ru.vsu.cs.Grushevskaya.base.repository;

import ru.vsu.cs.Grushevskaya.base.models.Disk;

import java.util.ArrayList;
import java.util.List;

public class DiskRepositoryMemory implements DiskRepository {
    private final List<Disk> disks;
    private int id = 0;

    public DiskRepositoryMemory() {
        this.disks = new ArrayList<>();
    }

    @Override
    public void add(Disk item) {
        item.setID(id);
        disks.add(item);
        id = id + 1;
    }

    @Override
    public Disk getById(int id) {
        for (Disk item : disks) {
            if (item.getID() == id) {
                return item;
            }
        }
        return null;
    }

    @Override
    public List<Disk> getAll() {
        return new ArrayList<>(disks);
    }

    @Override
    public void update(int id, Disk newItem) throws IllegalArgumentException {
        newItem.setID(id);
        for (int i = 0; i < disks.size(); i++) {
            if (disks.get(i).getID() == id) {
                disks.set(i, newItem);
                return;
            }
        }
        throw new IllegalArgumentException("Disk with ID " + id + " not found.");
    }

    @Override
    public void delete(int id) throws IllegalArgumentException {
        for (int i = 0; i < disks.size(); i++) {
            if (disks.get(i).getID() == id) {
                disks.remove(i);
                return;
            }
        }
        throw new IllegalArgumentException("Disk with ID " + id + " not found.");
    }
}
