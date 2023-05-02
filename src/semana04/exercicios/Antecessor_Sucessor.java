package semana04.exercicios;

import java.util.Scanner;

public class Antecessor_Sucessor {

    public static void  main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        System.out.println("Insira um numero:");
        int numDado = entrada.nextInt();
        System.out.println("O numero inserido é "+numDado);
        System.out.println("O seu sucessor é "+(+numDado+1));
        System.out.println("O seu antecessor é "+(+numDado-1));

        entrada.close();
        
    } 
    

}
