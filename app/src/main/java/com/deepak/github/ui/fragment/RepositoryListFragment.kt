package com.deepak.github.ui.fragment


import android.app.SearchManager
import android.arch.lifecycle.Observer
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SearchView
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import com.deepak.github.R
import com.deepak.github.data.local.entity.RepositoryEntity
import com.deepak.github.data.remote.Status
import com.deepak.github.databinding.FragmentTrendingReposBinding
import com.deepak.github.ui.adaptor.RepositoryListAdapter
import com.deepak.github.ui.base.BaseFragment
import com.deepak.github.ui.callbacks.RepositoryListCallback
import com.deepak.github.viewmodel.RepositoryListViewModel
import javax.inject.Inject


class RepositoryListFragment : BaseFragment<RepositoryListViewModel, FragmentTrendingReposBinding>(),
    RepositoryListCallback {

    @Inject
    override fun getViewModel() = (RepositoryListViewModel::class.java)

    override val layoutRes: Int
        get() = R.layout.fragment_trending_repos

    var repositoryListAdapter: RepositoryListAdapter? = null

    override fun onRepositoryClicked(repositoryEntity: RepositoryEntity?) {

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        //setHasOptionsMenu(true)
        dataBinding?.recyclerView?.setLayoutManager(LinearLayoutManager(getActivity()))
        repositoryListAdapter = RepositoryListAdapter(this)
        dataBinding?.recyclerView?.setAdapter(repositoryListAdapter)
        return dataBinding?.getRoot()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        viewModel?.getTendingRepositories()?.observe(this, Observer { listResource ->

            if (null != listResource && (listResource.status === Status.ERROR || listResource.status === Status.SUCCESS)) {
                dataBinding?.loadingProgress?.setVisibility(View.GONE)
            }
            listResource?.data?.let {
                repositoryListAdapter?.setData(it)
            }

            Log.i("DEEPAK", "sd" + listResource.toString())
        })

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        if (null == getActivity())
            return

       /* val searchView: SearchView
        getActivity().getMenuInflater().inflate(R.menu.menu_main, menu)

        // Associate searchable configuration with the SearchView
        val searchManager = getActivity().getSystemService(Context.SEARCH_SERVICE) as SearchManager
        searchView = menu.findItem(R.id.action_search)
            .actionView as SearchView

        searchView.setSearchableInfo(
            searchManager
                .getSearchableInfo(getActivity().getComponentName())
        )
        searchView.maxWidth = Integer.MAX_VALUE

        // listening to search query text change
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                // filter recycler view when query submitted
                if (null != dataBinding.recyclerView.getAdapter())
                    (dataBinding.recyclerView.getAdapter() as ArticleListAdapter).getFilter().filter(
                        query
                    )
                return false
            }

            override fun onQueryTextChange(query: String): Boolean {
                // filter recycler view when text is changed
                if (null != dataBinding.recyclerView.getAdapter())
                    (dataBinding.recyclerView.getAdapter() as ArticleListAdapter).getFilter().filter(
                        query
                    )
                return false
            }
        })*/
        super.onCreateOptionsMenu(menu, inflater)
    }


   /* override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //val id = item.itemId


        return if (id == R.id.action_search) {
            true
        } else super.onOptionsItemSelected(item)

    }
*/
    companion object {

        fun newInstance(): RepositoryListFragment {
            val args = Bundle()
            val fragment = RepositoryListFragment()
            fragment.setArguments(args)
            return fragment
        }
    }
}
