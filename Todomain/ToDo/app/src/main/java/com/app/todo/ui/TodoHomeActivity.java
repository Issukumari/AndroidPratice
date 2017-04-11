package com.app.todo.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.app.todo.Fragment.NoteFragment;
import com.app.todo.R;
import com.app.todo.adapter.RecyclerAdapter;
import com.app.todo.base.BaseActivity;

import java.util.ArrayList;


public class TodoHomeActivity extends BaseActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {
    RecyclerView.LayoutManager layoutManager;
    boolean isGrid = true;
    Toolbar toolbar;
    DrawerLayout drawer;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    public static int navItemIndex = 0;
    RecyclerAdapter recyclerAdapter;
    ArrayList<String> data = new ArrayList<>();
    FloatingActionButton fab;
    private RecyclerView recyclerView;
    private AlertDialog.Builder alertDialog;
    private EditText et_Notes;
    private int edit_position;
    private View view;
    private boolean add = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);
        if (savedInstanceState == null) {
            navItemIndex = 0;
        initView();
        initDialog();

    }
    }

    @Override
    public void initView() {
        fab = (FloatingActionButton) findViewById(R.id.fab_button);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.Open_navigation_drawer, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerAdapter = new RecyclerAdapter(this, data);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerAdapter.notifyDataSetChanged();
        initSwipe();
        setListeners();
    }

    @Override
    public void setListeners() {
        fab.setOnClickListener(this);

    }

    private void initSwipe() {
        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();

                if (direction == ItemTouchHelper.LEFT) {
                    recyclerAdapter.removeItem(position);
                } else {
                    removeView();
                    edit_position = position;
                    alertDialog.setTitle("Edit Country");
                    et_Notes.setText(data.get(position));
                    alertDialog.show();
                }
            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    private void removeView() {
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    private void initDialog() {
        alertDialog = new AlertDialog.Builder(this);
        view = getLayoutInflater().inflate(R.layout.todoswipenote, null);
        et_Notes = (EditText) view.findViewById(R.id.et_Title);
        alertDialog.setView(view);
        alertDialog.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (add) {
                    add = false;
                    recyclerAdapter.addItem(et_Notes.getText().toString());
                    dialog.dismiss();
                } else {
                    data.set(edit_position, et_Notes.getText().toString());
                    recyclerAdapter.notifyDataSetChanged();
                    dialog.dismiss();
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fab_button:
                removeView();
                add = true;
                alertDialog.setTitle("Add Notes");
                et_Notes.setText("");
                alertDialog.show();
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.show_as_view:
                if (!isGrid) {
                    recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
                    isGrid = true;
                } else {
                    recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
                    isGrid = false;
                }
                Toast.makeText(this, "item Selectd", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.nav_Notes:
                navItemIndex = 0;
                toolbar.setTitle("Notes");
               /* NoteFragment fragment=new NoteFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragment).commit();*/
                // getSupportFragmentManager().beginTransaction().replace(R.id.recyclerview,fragment).commit();
                // drawer.closeDrawers();
                return true;
            case R.id.nav_Reminders:
                navItemIndex = 1;
                toolbar.setTitle("Remainders");

                return true;
            case R.id.nav_Createnewlabel:
                navItemIndex = 2;
                toolbar.setTitle("CreatenewLabel");

                return true;
            case R.id.nav_Archive:
                navItemIndex = 3;
                toolbar.setTitle("Archive");
                return true;
            case R.id.nav_Deleted:
                navItemIndex = 4;
                toolbar.setTitle("deleted");
            case R.id.nav_Settings:
                navItemIndex = 5;
                toolbar.setTitle("Settings");
            case R.id.Logout:
                navItemIndex = 5;
                Intent intent=new Intent(TodoHomeActivity.this,LoginActivity.class);
                startActivity(intent);
            default:
                navItemIndex = 0;
                return true;
        }

    }



}