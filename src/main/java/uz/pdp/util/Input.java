package uz.pdp.util;

import java.util.Scanner;

public interface Input {
    static int inputInt(String msg){
        System.out.print(msg+": ");
        return new Scanner(System.in).nextInt();
    }
}
