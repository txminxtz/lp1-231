package semana22.exercicios;

import java.sql.*;

class ExibirAlunos{

    public static void main(String args[]){

        ResultSet rs;

        try
        {

            Class.forName("com.mysql.jdbc.Driver");

            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_dados","root","bts4");

            Statement stmt=con.createStatement();

            System.out.println();
            System.out.println("RELATORIO DE ALUNOS");
            System.out.println();

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

            con.close();

        }
        catch(Exception e)
        { 
            System.out.println(e);
        }

    }

}