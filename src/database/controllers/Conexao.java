package database.controllers;

import java.sql.*;

public class Conexao {
  private final String url = "jdbc:postgresql://localhost:5432/";
  private final String username = "postgres";
  private final String password = "1234";
  private Connection connection;
  Statement stmt = null;


  public Connection connect() throws SQLException {
    return connection = DriverManager.getConnection(url, username, password);
  }

  public void checkTable() {
    try {
      stmt = connection.createStatement();
      System.out.println("Verificando tabela de caracteristicas.....");
      String queryCreateTableCaracteristica = "CREATE TABLE IF NOT EXISTS Caracteristica(id serial primary key, nome varchar(255) not null, regiao varchar(255) not null )";
      stmt.executeUpdate(queryCreateTableCaracteristica);
      System.out.println("Verificando tabela dos pokemons.....");
      String queryCreateTablePokemon = "CREATE TABLE IF NOT EXISTS Pokemon(pokemon_id serial, habilidade VARCHAR (255) NOT NULL, peso REAL, tipo VARCHAR (100) NOT NULL,pokemon_caracteristica_id int NOT NULL, PRIMARY KEY(pokemon_id), FOREIGN KEY (pokemon_caracteristica_id) REFERENCES Caracteristica(id))";
      stmt.executeUpdate(queryCreateTablePokemon);
      System.out.println("Verificando tabela dos treinadores.....");
      String queryCreateTableTreinador = "CREATE TABLE IF NOT EXISTS Treinador(id serial, regiao varchar(255) not null, primary key (id), treinador_caracteristica_id int NOT NULL,FOREIGN KEY (treinador_caracteristica_id) REFERENCES Caracteristica(id))";
      stmt.executeUpdate(queryCreateTableTreinador);

      System.out.println("Tabelas geradas com sucesso.");
      stmt.close();
    } catch (Exception e) {
      e.getStackTrace();
    }

  }


}