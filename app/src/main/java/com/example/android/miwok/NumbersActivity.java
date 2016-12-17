package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class NumbersActivity extends AppCompatActivity {

//    //set variable mediaPlayer
//    private MediaPlayer mMediaPlayer;
//
//    //create variable for audio focus
//    private AudioManager audioManager;
//
//    //create audio focus listener to know when the focus change
//    private AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
//        @Override
//        public void onAudioFocusChange(int focusChange) {
//            //check if the focus change is loss or not
//            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
//                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
//                Log.v("NumbersActivity", "this is pause ");
//                //if it loss pause immediately
//                mMediaPlayer.pause();
//                //want to play again need to start from beginning
//                mMediaPlayer.seekTo(0);
//            }
//            //but if the focus change is gain
//            else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
//                //then need to start audio
//                mMediaPlayer.start();
//            }
//            //when audio is finish then release resource
//            else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
//                releaseMedia();
//            }
//        }
//    };
//
//    //set on complete listener for audio finish then release it from memory
//    private MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener() {
//        @Override
//        public void onCompletion(MediaPlayer mp) {
//            //is term is for release audio
//            releaseMedia();
//
//            //show toast when audio finished
//            Toast.makeText(NumbersActivity.this, "I\'m done", Toast.LENGTH_SHORT).show();
//        }
//    };
//
//    //check if audio is playing or not if playing then release it from memory
//    private void releaseMedia() {
//        // audio is playing so it not null
//        if (mMediaPlayer != null) {
//            // playing then it finished so we release it from memory
//            mMediaPlayer.release();
//        }
//        //set audio to null to play next audio
//        mMediaPlayer = null;
//
//        //after finished playing then need to stop focus
//        audioManager.abandonAudioFocus(onAudioFocusChangeListener);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new NumbersFragment()).commit();

//        //create and setup request for audio focus
//        audioManager = (AudioManager) getSystemService(NumbersActivity.AUDIO_SERVICE);
//
//        // create initial ArrayList for number
//        final ArrayList<Word> words = new ArrayList<Word>();
//        words.add(new Word("one", "Itchi", R.drawable.number_one, R.raw.number_one));
//        words.add(new Word("two", "Ni", R.drawable.number_two, R.raw.number_two));
//        words.add(new Word("three", "San", R.drawable.number_three, R.raw.number_three));
//        words.add(new Word("four", "Yon, shi", R.drawable.number_four, R.raw.number_four));
//        words.add(new Word("five", "Go", R.drawable.number_five, R.raw.number_five));
//        words.add(new Word("six", "Roku", R.drawable.number_six, R.raw.number_six));
//        words.add(new Word("seven", "Nana, shichi", R.drawable.number_seven, R.raw.number_seven));
//        words.add(new Word("eight", "Hatchi", R.drawable.number_eight, R.raw.number_eight));
//        words.add(new Word("nine", "Kyuu, Ku", R.drawable.number_nine, R.raw.number_nine));
//        words.add(new Word("ten", "Juu", R.drawable.number_ten, R.raw.number_ten));
//        number.add("one");
//        number.add("two");
//        number.add("three");
//        number.add("four");
//        number.add("five");
//        number.add("six");
//        number.add("seven");
//        number.add("eight");
//        number.add("nine");
//        number.add("ten");

//        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_numbers);
//
//        ListView listView = (ListView) findViewById(R.id.list);
//        listView.setAdapter(itemsAdapter);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                //release audio if audio playing and finishing
//                releaseMedia();
//                //set position audio in Word
//                Word numberAudio = words.get(position);
//
//                //request for audio focus
//                int request = audioManager.requestAudioFocus(onAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN);
//
//                //check if the request is granted or not
//                if (request == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
//                    //if it's granted then create media player
//                    mMediaPlayer = MediaPlayer.create(NumbersActivity.this, numberAudio.getAudio());
//
//                    //after create then we need to start audio
//                    mMediaPlayer.start();
//
//                    //need a listener to know when it finish
//                    //so we can release resource out of memory
//                    mMediaPlayer.setOnCompletionListener(mOnCompletionListener);
//                }

//                //find audio in word
//                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, numberAudio.getAudio());
//                mMediaPlayer.start();
//
//                //complete listener when audio is complete then it will release
//                mMediaPlayer.setOnCompletionListener(mOnCompletionListener);
//            }
//        });
//        ArrayAdapter<String> adapterItems = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, number);
//        GridView gridView = (GridView) findViewById(R.id.list);
//        gridView.setAdapter(adapterItems);

//        LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);
//
//        for (int index = 0; index < number.size(); index++)
//        {
//            TextView wordView = new TextView(this);
//            wordView.setText(number.get(index));
//            rootView.addView(wordView);
//        }

        //create variable to keep track of position
//        int index = 0;
//
//        while (index < number.size())
//        {
//            TextView wordView = new TextView(this);
//            wordView.setText(number.get(index));
//            rootView.addView(wordView);
//            index++;
//        }


        // log show for ArrayList
//        Log.v("NumbersActivity", "word at index 0: " + number.get(0));
//        Log.v("NumbersActivity", "word at index 1: " + number.get(1));
//        Log.v("NumbersActivity", "word at index 2: " + number.get(2));
//        Log.v("NumbersActivity", "word at index 3: " + number.get(3));
//        Log.v("NumbersActivity", "word at index 4: " + number.get(4));
//        Log.v("NumbersActivity", "word at index 5: " + number.get(5));
//        Log.v("NumbersActivity", "word at index 6: " + number.get(6));
//        Log.v("NumbersActivity", "word at index 7: " + number.get(7));
//        Log.v("NumbersActivity", "word at index 8: " + number.get(8));
//        Log.v("NumbersActivity", "word at index 9: " + number.get(9));


        //create initial array for number
//        String[] word = new String[10];
//        word[0] = "one";
//        word[1] = "two";
//        word[2] = "three";
//        word[3] = "four";
//        word[4] = "five";
//        word[5] = "six";
//        word[6] = "seven";
//        word[7] = "eight";
//        word[8] = "nine";
//        word[9] = "ten";

        //log show number in array
//        Log.v("NumbersActivity", "word at index 0: " + word[0]);
//        Log.v("NumbersActivity", "word at index 1: " + word[1]);
//        Log.v("NumbersActivity", "word at index 2: " + word[2]);
//        Log.v("NumbersActivity", "word at index 3: " + word[3]);
//        Log.v("NumbersActivity", "word at index 4: " + word[4]);
//        Log.v("NumbersActivity", "word at index 5: " + word[5]);
//        Log.v("NumbersActivity", "word at index 6: " + word[6]);
//        Log.v("NumbersActivity", "word at index 7: " + word[7]);
//        Log.v("NumbersActivity", "word at index 8: " + word[8]);
//        Log.v("NumbersActivity", "word at index 9: " + word[9]);
    }

//    @Override
//    protected void onStop() {
//        super.onStop();
//        //release when user leave the app
//        releaseMedia();
//    }
}
