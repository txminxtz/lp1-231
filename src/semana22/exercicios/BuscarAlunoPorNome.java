package semana22.exercicios;

import java.util.Scanner;
import java.sql.*;

class BuscarAlunoPorNome{

    public static void main(String args[]){

        Scanner l;
        String sAux;
        Boolean bAux=true;

        try
        {

            Class.forName("com.mysql.jdbc.Driver");

            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_dados","root","bts4");

            Statement stmt=con.createStatement();

            l = new Scanner(System.in);

            while (bAux) {

                System.out.println();
                System.out.println("PESQUISA DE ALUNOS");
                System.out.println("Digite o nome do Aluno (0 para sair): ");
                sAux = l.nextLine();
    
                if (sAux.equalsIgnoreCase("0")) {
                    bAux = false;
                } 
                else {
        
                    ResultSet rs=stmt.executeQuery("select * from tbl_alunos where nome = '"+sAux+"'");
        
                    while(rs.next()){
                        System.out.println(
                            rs.getInt(1)    +"  "+
                            rs.getString(2) +"  "+
                            rs.getString(3) +"  "+
                            rs.getString(4)
                            );
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