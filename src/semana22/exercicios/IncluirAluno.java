package semana22.exercicios;

import java.util.Scanner;
import java.sql.*;

class IncluirAluno{

    public static void main(String args[]){

        Scanner l;
        String sCod, sNome, sEmail, sAtivo, sAux, sComando;
        Boolean bAux=true;

        ResultSet rs;

        try
        {

            Class.forName("com.mysql.jdbc.Driver");

            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_dados","root","bts4");

            Statement stmt=con.createStatement();

            l = new Scanner(System.in);

            while (bAux) {

                System.out.println();
                System.out.println("ALUNOS CADASTRADOS");

                rs = stmt.executeQuery("select * from tbl_alunos");

                while(rs.next()){
                    System.out.println(
                        rs.getInt(1)    +"  "+
                        rs.getString(2) +"  "+
                        rs.getString(3) +"  "+
                        rs.getString(4)
                        );
                }

                System.out.println();
                System.out.println("INCLUSAO DE ALUNOS");
                System.out.println("Deseja Prosseguir (S/N): ");                
                sCod = l.nextLine();
    
                bAux = false;

                bAux = sCod.equalsIgnoreCase("s");

                if (bAux) {
        

                    //System.out.println();
                    System.out.println("Nome: "); sNome = l.nextLine();
                    System.out.println("Email: "); sEmail = l.nextLine();
                    System.out.println("Ativo (S/N): "); sAtivo = l.nextLine();

                    System.out.println();
                    System.out.println("Confirma Inclusao (S/N) ?");                
                    sAux = l.nextLine();

                    if (sAux.equalsIgnoreCase("s")) {
                        sComando = "INSERT INTO tbl_alunos " +
                                    "(codigo, nome, email, ativo) " +
                                    "VALUE (null, " +
                                    "'" + sNome + "'" + ", " +
                                    "'" + sEmail + "'"+ ", " +
                                    "'" + sAtivo + "'" +
                                   ")";

                        stmt.execute(sComando);
                    } 

                }
            }           

            con.close();

        }
        catch(Exception e)
        { 
            System.out.println(e);
        }

    }

}