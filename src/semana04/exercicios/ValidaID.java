package semana04.exercicios;

//import java.util.InputMismatchException;

public class ValidaID {

    public static boolean isValidID(String ID) {

        char cDig;
        int iCode, iTam;

        iTam = ID.length();

        if (iTam != 7) return(false);

        cDig = ID.charAt(6);

        if (cDig != 'X') return(false);

        iCode = ID.codePointAt(0);
        if ((iCode < 65) || (iCode > 90)) return(false);

        iCode = ID.codePointAt(1);
        if ((iCode < 65) || (iCode > 90)) return(false);

        for (int i = 3; i <= iTam-2; i++){

            iCode = ID.codePointAt(i);
            if ((iCode < 48) || (iCode > 57)) return(false);
    
        }

        return(true);

    }
    
}

