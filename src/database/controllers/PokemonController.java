package database.controllers;

import database.models.Pokemon;
import database.ConexaoDAO;
import database.models.Treinador;
import database.models.UsuarioHasPokemon;
import database.views.Menu;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PokemonController {

  public int excluir(int id, ConexaoDAO connection) throws SQLException {
    String queryString = "DELETE FROM Pokemon WHERE pokemon_id = '" + id + "'";
    try {
      System.out.println("Deletando registro do banco de dados...");
      return connection.executeQuery(queryString);
    } catch (SQLException e) {
      System.out.println("Nao foi possivel deletar o pokemon do id" + id);
      System.out.println(e.toString());
      System.out.println("Voce tem certeza que o ID" + id + "existe no banco de dados?");
      return 0;
    }
  }

  public void criar(ConexaoDAO connection) throws SQLException {
    Scanner scan = new Scanner(System.in);
    Pokemon pokemon = new Pokemon();
    Treinador treinador = new Treinador();
    String type = "create";
    UsuarioHasPokemon up = new UsuarioHasPokemon();


    System.out.println("----------------Catalogar pokemons--------------");
    System.out.println("Digite o nome do pokemon que deseja catalogar");
    String nome = scan.nextLine();
    pokemon.setNome(nome);
    //
    System.out.println("Digite o tipo desse pokemon");
    String tipo = scan.nextLine();
    pokemon.setTipo(tipo);
    //
    System.out.println("Digite a geracao desse pokemon");
    Integer geracao = scan.nextInt();
    pokemon.setGeracao(geracao);
    pokemon.setId();
    pokemon.setTreinador(treinador);

    try {
      this.salvar(pokemon, connection, type);
    } catch (SQLException e) {
      System.out.println(e.toString());
    }
  }

  private int salvar(Pokemon pk, ConexaoDAO connection, String type) throws SQLException {
    String queryString = "";

    if (type.equals("create")) {
      queryString = "INSERT INTO Pokemon(nome, tipo, geracao) VALUES ('" + pk.getNome() + "','" + pk.getTipo() + "','" + pk.getGeracao() + "')";
    } else {
      queryString = "UPDATE Pokemon SET nome = '" + pk.getNome() + "' , tipo = '" + pk.getTipo() + "', geracao = '" + pk.getGeracao() + "' WHERE pokemon_id = " + pk.getId() + "";
    }

    try {
      return connection.executeQuery(queryString);
    } catch (SQLException e) {
      System.out.println(e.toString());
      return 0;
    }
  }


  public void listar(ConexaoDAO connection) throws SQLException {
    String queryString = "SELECT * FROM Pokemon";
    Menu menu = new Menu();
    Treinador tr = new Treinador();
    ResultSet rs = connection.search(queryString);
    try {
      while (rs.next()) {
        int id = rs.getInt("pokemon_id");
        String nome = rs.getString("nome");
        String tipo = rs.getString("tipo");
        int geracao = rs.getInt("geracao");
        menu.menuPokemon(id, nome, tipo, geracao, tr);
      }
    } catch (Exception e) {
      System.out.println(e.toString());
    }
  }

  public void alterar(int id, ConexaoDAO connection) throws SQLException {
    Scanner scan = new Scanner(System.in);
    String type = "update";
    Pokemon pk = new Pokemon();


    System.out.println("----------------Atualizar Pokemon--------------");
    System.out.println("Pokemon a ser atualizado tem o ID igual a: " + id);
    //
    System.out.println("Digite o novo nome do pokemon");
    String nome = scan.nextLine();
    pk.setNome(nome);
    //
    System.out.println("Digite o novo tipo do pokemon");
    String tipo = scan.nextLine();
    pk.setTipo(tipo);
    //
    System.out.println("Digite o nova geracao do pokemon");
    Integer geracao = scan.nextInt();
    pk.setGeracao(geracao);
    pk.setIdUpload(id);

    try {
      this.salvar(pk, connection, type);
    } catch (SQLException e) {
      System.out.println(e.toString());
    }
  }
}

