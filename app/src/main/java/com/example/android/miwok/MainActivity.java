/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        //find View paper
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpaper);

        //create an adapter to know which fragment is shown in the screen
        FragmentSwitch adapter = new FragmentSwitch(this, getSupportFragmentManager());

        //set adapter to View paper
        viewPager.setAdapter(adapter);

        //find the tab layout
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        /**
         * connect to the tab layout with the view paper
         * 1. update tab layout when swiped
         * 2. update view paper when tab selected
         * 3. set the tab layout names with the view paper adapter titles by calling onPageTitle
         */
        tabLayout.setupWithViewPager(viewPager);

//        //find the view that show number category
//        TextView number = (TextView) findViewById(R.id.numbers);
//        //set click listeners on numbers category
//        number.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                //create intent for numbers category
//                Intent findNumbers = new Intent(MainActivity.this, NumbersActivity.class);
//                startActivity(findNumbers);
//
//                //create toast
////                Toast.makeText(MainActivity.this, "Trying to open Numbers category", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        //check id of family member
//        TextView family = (TextView) findViewById(R.id.family);
//
//        //set click listeners on family category
//        family.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //create intent family category
//                Intent findFamily = new Intent(MainActivity.this, FamilyActivity.class);
//                startActivity(findFamily);
//            }
//        });
//
//        //check for Colors
//        TextView colors = (TextView) findViewById(R.id.colors);
//
//        //set click listeners for Colors
//        colors.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //create intent for colors category
//                Intent findColor = new Intent(MainActivity.this, ColorsActivity.class);
//                startActivity(findColor);
//            }
//        });
//
//        // check id for Phrases
//        TextView phrases = (TextView) findViewById(R.id.phrases);
//
//        //set click listeners for phrases
//        phrases.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //create Intent for phrases
//                Intent findPhrases = new Intent(MainActivity.this, PhrasesActivity.class);
//                startActivity(findPhrases);
//            }
//        });
//
//        //create intent to family member category
//
//
//
//    }

//    public void clickNumbersList(View view)
//    {
//        Intent numbersList = new Intent(MainActivity.this, NumbersActivity.class);
//        MainActivity.this.startActivity(numbersList);
//    }

//    public void clickFamilyList(View view)
//    {
//        Intent familyList = new Intent(MainActivity.this, FamilyActivity.class);
//        MainActivity.this.startActivity(familyList);
//    }
//
//    public void clickColorsList(View view)
//    {
//        Intent colorsList = new Intent(MainActivity.this, ColorsActivity.class);
//        MainActivity.this.startActivity(colorsList);
//    }
//
//    public void clickPhrasesList(View view)
//    {
//        Intent phrasesList = new Intent(MainActivity.this, PhrasesActivity.class);
//        MainActivity.this.startActivity(phrasesList);
//    }
    }
}
