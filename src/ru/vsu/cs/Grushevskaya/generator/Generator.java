package ru.vsu.cs.Grushevskaya.generator;

import ru.vsu.cs.Grushevskaya.base.Database;
import ru.vsu.cs.Grushevskaya.base.models.Category;
import ru.vsu.cs.Grushevskaya.base.models.Disk;
import ru.vsu.cs.Grushevskaya.base.models.DiskCategoryEntity;
import ru.vsu.cs.Grushevskaya.base.models.DiskType;

import java.util.Date;
import java.util.List;
import java.util.Random;

public class Generator {
    protected final Database db;
    protected final Random random;

    public Generator(Database db){
        this.db = db;
        random = new Random();
    }

    public void generate() {
        // categories 4
        String[] categories = {"games", "music", "films", "personal archive"};
        for (String str : categories) {
            db.createCategory(new Category(str));
        }
        // diskType 3
        String[] diskTypes = {"CD-R", "DVD", "mini-disc"};
        for (String str : diskTypes) {
            db.createDiskType(new DiskType(str));
        }
        // disks 240
        String[] names = {"Форсаж", "Семейные записи", "Иллюзия обмана", "Some game", "Анапа отдых лето", "Titanic", "Some film", "Выпускной 1999", "dirty Dance", "Кухня", "Winx", "Чародейки"};
        for (String str : names) {
            for (int i = 0; i < 20; i++) {
                String name = str + " " + i;
                int diskType = random.nextInt(diskTypes.length);
                int yearOfRelize = random.nextInt(50) + 1973;
                String description = "Some description for film " + name;
                db.createDisk(new Disk(name, diskType, yearOfRelize, description));
            }
        }
        // disk_categories_entity 240-720
        List<Category> categories_new = db.getAllCategories();
        for (Disk disks : db.getAllDisks()){
            for (int i = 0; i < random.nextInt(3) + 1; i++) {
                db.createDiskCategoryEntity(new DiskCategoryEntity(disks.getID(), random.nextInt(categories_new.size())));
            }
        }
    }
}
