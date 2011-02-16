package com.tumblr.totte.hellogit;

import java.util.ArrayList;
import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class HelloGithub extends ListActivity {
    
    private ArrayList<Item> crows; 
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        crows = new ArrayList<Item>();
        setContentView(R.layout.main);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        boolean result = super.onCreateOptionsMenu(menu);
        // デフォルトではアイテムを追加した順番通りに表示する
        menu.add("にゃーん");
        return result;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if("にゃーん".equals(item.getTitle())) {
            ArrayAdapter<Item> adapter = new ArrayAdapter<Item>(this, 0, crows) {
                
                
                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    View ret = convertView;
                    
                    if(convertView == null) {
                        LayoutInflater mInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        ret = mInflater.inflate(R.layout.item_row, null);
                    }
                    
                    Item posItem = getItem(position);
                    if (posItem != null) {
                        ((TextView) ret.findViewById(R.id.crow)).setText("にゃーん");
                    }
                    return ret;
                }
                
            };
            adapter.add(new Item("にゃーん"));
            super.setListAdapter(adapter);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}