package ru.vsu.cs.Grushevskaya.base;

import ru.vsu.cs.Grushevskaya.base.models.Category;
import ru.vsu.cs.Grushevskaya.base.models.Disk;
import ru.vsu.cs.Grushevskaya.base.models.DiskCategoryEntity;
import ru.vsu.cs.Grushevskaya.base.models.DiskType;

import java.util.List;

public interface Database {
    // Для объектов типа Disk
    void createDisk(Disk disk);
    List<Disk> getAllDisks();
    Disk getDiskById(int id);
    void updateDisk(int id, Disk newDisk);
    void deleteDisk(int id);

    // Для объектов типа Category
    void createCategory(Category category);
    List<Category> getAllCategories();
    Category getCategoryById(int id);
    void updateCategory(int id, Category newCategory);
    void deleteCategory(int id);

    // Для объектов типа DiskType
    void createDiskType(DiskType diskType);
    List<DiskType> getAllDiskTypes();
    DiskType getDiskTypeById(int id);
    void updateDiskType(int id, DiskType newDiskType);
    void deleteDiskType(int id);

    // Для объектов типа DiskCategoryEntity
    void createDiskCategoryEntity(DiskCategoryEntity diskCategory);
    List<DiskCategoryEntity> getAllDiskCategoryEntities();
    DiskCategoryEntity getDiskCategoryEntityById(int id);
    void updateDiskCategoryEntity(int id, DiskCategoryEntity newDiskCategoryEntity);
    void deleteDiskCategoryEntity(int id);
}
