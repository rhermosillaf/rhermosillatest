package com.example.rhermosillatest.ui.productlist

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rhermosillatest.R
import kotlinx.android.synthetic.main.activity_productlist.*

class ProductListActivity : AppCompatActivity() {

    private lateinit var viewModel: ProductListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productlist)
        viewModel = ViewModelProvider(this)[ProductListViewModel::class.java]
        initUI()
    }

    private fun initUI(){
        productlistRecyclerView.layoutManager = LinearLayoutManager(this)
        productlistRecyclerView.adapter = ProductListAdapter{
            val intent = Intent(this, ProductListActivity::class.java)
            intent.putExtra("id", it)
            startActivity(intent)
        }
        viewModel.getProductList()
        viewModel.productList.observe(this, Observer { list ->
            (productlistRecyclerView.adapter as ProductListAdapter).setData(list)
        })

    }
}