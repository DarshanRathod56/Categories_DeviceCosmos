package devicecosmos.com.categoreis;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ArrayList<ExampleItem> examplelist;
    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createRecyclerView();
        buildRecyclerView();

    }
    private void createRecyclerView() {
        examplelist = new ArrayList<>();
        examplelist.add(new ExampleItem("   All Blogs"));
        examplelist.add(new ExampleItem("   Weekly Tech Update"));
        examplelist.add(new ExampleItem("   New launch"));
        examplelist.add(new ExampleItem("   Trending"));
        examplelist.add(new ExampleItem("   Deals"));
        examplelist.add(new ExampleItem("   Blogs and News"));
        examplelist.add(new ExampleItem("   Apps"));
        examplelist.add(new ExampleItem("   Review"));
        examplelist.add(new ExampleItem("   Tips and Tricks"));
    }

    private void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.list1);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(examplelist);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new ExampleAdapter.onItemClickedListener() {
            @Override
            public void onItemClicked(int position) {
                Intent intent=new Intent(MainActivity.this,Trial.class);
                intent.putExtra("Positions",position);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }




}
