package semana22.exercicios;

//import java.time.LocalDateTime;

//import java.util.List;
//import java.util.ArrayList;

public class Main 
{
    
    public static void main(String[] args) {

        Dados dados = new Dados();
        int i;

        ////////////
        /////// LISTA DE INVESTIDORES

        Lista l_Alunos = dados.getAlunos();
        Aluno aluno;

        i = 0;

        aluno = new Aluno(
            String.format("%03d", ++i),
            "Bruno Taminato",
            "bruno.taminato@gmail.com");
    
        l_Alunos.inserirPilhaCrescente(aluno, aluno.getCod());

        aluno = new Aluno(
            String.format("%03d", ++i),
            "Caio Bertaglia",
            "caio.bertaglia@gmail.com");
        l_Alunos.inserirPilhaCrescente(aluno, aluno.getCod());

        aluno = new Aluno(
            String.format("%03d", ++i),
            "Maria Eduarda",
            "madu@gmail.com");
        l_Alunos.inserirPilhaCrescente(aluno, aluno.getCod());
  
        ////////////
        /////// MENU

        new Menu(dados);

    }    

}

