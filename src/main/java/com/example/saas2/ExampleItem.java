package com.example.saas2;

import android.widget.Button;

public class ExampleItem {
    private int mImageResource;
    private String mText1;
    private String mText2;
    private String mButtonText;
    private String mPrice;

    public ExampleItem(int imageResource, String text1, String text2, String buttonText, String Price) {
        mImageResource = imageResource;
        mText1 = text1;
        mText2 = text2;
        mButtonText = buttonText;
        mPrice = Price;
    }

    public void setButtonText(String mButtonText) {
        this.mButtonText = mButtonText;
    }

    public String getButtonText() {
        return mButtonText;
    }

    public int getImageResource() {
        return mImageResource;
    }

    public String getText1() {
        return mText1;
    }

    public String getText2() {
        return mText2;
    }

    public String getPrice() {
        return mPrice;
    }
}
