package semana04.exercicios;
import java.util.Scanner;

public class ValidaID_Main {

    public static void main(String[] args) throws Exception {

        Scanner ler = new Scanner(System.in);
    
        String ID;
    
        System.out.printf("Informe o ID: ");
        ID = ler.next();
    
        System.out.printf("\nResultado: ");
            // usando os metodos isID() da classe "ValidaID"
        if (ValidaID.isValidID(ID) == true)
            System.out.printf("ID Valido !!!\n");
        else System.out.printf("Erro, ID invalido !!!\n");
 
        ler.close();

    }
}
    

