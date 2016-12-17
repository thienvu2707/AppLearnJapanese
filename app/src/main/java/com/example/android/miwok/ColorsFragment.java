package com.example.android.miwok;


import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
public class ColorsFragment extends Fragment {

    //variable media player
    private MediaPlayer mediaPlayer;

    //create variable for audio focus
    private AudioManager audioManager;

    //create and setup audio focus listener
    private AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            //check whether or not if audio interrupt
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                //then immediately pause audio
                mediaPlayer.pause();
                //when want to play again need to start from beginning
                mediaPlayer.seekTo(0);
            }
            //then when playing it need to gain focus again
            else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mediaPlayer.start();
            }
            //then when player is finished
            // it need to release resource from memory
            else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMedia();
            }
        }
    };

    //set listener mediaPlayer to trigger when audio is complete
    private MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {

            // Now that the sound file has finished playing, release the media player resources.
            releaseMedia();

            //show toast when audio finished
            Toast.makeText(getActivity(), "I\'m done", Toast.LENGTH_SHORT).show();
        }
    };

    private void releaseMedia() {
        //check if media player is playing the sound if it's playing release it
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        //set media back to null
        mediaPlayer = null;

        //after finishing playing audio need to abandon focus
        audioManager.abandonAudioFocus(onAudioFocusChangeListener);
    }


    public ColorsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        //create and setup the request for audio focus
        audioManager = (AudioManager) getActivity().getSystemService(ColorsActivity.AUDIO_SERVICE);

        // create initial ArrayList for number
        final ArrayList<Word> words = new ArrayList<Word>();
        //setting for array
        words.add(new Word("Red", "Akai", R.drawable.color_red, R.raw.color_red));
        words.add(new Word("Green", "Midori", R.drawable.color_green, R.raw.color_green));
        words.add(new Word("Yellow", "Kii", R.drawable.color_dusty_yellow, R.raw.color_yellow));
        words.add(new Word("White", "Shiru", R.drawable.color_white, R.raw.color_white));
        words.add(new Word("Black", "Kurui", R.drawable.color_black, R.raw.color_black));

        //set Adapter to show
        WordAdapter showColor = new WordAdapter(getActivity(), words, R.color.category_colors);

        //finding listView and show on the screen
        ListView colorList = (ListView) rootView.findViewById(R.id.list);
        colorList.setAdapter(showColor);

        colorList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //release audio if it's playing
                releaseMedia();

                // get audio position
                Word colorAudio = words.get(position);

                //now we request for audio focus
                int request = audioManager.requestAudioFocus(onAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN);

                //check whether the request granted or not
                if (request == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // if granted we create media player
                    mediaPlayer = MediaPlayer.create(getActivity(), colorAudio.getAudio());

                    //after create we need to start media player
                    mediaPlayer.start();

                    //done playing then create complete listener
                    // to release audio
                    mediaPlayer.setOnCompletionListener(mOnCompletionListener);
                }

//                //create audio
//                mediaPlayer = MediaPlayer.create(ColorsActivity.this, colorAudio.getAudio());
//                mediaPlayer.start();
//
//                //set OnCompletionListener to release audio
//                mediaPlayer.setOnCompletionListener(mOnCompletionListener);
            }
        });

        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMedia();
    }
}
