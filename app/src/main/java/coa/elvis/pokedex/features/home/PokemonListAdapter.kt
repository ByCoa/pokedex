package coa.elvis.pokedex.features.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coa.elvis.pokedex.common.networking.response.Pokemon
import coa.elvis.pokedex.common.view.BindableAdapter
import coa.elvis.pokedex.databinding.ViewCardPokemonBinding

class PokemonListAdapter internal constructor(private var pokemons: MutableList<Pokemon> = mutableListOf()) : RecyclerView.Adapter<PokemonListAdapter.PokemonViewHolder>(),BindableAdapter<List<Pokemon>> {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
    val pokemonListItemBinding = ViewCardPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return PokemonViewHolder(pokemonListItemBinding)
  }

  override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) = holder.bind(pokemons[position])

  override fun setData(data: List<Pokemon>) {
    if (!data.isNullOrEmpty()) {
      pokemons.clear()
      pokemons.addAll(data.toMutableList())
      notifyDataSetChanged()
    }
  }

  override fun getItemCount(): Int {
    return pokemons.size
  }

  inner class PokemonViewHolder(val pokemonListItemBinding: ViewCardPokemonBinding) :
    RecyclerView.ViewHolder(pokemonListItemBinding.root) {

    fun bind(pokemon: Pokemon) {
      pokemonListItemBinding.pokemon = pokemon
      setAdapter(pokemonListItemBinding.rvPokemonTypes)
      pokemonListItemBinding.executePendingBindings()
    }

    fun setAdapter(recyclerView: RecyclerView) {
      val adapter = PokemonTypeListAdapter()
      recyclerView.adapter = adapter
    }
  }

}