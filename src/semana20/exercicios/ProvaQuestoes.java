package semana20.exercicios;

import java.util.ArrayList;
import java.util.List;

public class ProvaQuestoes {

    private  List <Questao> Questoes;

    private int cont;
    
    public ProvaQuestoes() 
    {
        Questoes = new ArrayList<>();
        cont = 0;
    }

    //Métodos para adicionar a questão e retornar as notas

    public void addQuestao(Questao questao) 
    {
        Questoes.add(questao);
        cont++;
    }
    
    public int getContQuestoes() 
    {
        return cont;
    }

    public void mostraQuestoes(int tipo)
    {
        for (Questao q : Questoes){
           q.mostraQuestao(tipo);
        }
    }

    public int corrigeProva(ProvaRespostas pRespostas)
    {
        Questao q;
        Resposta r;
        int nota = 0;
        Boolean b;

        for(int i = 0; i < Questoes.size(); i++)
        {
            q = Questoes.get(i);
            r = pRespostas.getResposta(i);
            b = q.validaResposta(r.getResposta());

            if (b) nota++;
        }

        return nota;
    }


}