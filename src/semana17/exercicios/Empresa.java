package semana17.exercicios;

import java.util.ArrayList;
import java.util.List;

public class Empresa {

        private String cnpj;
        private String nome;
        private List <ContaSalario> contasSalario;

        public Empresa(String cnpj, String nome) {
            this.cnpj = cnpj;
            this.nome = nome;
            this.contasSalario = new ArrayList <ContaSalario> ();
        }

        //getters e setters para a classe: 
    
        public void addConta(ContaSalario contasSalario){
            this.contasSalario.add(contasSalario);
        }

        public String getCnpj() {
            return cnpj;
        }
    
        public void setCnpj(String cnpj) {
            this.cnpj = cnpj;
        }
    
        public String getNome() {
            return nome;
        }
    
        public void setNome(String nome) {
            this.nome = nome;
        }

        public void Dados() {
            System.out.println() ;
            System.out.println("EMPRESA: ") ;
            System.out.println("Cnpj: " + this.getCnpj()) ;
            System.out.println("Nome: " + this.getNome()) ;
            
            System.out.println();
            System.out.println("Contas da Empresa:");

            for (ContaSalario contaSalario : contasSalario){
                contaSalario.Dados(1);
            }
    

        }
}