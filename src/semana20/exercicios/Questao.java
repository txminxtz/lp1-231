package semana20.exercicios;

public abstract class Questao { 
   
    private int numero; 
    private String enunciado; 
    private String gabarito; 
    
    public Questao(
        int numero, 
        String enunciado,
        String gabarito)
    { 
        this.numero = numero; 
        this.enunciado = enunciado;
        this.gabarito = gabarito; 
     }

    public void mostrarEnunciado(int tipo){ 
        System.out.println(); 
        System.out.print(numero + ") " + enunciado); 
        if (tipo == 1) System.out.print(" R: " + gabarito);
        System.out.println(); 
    }

    public boolean validaResposta(String resposta)
    {
        Boolean b;

        b = gabarito.equalsIgnoreCase(resposta);

        System.out.println(); 
        System.out.println(numero + ") " + enunciado); 

        System.out.println("Gabarito: " + gabarito); 
        System.out.println("Minha Resposta: " + resposta); 
 
        if (b) System.out.println("Resposta Correta.");
        else   System.out.println("Resposta Incorreta.");

        return b; 
    }

}