package ru.vsu.cs.Grushevskaya.console;

import ru.vsu.cs.Grushevskaya.base.models.Category;

import java.util.Scanner;

public class AddCategory extends ConsoleScanner{
    public AddCategory(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void process() {
        System.out.println("Input name of category");
        db.createCategory(new Category(scanner.nextLine()));
        System.out.println("success");
    }

    @Override
    public String getName() {
        return "Add new category";
    }
}
