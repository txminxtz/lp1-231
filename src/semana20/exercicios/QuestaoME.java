package semana20.exercicios;

import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.List;

public class QuestaoME extends Questao {
       
    private List <String> Alternativas; 

//    private String respostaCorreta; 

    public QuestaoME(
        int numero, 
        String enunciado, 
        String respostaCorreta) 
    { 
        super(numero, enunciado, respostaCorreta); 
        this.Alternativas = new ArrayList<>();
        //this.respostaCorreta = respostaCorreta; 
    } 

    public void AddAlternativa(String alternativa) 
    {
        this.Alternativas.add(alternativa);
    }

//    @Override 
//    public boolean validaResposta(String resposta) 
//    { 
//        return respostaCorreta.equalsIgnoreCase(resposta); 
//    }

//    @Override 
//    public boolean validarResposta(String resposta) 
//    { 
//        return respostasCorretas.contains(resposta); 
//    } 

//    @Override 
//    public int getPontuacao() 
//    { 
//        return respostasCorretas.size(); 
//    }

    @Override 
    public void mostraQuestao(int tipo){ 
        super.mostraQuestao(tipo); 
        for (String alternativa : Alternativas){
            System.out.println(alternativa); 
        }        
    }

//    public boolean validaResposta(String resposta) 
//    { 
//        return respostaCorreta.equalsIgnoreCase(resposta); 
//    }

}