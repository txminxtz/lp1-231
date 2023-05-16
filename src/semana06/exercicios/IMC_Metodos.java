package semana06.exercicios;

public class IMC_Metodos {
    
    public static float f_Func_IMC_Calculo (
        float fMassa, 
        float fAltura 
        ) {

        float 
            fIMC;

        fIMC = fMassa / fAltura / fAltura;

        return fIMC;

    }

    public static String s_Func_IMC_Mensagem (
        float fIMC 
        ) {

        String  
            sMsg;

        if (fIMC < 18.5)        sMsg = "Baixo peso";
        else if (fIMC < 24.9)   sMsg = "Peso Normal";
        else if (fIMC < 29.9)   sMsg = "Excesso de Peso";
        else if (fIMC < 34.9)   sMsg = "Obesidade Classe 1";
        else if (fIMC < 39.9)   sMsg = "Obesidade Classe 2";
        else                    sMsg = "Obesidade Classe 3";
    
        return sMsg;

    }

    public static float f_Func_IMC_Excesso (
        float fMassa, 
        float fAltura 
        ) {

        float 
            fExcesso,
            fAux;

        fExcesso = 0;

        fAux = (float) (18.5 * fAltura * fAltura);

        if (fMassa < fAux) fExcesso = fMassa - fAux;

        fAux = (float) (24.9 * fAltura * fAltura);

        if (fMassa > fAux) fExcesso = fMassa - fAux;
             
        return fExcesso;

    }

}