package semana22.exercicios;

//import java.util.Scanner;

public class Aluno extends Elemento {

    //private String cod;
    private String nome;
    private String email;    
   
    public Aluno(String cod, String nome, String email) {

        super("Aluno", cod);         

        this.nome = nome;
        this.email = email;

    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String name) {
        this.nome = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override 
    public void mostraDados(int iTab){ 

        int i;

        //System.out.println();
 
        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Cod: " + this.getCod());
 
        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Nome: " + this.nome);
 
        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Email: " + this.email);

    }

}


