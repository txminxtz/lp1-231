package avaliacao01;

//import java.util.Scanner;
import java.util.Random;

public class Av1_Principal  {

    public static void main(String[] args) {

        //Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int[] vet_iNumeros = {9, 10, 11, 3, 2};
        double[] vet_dNumeros = {3.0, 10.0, 8.0, 3.0, 2.0};
        double[] vet_dNotas = new double[3];

        int i, iCont;
        int iPosicao;
        double dMedia, dSoma, dNumero;
        String sNome; 

        iPosicao = Av1_Metodos.buscaPosicao(vet_iNumeros, 11);
  
        System.out.println("buscaPosicao = " +iPosicao);

        iCont = Av1_Metodos.quantidadeNumerosIguais(vet_iNumeros, 11);
        System.out.println("quantidadeNumerosIguais: " +iCont);

        dNumero = 4.0;

        dMedia = Av1_Metodos.mediaMaioresIgualQueNumero(vet_dNumeros, dNumero);
        System.out.println("mediaMaioresIgualQueNumero "+ dNumero + " = "+dMedia);

        dSoma = Av1_Metodos.somaMaioresQueNumero(vet_dNumeros, dNumero);
        System.out.println("somaMaioresQueNumero " +dNumero + " = "+dSoma);

        System.out.print("Insira o nome do aluno: ");
        //sNome = sc.next();
        sNome = "Bruno";

        System.out.println("Nome: " +sNome);

        for (i = 0; i <= 2; i++) {
            System.out.println("Insira a nota " +(i+1) + ": "); 
            //vet_dNotas[i] = sc.nextDouble();
            vet_dNotas[i] = random.nextDouble() *10;
        }

        for (i = 0; i <= 2; i++) {
            System.out.println(
                "Nota " +
                (i+1) + 
                ": " +
                String.format("%.2f",vet_dNotas[i])
            ); 
        }
        
        dMedia = Av1_Metodos.mediaMaioresIgualQueNumero(vet_dNotas, 0);

        System.out.println("Media = " +String.format("%.2f",dMedia));

        if (dMedia >= 6){
            System.out.println("Aprovado");
        }
        else {
            System.out.println("Reprovado");
        }

        //sc.close(); 

    }
}
