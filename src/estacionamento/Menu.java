package estacionamento;

import java.sql.SQLException;
//import java.time.LocalDateTime;
//import java.util.List;
import java.util.Scanner;
//import java.util.ArrayList;

public class Menu 
{

    private Scanner l;
    private MenuAux menuAux;
    private Usuario usuario;
    private Tarifa tarifa;

    ////////////
    /////// CONSTRUTOR

    public Menu(Usuario usuario, Tarifa tarifa) throws SQLException
    {

        l = new Scanner(System.in);
        menuAux = new MenuAux();

        System.out.println();
        System.out.println("ESTACIONAMENTO");

        //if (usuario == null) usuario = menuAux.pesquisa_Usuario();
        usuario = menuAux.pesquisa_Usuario();

        if (usuario == null) return;
       
        if (tarifa == null) tarifa = menuAux.pesquisa_Tarifa();

        if (tarifa == null) return;

        this.usuario = usuario;
        this.tarifa = tarifa;

        this.Menu_Principal();

    }

    ///////////
    /////// MENU PRINCIPAL

    public void Menu_Principal() throws SQLException
    {

        boolean bMenu = true;
        String sAux;
        String [] vet_sOpcoes = new String [10];     
        int iTam = 0;       

        vet_sOpcoes[iTam++] = "========= MENU PRINCIPAL ==========";
        vet_sOpcoes[iTam++] = "1 - Cadastros";
        vet_sOpcoes[iTam++] = "2 - Registros";
        vet_sOpcoes[iTam++] = "3 - Relatorios";
        vet_sOpcoes[iTam++] = "0 - Sair";

        while (bMenu) {

            sAux = opcaoMenu(vet_sOpcoes, iTam);

            if (sAux.equalsIgnoreCase("0")) {
                bMenu = false;
            } 
            else if (sAux.equalsIgnoreCase("1")){
                Menu_Cadastros();

            } 
            else if (sAux.equalsIgnoreCase("2")) {
                menuAux.dadosInput_Estacionamento(usuario, tarifa);

            } 
            else if (sAux.equalsIgnoreCase("3")) {
                Menu_Relatorios();

            } 
            else if (sAux.equalsIgnoreCase("0")) {
                bMenu = false;
            } 
            else {
                System.out.println("\nOpcao Invalida!");
            }
        }

    }



    ////////////
    /////// MENU DE CADASTROS

    public void Menu_Cadastros() throws SQLException
    {

        boolean bMenu = true;
        String sAux;
        String [] vet_sOpcoes = new String [10]; 
        int iTam = 0;       

        vet_sOpcoes[iTam++] = "========= CADASTROS ==========";
        vet_sOpcoes[iTam++] = "1 - Usuarios";
        vet_sOpcoes[iTam++] = "2 - Proprietarios";
        vet_sOpcoes[iTam++] = "3 - Veiculos";
        vet_sOpcoes[iTam++] = "4 - Tarifas";
        vet_sOpcoes[iTam++] = "0 - Voltar";

        //l = new Scanner(System.in);

        while (bMenu) {

            sAux = opcaoMenu(vet_sOpcoes, iTam);

            if (sAux.equalsIgnoreCase("0")) {
                bMenu = false;
            } 
            // CADASTRO DE USUARIOS
            else if (sAux.equalsIgnoreCase("1")) {
                menuAux.dadosInput_Usuario();

            } 
            // CADASTRO DE PROPRIETARIOS
            else if (sAux.equalsIgnoreCase("2")) {
                menuAux.dadosInput_Proprietario();

            } 
            // CADASTRO DE VEICULOS
            else if (sAux.equalsIgnoreCase("3")){
                menuAux.dadosInput_Veiculo();

            } 
            // CADSTRO DE Tarifas
            else if (sAux.equalsIgnoreCase("4")){
                menuAux.dadosInput_Tarifa();

            }
            else {
                System.out.println("\nOpcao Invalida!");
            }
        }

    }

    ////////////
    /////// MENU DE RELATORIOS

    public void Menu_Relatorios()throws SQLException {
    try
    {

        boolean bMenu = true;
        String sAux;
        String [] vet_sOpcoes = new String [10]; 
        int iTam = 0;       

        vet_sOpcoes[iTam++] = "========= RELATORIOS ==========";
        vet_sOpcoes[iTam++] = "1 - Administrativos";
        vet_sOpcoes[iTam++] = "2 - Financeiros";
        vet_sOpcoes[iTam++] = "0 - Voltar";

        //l = new Scanner(System.in);

        while (bMenu) {

            sAux = opcaoMenu(vet_sOpcoes, iTam);

            if (sAux.equalsIgnoreCase("0")) {
                bMenu = false;
            } 
            // RELATORIOS ADMINISTRATIVOS
            else if (sAux.equalsIgnoreCase("1")) {
                Menu_Relatorios_Administrativos();

            } 
            // RELATORIOS FINANCEIROS
            else if (sAux.equalsIgnoreCase("2")) {
                Menu_Relatorios_Financeiros();

            }  
            else {
                System.out.println("\nOpcao Invalida!");
            }
        }
    }
    catch(Exception e)
    { 
        System.out.println(e);
        return;
    }
    }
    
    ////////////
    /////// MENU DE RELATORIOS ADMINISTRATIVOS

    public void Menu_Relatorios_Administrativos() throws SQLException {
    try
    {

        boolean bMenu = true;
        String sAux;
        String [] vet_sOpcoes = new String [10]; 
        int iTam = 0;       

        vet_sOpcoes[iTam++] = "========= RELATORIOS ==========";
        vet_sOpcoes[iTam++] = "1 - Usuarios";
        vet_sOpcoes[iTam++] = "2 - Proprietarios";
        vet_sOpcoes[iTam++] = "3 - Veiculos";
        vet_sOpcoes[iTam++] = "4 - Tarifas";
        vet_sOpcoes[iTam++] = "5 - Registros";
        vet_sOpcoes[iTam++] = "0 - Voltar";

        //l = new Scanner(System.in);

        while (bMenu) {

            sAux = opcaoMenu(vet_sOpcoes, iTam);

            if (sAux.equalsIgnoreCase("0")) {
                bMenu = false;
            } 
            // RELATORIO DE USUARIOS
            else if (sAux.equalsIgnoreCase("1")) {
                 //menuAux.relatorio_Usuarios();
                menuAux.relatorio_Geral("USUARIOS");
            
            } 
            // RELATORIO DE PROPRIETARIOS
            else if (sAux.equalsIgnoreCase("2")) {
                //menuAux.relatorio_Proprietarios();
                menuAux.relatorio_Geral("PROPRIETARIOS");

            } 
            // RELATORIO DE VEICULOS
            else if (sAux.equalsIgnoreCase("3")) {
                //menuAux.relatorio_Veiculos();
                menuAux.relatorio_Geral("VEICULOS");
               
            } 
            // RELATORIO DE Tarifas
            else if (sAux.equalsIgnoreCase("4")) {
                //menuAux.relatorio_Tarifas();
                menuAux.relatorio_Geral("Tarifas");

            }
            // RELATORIO DE REGISTROS
            else if (sAux.equalsIgnoreCase("5")) {
                //menuAux.relatorio_Tarifas();
                menuAux.relatorio_Geral("REGISTROS");

            }  
            else {
                System.out.println("\nOpcao Invalida!");
            }
        }
    }
    catch(Exception e)
    { 
        System.out.println(e);
        return;
    }
    }

    ////////////
    /////// MENU DE RELATORIOS FINANCEIROS

    public void Menu_Relatorios_Financeiros() throws SQLException {
    try
    {

        boolean bMenu = true;
        String sAux;
        String [] vet_sOpcoes = new String [10]; 
        int iTam = 0;       

        vet_sOpcoes[iTam++] = "========= RELATORIOS FINANCEIROS ==========";
        vet_sOpcoes[iTam++] = "1 - Geral por Periodo";
        vet_sOpcoes[iTam++] = "2 - Veiculo por Periodo";
        vet_sOpcoes[iTam++] = "3 - Veiculos Estacionados";
        vet_sOpcoes[iTam++] = "0 - Voltar";

        //l = new Scanner(System.in);

        while (bMenu) {

            sAux = opcaoMenu(vet_sOpcoes, iTam);

            if (sAux.equalsIgnoreCase("0")) {
                bMenu = false;
            } 

            // GERAL POR PERIODO
            else if (sAux.equalsIgnoreCase("1")) {
                sAux = "GERAL POR PERIODO";
                System.out.println("\nLISTA DE " + sAux + ":");
                menuAux.relatorio_Financeiro(1); 
            
            } 
            // VEICULO POR PERIODO
            else if (sAux.equalsIgnoreCase("2")) {
                sAux = "VEICULO POR PERIODO";
                System.out.println("\nLISTA DE " + sAux + ":");
                menuAux.relatorio_Financeiro(2); 
            } 
            // VEICULOS ESTACIONADOS
            else if (sAux.equalsIgnoreCase("3")) {
                sAux = "VEICULOS ESTACIONADOS";
                System.out.println("\nLISTA DE " + sAux + ":");
                menuAux.relatorio_Financeiro(3); 

            }
            else {
                System.out.println("\nOpcao Invalida!");
            }
        }
    }
    catch(Exception e)
    { 
        System.out.println(e);
        return;
    }
    }




    ////////////
    /////// ENTRADA DE DADOS

    private String opcaoMenu(String [] vet_sOpcoes, int iTam) {

        System.out.println();
        System.out.println(vet_sOpcoes[0]);
        System.out.println();
        System.out.println("Selecione uma Opcao:");
        System.out.println();

        for (int i=1;i<iTam;i++) System.out.println(vet_sOpcoes[i]);

        return l.nextLine();

    }

}

