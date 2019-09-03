package coa.elvis.pokedex.features.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coa.elvis.pokedex.common.networking.response.Pokemon
import coa.elvis.pokedex.databinding.ViewCardPokemonBinding

class PokemonListAdapter : RecyclerView.Adapter<PokemonListAdapter.PokemonViewHolder>() {

  private var pokemons = mutableListOf<Pokemon>()

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
    val pokemonListItemBinding =
      ViewCardPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return PokemonViewHolder(pokemonListItemBinding)
  }

  override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) = holder.bind(pokemons[position])

  fun setupList(list: List<Pokemon>) {
    pokemons.clear()
    pokemons.addAll(list.toMutableList())
    notifyDataSetChanged()
  }

  override fun getItemCount(): Int {
    return pokemons.size
  }

  inner class PokemonViewHolder(val pokemonListItemBinding: ViewCardPokemonBinding) :
    RecyclerView.ViewHolder(pokemonListItemBinding.root) {
    fun bind(pokemon: Pokemon) {
      pokemonListItemBinding.pokemon = pokemon
      pokemonListItemBinding.executePendingBindings()
    }
  }

}