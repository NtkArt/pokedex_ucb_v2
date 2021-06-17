package database.models;

public class UsuarioHasPokemon {

  private int pokemon_treinador_id;
  private int treinador_pokemon_id;
  private int id;

  public UsuarioHasPokemon() {
  }

  public UsuarioHasPokemon(int id) {
    super();
    this.id = id;
  }


  public int getId() {
    return this.id;
  }

  public void setId() {
    this.id++;
  }

  public void setPokemonTreinadorId(int pokemon_treinador_id) {
    this.pokemon_treinador_id = pokemon_treinador_id;
  }

  public void setTreinadorPokemonId(int treinador_pokemon_id) {
    this.treinador_pokemon_id = treinador_pokemon_id;
  }

  public int getPokemonTreinadorId() {
    return this.pokemon_treinador_id;
  }

  public int getTreinadorPokemonId() {
    return this.treinador_pokemon_id;
  }


}
