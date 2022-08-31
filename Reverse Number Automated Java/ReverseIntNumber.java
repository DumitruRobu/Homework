package com.Application;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner Nume_Scaner = new Scanner(System.in);
        System.out.println("Enter desired int number: ");

        int var1 = Nume_Scaner.nextInt();
        int[] c = new int[10];
        int temp=1;

        int var1copy=var1;
        int contor = 0;

        while (temp != 0)
        {
            temp = var1%10;
            var1=var1/10;
            c[contor]=temp;
            contor++;
        }

        System.out.println("Numarul introdus este: "+var1copy);
        System.out.println("Numarul inversat este: ");

        for (int i=0; i<contor-1; i++)
        {
            System.out.println(c[i]);
        }
    }
}