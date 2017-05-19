package com.example.chris.friendslist;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button buttonAdd, buttonClear;
    Context context = this;
    ArrayList friendList = new ArrayList<Friend>();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayAdapter<Friend> arrayAdapter = new FriendArrayAdapter(context, friendList);

        // Button will open dialog for friend data entry
        buttonAdd = (Button)findViewById(R.id.button_add);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
                final View subView = layoutInflater.inflate(R.layout.dialog_add_friend, null);

                final EditText etFirst = (EditText) subView.findViewById(R.id.firstname);
                final EditText etLast = (EditText) subView.findViewById(R.id.lastname);
                final EditText etTown = (EditText) subView.findViewById(R.id.hometown);
                final EditText etAge = (EditText) subView.findViewById(R.id.age);

                final AlertDialog alertDialog = new AlertDialog.Builder(context)
                        .setTitle("Add a Friend")
                        .setView(subView)
                        .setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                String first = etFirst.getText().toString();
                                String last = etLast.getText().toString();
                                String town = etTown.getText().toString();
                                int age = Integer.parseInt(etAge.getText().toString());

                                Friend newFriend = new Friend(first, last, town, age);
                                friendList.add(newFriend);
                                dialog.cancel();
                                Toast.makeText(context,"New Friend, " + first + ", added.", Toast.LENGTH_SHORT).show();

                                listView = (ListView) findViewById(R.id.list);
                                listView.setAdapter(arrayAdapter);
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        })
                        .create();
                alertDialog.show();
            }
        });

        // Button will Clear friends list
        buttonClear = (Button)findViewById(R.id.button_clear);
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Friends list cleared.", Toast.LENGTH_SHORT).show();
                arrayAdapter.clear();
            }
        });
    }
}
