package com.example.android.chatapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abc on 31/01/2017.
 */
public class ChatArrayAdapter extends ArrayAdapter<ChatMessage>{
private TextView Chat_Box;
    private List<ChatMessage> msg_list=new ArrayList<ChatMessage>();
    private LinearLayout linear;

     public ChatArrayAdapter(Context applicationContext, int chat) {
         super(applicationContext,chat);
     }
    public ChatArrayAdapter(Context context, int resource, ChatMessage[] objects) {
        super(context, resource, objects);
    }
    public  void add(ChatMessage object){
        msg_list.add(object);
        super.add(object);
    }
    public int getCount(){
        return this.msg_list.size();
    }
    public ChatMessage getItem(int Index){
        return this.msg_list.get(Index);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v=convertView;
        if (v==null){
            LayoutInflater inflater = (LayoutInflater)this.getContext().getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.chat, parent,false);
            linear=(LinearLayout)v.findViewById(R.id.forMsg);
            ChatMessage messageobj = getItem(position);
            Chat_Box=(TextView)v.findViewById(R.id.msg);
            Chat_Box.setText(messageobj.message);
            Chat_Box.setBackgroundResource(messageobj.left?R.drawable.text_message_from_bg:R.drawable.blue);
          //  linear.setGravity(messageobj.left?Gravity.LEFT:Gravity.RIGHT);
        }

        return  v;
    }
    public Bitmap decodeToBitMap(byte[] decodeToByte){
return BitmapFactory.decodeByteArray(decodeToByte,0,decodeToByte.length);
    }
}
