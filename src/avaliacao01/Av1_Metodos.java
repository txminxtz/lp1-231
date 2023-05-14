package avaliacao01;

public class Av1_Metodos {

    public static int buscaPosicao(int[] array, int iNumero) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == iNumero) {
                return i;
            }
        }
        return -1;
    }

    public static int quantidadeNumerosIguais(int[] array, int numero) {
        int iContador = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == numero) {
                iContador++;
            }
        }
        return iContador;
    }

    public static double mediaMaioresIgualQueNumero(double[] vet_dArray, double dNumero){
        
        double dSoma = 0;
        int iContador = 0;

        for (int i = 0; i < vet_dArray.length; i++) {
            if (vet_dArray[i] >= dNumero) {
            dSoma += vet_dArray[i];
            iContador++;
            }
        }
        if (iContador == 0){
            return 0;
        }
        return dSoma/iContador;
    }

    public static double somaMaioresQueNumero(double[] vet_dArray, double dNumero){
        
        double dSoma = 0;

        for (int i = 0; i < vet_dArray.length; i++) {
            if (vet_dArray[i] > dNumero) {
                dSoma += vet_dArray[i];
            }
        }
        return dSoma;
    }


}
