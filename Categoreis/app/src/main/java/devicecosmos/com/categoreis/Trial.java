package devicecosmos.com.categoreis;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

public class Trial extends AppCompatActivity {
    private List<BlogDownload> displayResultList;
    ArrayList<String> resultTitle,resultDate,resultDetails,resultReadMore,resultTags,resultImageUrl;
    int i=0;
    int pos;
    int a;
    int step=1;
    String proper;
    int temp=-1;
    String[] dataArr;
    Toolbar toolbar;
    private List<BlogDownload> mUploads;
    boolean searchViewEnable;
    ArrayList<String>blogID;
    RecyclerView mRecyclerView;
    String[] links;
    String[] youtubeLink;
    ArrayList<Upload>blogging;
    ArrayList <Upload> blog;
    ArrayList<BlogDownload>proceedingArrayListFull;
    private UploadAdapter mAdapter;
    private DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
    public Trial() {

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trial);
        links = new String[500];
        youtubeLink = new String[500];
        proceedingArrayListFull = new ArrayList<>();
        blogID= new ArrayList<>();
        blogging = new ArrayList<>();
        mUploads = new ArrayList<>();

        blog = new ArrayList<>();
        toolbar=(Toolbar)findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView1);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        Toast.makeText(Trial.this,"Loading...",Toast.LENGTH_SHORT).show();

        displayMethod();
        findViewById(R.id.rel1).requestFocus();
        closeKeyboard();
    }
    private void displayMethod() {
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("uploads");
        databaseReference.keepSynced(true);
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    blogging.add(ds.getValue(Upload.class));
                    a=blogging.size();
                }
                int count=0;
                for (DataSnapshot ds: dataSnapshot.getChildren())
                {
                    blog.add(ds.getValue(Upload.class));
                    count++;
                    if (count==a)
                    {
                        String idOrDomain=" ";
                        Intent intent=getIntent();
                        pos=intent.getIntExtra("Positions",0);
                        if (pos==0)
                            idOrDomain="All";
                        if (pos==1)
                            idOrDomain="Weekly Tech Update";
                        if (pos==2)
                            idOrDomain="New Launch";
                        if (pos==3)
                            idOrDomain="Trending";
                        if (pos==4)
                            idOrDomain="Deals";
                        if (pos==5)
                            idOrDomain="Blogs and News";
                        if (pos==6)
                            idOrDomain="Apps";
                        if (pos==7)
                            idOrDomain="Review";
                        if (pos==8)
                            idOrDomain="Tips and Tricks";



                        links = new String[500];
                        youtubeLink = new String[500];
                        displayResultList = new ArrayList<>();

                        if(idOrDomain == null)
                            idOrDomain = "445sdsd";

                        resultTitle = new ArrayList();
                        resultDate = new ArrayList();
                        resultDetails = new ArrayList();
                        resultReadMore = new ArrayList();
                        resultTags = new ArrayList();
                        resultImageUrl = new ArrayList();

                        linkInitialse();

                        for(Upload p: blogging)
                        {
                            if (p.getTags().toString().toLowerCase().contains(idOrDomain.toLowerCase()))
                            {
                                resultTitle.add(p.getTitle());
                                resultDate.add(p.getDate());
                                resultDetails.add(p.getDetails());
                                resultImageUrl.add(p.getImageURL());
                                resultReadMore.add(p.getBlogID());
                                links[i]=p.getBlogID();
                                youtubeLink[i]=p.getYouTubelink();
                                i+=1;
                                BlogDownload see1=new BlogDownload(
                                        p.getTitle(),
                                        p.getDate(),
                                        "Read More...",
                                        p.getDetails(),
                                        p.getImageURL(),
                                        "see on Youtube",
                                        p.getTime()
                                );
                                displayResultList.add(see1);
                            }
                        }
                        mAdapter = new UploadAdapter(Trial.this,displayResultList);
                        mRecyclerView.setAdapter(mAdapter);
                        method();
                    }
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    public void method() {
        mAdapter.setOnItemClickListener(new UploadAdapter.OnItemClickListener() {
            @Override
            public void onReadClicked(int position) {
                int j;
                Log.d("asdfg"," "+position);
                Log.d("asdfg"," "+links[position]);
                for(j=0;j<50;j++)
                {
                    if (links[position].equals("37"))
                    {
                        Intent intent37 = new Intent(Trial.this, OppoFSeven.class);
                        startActivity(intent37);
                        finish();
                        break;
                    }
                    if (links[position].equals("36"))
                    {
                        Intent intent36 = new Intent(Trial.this, OnePlusSix.class);
                        startActivity(intent36);
                        finish();
                        break;
                    }
                    if (links[position].equals("35"))
                    {
                        Intent intent35 = new Intent(Trial.this, FacebookProtection.class);
                        startActivity(intent35);
                        finish();
                        break;
                    }
                    if (links[position].equals("34"))
                    {
                        Intent intent35 = new Intent(Trial.this, MIUI.class);
                        startActivity(intent35);
                        finish();
                        break;
                    }
                    if (links[position].equals("33"))
                    {
                        Intent intent35 = new Intent(Trial.this, GoogleActivity.class);
                        startActivity(intent35);
                        finish();
                        break;
                    }
                    if (links[position].equals("32"))
                    {
                        Intent intent35 = new Intent(Trial.this, Whatsapp.class);
                        startActivity(intent35);
                        finish();
                        break;
                    }
                    if (links[position].equals("31"))
                    {
                        Intent intent35 = new Intent(Trial.this, Irctc.class);
                        startActivity(intent35);
                        finish();
                        break;
                    }
                    if (links[position].equals("30"))
                    {
                        Intent intent35 = new Intent(Trial.this, PasswordActivity.class);
                        startActivity(intent35);
                        finish();
                        break;
                    }
                    if (links[position].equals("29"))
                    {
                        Intent intent35 = new Intent(Trial.this, Deals.class);
                        startActivity(intent35);
                        finish();
                        break;
                    }
                    if (links[position].equals("28"))
                    {
                        Intent intent35 = new Intent(Trial.this, MessagingAct.class);
                        startActivity(intent35);
                        finish();
                        break;
                    }
                    if (links[position].equals("27"))
                    {
                        Intent intent35 = new Intent(Trial.this, Samsung.class);
                        startActivity(intent35);
                        finish();
                        break;
                    }
                    break;
                }
            }
            @Override
            public void onYoutubeClicked(int position) {
                Intent i=new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(youtubeLink[position]));
                startActivity(Intent.createChooser(i,""));
            }

        });
    }
    public void linkInitialse(){
        i=0;
        for (i=0;i<50;i++)
        {
            links[i]="900";
        }
        i=0;
    }
    public void closeKeyboard() {
        View view=findViewById(android.R.id.content);
        if(view!=null)
        {
            InputMethodManager inm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            inm.hideSoftInputFromWindow( view.getWindowToken(),0);

        }
    }
    public void search(String idOrDomain,String proper) {
        links = new String[500];
        youtubeLink = new String[500];
        blogID.clear();
        displayResultList = new ArrayList<>();

        if (idOrDomain == null)
            idOrDomain = "445sdsd";

        resultTitle = new ArrayList();
        resultDate = new ArrayList();
        resultDetails = new ArrayList();
        resultReadMore = new ArrayList();
        resultTags = new ArrayList();
        resultImageUrl = new ArrayList();
        linkInitialse();
        Intent intent=getIntent();
        pos=intent.getIntExtra("Positions",0);

        if (pos==0)
        {
            temp=0;
        }
        if (pos==1)
        {
            temp=1;
        }
        if (pos==2)
        {
            temp=2;
        }
        if (pos==3)
        {
            temp=3;
        }
        if (pos==4)
        {
            temp=4;
        }
        if (pos==5)
        {
            temp=5;
        }
        if (pos==6)
        {
            temp=6;
        }
        if (pos==7)
        {
            temp=7;
        }
        if (pos==8)
        {
            temp=8;
        }
        for (Upload p : blog) {
            Log.d("In search for loop"," "+pos);
            if (temp == 0) {
                if (p.getTags().toString().toLowerCase().contains(idOrDomain.toLowerCase()) && p.getTags().toString().toLowerCase().contains("All Blogs".toLowerCase())) {
                    resultTitle.add(p.getTitle());
                    resultDate.add(p.getDate());
                    resultDetails.add(p.getDetails());
                    resultImageUrl.add(p.getImageURL());
                    resultReadMore.add(p.getBlogID());
                    links[i] = p.getBlogID();
                    youtubeLink[i] = p.getYouTubelink();
                    i += 1;
                    BlogDownload see1 = new BlogDownload(
                            p.getTitle(),
                            p.getDate(),
                            "Read More...",
                            p.getDetails(),
                            p.getImageURL(),
                            "see on Youtube",
                            p.getTime()
                    );
                    displayResultList.add(see1);
                }
            }
            if (temp == 1) {
                if (p.getTags().toString().toLowerCase().contains(idOrDomain.toLowerCase()) && p.getTags().toString().toLowerCase().contains("Weekly Tech Update".toLowerCase())) {
                    resultTitle.add(p.getTitle());
                    resultDate.add(p.getDate());
                    resultDetails.add(p.getDetails());
                    resultImageUrl.add(p.getImageURL());
                    resultReadMore.add(p.getBlogID());
                    links[i] = p.getBlogID();
                    youtubeLink[i] = p.getYouTubelink();
                    i += 1;
                    BlogDownload see1 = new BlogDownload(
                            p.getTitle(),
                            p.getDate(),
                            "Read More...",
                            p.getDetails(),
                            p.getImageURL(),
                            "see on Youtube",
                            p.getTime()
                    );
                    displayResultList.add(see1);
                }
            }
            if (temp == 2) {
                if (p.getTags().toString().toLowerCase().contains(idOrDomain.toLowerCase()) && p.getTags().toString().toLowerCase().contains("New Launch".toLowerCase())) {
                    resultTitle.add(p.getTitle());
                    resultDate.add(p.getDate());
                    resultDetails.add(p.getDetails());
                    resultImageUrl.add(p.getImageURL());
                    resultReadMore.add(p.getBlogID());
                    links[i] = p.getBlogID();
                    youtubeLink[i] = p.getYouTubelink();
                    i += 1;
                    BlogDownload see1 = new BlogDownload(
                            p.getTitle(),
                            p.getDate(),
                            "Read More...",
                            p.getDetails(),
                            p.getImageURL(),
                            "see on Youtube",
                            p.getTime()
                    );
                    displayResultList.add(see1);
                }
            }
            if (temp == 3) {
                if (p.getTags().toString().toLowerCase().contains(idOrDomain.toLowerCase()) && p.getTags().toString().toLowerCase().contains("Trending".toLowerCase())) {
                    resultTitle.add(p.getTitle());
                    resultDate.add(p.getDate());
                    resultDetails.add(p.getDetails());
                    resultImageUrl.add(p.getImageURL());
                    resultReadMore.add(p.getBlogID());
                    links[i] = p.getBlogID();
                    youtubeLink[i] = p.getYouTubelink();
                    i += 1;
                    BlogDownload see1 = new BlogDownload(
                            p.getTitle(),
                            p.getDate(),
                            "Read More...",
                            p.getDetails(),
                            p.getImageURL(),
                            "see on Youtube",
                            p.getTime()
                    );
                    displayResultList.add(see1);
                }
            }
            if (temp == 4) {
                if (p.getTags().toString().toLowerCase().contains(idOrDomain.toLowerCase()) && p.getTags().toString().toLowerCase().contains("Deals".toLowerCase())) {
                    resultTitle.add(p.getTitle());
                    resultDate.add(p.getDate());
                    resultDetails.add(p.getDetails());
                    resultImageUrl.add(p.getImageURL());
                    resultReadMore.add(p.getBlogID());
                    links[i] = p.getBlogID();
                    youtubeLink[i] = p.getYouTubelink();
                    i += 1;
                    BlogDownload see1 = new BlogDownload(
                            p.getTitle(),
                            p.getDate(),
                            "Read More...",
                            p.getDetails(),
                            p.getImageURL(),
                            "see on Youtube",
                            p.getTime()
                    );
                    displayResultList.add(see1);
                }
            }
            if (temp == 5) {
                if (p.getTags().toString().toLowerCase().contains(idOrDomain.toLowerCase()) && p.getTags().toString().toLowerCase().contains("Blogs and News".toLowerCase())) {
                    resultTitle.add(p.getTitle());
                    resultDate.add(p.getDate());
                    resultDetails.add(p.getDetails());
                    resultImageUrl.add(p.getImageURL());
                    resultReadMore.add(p.getBlogID());
                    links[i] = p.getBlogID();
                    youtubeLink[i] = p.getYouTubelink();
                    i += 1;
                    BlogDownload see1 = new BlogDownload(
                            p.getTitle(),
                            p.getDate(),
                            "Read More...",
                            p.getDetails(),
                            p.getImageURL(),
                            "see on Youtube",
                            p.getTime()
                    );
                    displayResultList.add(see1);
                }
            }
            if (temp == 6) {
                if (p.getTags().toString().toLowerCase().contains(idOrDomain.toLowerCase()) && p.getTags().toString().toLowerCase().contains("Apps".toLowerCase())) {
                    resultTitle.add(p.getTitle());
                    resultDate.add(p.getDate());
                    resultDetails.add(p.getDetails());
                    resultImageUrl.add(p.getImageURL());
                    resultReadMore.add(p.getBlogID());
                    links[i] = p.getBlogID();
                    youtubeLink[i] = p.getYouTubelink();
                    i += 1;
                    BlogDownload see1 = new BlogDownload(
                            p.getTitle(),
                            p.getDate(),
                            "Read More...",
                            p.getDetails(),
                            p.getImageURL(),
                            "see on Youtube",
                            p.getTime()
                    );
                    displayResultList.add(see1);
                }
            }
            if (temp == 7) {
                if (p.getTags().toString().toLowerCase().contains(idOrDomain.toLowerCase()) && p.getTags().toString().toLowerCase().contains("Review".toLowerCase())) {
                    resultTitle.add(p.getTitle());
                    resultDate.add(p.getDate());
                    resultDetails.add(p.getDetails());
                    resultImageUrl.add(p.getImageURL());
                    resultReadMore.add(p.getBlogID());
                    links[i] = p.getBlogID();
                    youtubeLink[i] = p.getYouTubelink();
                    i += 1;
                    BlogDownload see1 = new BlogDownload(
                            p.getTitle(),
                            p.getDate(),
                            "Read More...",
                            p.getDetails(),
                            p.getImageURL(),
                            "see on Youtube",
                            p.getTime()
                    );
                    displayResultList.add(see1);
                }
            }
            if (temp == 8) {
                if (p.getTags().toString().toLowerCase().contains(idOrDomain.toLowerCase()) && p.getTags().toString().toLowerCase().contains("Tips and Ticks".toLowerCase())) {
                    resultTitle.add(p.getTitle());
                    resultDate.add(p.getDate());
                    resultDetails.add(p.getDetails());
                    resultImageUrl.add(p.getImageURL());
                    resultReadMore.add(p.getBlogID());
                    links[i] = p.getBlogID();
                    youtubeLink[i] = p.getYouTubelink();
                    i += 1;
                    BlogDownload see1 = new BlogDownload(
                            p.getTitle(),
                            p.getDate(),
                            "Read More...",
                            p.getDetails(),
                            p.getImageURL(),
                            "see on Youtube",
                            p.getTime()
                    );
                    displayResultList.add(see1);
                }
            }
            mAdapter = new UploadAdapter(Trial.this, displayResultList);
            mRecyclerView.setAdapter(mAdapter);
            step = 2;
            method();
        }
    }
    @Override
    public void onBackPressed() {
        if (step==2)
        {
            Intent intent = new Intent(Trial.this,MainActivity.class);
            startActivity(intent);
            finish();
            step=1;
        }
        finish();
        super.onBackPressed();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the search menu action bar.
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.material_search, menu);

        // Get the search menu.
        MenuItem searchMenu = menu.findItem(R.id.app_bar_menu);

        // Get SearchView object.
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchMenu);

        // Get SearchView autocomplete object.
        final SearchView.SearchAutoComplete searchAutoComplete = (SearchView.SearchAutoComplete)searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);
        searchAutoComplete.setBackgroundColor(Color.WHITE);
        searchAutoComplete.setTextColor(Color.BLACK);
        searchAutoComplete.setDropDownBackgroundResource(android.R.color.white);

        // Create a new ArrayAdapter and add data to search auto complete object.
        Intent intent=getIntent();
        pos=intent.getIntExtra("Positions",0);
        Log.d("Position new:","pos. = "+pos);
        if (pos==0)
        {
            dataArr =new String[] {"Mobile ","phone ","oppo ","oppo f7 ","android 8.1 "
                    ,"oreo ","₹20000 to $60000 mobiles ","25MP camera ","16MP camera "
                    ,"oneplus ","oneplus 6 ","20MP camera ","₹35000-45000 mobile ","android 8"
                    ,"facebook ","protection ","data ","personal ","applications ","MIUI "
                    , "MIUI 9.5 ","nougat ","clash royale ","google ","google play instant"
                    , "whatsapp ","new features ","indian railway ","rail ","irctc ","aadhar ","train tickets "
                    ,"password ","otp ", "flipkart ","amazon ","online shopping ","play store "
                    , "Messaging ", "News ", "Cricket Score ", "samsung ","apps "};
            temp=0;
            proper="Weekly Tech Update";
        }
        if (pos==1)
        {
            dataArr =new String[] {"Mobile ","phone ","oppo ","oppo f7 ","android 8.1 ","oreo "
                    ,"₹20000 to $60000 mobiles ","25MP camera ","16MP camera "};
            temp=1;
            proper="Weekly Tech Update";
        }
        if (pos==2)
        {
            dataArr = new String[]{"Mobile ","phone ","oppo ","oppo f7 ","android 8.1 ","oreo "
                    ,"₹20000 to $60000 mobiles ","25MP camera ","16MP camera ", "oneplus ","oneplus 6 "
                    ,"20MP camera ","₹35000-45000 mobile ","android 8 ", "MIUI ", "MIUI 9.5 ","nougat "};
            temp=2;
            proper="New Launch";
        }
        if (pos==3)
        {
            dataArr = new String[]{"facebook ","protection ","data ","personal ","applications ", "password ", "otp "};
            temp=3;
            proper="Trending";
        }
        if (pos==4)
        {
            dataArr =new String[] {"flipkart ","amazon ","online shopping ","play store "};
            temp=4;
            proper="Deals";
        }
        if (pos==5)
        {
            dataArr =new String[] {"whatsapp ","new features ", "indian railway ","irctc ","aadhar "
                    ,"train tickets ", "Messaging ", "News ", "Cricket Score ", "Rail Info without DATA. "
                    , "samsung ","apps ","play store "};
            temp=5;
            proper="Blogs and News";
        }
        if (pos==6)
        {
            dataArr =new String[] {"facebook ","protection ","data ","personal ","applications "
                    , "clash royale ","google ","google play instant ", "whatsapp "
                    ,"new features ", "Messaging ", "News ", "Cricket Score "};
            temp=6;
            proper="Apps";
        }
        if (pos==7)
        {
            dataArr =new String[] {"Mobile ","phone ","oppo ","oppo f7 ","android 8.1 ","oreo "
                    ,"₹20000 to $60000 mobiles ","25MP camera ","16MP camera ", "oneplus ","oneplus 6 "
                    ,"20MP camera ","₹35000-45000 mobile ","android 8 ", "MIUI ", "MIUI 9.5 ","nougat "
                    , "samsung ","apps ","play store "};
            temp=7;
            proper="Review";
        }
        if (pos==8)
        {
            dataArr =new String[] {"facebook ","protection ","data ","personal ","applications ", "clash royale "
                    ,"google ","google play instant ", "indian railway ","irctc ","aadhar "
                    ,"train tickets ", "password ", "otp ", "Messaging ", "News ", "Cricket Score "};
            temp=8;
            proper="Tips and Tricks";
        }
        ArrayAdapter<String> newsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, dataArr);
        searchAutoComplete.setAdapter(newsAdapter);

        // Listen to search view item on click event.
        searchAutoComplete.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int itemIndex, long id) {
                String queryString=(String)adapterView.getItemAtPosition(itemIndex);
                searchAutoComplete.setText(queryString);
                Log.d("Searching","wait");
                search(queryString,proper);
                Log.d("Searching","over");

            }
        });

        // Below event is triggered when submit search query.
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                search(query,proper);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.d("onQueryTextChange",newText);
                search(newText,proper);
                return false;
            }

        });

        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(searchViewEnable == false)
                {
                    //Toast.makeText(Trial.this, "Retriving data, ensure data connection.",Toast.LENGTH_LONG).show();
                }
                searchView.setIconified(!searchView.isIconified());
            }
        });
        searchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchView.setQueryHint("Search...");
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.d("onQueryTextSubmit",query);
                search(query,proper);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                {
                    Log.d("onQueryTextChange",newText);
                    searchViewEnable=true;
                    if (searchViewEnable) {
                        if (newText.length() > 1) {

                            links = new String[500];
                            youtubeLink = new String[500];
                            blogID.clear();
                            Log.d("onQueryTextChange","String:"+newText);
                            search(newText,proper);
                        }
                        else
                        {
                            proceedingArrayListFull.clear();
                            mUploads.clear();
                            blogging.clear();
                            blog.clear();
                            displayResultList.clear();
                            displayMethod();
                            }
                    }
                    else {
                        proceedingArrayListFull.clear();
                        mUploads.clear();
                        displayResultList.clear();
                        blogging.clear();
                        blog.clear();
                        displayMethod();
                    }
                    return false;
                }
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}