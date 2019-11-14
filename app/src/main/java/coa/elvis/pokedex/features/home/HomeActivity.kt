package coa.elvis.pokedex.features.home

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import coa.elvis.pokedex.R
import coa.elvis.pokedex.common.base.BaseActivity
import coa.elvis.pokedex.common.networking.response.Pokemon
import coa.elvis.pokedex.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeActivity : BaseActivity() {
  //Changes
  private val homeViewModel: HomeViewModel by viewModel()
  lateinit var adapter: PokemonListAdapter
  lateinit var activityMainBinding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    setAdapter(activityMainBinding.rvPokemons)
    homeViewModel.start()
    setObservers()
  }

  fun setAdapter(recyclerView: RecyclerView) {
    adapter = PokemonListAdapter()
    recyclerView.adapter = adapter
  }

  fun setObservers() {
    homeViewModel.pokemonsMutableLiveData.observe(
      this,
      Observer<List<Pokemon>> { pokemons: List<Pokemon> -> adapter.setData(pokemons) })
  }


  override fun getToolbarActionImage(): Int = 0

  override fun onToolbarActionClick() {}

  override fun getToolbarTitle(): Int = R.drawable.img_logo_pokedex
}
