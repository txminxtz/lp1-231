package semana22.exercicios;

//import java.util.Scanner;

/**
 * Implementação da estrutura de dados Lista Encadeada
 *
 * Implementação utilizando primeiro (head) e último nó da lista
 */
public class Lista {

    private No primeiro;
    private No ultimo;
    private int qt;

    public Lista(){
        primeiro = null;
        ultimo = null;
        qt = 0;
    }

    public int getQt() {
        return qt;
    }

    public No getPrimeiro() {
        return primeiro;
    }

    public No getUltimo() {
        return ultimo;
    }


    public void inserirPrimeiro(Elemento elemento, String sIndexador) {

        No novoNo = new No(elemento, sIndexador);

        primeiro = novoNo;
        ultimo = novoNo;
        qt = 1;

    }

    public void inserirNoInicio(Elemento elemento, String sIndexador) {

        if (qt == 0){
            inserirPrimeiro(elemento,  sIndexador);
            return;
        }

        No novoNo = new No(elemento, sIndexador);

        novoNo.setAnterior(null);
        novoNo.setProximo(primeiro);

        primeiro.setAnterior(novoNo);
        primeiro = novoNo;

        qt = qt + 1;
    }


    public void inserirNoFinal(Elemento elemento, String sIndexador) {

        if (qt == 0){
            inserirPrimeiro(elemento,  sIndexador);
            return;
        }

        No novoNo = new No(elemento, sIndexador);
        
        novoNo.setAnterior(ultimo);
        novoNo.setProximo(null);

        ultimo.setProximo(novoNo);
        ultimo = novoNo;

        qt = qt + 1;

    }

    public void inserirFilaCrescente(Elemento elemento, String sIndexador) {

        if (qt == 0){
            inserirPrimeiro(elemento,  sIndexador);
            return;
        }

        if (sIndexador.compareTo(primeiro.getIndexador()) <= 0)
        {
            this.inserirNoInicio(elemento,  sIndexador);
            return;
        }

        if (sIndexador.compareTo(ultimo.getIndexador()) > 0)
        {
            this.inserirNoFinal(elemento,  sIndexador);
            return;
        }

        No novoNo = new No(elemento, sIndexador);
        No atual;

        atual = primeiro;

        while (sIndexador.compareTo(atual.getProximo().getIndexador()) > 0) {                
            atual = atual.getProximo();
        }

        atual.getProximo().setAnterior(novoNo);
        novoNo.setProximo(atual.getProximo());
        novoNo.setAnterior(atual);
        atual.setProximo(novoNo);

        qt++;

    }

    public void inserirPilhaCrescente(Elemento elemento, String sIndexador) {

        if (qt == 0){
            inserirPrimeiro(elemento,  sIndexador);
            return;
        }

        if (sIndexador.compareTo(primeiro.getIndexador()) < 0)
        {
            this.inserirNoInicio(elemento,  sIndexador);
            return;
        }

        if (sIndexador.compareTo(ultimo.getIndexador()) >= 0)
        {
            this.inserirNoFinal(elemento,  sIndexador);
            return;
        }

        No novoNo = new No(elemento, sIndexador);
        No atual;

        atual = primeiro;

        while (sIndexador.compareTo(atual.getProximo().getIndexador()) >= 0) {                
            atual = atual.getProximo();
        }

        atual.getProximo().setAnterior(novoNo);
        novoNo.setProximo(atual.getProximo());
        novoNo.setAnterior(atual);
        atual.setProximo(novoNo);

        qt++;

    }

    public void removeNo(No no) {

        No no_anterior, no_proximo;

        if (no == primeiro) {
            removePrimeiroNo();
            return;
        }

        if (no == ultimo) {
            removeUltimoNo();
            return;
        }

        no_anterior = no.getAnterior();
        no_proximo = no.getProximo();

        no_anterior.setProximo(no_proximo);
        no_proximo.setAnterior(no_anterior);

        qt--;

    }


    public void removePrimeiroNo() {

        if(qt == 0) {
            return;
        }

        primeiro = primeiro.getProximo();
        primeiro.setAnterior(null);
        qt--;

        if(qt == 0) {
            ultimo = null;
        }
    }

    public void removeUltimoNo() {

        if(qt == 0) {
            return;
        }

        ultimo = ultimo.getAnterior();
        ultimo.setProximo(null);
        qt--;

        if(qt == 0) {
            primeiro = null;
        }
    }

    public void imprimir() {
        if(qt == 0) {
            System.out.println("[]");
            return;
        }

        String indexadors = retornaElementos();
        System.out.println(indexadors);
    }

    String retornaElementos() {

        StringBuilder elementos = new StringBuilder("[");

        No atual = primeiro;

        while (atual.getProximo() != null) {
            elementos.append(atual.getIndexador());
            elementos.append(" ");
            atual = atual.getProximo();
        }

        elementos.append(atual.getIndexador());

        elementos.append("]");

        return elementos.toString();
    }

    public void exibeComponentes(int iTab) {

        //No no = this.getPrimeiro();
        No no = this.getUltimo();

        while (no != null){

            System.out.println();

            no.getElemento().mostraDados(iTab);

            //no = no.getProximo();
            no = no.getAnterior();

        }
        
    }    

    public No procuraNo( 
        String sIndexador,
        String sTipo	// > Maior; < Menor; <> Indiferente
        ) {

        No no_atual;

        String sAux;
        int iTam;

        sAux = "<>";

        if (!sAux.contains(sTipo)) return null;

        iTam = sIndexador.length();

        if (sTipo==">") no_atual = this.ultimo;
        else            no_atual = this.primeiro;

        while (no_atual!=null) {                
            
            sAux = no_atual.getIndexador();
            sAux = sAux.substring(0,iTam);

            if (sIndexador.equals(sAux))  return no_atual;                
            
            if (sTipo==">") { 
                no_atual = no_atual.getAnterior();
            }
            else { 
                no_atual = no_atual.getProximo();
            }
            
        }

        return null;

    }

}
