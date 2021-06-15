package database.views;

import java.sql.SQLException;
import java.util.Scanner;

import database.ConexaoDAO;
import database.controllers.PokemonController;

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
                try {
                  pkController.criar(connection);
                  break;
                } catch (SQLException e) {
                  System.out.println(e.toString());
                }
              case 2:
//                treinador.listar();
//                pk.listar();
                break;
              case 3:
                System.out.println("Alterar pokemon");
                System.out.println("Digite o ID do pokemon que deseja alterar");
                int id = scan.nextInt();
//                pk.alterar(id);
                break;
              case 4:
                System.out.println("Excluir pokemon");
                System.out.println("Digite o ID do pokemon que deseja excluir");
                int id1 = scan.nextInt();
//                pk.excluir(id1);
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
}
