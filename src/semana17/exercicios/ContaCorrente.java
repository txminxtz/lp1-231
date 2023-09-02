package semana17.exercicios;

import java.time.LocalDate;

public class ContaCorrente extends Conta {

    private double limite;

    public ContaCorrente(
        int numero, 
        LocalDate dataAbertura, 
        double saldo, 
        double tarifa, 
        Correntista correntista, 
        double limite) 
    {
        super(numero, dataAbertura, saldo, tarifa, correntista);
        this.limite = limite;
    }

    //sobrescrita do método da superclasse Conta 
    @Override
    public void sacar(double valor) {
        if(valor > limite) {
            throw new RuntimeException("Saque fora do limite");
        }

        super.sacar(valor);
    }

    @Override
    public double calcularTarifa() {
        return this.tarifa * 1.5;
    }

    @Override
    public void Dados(int tipo) {

        System.out.println() ;
        System.out.println("Conta Corrente: ");

        if (tipo == 1){
            System.out.println("Correntista: " + this.getCorrentista().getNome()) ;
        }

        System.out.println("Numero: " + this.getNumero()) ;
        System.out.println("Saldo: " + this.getSaldo()) ;
        System.out.println("Tarifa: " + this.calcularTarifa());
        
    }

}