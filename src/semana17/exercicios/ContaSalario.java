package semana17.exercicios;

import java.time.LocalDate;

public class ContaSalario extends Conta{

    private Empresa empresa;

    public ContaSalario(
        int numero, 
        LocalDate dataAbertura, 
        double saldo, 
        double tarifa, 
        Correntista correntista, 
        Empresa empresa) 
    {
        super(numero, dataAbertura, saldo, tarifa, correntista);
        this.empresa = empresa;
        empresa.addConta(this);
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public double calcularTarifa() {
        return 0;
    }

    @Override
    public void Dados(int tipo) {

        System.out.println();
        System.out.println("Conta Salario: ");

        if (tipo == 1){
            System.out.println("Correntista: " + this.getCorrentista().getNome()) ;
        }

        System.out.println("Numero: " + this.getNumero()) ;
        System.out.println("Saldo: " + this.getSaldo()) ;
        System.out.println("Tarifa: " + this.calcularTarifa());

    }

}