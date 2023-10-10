package estacionamento;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class VeiculoDAO_Ant{

    public Veiculo create(Veiculo veiculo) throws SQLException {
        String sql = """
            INSERT INTO veiculo (placa, marca, modelo, cor)
            VALUES (?, ?, ?, ?);
        """;

        try (
                Connection connection = Conexao.getConnection();
                PreparedStatement statement = connection
                    .prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ) {

                statement.setString(1, veiculo.getPlaca());
                statement.setString(2, veiculo.getMarca());
                statement.setString(3, veiculo.getModelo());
                statement.setString(4, veiculo.getCor());
               
                statement.executeUpdate();

                ResultSet rs = statement.getGeneratedKeys();

                if(rs.next()) {
                    aluno.setId(rs.getInt(1));
                }

                rs.close();

                return aluno;
            
        } 
        
    }

    public Veiculo update(Veiculo veiculo) throws SQLException {

        String sql = """
            UPDATE veiculo
            SET placa = ?, marca = ?, modelo = ?, cor = ?
            WHERE cod = ?;
        """;

        try 
        (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) 
        {

            statement.setString(1, veiculo.getPlaca());
            statement.setString(2, veiculo.getMarca());
            statement.setDouble(3, veiculo.getModelo());
            statement.setDouble(4, veiculo.getCor());
            statement.setInt(5, veiculo.getCod());
            
            int linhasAfetadas = statement.executeUpdate();

            if (linhasAfetadas > 0) {
                return veiculo;
            }
            
            return null;

        } catch (SQLException e) {
            return null;
        }
    }

    public void delete(Integer cod) {
        String sql = "DELETE FROM veiculo WHERE cod = ?;";

        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, cod);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        public void delete(Veiculo veiculo) {
        delete(veiculo.getCod());
    }

        public Veiculo findByCod(Integer cod) {
        String sql = "SELECT * FROM veiculo WHERE cod = ?;";

        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return resultSetToVeiculos(rs);
            }

            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return null;
    }

    public List<Veiculo> findAll() {
        String sql = "SELECT * FROM veiculo;";
        List<Veiculo> veiculo = new ArrayList<>();

        try (
            Connection connection = Conexao.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
        ) {
            while(rs.next()) {
                veiculo.add(resultSetToVeiculos(rs));
            }

            return veiculo;
        
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        
    }

    private Veiculo resultSetToVeiculos(ResultSet rs) throws SQLException {
        return new Veiculo(
            rs.getInt("cod"),
            rs.getString("placa"),
            rs.getString("marca"),
            rs.getDouble("modelo"),
            rs.getDouble("cor")
        );
    }
}
