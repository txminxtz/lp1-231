package semana07;

public class ER_Principal  {

    public static void main(String[] args) {

        double[] numeros = { 10.0, 2.2, 3.0 };

        System.out.print("\n01) "+ER_Metodos.calcularSoma(10.0, 2.2, 3.0));
        System.out.print("\n06) "+ER_Metodos.calcularSoma(numeros));

        System.out.print("\n02) "+ER_Metodos.calcularMedia(10.0, 2.2, 3.0));
        System.out.print("\n07) "+ER_Metodos.calcularMedia(numeros));

        System.out.print("\n03) "+ER_Metodos.encontrarMaior(10, 2, 3));
        System.out.print("\n08) "+ER_Metodos.encontrarMaior(numeros));

        System.out.print("\n04) "+ER_Metodos.encontrarMenor(10, 2, 3));
        System.out.print("\n09) "+ER_Metodos.encontrarMenor(numeros));

        System.out.print("\n05) ");

        double[] arrayCriado = ER_Metodos.criarArray(10.0, 2.2, 3.0);
        
        for (double numero : arrayCriado) {
            System.out.print(numero + ", ");
        }

        System.out.print("\n10) ");

        int[] inteiros1 = {3, 10};
        int[] inteiros2 = {15, 20, 33};

        int[] novoArray = ER_Metodos.juntarArrays(inteiros1, inteiros2);
        for (int i : novoArray) {
            System.out.print(i + ", ");
        }
    }



}
