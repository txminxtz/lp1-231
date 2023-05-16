package OOPessoa;

public class Pessoa {
  
    private String nome;
    //private int idade;
    //private double altura; 
      
    // construtor vazio
    public Pessoa() {
        this.nome = "";   
    }

    // construtor cheio 
    public Pessoa(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
     
    public void setNome(String nome) {
        this.nome = nome;
    }

    // método que imprime todos os dados da pessoa
    public void imprimirDados(){
        System.out.print("\nNome: " +  this.nome );
    }
    

}
