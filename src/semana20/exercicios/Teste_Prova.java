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
            "2+2 = 5 (V|F) ",
            "F");

        pQuestoes.addQuestao(q_VF);

        // 2)

        q_UE = new QuestaoUE(
            2,
            "Quantos dias tem uma semana?",
            "7");

        pQuestoes.addQuestao(q_UE);

        // 3)

        q_ME = new QuestaoME(
            3,
            "Quem descobriu o Brasil? (A|B|C|D|E)",
            "C");

        q_ME.AddAlternativa(" a) Neymar");
        q_ME.AddAlternativa(" b) Vasco da Gama");
        q_ME.AddAlternativa(" c) Pedro Alavares Cabral");
        q_ME.AddAlternativa(" d) Bolsonaro");
        q_ME.AddAlternativa(" e) Pelé");

        pQuestoes.addQuestao(q_ME);

        // 4)

        q_VF = new QuestaoVF(
            1,
            "Espanha é um pais da Europa (V|F) ",
            "V");

        pQuestoes.addQuestao(q_VF);

        // 5)

        q_UE = new QuestaoUE(
            2,
            "Quem foi a ultima selecao a ganhar a copa do mundo?",
            "Argentina");

        pQuestoes.addQuestao(q_UE);


        // Exibe Questões

        System.out.println();
        System.out.println("QUESTOES: ") ;

        pQuestoes.mostrarQuestao(0);

        /////////////////////////////////////////////
        // RESPOSTAS

        pRespostas = new ProvaRespostas();

        r = new Resposta (1,"F");
        pRespostas.addResposta(r);

        r = new Resposta (2,"7");
        pRespostas.addResposta(r);

        r = new Resposta (3,"D");
        pRespostas.addResposta(r);

        r = new Resposta (4,"V");
        pRespostas.addResposta(r);

        r = new Resposta (5,"Argentina");
        pRespostas.addResposta(r);
        // Exibe Respostas

        System.out.println();
        System.out.println("MINHAS RESPOSTAS: ") ;

        pRespostas.mostraRespostas();

        /////////////////////////////////////////////
        // CORREÇÃO

        System.out.println();
        System.out.println("CORRECAO: ") ;

        nota = pQuestoes.corrigirProva(pRespostas);

        System.out.println();
        System.out.println("Nota: "+10*nota/pQuestoes.getContQuestoes()) ;

    }
}