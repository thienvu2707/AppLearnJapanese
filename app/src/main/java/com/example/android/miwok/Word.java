package com.example.android.miwok;

/**
 * Created by thien on 31-Aug-16.
 */
public class Word {

    //Default language to use
    private String mDefaultLanguage;

    //Translation language use
    private String mJapaneseLanguage;

    //get audio
    private int mAudio;

    //picture of this word
//    private int mImage;
    private int mImage = NO_IMAGE_PROVIDED;
    /** Constant value that represents no image was provided for this word */
    private static final int NO_IMAGE_PROVIDED = -1;



    /**
     * Constructor of the word class
     *
     * @param defaultLanguage get default translation
     * @param japaneseLanguge get japanese translation
     */
    public Word(String defaultLanguage, String japaneseLanguge, int audio) {
        mDefaultLanguage = defaultLanguage;
        mJapaneseLanguage = japaneseLanguge;
        mAudio = audio;
    }

    /**
     * constructor of the word class
     * @param defaultLanguage
     * @param japaneseLanguge
     * @param image get drawable image
     * @param audio get resource of audio
     */
    public Word(String defaultLanguage, String japaneseLanguge, int image, int audio) {
        mDefaultLanguage = defaultLanguage;
        mJapaneseLanguage = japaneseLanguge;
        mImage = image;
        mAudio = audio;
    }


    /**
     * get default translation language
     *
     * @return
     */
    public String getDefaultLanguage() {
        return mDefaultLanguage;
    }

    /**
     * get japanese translation
     *
     * @return
     */
    public String getJapaneseLanguage() {
        return mJapaneseLanguage;
    }

    /**
     * get image hear
     * @return
     */
    public int getImage() {
        return mImage;
    }

    public boolean hasImage()
    {
        return mImage != NO_IMAGE_PROVIDED;
    }

    public int getAudio()
    {
        return mAudio;
    }
}
