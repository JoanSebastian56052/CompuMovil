package com.example.estudiantelis.actividadlistadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MyListActivity extends AppCompatActivity {

    private ListView myListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list);

        myListView = (ListView) findViewById(R.id.list_view);
        String[] values = new String[] {"Android", "Iphone", "WindowsMobile",
                "Blackberry", "WebOS", "Ubuntu", "Windows7", "MacOS", "LUbuntu",
                "KaliLinux", "Windows10", "WindowsXP", "Symbian"};

        MyCustomeAdapter adapter = new MyCustomeAdapter(this, values);
        myListView.setAdapter(adapter);
    }
}
