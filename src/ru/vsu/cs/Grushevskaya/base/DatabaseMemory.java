package ru.vsu.cs.Grushevskaya.base;

import ru.vsu.cs.Grushevskaya.base.models.Category;
import ru.vsu.cs.Grushevskaya.base.models.Disk;
import ru.vsu.cs.Grushevskaya.base.models.DiskCategoryEntity;
import ru.vsu.cs.Grushevskaya.base.models.DiskType;
import ru.vsu.cs.Grushevskaya.base.repository.Repository;
import ru.vsu.cs.Grushevskaya.base.repository.RepositoryMemory;

import java.util.List;

public class DatabaseMemory implements Database {
    Repository<Disk> disks;
    Repository<Category> categories;
    Repository<DiskType> diskTypes;
    Repository<DiskCategoryEntity> diskCategoryEntities;

    private static DatabaseMemory example;

    public static DatabaseMemory getExample(){
        if(example == null) {
            example = new DatabaseMemory();
        }
        return example;
    }

    private DatabaseMemory(){
        disks = new RepositoryMemory<>();
        categories = new RepositoryMemory<>();
        diskTypes = new RepositoryMemory<>();
        diskCategoryEntities = new RepositoryMemory<>();
    }

    protected void checkDiskCategory(DiskCategoryEntity diskCategoryEntity){
        if (categories.getById(diskCategoryEntity.getCategoryId()) == null){
            throw new IllegalArgumentException("Illegal category ID, create this category at first");
        }
    }

    protected void checkDiskType(Disk disk) {
        if(diskTypes.getById(disk.getDiskTypeId()) == null){
            throw new IllegalArgumentException("Illegal diskType ID, create this type at first");
        }
    }

    protected void checkDiskId(DiskCategoryEntity diskCategoryEntity) {
        if(disks.getById(diskCategoryEntity.getDiskId()) == null){
            throw new IllegalArgumentException("Illegal disk ID, create this disk at first");
        }
    }

    @Override
    public void createDisk(Disk disk) {
        checkDiskType(disk);
        disks.add(disk);
    }

    @Override
    public List<Disk> getAllDisks() {
        return disks.getAll();
    }

    @Override
    public Disk getDiskById(int id) {
        return disks.getById(id);
    }

    @Override
    public void updateDisk(int id, Disk newDisk) {
        disks.update(id, newDisk);
    }

    @Override
    public void deleteDisk(int id) {
        disks.delete(id);
    }

    //

    @Override
    public void createCategory(Category category) {
        categories.add(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categories.getAll();
    }

    @Override
    public Category getCategoryById(int id) {
        return categories.getById(id);
    }

    @Override
    public void updateCategory(int id, Category newCategory) {
        categories.update(id, newCategory);
    }

    @Override
    public void deleteCategory(int id) {
        categories.delete(id);
    }

    //

    @Override
    public void createDiskType(DiskType diskType) {
        diskTypes.add(diskType);
    }

    @Override
    public List<DiskType> getAllDiskTypes() {
        return diskTypes.getAll();
    }

    @Override
    public DiskType getDiskTypeById(int id) {
        return diskTypes.getById(id);
    }

    @Override
    public void updateDiskType(int id, DiskType newDiskType) {
        diskTypes.update(id, newDiskType);
    }

    @Override
    public void deleteDiskType(int id) {
        diskTypes.delete(id);
    }

    //

    @Override
    public void createDiskCategoryEntity(DiskCategoryEntity diskCategoryEntity) {
        checkDiskId(diskCategoryEntity);
        checkDiskCategory(diskCategoryEntity);
        diskCategoryEntities.add(diskCategoryEntity);
    }

    @Override
    public List<DiskCategoryEntity> getAllDiskCategoryEntities() {
        return diskCategoryEntities.getAll();
    }

    @Override
    public DiskCategoryEntity getDiskCategoryEntityById(int id) {
        return diskCategoryEntities.getById(id);
    }

    @Override
    public void updateDiskCategoryEntity(int id, DiskCategoryEntity newDiskCategoryEntity) {
        diskCategoryEntities.update(id, newDiskCategoryEntity);
    }

    @Override
    public void deleteDiskCategoryEntity(int id) {
        diskCategoryEntities.delete(id);
    }
}
