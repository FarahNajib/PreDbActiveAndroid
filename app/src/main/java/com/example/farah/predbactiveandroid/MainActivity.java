package com.example.farah.predbactiveandroid;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import com.activeandroid.query.Select;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    Toolbar toolbar;


    private RecyclerView mRecycleView;
    public   List<Itemd> allItems ;
    private NavigationView navigationView;
    ContentAdapter Adpterff;

    private DrawerLayout mDrawerLayout;
    ArrayList<Itemd> addListedItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        allItems = prepareDBData();// retrive data from sqlite DB
        addListedItems = new ArrayList<>();
        for (int i = 0; i < allItems.size(); i++) {
            Itemd inventory = allItems.get(i);
            addListedItems.add(allItems.get(i));
        }
        mRecycleView =(RecyclerView)findViewById(R.id.recycler_view1);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);

        Adpterff= new ContentAdapter(this,addListedItems);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecycleView.setLayoutManager(mLayoutManager);
        mRecycleView.setAdapter(Adpterff);
        initToolBar();


        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
           /* VectorDrawableCompat indicator
                    = VectorDrawableCompat.create(getResources(), R.drawable.ic_menu, getTheme());*/

            supportActionBar.setHomeAsUpIndicator( R.drawable.ic_menu);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }

    }


    //----------------------------------------------------------------------------------
    private List<Itemd> prepareDBData()   //method(1)  to retrive all data from sqliteDB
    {
        return new Select()
            .from(Itemd.class)
            .orderBy("namef ASC")
            .execute();
    }

  //--------------------------------------------------------------------------------------
    public void initToolBar() //instantiate toolbar
    {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

  //-------------------------------------------------------------------------------------






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.actiontoolbutton, menu);
        final MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(this);

        return true;
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newText=newText.toLowerCase();
        ArrayList<Itemd> newlist= new ArrayList<>();
        for(Itemd searchitem : addListedItems)

        {
            String nn = searchitem.namef.toLowerCase();


            if (nn.contains(newText)) {
                //ADD PLAYER TO FILTERED PLAYERS
                newlist.add(searchitem);

            }


        }
        Adpterff.setFilter(newlist);
        return  false ;
    }
}
