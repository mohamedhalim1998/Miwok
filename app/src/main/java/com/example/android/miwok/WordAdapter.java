package com.example.android.miwok;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import static androidx.core.content.ContextCompat.getColor;

public class WordAdapter extends ArrayAdapter<Word> {
    private int backgroundColor;

    public WordAdapter(Context context, List<Word> objects, int backgroundColor) {
        super(context, 0, objects);
        this.backgroundColor = backgroundColor;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext())
                    .inflate(R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        final Word currentWord = getItem(position);

        // Find the LinearLayout in the list_item.xml layout with the ID version_name
        LinearLayout wordsLayout = listItemView.findViewById(R.id.words_layout);
        // set the background color for the view
        wordsLayout.setBackgroundColor(getColor(getContext(),backgroundColor));
        listItemView.setBackgroundColor(getColor(getContext(),backgroundColor));

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.miwok_word);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        nameTextView.setText(currentWord.getMiwok());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView numberTextView = (TextView) listItemView.findViewById(R.id.english_word);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        numberTextView.setText(currentWord.getEnglish());
        ImageView imageView = listItemView.findViewById(R.id.word_image);
        int imageId = currentWord.getImageId();
        if(imageId != 0) {
            imageView.setImageResource(imageId);
        } else {
            imageView.setVisibility(View.GONE);
        }
        // Return the whole list item layout (containing 2 TextViews)
        // so that it can be shown in the ListView
        return listItemView;
    }

}
