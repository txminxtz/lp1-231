package semana20.exercicios;

import java.util.ArrayList;
import java.util.List;

public class ProvaRespostas {

    private List <Resposta> Respostas; 

    private int cont;
    
    public ProvaRespostas() 
    {
        Respostas = new ArrayList<>();
        cont = 0;
    }

    //Métodos para adicionar a questão e retornar as notas

    public void addResposta(Resposta resposta) 
    {
        Respostas.add(resposta);
        cont++;
    }
    
    public int getContRespostas() 
    {
        return cont;
    }

    public Resposta getResposta(int i) 
    {
        return Respostas.get(i);
    }

    public void mostraRespostas()
    {
        for (Resposta r : Respostas){
           r.mostraResposta();
        }
    }



}