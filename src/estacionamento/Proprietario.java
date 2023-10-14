package estacionamento;

class Proprietario{

    private int cod;
    private String nome;
    private String email;
    private String telefone;

    public Proprietario(){}

    public Proprietario (
        int cod, 
        String nome, 
        String email, 
        String telefone) 
    {

        this.cod = cod;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;

    }

    public int getCod () {
        return this.cod;
    }
    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome () {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail () {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone () {
        return this.telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void exibeDados(int iTab){ 

        int i;

        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Codigo: " + cod);
 
        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Nome: " + nome);
 
        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Email: " + email);

        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Telefone: " + telefone);

    }


}