package semana17.exercicios;

import java.time.LocalDate;

public class Teste_Correntista {
    public static void main(String[] args) {

        Correntista cor1, cor2;
        Empresa em1;
        ContaCorrente cc1;
        ContaPoupanca cp1;
        ContaSalario cs1, cs2;

        cor1 = new Correntista(1,"Joao Silva");
        cor2 = new Correntista(1,"Bruno Silva");

        em1 = new Empresa ("255.255.255.0","Empresa 1");

        cc1 = new ContaCorrente (
            1, 
            LocalDate.now(), 
            20.00, 
            2000.00, 
            cor1,
            1000.00
            );

        cp1 = new ContaPoupanca (
            2, 
            LocalDate.now(), 
            20.00, 
            2000.00, 
            cor1,
            LocalDate.now()    
            ); 

        cs1 = new ContaSalario 
            (3, 
            LocalDate.now(), 
            20.00, 
            2000.00, 
            cor1,
            em1);

        cs2 = new ContaSalario 
            (4, 
            LocalDate.now(), 
            30.00, 
            1000.00, 
            cor2,
            em1);   
            
        cor1.Dados();
        em1.Dados();

        System.out.println() ;
        System.out.println("TOTAL TARIFAS: ") ;
        System.out.println(cor1.calcularTarifas());

    }
}