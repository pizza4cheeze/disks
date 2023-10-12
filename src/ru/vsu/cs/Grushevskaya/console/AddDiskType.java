package ru.vsu.cs.Grushevskaya.console;

import ru.vsu.cs.Grushevskaya.base.models.DiskType;

import java.util.Scanner;

public class AddDiskType extends ConsoleScanner {

    public AddDiskType(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void process() {
        System.out.println("Input new type");
        db.createDiskType(new DiskType(scanner.nextLine()));
        System.out.println("success");

    }

    @Override
    public String getName() {
        return "Add new disk type";
    }
}
