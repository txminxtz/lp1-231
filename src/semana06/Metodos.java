package semana06;

public class Metodos{

public static void main(String[] args) {
    System.out.println(Math.sqrt(25.0));    
    ImprimirPalavra( "Olá Mundo");
    ImprimirPalavra( "Teste");
    
    double soma = Calculadora.somar(10.0, 2.0);
    System.out.println(soma);

    System.out.println(Calculadora.somar(3.0, 4.0));
}

// Assinatura de Método 
// public - acesso em qualquer parte do projeto 
// static - método atrelado a classe (não precis acriar um objeto)
// void - tiṕo de retorno (sem retorno)
// ImprimirPalavra - nome do método 
// String palavra - prâmetro (pode ter zero ou muitos)
// definindo o método 

public static void ImprimirPalavra (String palavra){
    System.out.println(palavra.toUpperCase());
    
}
    
    
}
