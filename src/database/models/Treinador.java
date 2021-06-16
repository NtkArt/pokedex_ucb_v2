package database.models;

import java.util.ArrayList;

import database.models.UsuarioHasPokemon;

public class Treinador {
  private String nome;
  private String regiao;
  private int id;
  private ArrayList<Pokemon> pokemon;

  public Treinador(int id, String regiao, String nome, ArrayList<Pokemon> pk) {
    super();
    this.id = id;
    this.regiao = regiao;
    this.nome = nome;
    this.pokemon = pk;
  }

  public Treinador() {

  }

  public int getId() {
    return id;
  }

  public int setIdUpload(Integer id) {
    return this.id = id;
  }


  public int setId() {
    return this.id++;
  }


  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public ArrayList<Pokemon> getPokemon() {
    return this.pokemon;
  }

  public void setPokemon(ArrayList<Pokemon> pk) {
    this.pokemon = pk;
  }


  public String getRegiao() {
    return regiao;
  }

  public void setRegiao(String regiao) {
    this.regiao = regiao;
  }


}
