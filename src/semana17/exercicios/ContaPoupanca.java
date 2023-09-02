package semana17.exercicios;

import java.time.LocalDate;

public class ContaPoupanca extends Conta {

    private LocalDate aniversario;

    public ContaPoupanca(
        int numero, 
        LocalDate dataAbertura, 
        double saldo, 
        double tarifa, 
        Correntista correntista, 
        LocalDate aniversario) 
    {
        super(numero, dataAbertura, saldo, tarifa, correntista); 
        this.aniversario = aniversario;
    }

    public LocalDate getAniversario() {
        return aniversario;
    }

    public void setAniversario(LocalDate aniversario) {
        this.aniversario = aniversario;
    }

    @Override
    public double calcularTarifa() {
        return this.tarifa;
    }

    @Override
    public void Dados(int tipo) {

        System.out.println() ;
        System.out.println("Conta Poupanca: ");

        if (tipo == 1){
            System.out.println("Correntista: " + this.getCorrentista().getNome()) ;
        }

        System.out.println("Numero: " + this.getNumero()) ;
        System.out.println("Saldo: " + this.getSaldo()) ;
        System.out.println("Tarifa: " + this.calcularTarifa());
    }

}