package semana04.exercicios;

import java.util.Scanner;

public class Media{
// Media

    public static void main(String[] args)
    {
       
        int num1;
        int num2;
        int num3;
        int soma;
        float media;
        Scanner entrada;
       
        entrada = new Scanner(System.in); 
        
        System.out.println("Digite o primeiro nota:");
        num1 = entrada.nextInt();
       
        System.out.println("Digite a segunda nota:");
        num2 = entrada.nextInt();
       
        System.out.println("Digite a terceira nota:");
        num3 = entrada.nextInt();
       
        soma = (num1 + num2 + num3);
        media = soma/3;
       
        System.out.println("Os numeros informados sao " + num1 + ", " + num2 + ", " + num3);
        System.out.println("A soma dos numeros eh " + soma);
        System.out.println("A media dos numeros eh " + media);

        entrada.close();
    }
    
}