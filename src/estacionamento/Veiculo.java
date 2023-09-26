package estacionamento;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

class Veiculos{

    private String cod;
    private String placa;
    private String marca;
    private double modelo;
    private double cor;

    public static void main(String args[]){

        String sPlaca, sMarca, sModelo, sCor, sComando, sAux;
        ResultSet rs;

        try
        {

            Class.forName("com.mysql.jdbc.Driver");

            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_estacionamento","root","bts4");

            Statement stmt=con.createStatement();

            System.out.println();
            System.out.println("INCLUSAO DE VEICULOS");
            System.out.println();

            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:ms");
            Calendar cal = Calendar.getInstance();
            
            sAux = dateFormat.format(cal.getTime());
            System.out.println(sAux);

            sAux = sAux.substring(sAux.length() - 4);
            System.out.println(sAux);

            sPlaca = "BTS"+sAux;
            sMarca = "honda";
            sModelo = "hrv";
            sCor = "prata";
            
            sComando = "INSERT INTO tbl_veiculos " +
                        "(placa, marca, modelo, cor) " +
                        "VALUE ("+
                        "'" + sPlaca + "'" + ", " +
                        "'" + sMarca + "'"+ ", " +
                        "'" + sModelo + "'" + ", " +
                        "'" + sCor + "'" +
                        ")";

            stmt.execute(sComando);


            System.out.println();
            System.out.println("RELATORIO DE VEICULOS");
            System.out.println();

            rs = stmt.executeQuery("select * from tbl_veiculos");

            while(rs.next()){
                System.out.println(
                    rs.getString(1)    +"  "+
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