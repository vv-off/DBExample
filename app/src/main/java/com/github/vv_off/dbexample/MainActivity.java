package com.github.vv_off.dbexample;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ListView mListViewMessage;
    Button mBtnAdd;
    DataBaseHandler dbHandler = new DataBaseHandler(this);



    String[] data = {"Строка1", "Строка1", "Строка1", "Строка1"};


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

        ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,getAllHeaders());
        mListViewMessage.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        //код нажатия на кнопку
        dbHandler.addDataDB(new DataDB("Заголовок", "Текст записи"));
    }

    public List<String> getAllHeaders(){
        List<String> listHeader = new LinkedList<>();
        for(int i=0;i<dbHandler.getAllDataDB().size();i++){
            listHeader.add(i,dbHandler.getAllDataDB().get(i).getHeader());
        }
        return listHeader;
    }
}
