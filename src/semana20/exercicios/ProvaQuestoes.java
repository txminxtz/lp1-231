package semana20.exercicios;

import java.util.ArrayList;
import java.util.List;

public class ProvaQuestoes {

    private  List <Questao> questoes;

    private int cont;
    
    public ProvaQuestoes() 
    {
        questoes = new ArrayList<>();
        cont = 0;
    }

    public void addQuestao(Questao questao) 
    {
        questoes.add(questao);
        cont++;
    }
    
    public int getContQuestoes() 
    {
        return cont;
    }

    public void mostrarQuestao(int tipo)
    {

        for (Questao q: questoes){
            q.mostrarEnunciado(tipo);
        }

    }

    public int corrigirProva(ProvaRespostas pRespostas)
    {
        Questao q;
        Resposta r;
        int nota = 0;
        Boolean b;

        for(int i = 0; i < questoes.size(); i++)
        {
            q = questoes.get(i);
            r = pRespostas.getResposta(i);
            b = q.validaResposta(r.getResposta());

            if (b) nota++;
        }

        return nota;
    }


}