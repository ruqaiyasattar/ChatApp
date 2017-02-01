package com.example.android.chatapp;

import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
private ChatArrayAdapter adp;
    private ListView list;
    private Button send;
    private EditText Chat_text;
    Intent i;
    private boolean side=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i=getIntent();
        send=(Button)findViewById(R.id.send);
        list=(ListView)findViewById(R.id.listview);
        adp=new ChatArrayAdapter(getApplicationContext(),R.layout.chat);
        //chatbox in list view
        Chat_text=(EditText)findViewById(R.id.text);
        Chat_text.setOnKeyListener(new View.OnKeyListener() {
    @Override
    public boolean onKey(View view, int keycode, KeyEvent keyEvent) {
        if(keyEvent.getAction()==keyEvent.ACTION_DOWN&&keycode==keyEvent.KEYCODE_ENTER){
return sendChatMessage();
        }
        return false;
    }
});
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendChatMessage();
            }
        });

        list.setTranscriptMode(AbsListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
        list.setAdapter(adp);
        adp.registerDataSetObserver(new DataSetObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                list.setSelection(adp.getCount() -1);

            }
        });
    }
    private boolean sendChatMessage() {
        adp.add(new ChatMessage(side,Chat_text.getText().toString()));
        Chat_text.setText("");
      //  false;
       // return false;
    return true;
    }
}
