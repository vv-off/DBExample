package com.github.vv_off.dbexample;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ListView mListViewMessage;
    Button mBtnAdd;
    DataBaseHandler dbHandler = new DataBaseHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListViewMessage = (ListView)findViewById(R.id.listViewMessage);

        mListViewMessage.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 //код обработки нажатия на позицию списка
            }
        });

        mListViewMessage.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                //код обработки долгого нажатия на позицию списка
                return false;
            }
        });

        mBtnAdd = (Button)findViewById(R.id.btnAdd);
        mBtnAdd.setOnClickListener(this);

        ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,dbHandler.getAllDataDB());
        mListViewMessage.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        //код нажатия на кнопку
    }
}
