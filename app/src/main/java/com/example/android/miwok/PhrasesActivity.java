package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class PhrasesActivity extends AppCompatActivity {

//    //create variable for audio focus
//    AudioManager audioManager;
//
//    //variable for media player
//    private MediaPlayer mMediaPlayer;
//
//    /**
//     * create audio focus listener to get triggered whenever audio focus change
//     */
//    private AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
//        @Override
//        public void onAudioFocusChange(int focusChange) {
//            //check audio focus loss or not
//            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT
//                    || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
//                //if focus change it need to pause immediately
//                mMediaPlayer.pause();
//                //and then audio need to playback from beginning
//                mMediaPlayer.seekTo(0);
//            }
//            //this is to regain focus for audio if press play again
//            else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
//                mMediaPlayer.start();
//            }
//            //this is release audio out from memory when finished
//            else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
//                //Stop playback and clean up resource
//                releaseMedia();
//            }
//        }
//    };
//
//    //set up media player completion listener it will trigger when audio is finish
//    private MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener() {
//        @Override
//        public void onCompletion(MediaPlayer mp) {
//            //show Toast
//            Toast.makeText(PhrasesActivity.this, "I\'m done", Toast.LENGTH_SHORT).show();
//
//            //when click audio after finishing it will release it from memory
//            releaseMedia();
//        }
//    };
//
//    //clean up resource after finishing audio
//    private void releaseMedia() {
//        //check if audio is playing or not if it's playing the release it
//        if (mMediaPlayer != null) {
//            //releasing audio when it finished
//            mMediaPlayer.release();
//        }
//
//        //set it back to null again
//        mMediaPlayer = null;
//
//        //after finish playing audio then abandon focus for it too
//        audioManager.abandonAudioFocus(onAudioFocusChangeListener);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new PhrasesFragment()).commit();

//        //create and set up request for audio focus
//        audioManager = (AudioManager) getSystemService(PhrasesActivity.AUDIO_SERVICE);
//
//        //set ArrayList for phrase
//        final ArrayList<Word> phrase = new ArrayList<Word>();
//        phrase.add(new Word("Good morning", " O'hayoo gozai'masu", R.raw.phrase_ohayoo));
//        phrase.add(new Word("Good afternoon", "Kon'nichiwa", R.raw.phrase_konichiwa));
//        phrase.add(new Word("Good evening", "konban'wa", R.raw.phrase_konbanwa));
//        phrase.add(new Word("Goodbye ( for long time ) ", "Sayoonara", R.raw.phrase_sayoonara));
//        phrase.add(new Word("Goodbye ( for short time )", "konban'ne", R.raw.phrase_konbane));
//        phrase.add(new Word("Thank you", "A'rigatoo Go'zaimasu", R.raw.phrase_arigatoo));
//        phrase.add(new Word("Sorry", "su'mimasen", R.raw.phrase_suminasen));
//        phrase.add(new Word("Excuse me/ please", "Onegaishi'masu", R.raw.phrase_onegaishimasu));
//        phrase.add(new Word("What\' your name?", "onamaewa?", R.raw.phrase_omanewa));
//        phrase.add(new Word("My name is...", "Wa'tashi no 'namae wa...", R.raw.phrase_name));
//        phrase.add(new Word("Please to meet you", "ha'jimemaste", R.raw.phrase_hajimemaste));
//
//        //set custom Adapter
//        WordAdapter showPhraseAdapter = new WordAdapter(this, phrase, R.color.category_phrases);
//
//        //find ListView
//        ListView phraseListView = (ListView) findViewById(R.id.list);
//        phraseListView.setAdapter(showPhraseAdapter);
//
//        phraseListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                //release audio out of memory before playing new one
//                releaseMedia();
//
//                //get position of audio file
//                Word newWord = phrase.get(position);
//
//                //request audio focus
//                int resultAudioFocus = audioManager.requestAudioFocus(onAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
//
//                //check if app has audio focus or not
//                if (resultAudioFocus == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
//                    //create and setup audio resource associated
//                    mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, newWord.getAudio());
//
//                    //create then start audio
//                    mMediaPlayer.start();
//
//                    //setup listener on media player to stop and release resource
//                    //when audio is finished
//                    mMediaPlayer.setOnCompletionListener(mOnCompletionListener);
//                }
//
//
////                //it create mediaPlayer and set it to play
////                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, newWord.getAudio());
////                mMediaPlayer.start();
//
////                //set on complete listener when audio is playing after it finishing
////                //it will trigger release out of memory
////                mMediaPlayer.setOnCompletionListener(mOnCompletionListener);
//            }
//        });
    }
//
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//
//        releaseMedia();
//    }
}
