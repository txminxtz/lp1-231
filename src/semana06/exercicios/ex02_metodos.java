package semana06.exercicios;

public class ex02_metodos {

    public static float fCalculo_IMC(Float fMassa, float fAltura) {
        float fIMC = fMassa / (fAltura * fAltura);
        return fIMC;
    }

    public static String fFunc_Mensagem(float fIMC) {

        String sMsg;

        if (fIMC<18.5)          sMsg = "Baixo peso";
        else if(fIMC<24.9)      sMsg = "Peso normal";
        else if (fIMC<29.9)     sMsg = "Excesso de peso";
        else if (fIMC<34.9)     sMsg = "Obesidade classe 1";
        else if (fIMC<39.9)     sMsg = "Obesidade classe 2";
        else                    sMsg = "Obesidade classe 3";
        
        return sMsg;

    }

    public static float fExcesso_IMC(Float fMassa, float fAltura) {
        float fExcesso, fAux;

        fExcesso = 0;

        fAux = (float) (24.9 * fAltura * fAltura);

        if (fMassa > fAux) fExcesso = fMassa - fAux;
        
        fAux = (float) (18.5 * fAltura * fAltura);

        if (fMassa < fAux) fExcesso = fMassa - fAux;

        return fExcesso;
    }

}