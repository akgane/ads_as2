import Utils.Console.ConsoleHandler;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MyApplication {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ConsoleHandler.chooseDataStructure(reader);
    }
}
