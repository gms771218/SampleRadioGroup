package com.gms.sampleradiogroup.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;

import androidx.annotation.Nullable;

import com.gms.sampleradiogroup.R;

public class CusRadioButton extends androidx.appcompat.widget.AppCompatRadioButton {

   /** 該選項是否為正確答案 */
   public boolean isCorrectAnswer = false;

   public CusRadioButton(Context context, @Nullable AttributeSet attrs) {
      super(context, attrs);
      TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.CusRadioButton, R.attr.isCorrectAnswer, 0);
      isCorrectAnswer = a.getBoolean(R.styleable.CusRadioButton_isCorrectAnswer , false);
      a.recycle();
   }


   public CusRadioButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
      super(context, attrs, defStyleAttr);
      TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.CusRadioButton, defStyleAttr, 0);
      isCorrectAnswer = a.getBoolean(R.styleable.CusRadioButton_isCorrectAnswer , false);
      a.recycle();
   }



}
