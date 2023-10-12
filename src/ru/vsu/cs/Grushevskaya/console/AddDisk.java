package ru.vsu.cs.Grushevskaya.console;

import ru.vsu.cs.Grushevskaya.base.models.Disk;
import ru.vsu.cs.Grushevskaya.base.models.DiskType;

import java.util.Scanner;

public class AddDisk extends  ConsoleScanner {
    public AddDisk(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void process() {
        System.out.println("input disk name");
        String name = scanner.nextLine();
        System.out.println("input disk type id");
        System.out.println("Types of disks:");
        for (DiskType type : db.getAllDiskTypes()) {
            System.out.println("id: " + type.getID() + " name: " + type.getName() + "\n");
        }
        int diskTypeId = scanner.nextInt();
        System.out.println("input year of release");
        int year = scanner.nextInt();
        System.out.println("input description");
        String desc = scanner.nextLine();
        db.createDisk(new Disk(name, diskTypeId, year, desc));
        System.out.println("success");
    }

    @Override
    public String getName() {
        return "Add new disk to collection";
    }
}
