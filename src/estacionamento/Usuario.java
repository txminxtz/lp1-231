package estacionamento;

class Usuario{

    private String login;
    private String nome;
    private String cargo;
    private String email;
    private String telefone;
    private String senha;

    public Usuario(){}

    public Usuario (
        String login, 
        String nome, 
        String cargo, 
        String email, 
        String telefone, 
        String senha) 
    {

        this.login = login;
        this.nome = nome;
        this.cargo = cargo;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;

    }

    public void setLogin(String login) {
        this.login = login;
    }
    public String getLogin () {
        return this.login;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome () {
        return this.nome;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public String getCargo () {
        return this.cargo;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail () {
        return this.email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getTelefone () {
        return this.telefone;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getSenha () {
        return this.senha;
    }
    
    public void exibeDados(int iTab){ 

        int i;

        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Login: " + login);
 
        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Nome: " + nome);
 
        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Cargo: " + cargo);

        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Email: " + email);

        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Telefone: " + telefone);

        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Senha: " + senha);
    }
 

}