package OOPessoa;

//import java.nio.BufferUnderflowException;
import java.util.Scanner;

public class PJ_Principal {
    
    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {       

        String nome; // nome da empresa
        String CNPJ; // nome da pessoa
        String IE;     
        
        PJ p;

        nome = "Silva & Taminato";
        CNPJ = "35.074.956/0001-12";
        IE = "427.266.758-08";
        
        p = new PJ(nome, CNPJ, IE);

        p.imprimirDados();

        nome = "Taminato";
        CNPJ = "36.022.344/0001-38";
        IE = "003.263.877-90";
        
        p.setNome("Taminato");
        p.setIE("36.022.344/0001-38");
        p.setCNPJ("003.263.877-90");

        p.imprimirDados();      

    }

}