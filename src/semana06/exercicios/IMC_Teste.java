package semana06.exercicios;

public class IMC_Teste {
    
    public static void main(String[] args) {
        
        float 
            fMassa, 
            fAltura,
            fIMC,
            fExcesso;
    
        String  
            sMsg;

        fMassa = 90;
        fAltura = (float)1.55;

        fIMC = IMC_Metodos.f_Func_IMC_Calculo(fMassa, fAltura);
        sMsg = IMC_Metodos.s_Func_IMC_Mensagem(fIMC);
        fExcesso = IMC_Metodos.f_Func_IMC_Excesso(fMassa, fAltura);

        System.out.println("Massa (Kg): " + fMassa);
        System.out.println("Altura (m): " + fAltura);
        System.out.println("IMC: " + fIMC);
        System.out.println("Classificacao: " + sMsg);

        if (fExcesso > 0){
            System.out.println("Você precisa PERDER " + fExcesso + " Kg.");
        }

        if (fExcesso < 0){
            System.out.println("Você precisa GANHAR " + (-fExcesso) + " Kg.");
        }
    
    }

 
      
}