package OOPessoa;

public class PF extends Pessoa {
  
    //private String nome;
    private int idade;
    private double altura; 
      
    // construtor vazio
    public PF() {
        //this.nome = "";
        super();
        this.idade = 0;
        this.altura = 0.0;        
    }

    // construtor cheio 
    public PF(String nome, int idade, double altura) {
        //this.nome = nome;
        super(nome);
        this.idade = idade;
        this.altura = altura;
    }
     
    public int getIdade() {
        return idade;
    }
    
    public double getAltura() {
        return altura;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
     
    public void setAltura(double altura) {
        this.altura = altura;
    }

    // método que imprime todos os dados da pessoa
    public void imprimirDados(){
        super.imprimirDados();
        System.out.print(
        "\nIdade: " +  this.idade + 
        "\nAltura: " +  this.altura);
    }

}
