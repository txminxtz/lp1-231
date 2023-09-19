package semana22.exercicios;

import java.util.Scanner;
import java.sql.*;

class ExcluirAluno{

    public static void main(String args[]){

        Scanner l;
        String sCod, sAux;
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
                System.out.println("EXLUSAO DE ALUNOS");
                System.out.println("Entre com o codigo do Aluno (0 para sair): ");                
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

                    System.out.println();
                    System.out.println("Confirma exclusao (S/N) ?");                
                    sAux = l.nextLine();

                    if (sAux.equalsIgnoreCase("s")) {
                        stmt.execute("delete from tbl_alunos where codigo="+sCod);
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