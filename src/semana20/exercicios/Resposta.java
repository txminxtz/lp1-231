package semana20.exercicios;

public class Resposta { 
   
    private int numero; 
    private String resposta; 
    
    public Resposta(
        int numero, 
        String resposta)
    { 
        this.numero = numero; 
        this.resposta = resposta; 
     }

    public String getResposta()
    { 
        return this.resposta;
    } 

    public int getNumero()
    { 
        return this.numero;
    } 

    public void mostraResposta(){ 
        //System.out.println(); 
        System.out.println(numero + ")" + resposta); 
    }


}