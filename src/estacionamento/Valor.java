package estacionamento;

import java.sql.*;

class Valor{

    private String cod;
    private double primeira;
    private double demais;
    private double diaria;
    private double mensalidade;

    public static void main(String args[]){

        String sCod, sPrimeira, sDemais, sDiaria, sMensalidade, sComando;
        ResultSet rs;

        try
        {

            Class.forName("com.mysql.jdbc.Driver");

            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_estacionamento","root","bts4");

            Statement stmt=con.createStatement();

            System.out.println();
            System.out.println("TABELA ANTERIOR DE VALORES");
            System.out.println();

            rs = stmt.executeQuery("select * from tbl_valores");

            while(rs.next()){
                System.out.println(
                    rs.getInt(1)    +"  "+
                    rs.getString(2) +"  "+
                    rs.getString(3) +"  "+
                    rs.getString(4) +"  "+
                    rs.getString(5)
                    );
            }     

            sCod = "1";
            sPrimeira = "12.00";
            sDemais = "7.00";
            sDiaria = "22.00";
            sMensalidade = "120.00";

            sComando = "UPDATE tbl_valores SET " +
                        "primeira=" + "'" + sPrimeira + "'"+ ", " +
                        "demais=" + "'" + sDemais + "'" + ", " +
                        "diaria=" + "'" + sDiaria + "'" + ", " +
                        "mensalidade=" + "'" + sMensalidade + "'" + " " +
                        "WHERE cod="+sCod;

            stmt.execute(sComando);

            System.out.println();
            System.out.println("TABELA ATUALIZADA DE VALORES");
            System.out.println();

            rs = stmt.executeQuery("select * from tbl_valores");

            while(rs.next()){
                System.out.println(
                    rs.getInt(1)    +"  "+
                    rs.getString(2) +"  "+
                    rs.getString(3) +"  "+
                    rs.getString(4) +"  "+
                    rs.getString(5)
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