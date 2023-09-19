package semana22.exercicios;

import java.util.Scanner;
import java.sql.*;

class AtualizarAluno{

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
                System.out.println("EDICAO DE ALUNO");
                System.out.println("Codigo (0 para sair): ");                
                sCod = l.nextLine();
    
                if (sCod.equalsIgnoreCase("0")) {
                    bAux = false;
                } 
                else {
        
                    rs = stmt.executeQuery("select * from tbl_alunos where codigo="+sCod);
        
                    while(rs.next()){
                        System.out.println(
                            rs.getInt(1)    +"  "+
                            rs.getString(2) +"  "+
                            rs.getString(3) +"  "+
                            rs.getString(4)
                            );
                    }

                    System.out.println("Nome: "); sNome = l.nextLine();
                    System.out.println("Email: "); sEmail = l.nextLine();
                    System.out.println("Ativo (S/N): "); sAtivo = l.nextLine();

                    System.out.println();
                    System.out.println("Confirma alteracao (S/N) ?");                
                    sAux = l.nextLine();

                    if (sAux.equalsIgnoreCase("s")) {
                        sComando = "UPDATE tbl_alunos SET " +
                                    "nome=" + "'" + sNome + "'" + ", " +
                                    "email=" + "'" + sEmail + "'" + ", " +
                                    "ativo=" + "'" + sAtivo + "'" + " " +
                                    "WHERE codigo="+sCod;

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