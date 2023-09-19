package estacionamento;

import java.sql.*;

class Valor{

    private String cod;
    private String data;
    private double primeira;
    private double demais;
    private double diaria;

    public static void main(String args[]){

        String sData, sPrimeira, sDemais, sDiaria, sComando;
        ResultSet rs;

        try
        {

            Class.forName("com.mysql.jdbc.Driver");

            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_estacionamento","root","bts4");

            Statement stmt=con.createStatement();

            System.out.println();
            System.out.println("INCLUSAO DE VALORES");
            System.out.println();

            sData = "2023-09-12";
            sPrimeira = "12.00";
            sDemais = "7.00";
            sDiaria = "22.00";
            
            sComando = "INSERT INTO tbl_valores " +
                        "(cod, data, primeira, demais, diaria) " +
                        "VALUE (null, " +
                        "'" + sData + "'" + ", " +
                        "'" + sPrimeira + "'"+ ", " +
                        "'" + sDemais + "'" + ", " +
                        "'" + sDiaria + "'" + 
                        ")";

            stmt.execute(sComando);


            System.out.println();
            System.out.println("RELATORIO DE VALORES");
            System.out.println();

            rs = stmt.executeQuery("select * from tbl_valores");

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