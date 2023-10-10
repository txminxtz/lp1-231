package estacionamento;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

class Registros{

    private String cod;
    private String data;
    private String usuario;
    private String placa;
    private String entrada;
    private String saida;
    private String valor;

    public static void main(String args[]){

        String sData, sUsuario, sPlaca, sEntrada, sSaida, sValor, sComando, sAux;
        ResultSet rs;

        try
        {

            Class.forName("com.mysql.jdbc.Driver");

            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_estacionamento","root","bts4");

            Statement stmt=con.createStatement();

            //DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:ms");
            DateFormat dateFormat1 = new SimpleDateFormat("yyyy/MM/dd");
            DateFormat dateFormat2 = new SimpleDateFormat("HH:mm:ss");
            Calendar cal = Calendar.getInstance();
            

            System.out.println();
            System.out.println("INCLUSAO DE REGISTROS");
            System.out.println();

            sData = dateFormat1.format(cal.getTime());
            System.out.println(sData);

            sEntrada = dateFormat2.format(cal.getTime());
            System.out.println(sEntrada);

            sUsuario = "1";
            sPlaca = "JUI9823";
            //sSaida = "14:43:09";
            //sSaida = "'14:43:09', ";
            sSaida = "null, ";

            sValor = "0.0";
            
            sComando = "INSERT INTO tbl_registros " +
                        "(cod, data, usuario, placa, entrada, saida, valor) " +
                        "VALUE ("+
                        "null, " +
                        "'" + sData + "'" + ", " +
                        "'" + sUsuario + "'"+ ", " +
                        "'" + sPlaca + "'" + ", " +
                        "'" + sEntrada + "'" + ", " +
                              sSaida +
                        "'" + sValor + "'" + 
                        ")";

            stmt.execute(sComando);


            System.out.println();
            System.out.println("RELATORIO DE REGISTROS");
            System.out.println();

            rs = stmt.executeQuery("select * from tbl_registros");

            while(rs.next()){
                System.out.println(
                    rs.getInt(1)    +"  "+
                    rs.getString(2) +"  "+
                    rs.getString(3) +"  "+
                    rs.getString(4) +"  "+
                    rs.getString(5) +"  "+
                    rs.getString(6)
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