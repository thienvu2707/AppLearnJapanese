package com.example.android.miwok;


import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NumbersFragment extends Fragment {


    //set variable mediaPlayer
    private MediaPlayer mMediaPlayer;

    //create variable for audio focus
    private AudioManager audioManager;

    //create audio focus listener to know when the focus change
    private AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            //check if the focus change is loss or not
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                Log.v("NumbersActivity", "this is pause ");
                //if it loss pause immediately
                mMediaPlayer.pause();
                //want to play again need to start from beginning
                mMediaPlayer.seekTo(0);
            }
            //but if the focus change is gain
            else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                //then need to start audio
                mMediaPlayer.start();
            }
            //when audio is finish then release resource
            else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMedia();
            }
        }
    };

    //set on complete listener for audio finish then release it from memory
    private MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            //is term is for release audio
            releaseMedia();

            //show toast when audio finished
            Toast.makeText(getActivity(), "I\'m done", Toast.LENGTH_SHORT).show();
        }
    };

    //check if audio is playing or not if playing then release it from memory
    private void releaseMedia() {
        // audio is playing so it not null
        if (mMediaPlayer != null) {
            // playing then it finished so we release it from memory
            mMediaPlayer.release();
        }
        //set audio to null to play next audio
        mMediaPlayer = null;

        //after finished playing then need to stop focus
        audioManager.abandonAudioFocus(onAudioFocusChangeListener);
    }

    public NumbersFragment() {
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        //create and setup request for audio focus
        audioManager = (AudioManager) getActivity().getSystemService(NumbersActivity.AUDIO_SERVICE);

        // create initial ArrayList for number
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("one", "Itchi", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("two", "Ni", R.drawable.number_two, R.raw.number_two));
        words.add(new Word("three", "San", R.drawable.number_three, R.raw.number_three));
        words.add(new Word("four", "Yon, shi", R.drawable.number_four, R.raw.number_four));
        words.add(new Word("five", "Go", R.drawable.number_five, R.raw.number_five));
        words.add(new Word("six", "Roku", R.drawable.number_six, R.raw.number_six));
        words.add(new Word("seven", "Nana, shichi", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("eight", "Hatchi", R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("nine", "Kyuu, Ku", R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("ten", "Juu", R.drawable.number_ten, R.raw.number_ten));
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

        WordAdapter itemsAdapter = new WordAdapter(getActivity(), words, R.color.category_numbers);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //release audio if audio playing and finishing
                releaseMedia();
                //set position audio in Word
                Word numberAudio = words.get(position);

                //request for audio focus
                int request = audioManager.requestAudioFocus(onAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN);

                //check if the request is granted or not
                if (request == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    //if it's granted then create media player
                    mMediaPlayer = MediaPlayer.create(getActivity(), numberAudio.getAudio());

                    //after create then we need to start audio
                    mMediaPlayer.start();

                    //need a listener to know when it finish
                    //so we can release resource out of memory
                    mMediaPlayer.setOnCompletionListener(mOnCompletionListener);
                }
            }
        });
        return rootView;
    }
    @Override
    public void onStop() {
        super.onStop();
        // When the activity is stopped, release the media player resources because we won't
        // be playing any more sounds.
        releaseMedia();
    }
}