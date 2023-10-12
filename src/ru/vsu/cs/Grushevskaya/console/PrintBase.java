package ru.vsu.cs.Grushevskaya.console;

import ru.vsu.cs.Grushevskaya.base.models.Category;
import ru.vsu.cs.Grushevskaya.base.models.Disk;
import ru.vsu.cs.Grushevskaya.base.models.DiskCategoryEntity;
import ru.vsu.cs.Grushevskaya.base.models.DiskType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class PrintBase extends ConsoleScanner {

    public PrintBase(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void process() {
        List<Disk> disks = db.getAllDisks();
        List<Category> categories = db.getAllCategories();
        List<DiskType> diskTypes = db.getAllDiskTypes();
        List<DiskCategoryEntity> diskCategoryEntities = db.getAllDiskCategoryEntities();

        System.out.println("Disks collection:");
        for (Disk disk : disks) {
            System.out.println("id: " + disk.getID() + " content: " + disk.getName() + " year of release: " + disk.getYearOfRelease() +
                    "\ndescription: " + disk.getDescription() + " content categories: " + getCategoriesByDiskId(disk.getID()) +
                    "\ndisk type: " + getTypeByDiskId(disk) + "\n");
        }

        System.out.println("Types of disks:");
        for (DiskType type : diskTypes) {
            System.out.println("id: " + type.getID() + " name: " + type.getName() + "\n");
        }

        System.out.println("Categories of content:");
        for (Category category : categories) {
            System.out.println("id: " + category.getID() + " name: " + category.getName() + "\n");
        }

    }

    public List<String> getCategoriesByDiskId(int diskId) {
        ArrayList<DiskCategoryEntity> temp = new ArrayList<>();
        ArrayList<String> categories = new ArrayList<>();
        for (DiskCategoryEntity dce : db.getAllDiskCategoryEntities()) {
            if (dce.getDiskId() == diskId) {
                temp.add(dce);
            }
        }
        for (Category category : db.getAllCategories()) {
            for (DiskCategoryEntity dce : temp) {
                if (category.getID() == dce.getCategoryId()) {
                    categories.add(category.getName());
                }
            }
        }
        return categories;
    }

    public String getTypeByDiskId(Disk disk) {
        for (DiskType type : db.getAllDiskTypes()) {
            if (type.getID() == disk.getDiskTypeId()) {
                return type.getName().toString();
            }
        }
        return null;
    }

    public Disk getDiskByName(String name) {
        for (Disk disk : db.getAllDisks()) {
            if (Objects.equals(disk.getName(), name)) {
                return disk;
            }
        }
        return null;
    }

    @Override
    public String getName() {
        return "Print base";
    }
}
