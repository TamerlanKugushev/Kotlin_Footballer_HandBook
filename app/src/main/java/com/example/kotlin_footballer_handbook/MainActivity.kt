package com.example.kotlin_footballer_handbook

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private var adapter: MyAdapter? = null
    private var navigationView: NavigationView? = null
    private var recyclerView: RecyclerView? = null
    private var drawerLayout: DrawerLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigationView = findViewById(R.id.navigation_view)
        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView?.setNavigationItemSelectedListener(this)
        recyclerView = findViewById(R.id.rcView)
        var list = ArrayList<ListItem>()
        list.addAll(
            fillArrays(
                resources.getStringArray(R.array.football_clubs),
                resources.getStringArray(R.array.football_clubs_content),
                getImageId(R.array.football_clubs_image_array)
            )
        )




        adapter = MyAdapter(list, this)
        recyclerView?.adapter = adapter
        recyclerView?.setHasFixedSize(true)
        recyclerView?.layoutManager = LinearLayoutManager(this)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.football_clubs -> {
                Toast.makeText(this, "Football clubs", Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(
                    fillArrays(
                        resources.getStringArray(R.array.football_clubs),
                        resources.getStringArray(R.array.football_clubs_content),
                        getImageId(R.array.football_clubs_image_array)
                    )
                )
            }
            R.id.football_teams -> {
                Toast.makeText(this, "Football teams", Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(
                    fillArrays(
                        resources.getStringArray(R.array.football_teams),
                        resources.getStringArray(R.array.football_teams_content),
                        getImageId(R.array.football_teams_image_array)
                    )
                )
            }
            R.id.football_players -> Toast.makeText(this, "Bayern", Toast.LENGTH_SHORT).show()
            R.id.football_awards -> Toast.makeText(this, "Juventus", Toast.LENGTH_SHORT).show()
        }
        drawerLayout?.closeDrawer(GravityCompat.START)

        return true
    }

    fun fillArrays(
        titleArray: Array<String>,
        contentArray: Array<String>,
        imageArray: IntArray
    ): List<ListItem> {
        var listItemArray = ArrayList<ListItem>()
        for (i in titleArray.indices) {
            var listItem = ListItem(imageArray[i], titleArray[i], contentArray[i])
            listItemArray.add(listItem)

        }
        return listItemArray
    }

    fun getImageId(imageArrayId: Int): IntArray {
        var tArray: TypedArray = resources.obtainTypedArray(imageArrayId)
        val count = tArray.length()
        val ids = IntArray(count)
        for (i in ids.indices) {
            ids[i] = tArray.getResourceId(i, 0)
        }
        tArray.recycle()
        return ids
    }


}