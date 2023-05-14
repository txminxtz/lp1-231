package semana06.exercicios;

import java.util.Scanner;

public class ex01 {
    

    public static void main(String[] args) {
    
        float 
            fComprimento,
            fLargura,
            fAltura,
            fVolume, 
            fPotencia,
            fFiltragem_Min,
            fFiltragem_Max,
            fTemp_Ambiente,
            fTemp_Desejada;

        Scanner sc = new Scanner(System.in);

        System.out.println("Insira as seguintes informações a respeito do seu aquário");

        System.out.println("Comprimento do aquário (cm): ");
        fComprimento = sc.nextFloat();
        System.out.println("Largura do aquário (cm): ");
        fLargura = sc.nextFloat();
        System.out.println("Altura do aquário (cm): ");
        fAltura = sc.nextFloat();
        System.out.println("Insira a temperatura ambiente: ");
        fTemp_Ambiente = sc.nextFloat();
        System.out.println("Insira a temperatura desejada:");
        fTemp_Desejada = sc.nextFloat();


        fVolume = ex01_metodos.fCalculo_Volume(fComprimento, fLargura, fAltura);
        fPotencia = ex01_metodos.fCalculo_Potencia(fVolume, fTemp_Desejada, fTemp_Ambiente);
        fFiltragem_Min = ex01_metodos.fCalculo_Filtragem(fVolume, 2);
        fFiltragem_Max = ex01_metodos.fCalculo_Filtragem(fVolume, 3);

        System.out.println("Comprimento (cm): " + fComprimento);
        System.out.println("Largura (cm): " +fLargura);
        System.out.println("Altura (cm): " + fAltura);
        System.out.println("Temperatura ambiente (C): " + fTemp_Ambiente);
        System.out.println("Temperatura desejada (C): " + fTemp_Desejada);
        System.out.println("Volume (l): " + fVolume);     
        System.out.println("Potência (w): " + fPotencia);  
        System.out.println("Filtragem mínima (l/h): " + fFiltragem_Min);
        System.out.println("Filtragem máxima (l/h): " + fFiltragem_Max);
    
        sc.close();

    }
}