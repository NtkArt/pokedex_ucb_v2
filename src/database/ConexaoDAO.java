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
      String queryCreateTablePokemon = "CREATE TABLE IF NOT EXISTS Pokemon(pokemon_id serial, nome VARCHAR (255) NOT NULL, geracao INTEGER, tipo VARCHAR (100) NOT NULL,PRIMARY KEY(pokemon_id))";
      stmt.executeUpdate(queryCreateTablePokemon);
      System.out.println("Verificando tabela dos treinadores.....");
      String queryCreateTableTreinador = "CREATE TABLE IF NOT EXISTS Treinador(treinador_id serial,nome varchar(255) not null, regiao varchar(255) not null, primary key (treinador_id))";
      stmt.executeUpdate(queryCreateTableTreinador);
      String queryCreateTableRelationship = "CREATE TABLE IF NOT EXISTS Usuario_has_Pokemon(pokemon_treinador_id int NOT NULL,FOREIGN KEY (pokemon_treinador_id) REFERENCES Pokemon(pokemon_id), treinador_pokemon_id int NOT NULL,FOREIGN KEY (treinador_pokemon_id) REFERENCES Treinador(treinador_id))";
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
      return null;
    }
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