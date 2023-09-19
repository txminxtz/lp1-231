package estacionamento;

import java.sql.*;

class Registros{

    private String cod;
    private String data;
    private String usuario;
    private String placa;
    private String entrada;
    private String saida;

    public static void main(String args[]){

        String sData, sUsuario, sPlaca, sEntrada, sSaida, sComando;
        ResultSet rs;

        try
        {

            Class.forName("com.mysql.jdbc.Driver");

            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_estacionamento","root","bts4");

            Statement stmt=con.createStatement();

            System.out.println();
            System.out.println("INCLUSAO DE REGISTROS");
            System.out.println();

            sData = "2023-09-11";
            sUsuario = "1";
            sPlaca = "JUI9823";
            sEntrada = "08:17:43";
            sSaida = "14:43:09";
            
            sComando = "INSERT INTO tbl_registros " +
                        "(cod, data, usuario, placa, entrada, saida) " +
                        "VALUE (null, " +
                        "'" + sData + "'" + ", " +
                        "'" + sUsuario + "'"+ ", " +
                        "'" + sPlaca + "'" + ", " +
                        "'" + sEntrada + "'" + ", " +
                        "'" + sSaida + "'" + 
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