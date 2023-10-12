package ru.vsu.cs.Grushevskaya.console;

import ru.vsu.cs.Grushevskaya.base.Database;
import ru.vsu.cs.Grushevskaya.base.DatabaseMemory;

import java.util.Scanner;

public abstract class ConsoleScanner {
    public final Scanner scanner;
    protected final Database db = DatabaseMemory.getExample();

    public ConsoleScanner(Scanner scanner){
        this.scanner = scanner;
    }

    public abstract void process();

    public abstract String getName();
}
