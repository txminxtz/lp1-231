package semana20.exercicios;

import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.List;

public class QuestaoME extends Questao {
       
    private List <String> alternativas; 

    public QuestaoME(
        int numero, 
        String enunciado, 
        String gabarito) 
    { 
        super(numero, enunciado, gabarito); 
        this.alternativas = new ArrayList<>();
    } 

    public void AddAlternativa(String alternativa) 
    {
        this.alternativas.add(alternativa);
    }

    @Override 
    public void mostrarEnunciado(int tipo){ 
        super.mostrarEnunciado(tipo); 
        for (String alternativa : alternativas){
            System.out.println(alternativa); 
        }        
    }

}