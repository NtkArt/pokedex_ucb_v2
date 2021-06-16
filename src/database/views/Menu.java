package database.views;

import java.sql.SQLException;
import java.util.Scanner;

import database.ConexaoDAO;
import database.controllers.PokemonController;
import database.models.Pokemon;

public class Menu {
  public void inicializar(ConexaoDAO connection) throws SQLException {
    PokemonController pkController = new PokemonController();
    Scanner scan = new Scanner(System.in);
    int opcao = -1;
    while (opcao != 0) {
      System.out.println("------Menu-------");
      System.out.println("1- Pokemons");
      System.out.println("2- Treinador");
      System.out.println("0- Encerrar Programa");
      opcao = scan.nextInt();
      switch (opcao) {
        case 1:
          while (opcao != 0) {
            System.out.println("----------Pokemons------------");
            System.out.println("1- Catalogar Pokemon");
            System.out.println("2- Listar Pokedex");
            System.out.println("3- Alterar Pokemon cadastrado");
            System.out.println("4- Excluir Pokemon");
            System.out.println("0- Retornar ao menu anterior");
            opcao = scan.nextInt();
            switch (opcao) {
              case 1:
                pkController.criar(connection);
                break;
              case 2:
                pkController.listar(connection);
                break;
              case 3:
                System.out.println("Alterar pokemon");
                System.out.println("Digite o ID do pokemon que deseja alterar");
                int id = scan.nextInt();
                pkController.alterar(id, connection);
                break;
              case 4:
                System.out.println("Excluir pokemon");
                System.out.println("Digite o ID do pokemon que deseja excluir");
                int id_pokemon = scan.nextInt();
                pkController.excluir(id_pokemon, connection);
                break;
              case 0:
                break;
              default:
                System.out.println("Opcao invalida");
                break;
            }

          }
          opcao = -1;
          break;
        case 2:
          while (opcao != 0) {
            System.out.println("--------Treinador----------");
            System.out.println("1- Cadastrar Treinador");
            System.out.println("0- Retornar ao menu anterior");
            opcao = scan.nextInt();
            switch (opcao) {
              case 1:
//                treinador.cadastrar();
                break;
              case 0:
                break;
              default:
                System.out.println("Opcao invalida");
                break;
            }

          }
          opcao = -1;
          break;
        case 0:
          break;
        default:
          System.out.println("Opcao invalida");
          break;
      }
    }
    scan.close();
  }

  public void menuPokemon(int id, String nome, String tipo, int geracao) {
    System.out.println("--------------------------------------");
    System.out.println("ID do Pokemon: " + id);
    System.out.println("Nome do Pokemon: " + nome);
    System.out.println("Tipo do Pokemon: " + tipo);
    System.out.println("Geracao do Pokemon: " + geracao);
    System.out.println("--------------------------------------");
  }
}
