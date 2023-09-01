package semana20.exercicios;

public class Teste_Prova {
    public static void main(String[] args) {

        ProvaQuestoes pQuestoes;
        ProvaRespostas pRespostas;

        QuestaoME q_ME;
        QuestaoUE q_UE;
        QuestaoVF q_VF;
        Resposta r;

        int nota;

        /////////////////////////////////////////////
        // QUESTÕES


        pQuestoes = new ProvaQuestoes();

        // 1)

        q_VF = new QuestaoVF(
            1,
            "Hoje esta quante! (V|F ?) ",
            "F");

        pQuestoes.addQuestao(q_VF);

        // 2)

        q_UE = new QuestaoUE(
            2,
            "Que dia eh Hoje ?",
            "1");

        pQuestoes.addQuestao(q_UE);

        // 3)

        q_ME = new QuestaoME(
            3,
            "Que dia da semana eh Hoje ? (A|B|C|D|E ?)",
            "E");

        q_ME.AddAlternativa(" a) Segunda");
        q_ME.AddAlternativa(" b) Terca");
        q_ME.AddAlternativa(" c) Quarta");
        q_ME.AddAlternativa(" d) Quinta");
        q_ME.AddAlternativa(" e) Sexta");

        pQuestoes.addQuestao(q_ME);

        // Exibe Questões

        System.out.println();
        System.out.println("QUESTOES: ") ;

        pQuestoes.mostraQuestoes(0);

//        System.out.println();
//        System.out.println("Total de Questoes: ") ;
//        System.out.println(pQuestoes.getContQuestoes());

        /////////////////////////////////////////////
        // RESPOSTAS

        pRespostas = new ProvaRespostas();

        r = new Resposta (1,"F");
        pRespostas.addResposta(r);

        r = new Resposta (2,"1");
        pRespostas.addResposta(r);

        r = new Resposta (3,"D");
        pRespostas.addResposta(r);

        // Exibe Respostas

        System.out.println();
        System.out.println("MINHAS RESPOSTAS: ") ;

        pRespostas.mostraRespostas();

 //       System.out.println();
 //       System.out.println("Total de Respostas: ") ;
 //       System.out.println(pRespostas.getContRespostas());


        /////////////////////////////////////////////
        // CORREÇÃO

        System.out.println();
        System.out.println("CORRECAO: ") ;

        nota = pQuestoes.corrigeProva(pRespostas);

        System.out.println();
        System.out.println("Nota: "+10*nota/pQuestoes.getContQuestoes()) ;

    }
}