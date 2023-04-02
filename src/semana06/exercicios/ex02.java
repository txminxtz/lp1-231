package semana06.exercicios;

import java.util.Scanner;

public class ex02 {
    public static void main(String[] args) {

        float
            fMassa,
            fAltura,
            fIMC,
            fExcesso;

        String
            sMsg;

        Scanner sc = new Scanner(System.in);

        System.out.println("Peso (kg):");
        fMassa = sc.nextFloat();
        System.out.println("Altura (m):");
        fAltura = sc.nextFloat();

        fIMC = ex02_metodos.fCalculo_IMC(fMassa, fAltura);

        sMsg = ex02_metodos.fFunc_Mensagem(fIMC);

        fExcesso = ex02_metodos.fExcesso_IMC(fMassa, fAltura);

        System.out.println("Massa (kg): " + fMassa);
        System.out.println("Altura (m): " + fAltura);
        System.out.println("IMC: " + fIMC);
        System.out.println("Classificacao: " + sMsg);
        
        if (fExcesso > 0 ) {
            System.out.println("Voce precisa perder: " + fExcesso + " Kg.");
        }

        if (fExcesso < 0) {
            System.out.println("Voce precisa ganhar: " + (- fExcesso) + " Kg.");
        }

        sc.close();
    }

}