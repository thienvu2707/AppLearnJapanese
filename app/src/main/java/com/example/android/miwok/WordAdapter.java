package com.example.android.miwok;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by thien on 31-Aug-16.
 */
public class WordAdapter extends ArrayAdapter<Word> {

    //resource id for the background color of each layout
    private int mColorResource;

    /**
     * constructor of word adapter
     * @param context
     * @param words
     * @param colorResource
     */
    public WordAdapter(Activity context, ArrayList<Word> words, int colorResource) {
        super(context, 0, words);
        mColorResource = colorResource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // Get the object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_items.xml japanese language
        TextView listItemTextJapanese = (TextView) listItemView.findViewById(R.id.japanese_text_view);

        //Get the translation of japanese
        //set this text of TextView
        listItemTextJapanese.setText(currentWord.getJapaneseLanguage());

        //Find the TextView in the list_items.xml default language
        TextView listItemEnglish = (TextView) listItemView.findViewById(R.id.English_text_view);

        //Get the translation of English
        //set this text to TextView
        listItemEnglish.setText(currentWord.getDefaultLanguage());

        //get imageView
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.all_image);
        //set image view to screen
//        imageView.setImageResource(currentWord.getImage());

        //check if the layout has image or not
        if (currentWord.hasImage())
        {
            imageView.setImageResource(currentWord.getImage());

            imageView.setVisibility(View.VISIBLE);
        } else
        {
            imageView.setVisibility(View.GONE);
        }

        //set the color for the text view of the list view
        View textContainer = listItemView.findViewById(R.id.text_container);
        //find the color that id that maps to layout that match to
        int color = ContextCompat.getColor(getContext(), mColorResource);
        //set background color
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
