package semana20.exercicios;

import java.util.ArrayList;
import java.util.List;

public class ProvaRespostas {

    private List <Resposta> respostas; 
    private int cont;
    
    public ProvaRespostas() 
    {
        respostas = new ArrayList<>();
        cont = 0;
    }

    public void addResposta(Resposta resposta) 
    {
        respostas.add(resposta);
        cont++;
    }
    
    public int getContRespostas() 
    {
        return cont;
    }

    public Resposta getResposta(int i) 
    {
        return respostas.get(i);
    }

    public void mostraRespostas()
    {
        for (Resposta r : respostas){
           r.mostraResposta();
        }
    }



}