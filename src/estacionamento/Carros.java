package estacionamento;

import java.sql.*;

class Carros{

    private String placa;
    private String montadora;
    private double modelo;
    private double cor;
    private double mensalidade;

    public static void main(String args[]){

        String sPlaca, sMontadora, sModelo, sCor, sMensalidade, sComando;
        ResultSet rs;

        try
        {

            Class.forName("com.mysql.jdbc.Driver");

            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_estacionamento","root","bts4");

            Statement stmt=con.createStatement();

            System.out.println();
            System.out.println("INCLUSAO DE CARROS");
            System.out.println();

            sPlaca = "HJU6774";
            sMontadora = "honda";
            sModelo = "hrv";
            sCor = "prata";
            sMensalidade = "100";
            
            sComando = "INSERT INTO tbl_carros " +
                        "(placa, montadora, modelo, cor, mensalidade) " +
                        "VALUE ("+
                        "'" + sPlaca + "'" + ", " +
                        "'" + sMontadora + "'"+ ", " +
                        "'" + sModelo + "'" + ", " +
                        "'" + sCor + "'" + ", " +
                        "'" + sMensalidade + "'" + 
                        ")";

            stmt.execute(sComando);


            System.out.println();
            System.out.println("RELATORIO DE CARROS");
            System.out.println();

            rs = stmt.executeQuery("select * from tbl_carros");

            while(rs.next()){
                System.out.println(
                    rs.getString(1)    +"  "+
                    rs.getString(2) +"  "+
                    rs.getString(3) +"  "+
                    rs.getString(4) +"  "+
                    rs.getString(5) +"  "
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