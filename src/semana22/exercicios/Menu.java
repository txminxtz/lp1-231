package semana22.exercicios;

//import java.time.LocalDateTime;
//import java.util.List;
import java.util.Scanner;
//import java.util.ArrayList;

public class Menu 
{

    private Scanner l;

     //public Menu(Lista l_Corretoras, Lista l_Investidores, Lista l_Ativos, Lista l_Investimentos)
     public Menu(Dados dados)
    {

        String sAux;
        boolean bMenu = true;

        l = new Scanner(System.in);

        System.out.println("Sistema Academico");

        while (bMenu) {

            sAux = opcaoMenu_Principal();

            if (sAux.equalsIgnoreCase("0")) {
                bMenu = false;
            } 
            else if (sAux.equalsIgnoreCase("1")){
                //Menu_Cadastros(l_Corretoras, l_Investidores, l_Ativos, l_Investimentos);
                Menu_Inclusao(dados);
            }
            else if (sAux.equalsIgnoreCase("2")){
                //Menu_Cadastros(l_Corretoras, l_Investidores, l_Ativos, l_Investimentos);
                Menu_Edicao(dados);
            } 
            else if (sAux.equalsIgnoreCase("3")){
                //Menu_Cadastros(l_Corretoras, l_Investidores, l_Ativos, l_Investimentos);
                Menu_Exclusao(dados);
            } 
            else if (sAux.equalsIgnoreCase("4")) {
                //Menu_Relatorios(l_Corretoras, l_Investidores, l_Ativos, l_Investimentos);
                Menu_Relatorios(dados);
            }
            else {
                System.out.println("\nOpcao Invalida!");
            }
        }
    }

    ////////////
    /////// MENUS

    private String opcaoMenu_Principal() {

        System.out.println("========= MENU PRINCIPAL ==========");
        System.out.println();
        System.out.println("Selecione uma opcao:");
        System.out.println();
        System.out.println("1 - Inclusao");
        System.out.println("2 - Ediccao");
        System.out.println("3 - Exclusao");
        System.out.println("4 - Relatorios");
        System.out.println("0 - Sair");
        
        return l.nextLine();

    }

    private String opcaoMenu_Inclusao() {

        System.out.println();
        System.out.println("========= INCLUSAO ==========");
        System.out.println();
        System.out.println("Selecione uma opcao:");
        System.out.println();
        System.out.println("1 - Alunos");
        System.out.println("0 - Voltar");

        return l.nextLine();

    }

    private String opcaoMenu_Edicao() {

        System.out.println();
        System.out.println("========= EDICAO ==========");
        System.out.println();
        System.out.println("Selecione uma opcao:");
        System.out.println();
        System.out.println("1 - Alunos");
        System.out.println("0 - Voltar");

        return l.nextLine();

    }

    private String opcaoMenu_Exclusao() {

        System.out.println();
        System.out.println("========= EXCLUSAO ==========");
        System.out.println();
        System.out.println("Selecione uma opcao:");
        System.out.println();
        System.out.println("1 - Alunos");
        System.out.println("0 - Voltar");

        return l.nextLine();

    }

    private String opcaoMenu_Relatorios() {

        System.out.println();
        System.out.println("========= RELATORIOS ==========");
        System.out.println();
        System.out.println("Selecione uma opcao:");
        System.out.println();
        System.out.println("1 - Aluno");
        System.out.println("2 - Alunos");
        System.out.println("0 - Voltar");

        return l.nextLine();

    }

    ////////////
    /////// INCLUSAO

    public void Menu_Inclusao(Dados dados)
    {

        String sAux;
        boolean bMenu = true;

        l = new Scanner(System.in);

        while (bMenu) {

            sAux = opcaoMenu_Inclusao();

            if (sAux.equalsIgnoreCase("0")) {
                bMenu = false;
            } 
            // CADASTRO DE ALUNOS
            else if (sAux.equalsIgnoreCase("1")) {
                this.dadosInput_Aluno(dados, l);

            } 
            else {
                System.out.println("\nOpcao Invalida!");
            }
        }

    }

    //////////////
    //////// EDICAO

    public void Menu_Edicao(Dados dados)
    {

        String sAux;
        boolean bMenu = true;

        l = new Scanner(System.in);

        while (bMenu) {

            sAux = opcaoMenu_Edicao();

            if (sAux.equalsIgnoreCase("0")) {
                bMenu = false;
            } 
            // EDICAO DE ALUNOS
            else if (sAux.equalsIgnoreCase("1")) {
                this.alteraAluno(dados, l);

            } 
            else {
                System.out.println("\nOpcao Invalida!");
            }
        }

    }


    ////////////
    /////// EXCLUSAO
    public void Menu_Exclusao(Dados dados)
    {

        String sAux;
        boolean bMenu = true;

        l = new Scanner(System.in);

        while (bMenu) {

            sAux = opcaoMenu_Exclusao();

            if (sAux.equalsIgnoreCase("0")) {
                bMenu = false;
            } 
            // EXCLUSAO DE ALUNOS
            else if (sAux.equalsIgnoreCase("1")) {
                this.excluiAluno(dados, l);

            } 
            else {
                System.out.println("\nOpcao Invalida!");
            }
        }

    }


    ////////////
    /////// RELATORIOS

    public void Menu_Relatorios(Dados dados)
    {

        String sAux;
        boolean bMenu = true;

        l = new Scanner(System.in);

        while (bMenu) {

            sAux = opcaoMenu_Relatorios();

            if (sAux.equalsIgnoreCase("0")) {
                bMenu = false;
            } 
            // PESQUISA DE ALUNO
            else if (sAux.equalsIgnoreCase("1")) {
                this.BuscarAlunoPorId(dados, l);
            }
            // RELATORIO DE ALUNOS
            else if (sAux.equalsIgnoreCase("2")) {
                sAux = "Alunos";
                System.out.println("\nLISTA DE " + sAux + ":");
                dados.getAlunos().exibeComponentes(0);
            } 
            else {
                System.out.println("\nOpcao Invalida!");
            }
        }
    }

    ////////////
    /////// ENTRADA DE DADOS

    // INCLUSAO DE ALUNOS
    public boolean dadosInput_Aluno(Dados dados, Scanner l){ 

        Aluno aluno;

        String sCod, sNome, sEmail;;
        String sAux; 

        System.out.println("Cadastro de Alunos");
        System.out.println();

        int iAux = dados.getAlunos().getQt();
        iAux++;

        sCod = String.format("%03d", iAux);

        System.out.println("Codigo: "+sCod);

        //sCod = textInput("Cod: ",l);

        sNome = textInput("Nome: ",l);
        sEmail = textInput("Email: ",l);

        sAux = textInput("Adicionar Aluno (S/N) ? ",l);

        if  (sAux.equalsIgnoreCase("s")==false){
            return false;
        }


        aluno = new Aluno(sCod, sNome, sEmail);
 
        dados.getAlunos().inserirPilhaCrescente(aluno, aluno.getCod());

        return true;

    }

    // PESQUISA DE ALUNO
    public boolean BuscarAlunoPorId(Dados dados, Scanner l){ 

        //String sCod, sNome, sEmail;;
        //String sAux; 

        System.out.println("Pesquisa Aluno");
        System.out.println();

        //int iAux = dados.getAlunos().getQt();
        //iAux++;

        No no;

        no = this.Quero_Elemento(
            dados.getAlunos(), 
            "Aluno: ",  
            l);

        if (no==null) return false;

        Aluno aluno;

        aluno = (Aluno)no.getElemento();

        aluno.mostraDados(0);

        return true;

    }


    // ALTERACAO DE DADOS
    public boolean alteraAluno (Dados dados, Scanner l){ 

        Aluno aluno;
        No no;

        String sNome, sEmail;
        String sAux; 

        System.out.println("Edicao de Alunos");
        System.out.println();

        no = this.Quero_Elemento(
            dados.getAlunos(), 
            "Aluno: ",  
            l);

        if (no==null) return false;

        aluno = (Aluno)no.getElemento();

        aluno.mostraDados(0);

        sNome = textInput("Nome: ",l);
        sEmail = textInput("Email: ",l);

        sAux = textInput("Confirma Edicao (S/N) ? ",l);

        if  (sAux.equalsIgnoreCase("s")==false){
            return false;
        }

        aluno.setNome(sNome);
        aluno.setEmail(sEmail);

        return true;

    }

    // EXCLUSAO DE ALUNO
    public boolean excluiAluno (Dados dados, Scanner l){ 

        Aluno aluno;
        No no;

        //String sNome, sEmail;
        String sAux; 

        System.out.println("Exclusao de Alunos");
        System.out.println();

        no = this.Quero_Elemento(
            dados.getAlunos(), 
            "Aluno: ",  
            l);

        if (no==null) return false;

        aluno = (Aluno)no.getElemento();

        aluno.mostraDados(0);

        //sNome = textInput("Nome: ",l);
        //sEmail = textInput("Email: ",l);

        sAux = textInput("Confirma Exclusao (S/N) ? ",l);

        if  (sAux.equalsIgnoreCase("s")==false){
            return false;
        }

	dados.getAlunos().removeNo(no);

        return true;

    }



    ////////////
    /////// FUNÇÕES AUXILIARES

    /* 
    private String NaoQuero_Elemento(Lista lista, String sLabel, Scanner l){ 

        No no; 

        String sAux="S", sCod;

        while (sAux.equalsIgnoreCase("s")) {

            sCod = textInput(sLabel,l);

            no =  lista.procuraNo(sCod, "<>");
            
            if (no == null) return sCod;

            sAux = this.textInput("Codigo Invalido. Deseja Continuar (S/N) ? ", l);

        }

        return "";

    }

    */

    private No Quero_Elemento(Lista lista, String sLabel, Scanner l){ 

        No no;

        String sAux="S", sCod;

        while (sAux.equalsIgnoreCase("s")) {

            sCod = textInput(sLabel, l);

            no =  lista.procuraNo(sCod, "<>");

            if (no != null) return no;

            sAux = this.textInput("Codigo Invalido. Deseja Continuar (S/N) ? ", l);

        }

        return null;

    }


    public String textInput(String label, Scanner l) {
        System.out.print(label);
        return l.nextLine();
    }

}

