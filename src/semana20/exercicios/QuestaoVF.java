package semana20.exercicios;

public class QuestaoVF extends Questao {

    //Questoes Verdadeiro/Falso

//    private boolean respostaCorreta;

    public QuestaoVF(
        int numero, 
        String enunciado, 
        String respostaCorreta) 
    {
        super(numero, enunciado, respostaCorreta);
        //this.respostaCorreta = respostaCorreta;
    }

//    @Override 
//    public boolean validaResposta(String resposta) 
//    { 
//        if (resposta == "T") return respostaCorreta; 
//        if (resposta == "F") return !respostaCorreta; 
//        return false;
//    }

//    public boolean getResposta() {
//        return resposta;
//    }

//   @Override
//   public int getPontuacao() 
//   {
//        return 1;
//   }

}