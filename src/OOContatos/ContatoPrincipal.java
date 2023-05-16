package OOContatos;

public class ContatoPrincipal {

    public static void main(String[] args) {

        Contato[] agenda = new Contato[5];
        
        agenda[0] = new Contato("Maria", "123432");
        agenda[1] = new Contato("Marcos", "356732");
        agenda[2] = new Contato("Joao", "742133");
        agenda[3] = new Contato("Julia", "683345");
        agenda[4] = new Contato("Pedro", "326842");

        System.out.println("Minha Agenda");
        
        for (Contato elemento: agenda){
            System.out.println(elemento);
        }

        for (int i=0; i < agenda.length; i++){
            System.out.print("Nome: " +agenda[i].getNome() + " / ");
            System.out.println("Telefone: " +agenda[i].getTelefone());
        }

    }
}
