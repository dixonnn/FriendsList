package com.example.chris.friendslist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.chris.friendslist.Friend;
import com.example.chris.friendslist.R;

import java.util.ArrayList;

/**
 * Created by chris on 5/18/17.
 */

public class FriendArrayAdapter extends ArrayAdapter<Friend> {

    public FriendArrayAdapter(Context context, ArrayList<Friend> friendslist) {
        super(context,0,friendslist);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Friend friend = getItem(position);
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_friend_list, parent, false);
        }

        TextView tvName = (TextView) convertView.findViewById(R.id.Name);
        TextView tvHometown = (TextView) convertView.findViewById(R.id.Hometown);
        TextView tvAge = (TextView) convertView.findViewById(R.id.age);

        tvName.setText(friend.getFirstName() + " " + friend.getLastName());
        tvHometown.setText(friend.getHometown());
        tvAge.setText(Integer.toString(friend.getAge()));

        return convertView;
    }
}
