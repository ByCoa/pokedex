package coa.elvis.pokedex.features.home

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import coa.elvis.pokedex.R
import coa.elvis.pokedex.common.base.BaseActivity
import coa.elvis.pokedex.common.networking.response.Pokemon
import coa.elvis.pokedex.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeActivity : BaseActivity() {

  private val homeViewModel: HomeViewModel by viewModel()
  lateinit var adapter: PokemonListAdapter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    val activityMainBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

    // bind RecyclerView
    val recyclerView = activityMainBinding.rvPokemons
    recyclerView.layoutManager = LinearLayoutManager(this)
    recyclerView.setHasFixedSize(true)
    adapter = PokemonListAdapter()
    recyclerView.adapter = adapter
    homeViewModel.start()
    //setAdapter()
    setObservers()
  }

  fun setObservers() {
    homeViewModel.pokemonsMutableLiveData.observe(
      this,
      Observer<List<Pokemon>> { pokemons: List<Pokemon> -> adapter.setupList(pokemons) })
  }

  fun setAdapter() {
    adapter = PokemonListAdapter()

  }

  override fun getToolbarActionImage(): Int = 0

  override fun onToolbarActionClick() {}

  override fun getToolbarTitle(): Int = R.string.app_name
}
