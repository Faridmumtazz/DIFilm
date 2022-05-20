package mumtaz.binar.difilm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import mumtaz.binar.difilm.R
import mumtaz.binar.difilm.adapter.NewsAdapter
import mumtaz.binar.difilm.viewmodel.ViewModelNews

class MainActivity : AppCompatActivity() {
    lateinit var adapternews : NewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapternews = NewsAdapter()

        rv_news.layoutManager = LinearLayoutManager(this)
        rv_news.adapter = adapternews

        getDataNews()
    }

    fun getDataNews(){
        val viewModel = ViewModelProvider(this).get(ViewModelNews::class.java)
        viewModel.getLiveDataObserver().observe(this, Observer {
            if (it != null) {
                adapternews.setDataNews(it)
                adapternews.notifyDataSetChanged()
            }
        })
        viewModel.getApiNews()
    }
}