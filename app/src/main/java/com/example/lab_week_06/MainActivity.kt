package com.example.lab_week_06

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
//import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.Gender

class MainActivity : AppCompatActivity() {
    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.recycler_view)
    }
    private val catAdapter by lazy {
        //Glide is used here to load the images
        //Here we are passing the onClickListener function to the Adapter
        CatAdapter(layoutInflater, GlideImageLoader(this), object:
            CatAdapter.OnClickListener {
            //When this is triggered, the pop up dialog will be shown
            override fun onItemClick(cat: CatModel) = showSelectionDialog(cat)
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Setup the adapter for the recycler view
        recyclerView.adapter = catAdapter

        //Setup the layout manager for the recycler view
        //A layout manager is used to set the structure of the item views
        //For this tutorial, we're using the vertical linear structure
        recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL, false
        )

        val itemTouchHelper = ItemTouchHelper(catAdapter.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

        //Add data to the model list in the adapter
        catAdapter.setData(
            listOf(
                CatModel(
                    Gender.Male,
                    CatBreed.BalineseJavanese,
                    "Fred",
                    "Silent and deadly",
                    "https://cdn2.thecatapi.com/images/7dj.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.ExoticShorthair,
                    "Wilma",
                    "Cuddly assassin",
                    "https://cdn2.thecatapi.com/images/egv.jpg"
                ),
                CatModel(
                    Gender.Unknown,
                    CatBreed.AmericanCurl,
                    "Curious George",
                    "Award winning investigator",
                    "https://cdn2.thecatapi.com/images/bar.jpg"
                ),
                CatModel(
                    Gender.Unknown,
                    CatBreed.AmericanCurl,
                    "Cat A",
                    "Cat A Bio",
                    "https://cdn2.thecatapi.com/images/2m1.jpg"
                ),
                CatModel(
                    Gender.Unknown,
                    CatBreed.AmericanCurl,
                    "Cat B",
                    "Cat B Bio",
                    "https://cdn2.thecatapi.com/images/8vm.jpg"
                ),
                CatModel(
                    Gender.Unknown,
                    CatBreed.AmericanCurl,
                    "Cat C",
                    "Cat C Bio",
                    "https://cdn2.thecatapi.com/images/abc.jpg"
                ),
                CatModel(
                    Gender.Unknown,
                    CatBreed.AmericanCurl,
                    "Cat D",
                    "Cat D Bio",
                    "https://cdn2.thecatapi.com/images/bcq.jpg"
                ),
                CatModel(
                    Gender.Unknown,
                    CatBreed.AmericanCurl,
                    "Cat E",
                    "Cat E Bio",
                    "https://cdn2.thecatapi.com/images/blj.jpg"
                ),
                CatModel(
                    Gender.Unknown,
                    CatBreed.AmericanCurl,
                    "Cat F",
                    "Cat F Bio",
                    "https://cdn2.thecatapi.com/images/bss.jpg"
                ),
                CatModel(
                    Gender.Unknown,
                    CatBreed.AmericanCurl,
                    "Cat G",
                    "Cat G Bio",
                    "https://cdn2.thecatapi.com/images/c8t.jpg"
                ),
                CatModel(
                    Gender.Unknown,
                    CatBreed.AmericanCurl,
                    "Cat H",
                    "Cat H Bio",
                    "https://cdn2.thecatapi.com/images/e04.jpg"
                ),
                CatModel(
                    Gender.Unknown,
                    CatBreed.AmericanCurl,
                    "Cat I",
                    "Cat I Bio",
                    "https://cdn2.thecatapi.com/images/MTU4MTUxMA.jpg"
                ),
                CatModel(
                    Gender.Unknown,
                    CatBreed.AmericanCurl,
                    "Cat J",
                    "Cat J Bio",
                    "https://cdn2.thecatapi.com/images/i-j1kCi3b.jpg"
                )
            )
        )

    }
    private fun showSelectionDialog(cat: CatModel) {
        AlertDialog.Builder(this)
//Set the title for the dialog
            .setTitle("Cat Selected")
//Set the message for the dialog
            .setMessage("You have selected cat ${cat.name}")
//Set if the OK button should be enabled
            .setPositiveButton("OK") { _, _ -> }.show()
    }
}