package coa.elvis.pokedex.features.home

import android.os.Bundle
import coa.elvis.pokedex.R
import coa.elvis.pokedex.common.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : BaseActivity() {

  private val homeViewModel: HomeViewModel by viewModel()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    homeViewModel.fetchPokemon("1")
  }

  override fun getToolbarActionImage(): Int = 0

  override fun onToolbarActionClick() {}

  override fun getToolbarTitle(): Int = R.string.app_name
}
