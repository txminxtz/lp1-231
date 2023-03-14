package semana04;

public class EstruturasControle {
    public static void main(String[] args) {
        // if 

        final int MAIORIDADE = 18;
        var idade = 17;

        if (idade >= MAIORIDADE) {
            System.out.println("Maior de idade");
        }

        var ligado = true;
        if (ligado == true) {
            System.out.println("Está ligado");
        } else {
            System.out.println("Está Desligado");
            
        }

        // switch
        // literal String 
        // enoe

        int n = 3;

        switch (n) {
            case 1:
                System.out.println("Número 1");
                break;
            case 2:
                System.out.println("Número 2");
                break;
            case 3:
                System.out.println("Número 3");
                break;
            default:
                System.out.println("Não identificado");
                break;
        }

        // looping
        // for, foreach, while, do while

        int contador = 0;
        while (contador < 3) {
            System.out.println("While ligado");
            contador++;
        }

        contador = 4;
        do {
            System.out.println("Do while ligado");
        } while (contador < 3);

        // i = 0; 0 < 3: |
        // i = 2; 1 < 3: |
        // i = 3; 2 < 3: |
        // i = 0; 3 < 3:
                
        for (int i = 0; i < 3; i++) {
            System.out.println("For ligado");
        }

        String nome = "João";

        // Array
        // Armazena mais de um elemento 
        // Acesso via Index - numero inteiro 

        // nomes = (_____,_____,_____)
        //            0     1     2

        String[] nomes = new String[3];
        nomes[0] = "Maria";
        nomes[1] = "Marta";
        nomes[2] = "Marcia";

        for (int i = 0; i < 3; i++) {
            System.out.println(nomes[i]);
            
        }

        // foreach 
        for (String nome : nomes) {
            System.out.println(nome);
        }

        int[] numeros = { 1, 3, 5, 0};

        for (int numero : numeros) {
            System.out.println(numero);
        }

    }   
}
