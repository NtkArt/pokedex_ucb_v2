package database;

import java.sql.*;

public class ConexaoDAO {
  private final String url = "jdbc:postgresql://localhost:5432/";
  private final String username = "postgres";
  public final String password = "postgres";
  private Connection connection;
  Statement stmt = null;


  public Connection connect() throws SQLException {
    return connection = DriverManager.getConnection(url, username, password);
  }


  @SuppressWarnings("SQLException")
  public boolean checkTable() {
    try {
      stmt = connection.createStatement();

      System.out.println("Verificando tabela dos pokemons.....");
      String queryCreateTablePokemon =
              "CREATE TABLE IF NOT EXISTS Pokemon(" +
                      "id SERIAL NOT NULL," +
                      "nome VARCHAR (255) NOT NULL," +
                      "tipo VARCHAR (255) NOT NULL," +
                      "geracao INTEGER NOT NULL," +
                      "PRIMARY KEY(id)" +
                      ")";
      stmt.executeUpdate(queryCreateTablePokemon);
      System.out.println("Verificando tabela dos treinadores.....");
      String queryCreateTableTreinador =
              "CREATE TABLE IF NOT EXISTS Treinador(" +
                      "id SERIAL NOT NULL," +
                      "nome VARCHAR(255) NOT NULL," +
                      "regiao VARCHAR(255) NOT NULL," +
                      "primary key (id)" +
                      ")";
      stmt.executeUpdate(queryCreateTableTreinador);
      String queryCreateTableRelationship =
              "CREATE TABLE IF NOT EXISTS Usuario_has_Pokemon(" +
                      "id serial, pokemon_id int NOT NULL," +
                      "treinador_id int NOT NULL," +
                      "PRIMARY KEY (id)," +
                      "FOREIGN KEY (pokemon_id) REFERENCES Pokemon(id), " +
                      "FOREIGN KEY (treinador_id) REFERENCES Treinador(id)" +
                      ")";
      stmt.executeUpdate(queryCreateTableRelationship);


      System.out.println("Tabelas geradas com sucesso.");
      stmt.close();
      return true;
    } catch (Exception e) {
      System.out.println(e.toString());
      return false;
    }
  }

  public ResultSet search(String queryString) throws SQLException {
    try {
      Statement stmt = connection.createStatement();
      return stmt.executeQuery(queryString);
    } catch (SQLException e) {
      System.out.println(e.toString());
    }
    return null;
  }

  public int executeQuery(String queryString) throws SQLException {
    try {
      Statement stmt = connection.createStatement();
      return stmt.executeUpdate(queryString);
    } catch (SQLException e) {
      System.out.println(e.toString());
      return 0;
    }
  }
}