package com.example.rhermosillatest.ui.productlist

import android.net.Uri
import android.view.LayoutInflater

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rhermosillatest.R
import com.example.rhermosillatest.model.api.ProductApiResponse
import com.example.rhermosillatest.model.api.ProductResult
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.card_product_search.view.*

class ProductListAdapter(val productClick: (Int) -> Unit): RecyclerView.Adapter<ProductListAdapter.SearchViewHolder>() {
    var productList: List<ProductResult> = emptyList<ProductResult>()

    fun setData(list: List<ProductResult>){
        productList = list
        notifyDataSetChanged()
    }

    fun addProduct(list: List<ProductResult>) {
        val productList: MutableList<ProductApiResponse>

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_product_search, parent,false))
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val product = productList[position]

        holder.itemView.priceText.text = "${product.price} Cents"// - ${product.title}    ${product.price}"
        holder.itemView.titleText.text = "${product.title}"
        Picasso.get().load(product.image).into(holder.itemView.productImage)


    }

    class SearchViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)


}