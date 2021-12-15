package com.rahul.fetchaddress.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.rahul.fetchaddress.R
import com.rahul.fetchaddress.data.model.SearchResultResponse
import com.rahul.fetchaddress.data.model.Suggestions
import com.rahul.fetchaddress.data.remote.Resource
import com.rahul.fetchaddress.data.remote.Status
import com.rahul.fetchaddress.repo.MyRepo
import com.rahul.fetchaddress.viewmodel.MainViewModel
import com.rahul.fetchaddress.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewMode: MainViewModel
    lateinit var dataRepository: MyRepo
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dataRepository = MyRepo()

        val viewModeFact = ViewModelFactory(dataRepository)

        viewMode = ViewModelProviders.of(this, viewModeFact).get(MainViewModel::class.java)

        floating_search_view.setOnQueryChangeListener { oldQuery, newQuery ->
            loadData(newQuery, "")

        }

    }

private fun loadData(queryString: String, city: String) {

    viewMode.getMatchingAddress(queryString, city).observe(this, Observer {

        when (it.status) {

            Status.ERROR -> {
                Toast.makeText(applicationContext, "Network error", Toast.LENGTH_LONG).show()

            }

            Status.SUCCESS -> {

                floating_search_view.swapSuggestions(getSuggestions(it))

            }

            Status.LOADING -> {
                //progressBar.visibility = View.VISIBLE
            }
        }
    })
}

private fun getSuggestions(
    it: Resource<SearchResultResponse>
): ArrayList<Suggestions> {
    val suggestions = ArrayList<Suggestions>()
    val list = it.data?.data?.addressList
    list?.forEach {
        val s = Suggestions(it.addressString)
        suggestions.add(s)
    }
    return suggestions
}
}