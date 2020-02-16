package com.deepak.github.ui.adaptor

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import com.deepak.github.data.local.entity.DeveloperEntity
import com.deepak.github.databinding.ItemDeveloperBinding
import com.deepak.github.ui.base.BaseAdapter
import com.deepak.github.ui.callbacks.DeveloperListCallback

import java.util.ArrayList


class DeveloperListAdapter(private val developerListCallback: DeveloperListCallback) :
    BaseAdapter<DeveloperListAdapter.DeveloperViewHolder, DeveloperEntity>(), Filterable {


    private var developerEntities: List<DeveloperEntity>? = null

    private var developerEntitiesFiltered: List<DeveloperEntity>? = null

    override fun getItemCount() = developerEntitiesFiltered?.size ?: 0


    init {
        developerEntities = ArrayList<DeveloperEntity>()
        developerEntitiesFiltered = ArrayList<DeveloperEntity>()
    }

    override fun setData(entities: List<DeveloperEntity>) {
        this.developerEntities = entities
        this.developerEntitiesFiltered = entities
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): DeveloperViewHolder {
        return DeveloperViewHolder.create(
            LayoutInflater.from(viewGroup.context),
            viewGroup,
            developerListCallback
        )
    }

    override fun onBindViewHolder(viewHolder: DeveloperViewHolder, position: Int) {
        viewHolder.onBind(getItem(position))
    }

    fun getItem(position: Int) : DeveloperEntity {
        return developerEntities!!.get(position)
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(charSequence: CharSequence): Filter.FilterResults {
                val charString = charSequence.toString()
                if (charString.isEmpty()) {
                    developerEntitiesFiltered = developerEntities
                } else {
                    val filteredList = ArrayList<DeveloperEntity>()
                    for (row in developerEntities!!) {


                    }

                    developerEntitiesFiltered = filteredList
                }

                val filterResults = Filter.FilterResults()
                filterResults.values = developerEntitiesFiltered
                return filterResults
            }

            override fun publishResults(
                charSequence: CharSequence,
                filterResults: Filter.FilterResults
            ) {
                developerEntitiesFiltered = filterResults.values as ArrayList<DeveloperEntity>
                notifyDataSetChanged()
            }
        }
    }

    class DeveloperViewHolder private constructor(
        var binding: ItemDeveloperBinding,
        callback: DeveloperListCallback
    ) : RecyclerView.ViewHolder(binding.getRoot()) {

       companion object {
           fun create(
               inflater: LayoutInflater,
               parent: ViewGroup,
               callback: DeveloperListCallback
           ): DeveloperViewHolder {
               val itemDeveloperBinding = ItemDeveloperBinding.inflate(inflater, parent, false)
               return DeveloperViewHolder(itemDeveloperBinding, callback)
           }
       }

        init {
            binding.getRoot()
                .setOnClickListener({ v -> callback.onDeveloperClicked(binding.developer) })
        }

        fun onBind(developerEntity: DeveloperEntity) {
            binding.developer = developerEntity
            binding.itemTitle.setText(developerEntity.name)
            binding.itemUsername.setText(developerEntity.username)
            binding.executePendingBindings()
        }
    }
}
