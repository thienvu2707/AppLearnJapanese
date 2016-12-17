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
public class FamilyFragment extends Fragment {

    // variable media player
    private MediaPlayer mediaPlayer;

    //create variable for audio focus
    private AudioManager audioManager;

    //create audio focus listener to know when it need to focus
    private AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            //first check whether it lose focus
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                //if it lose focus then immediately need to pause audio
                mediaPlayer.pause();
                //but want to play it again need to start from beginning
                mediaPlayer.seekTo(0);
            }
            //if it gain focus then audio can start
            else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mediaPlayer.start();
            }
            //if it's finished playing then release resource
            else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            }
        }
    };

    /**
     * This listener gets triggered when the {@link MediaPlayer} has completed
     * playing the audio file.
     */
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();

            //show toast when audio finished
            Toast.makeText(getActivity(), "I\'m done", Toast.LENGTH_SHORT).show();
        }
    };

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();
        }
        // Set the media player back to null. For our code, we've decided that
        // setting the media player to null is an easy way to tell that the media player
        // is not configured to play an audio file at the moment.
        mediaPlayer = null;

        //finished playing audio need to stop focus
        audioManager.abandonAudioFocus(onAudioFocusChangeListener);
    }

    public FamilyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        //create and set up request for audio focus
        audioManager = (AudioManager) getActivity().getSystemService(FamilyActivity.AUDIO_SERVICE);

        /**
         * create an arrayList for family tabs
         */
        final ArrayList<Word> familyWords = new ArrayList<Word>();

        familyWords.add(new Word("Mom", "Oka-san", R.drawable.family_mother, R.raw.family_mom));
        familyWords.add(new Word("Dad", "Oto-san", R.drawable.family_father, R.raw.family_father));
        familyWords.add(new Word("Grandma", "Sobo", R.drawable.family_grandmother, R.raw.family_grand_mom));
        familyWords.add(new Word("Grandad", "Sofu", R.drawable.family_grandfather, R.raw.family_grand_dad));
        familyWords.add(new Word("Brother", "Oni-chan", R.drawable.family_older_brother, R.raw.family_brother));
        familyWords.add(new Word("Sister", "Imouto", R.drawable.family_younger_sister, R.raw.family_sister));
        familyWords.add(new Word("Uncle", "Oji-san", R.drawable.family_father, R.raw.family_uncle));
        familyWords.add(new Word("Aunt", "Oba-san", R.drawable.family_older_sister, R.raw.family_aunt));

        //set Adapter to show on the screen
        WordAdapter showFamily = new WordAdapter(getActivity(), familyWords, R.color.category_family);

        // find listView in family Layouts
        ListView listFamily = (ListView) rootView.findViewById(R.id.list);

        //display on the screen
        listFamily.setAdapter(showFamily);

        //set on items click for audio
        listFamily.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Release the media player if it currently exists because we are about to
                // play a different sound file
                releaseMediaPlayer();

                //get position for audio in adapter
                Word familyAudio = familyWords.get(position);

                /**
                 * request for audio focus
                 * @param onAudioFocusChangeListener is the requirement for audio focus
                 * @param STREAM_MUSIC is the type of stream
                 */
                int request = audioManager.requestAudioFocus(onAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN);

                //check whether the request granted or not
                if (request == AudioManager.AUDIOFOCUS_REQUEST_GRANTED)
                {
                    //if granted then create media player
                    mediaPlayer = MediaPlayer.create(getActivity(), familyAudio.getAudio());
                    //create then it need to start
                    mediaPlayer.start();

                    //set complete listener to know when it finish
                    //so we can release resource out from the memory
                    mediaPlayer.setOnCompletionListener(mCompletionListener);

                }

//                //set media player for each word
//                mediaPlayer = MediaPlayer.create(FamilyActivity.this, familyAudio.getAudio());
//                mediaPlayer.start();
//
//                // Setup a listener on the media player, so that we can stop and release the
//                // media player once the sound has finished playing.
//                mediaPlayer.setOnCompletionListener(mCompletionListener);

            }
        });

        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}
