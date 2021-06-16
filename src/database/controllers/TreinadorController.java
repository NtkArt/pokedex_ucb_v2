package database.controllers;

import database.models.Pokemon;
import database.models.Treinador;
import database.ConexaoDAO;
import database.views.Menu;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class TreinadorController {

  private int salvar(Treinador treinador, ConexaoDAO connection, String type) throws SQLException {
    String queryString = "";

    if (type.equals("create")) {
      queryString = "INSERT INTO Treinador(nome, regiao) VALUES ('" + treinador.getNome() + "','" + treinador.getRegiao() + "')";
    } else {
      queryString = "UPDATE Treinador SET nome = '" + treinador.getNome() + "' , regiao = '" + treinador.getRegiao() + "' WHERE treinador_id = " + treinador.getId() + "";
    }


    try {
      return connection.executeQuery(queryString);
    } catch (SQLException e) {
      System.out.println(e.toString());
      return 0;
    }
  }

  public void listar(ConexaoDAO connection) throws SQLException {
    String queryString = "SELECT * FROM Treinador";
    Menu menu = new Menu();
    ResultSet rs = connection.search(queryString);
    try {
      while (rs.next()) {
        int id = rs.getInt("treinador_id");
        String nome = rs.getString("nome");
        String regiao = rs.getString("regiao");
        Array pokemons = rs.getArray("pokemons");
        menu.menuTreinador(id, nome, regiao, pokemons);
      }
    } catch (Exception e) {
      System.out.println(e.toString());
    }
  }

  public void criar(ConexaoDAO connection) {
    Scanner scan = new Scanner(System.in);
    Treinador treinador = new Treinador();
    String type = "create";


    System.out.println("----------------Catalogar pokemons--------------");
    System.out.println("Digite o nome do treinador que deseja adicionar na pokedex");
    String nome = scan.nextLine();
    treinador.setNome(nome);
    //
    System.out.println("Digite a regiao desse treinador");
    String regiao = scan.nextLine();
    treinador.setRegiao(regiao);
    //

    System.out.println("Digite o ID do pokemon que deseja atribuir a esse treinador");
    int idPokemon = scan.nextInt();

    try {
      this.salvar(treinador, connection, type);
    } catch (Exception e) {
      System.out.println(e.toString());
    }
  }


  public int excluir(int id, ConexaoDAO connection) {
    String queryString = "DELETE FROM Treinador WHERE treinador_id = '" + id + "'";
    try {
      System.out.println("Deletando registro do banco de dados...");
      return connection.executeQuery(queryString);
    } catch (Exception e) {
      System.out.println("Nao foi possivel deletar o treinador do id" + id);
      System.out.println(e.toString());
      System.out.println("Voce tem certeza que o ID" + id + "existe no banco de dados?");
      return 0;
    }
  }


  public void alterar(int id, ConexaoDAO connection) {
    Scanner scan = new Scanner(System.in);
    String type = "update";
    Treinador tr = new Treinador();


    System.out.println("----------------Atualizar Pokemon--------------");
    System.out.println("Treinador a ser atualizado tem o ID igual a: " + id);
    //
    System.out.println("Digite o novo nome do treinador");
    String nome = scan.nextLine();
    tr.setNome(nome);
    //
    System.out.println("Digite a nova regiao do treinador");
    String regiao = scan.nextLine();
    tr.setRegiao(regiao);
    tr.setIdUpload(id);
    //


    try {
      this.salvar(tr, connection, type);
    } catch (Exception e) {
      System.out.println(e.toString());
    }
  }

}
