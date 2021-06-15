package database.controllers;

import database.models.Pokemon;
import database.ConexaoDAO;

import java.sql.SQLException;
import java.util.Scanner;

public class PokemonController {


  private Object Pokemon;

  public void excluir(int id) {


  }

  public void criar(ConexaoDAO connection) throws SQLException {
    Scanner scan = new Scanner(System.in);
    Pokemon pokemon = new Pokemon();

    Integer id = 0;
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

    try {
      this.salvar(pokemon, connection);
    } catch (SQLException e) {
      System.out.println(e.toString());
    }
  }

  private int salvar(Pokemon pk, ConexaoDAO connection) throws SQLException {
    String queryString = "INSERT INTO Pokemon(nome, tipo, geracao) VALUES ('" + pk.getNome() + "','" + pk.getTipo() + "','" + pk.getGeracao() + "')";
    try {
      return connection.executeQuery(queryString);
    } catch (SQLException e) {
      System.out.println(e.toString());
      return 0;
    }
  }

  public void listar() {

  }

  public void alterar(int id) {

  }
}

