package coa.elvis.pokedex.features.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coa.elvis.pokedex.common.view.BindableAdapter
import coa.elvis.pokedex.databinding.ViewPokemonTypeBinding
import coa.elvis.pokedex.model.EnumPokemonType

class PokemonTypeListAdapter internal constructor(private var pokemonTypes: MutableList<EnumPokemonType> = mutableListOf()) : RecyclerView.Adapter<PokemonTypeListAdapter.PokemonTypeViewHolder>(),
  BindableAdapter<List<EnumPokemonType>> {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonTypeViewHolder {
    val pokemonListItemBinding = ViewPokemonTypeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return PokemonTypeViewHolder(pokemonListItemBinding)
  }

  override fun onBindViewHolder(holder: PokemonTypeViewHolder, position: Int) = holder.bind(pokemonTypes[position])

  override fun setData(data: List<EnumPokemonType>) {
    if (!data.isNullOrEmpty()) {
      pokemonTypes.clear()
      pokemonTypes.addAll(data.toMutableList())
      notifyDataSetChanged()
    }
  }

  override fun getItemCount(): Int {
    return pokemonTypes.size
  }

  inner class PokemonTypeViewHolder(val pokemonListItemBinding: ViewPokemonTypeBinding) :
    RecyclerView.ViewHolder(pokemonListItemBinding.root) {
    fun bind(pokemonType: EnumPokemonType) {
      pokemonListItemBinding.pokemonType = pokemonType
      pokemonListItemBinding.executePendingBindings()
    }
  }

}