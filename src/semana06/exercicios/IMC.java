package semana06.exercicios;

import javax.swing.JOptionPane;

public class IMC {
    
    public static void main(String[] args) {
        
        float 
            fMassa, 
            fAltura,
            fIMC,
            fExcesso;
    
        String  
            sMsg;

        fMassa = Float.parseFloat(JOptionPane.showInputDialog("Peso (Kg): "));
        fAltura = Float.parseFloat(JOptionPane.showInputDialog("Altura (m): "));

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