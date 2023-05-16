package OOPessoa;

//import java.nio.BufferUnderflowException;
import java.util.Scanner;

public class PF_Principal {
    
    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {       

        int opcao; 
        int indice;

        String nome; // nome da pessoa
        int idade; // idade da pessoa
        double altura; // altura da pessoa     
        
        // cria uma nova Agenda
        PF_Agenda agenda = new PF_Agenda(5);

        // cria o menu de opções
        while(true){

            System.out.println("\n");
            System.out.println("1. Nova Pessoa");
            System.out.println("2. Excluir Pessoa");
            System.out.println("3. Buscar Pessoa");
            System.out.println("4. Imprimir Agenda");
            System.out.println("5. Imprimir Pessoa (indice)");
            System.out.println("6. Sair");
            System.out.print("Sua opcao: ");

            opcao = Integer.parseInt(entrada.nextLine());
            
            switch(opcao){
            case 1:

                System.out.print("\n");
                System.out.print("Informe o nome: ");
                nome = entrada.nextLine();
                System.out.print("Informe a idade: ");
                idade = Integer.parseInt(entrada.nextLine());
                System.out.print("Informe a altura (use ponto em vez de vírgula): ");
                altura = Double.parseDouble(entrada.nextLine());

                agenda.armazenaPessoa(nome, idade, altura);

                break;
                
            case 2:

                System.out.print("\n");
                System.out.print("Informe o nome a ser removido: ");
                nome = entrada.nextLine();

                agenda.removePessoa(nome);

                break;  
            
            case 3:

                System.out.print("\n");
                System.out.print("Informe o nome a ser pesquisado: ");
                nome = entrada.nextLine();

                indice = agenda.buscaPessoa(nome);

                System.out.print("\n");

                if(indice < 0){
                System.out.println("A pessoa nao foi encontrada");
                }
                else{
                System.out.println("A pessoa encontrada: " + indice);
                }
                
                break;  
            
            case 4:

                agenda.imprimeAgenda();
                break;
            
            case 5:

                System.out.print("\nInforme o índice desejado: ");
                int index = Integer.parseInt(entrada.nextLine());

                agenda.imprimePessoa(index);
                break;  
                
            case 6:

                System.exit(0);
                
            default:

                System.out.print("\n");
                System.out.println("Opcao invalida\n");
                break;
            }
        }     

    }

}