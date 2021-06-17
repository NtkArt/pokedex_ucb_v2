package database.models;

import java.util.ArrayList;

import database.models.UsuarioHasPokemon;

public class Treinador {
  private String nome;
  private String regiao;
  private int id;

  public Treinador(int id, String regiao, String nome) {
    super();
    this.id = id;
    this.regiao = regiao;
    this.nome = nome;
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

  public String getRegiao() {
    return regiao;
  }

  public void setRegiao(String regiao) {
    this.regiao = regiao;
  }


}
