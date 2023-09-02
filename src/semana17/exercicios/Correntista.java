package semana17.exercicios;

import java.util.ArrayList;
import java.util.List;

public class Correntista {
    
    private int codigo;
    private String nome;
    private List <Conta> contas;

     public Correntista(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
        this.contas = new ArrayList <Conta> ();
    }

     public Correntista(int codigo, String nome, List <Conta> contas) {
        this.codigo = codigo;
        this.nome = nome;
        this.contas = contas;
    }

    public void addConta(Conta conta){
        this.contas.add(conta);
    }
    
    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Conta> getContas(){
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }
    public double calcularTarifas(){
        double totalTarifas = 0;
        for (Conta conta : contas){
            totalTarifas += conta.calcularTarifa();
        }
        return totalTarifas;
    }
    public void Dados() {

        System.out.println() ;

        System.out.println("CORRENTISTA: ") ;
        System.out.println("Código: " + this.getCodigo()) ;
        System.out.println("Nome: " + this.getNome()) ;
        
        System.out.println("Contas:");
        for (Conta conta : contas){
            conta.Dados(0);
        }

    }
}