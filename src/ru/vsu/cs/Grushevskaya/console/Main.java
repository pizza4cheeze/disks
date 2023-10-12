package ru.vsu.cs.Grushevskaya.console;

import ru.vsu.cs.Grushevskaya.base.Database;
import ru.vsu.cs.Grushevskaya.base.DatabaseMemory;
import ru.vsu.cs.Grushevskaya.generator.Generator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Database database = DatabaseMemory.getExample();
        Generator generator = new Generator(database);
        generator.generate();

        Scanner scanner = new Scanner(System.in);
        ConsoleScanner[] commands = new ConsoleScanner[]{
                new AddDisk(scanner),
                new AddDiskType(scanner),
                new AddCategory(scanner),
                new PrintBase(scanner),
        };

        // commands[commands.length-1].process();

        while (true) {
            for (int i = 0; i < commands.length; i++) {
                ConsoleScanner c = commands[i];
                System.out.print(i);
                System.out.print(") ");
                System.out.println(c.getName());
            }
            System.out.println("Choose number:");
            int num = scanner.nextInt();
            if (num < 0) break;
            if (num >= commands.length) {
                System.out.println("illegal num");
                continue;
            }

            try {
                commands[num].process();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            System.out.println();
        }
    }
}
