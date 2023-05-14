package OOPessoa;

public class PJ extends Pessoa {
  
    //private String nome;
    private String CNPJ;
    private String IE; 
      
    // construtor vazio
    public PJ() {
        super();
        this.CNPJ = "";
        this.IE = "";        
    }

    // construtor cheio 
    public PJ(String nome, String CNPJ, String IE) {
        super(nome);
        this.CNPJ = CNPJ;
        this.IE = IE;
    }

    public String getCNPJ() {
        return CNPJ;
    }
    
    public String getIE() {
        return IE;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }
     
    public void setIE(String IE) {
        this.IE = IE;
    }

    // método que imprime todos os dados da pessoa
    public void imprimirDados(){
        super.imprimirDados();
        System.out.print(
        "\nCNPJ: " +  this.CNPJ + 
        "\nIE: " +  this.IE);
    }

}
