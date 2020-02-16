package com.deepak.github.ui.adaptor

import android.graphics.drawable.GradientDrawable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import com.deepak.github.R
import com.deepak.github.data.local.entity.RepositoryEntity
import com.deepak.github.databinding.ItemRepositoryBinding
import com.deepak.github.ui.base.BaseAdapter
import com.deepak.github.ui.callbacks.RepositoryListCallback

import java.util.ArrayList


class RepositoryListAdapter(private val repositoryListCallback: RepositoryListCallback) :
    BaseAdapter<RepositoryListAdapter.RepositoryViewHolder, RepositoryEntity>(), Filterable {


    private var repositoryEntities: List<RepositoryEntity>? = null

    private var repositoryEntitiesFiltered: List<RepositoryEntity>? = null

    override fun getItemCount() = repositoryEntitiesFiltered?.size ?: 0


    init {
        repositoryEntities = ArrayList<RepositoryEntity>()
        repositoryEntitiesFiltered = ArrayList<RepositoryEntity>()
    }

    override fun setData(entities: List<RepositoryEntity>) {
        this.repositoryEntities = entities
        this.repositoryEntitiesFiltered = entities
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): RepositoryViewHolder {
        return RepositoryViewHolder.create(
            LayoutInflater.from(viewGroup.context),
            viewGroup,
            repositoryListCallback
        )
    }

    override fun onBindViewHolder(viewHolder: RepositoryViewHolder, position: Int) {
        viewHolder.onBind(getItem(position))
    }

    fun getItem(position: Int) : RepositoryEntity {
        return repositoryEntities!!.get(position)
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(charSequence: CharSequence): Filter.FilterResults {
                val charString = charSequence.toString()
                if (charString.isEmpty()) {
                    repositoryEntitiesFiltered = repositoryEntities
                } else {
                    val filteredList = ArrayList<RepositoryEntity>()
                    for (row in repositoryEntities!!) {


                    }

                    repositoryEntitiesFiltered = filteredList
                }

                val filterResults = Filter.FilterResults()
                filterResults.values = repositoryEntitiesFiltered
                return filterResults
            }

            override fun publishResults(
                charSequence: CharSequence,
                filterResults: Filter.FilterResults
            ) {
                repositoryEntitiesFiltered = filterResults.values as ArrayList<RepositoryEntity>
                notifyDataSetChanged()
            }
        }
    }

    class RepositoryViewHolder private constructor(
        var binding: ItemRepositoryBinding,
        callback: RepositoryListCallback
    ) : RecyclerView.ViewHolder(binding.getRoot()) {

       companion object {
           fun create(
               inflater: LayoutInflater,
               parent: ViewGroup,
               callback: RepositoryListCallback
           ): RepositoryViewHolder {
               val itemMovieListBinding = ItemRepositoryBinding.inflate(inflater, parent, false)
               return RepositoryViewHolder(itemMovieListBinding, callback)
           }
       }

        init {
            binding.getRoot()
                .setOnClickListener({ v -> callback.onRepositoryClicked(binding.repository) })
        }

        fun onBind(repostoryEntity: RepositoryEntity) {
            binding.repository = repostoryEntity
            binding.itemTitle.setText(repostoryEntity.name)
            binding.itemDesc.setText(repostoryEntity.description)
            binding.itemStars.setText(repostoryEntity.stars.toString() + " stars")


            binding.itemLanguage.setText(repostoryEntity.language)



            binding.executePendingBindings()
        }
    }
}
