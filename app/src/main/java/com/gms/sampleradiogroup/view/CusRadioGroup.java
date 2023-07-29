package com.gms.sampleradiogroup.view;

import android.content.Context;

import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioGroup;

import com.gms.sampleradiogroup.R;

import java.util.ArrayList;

public class CusRadioGroup extends RadioGroup {

    private boolean isInitFinish = false;
    private int initPhaseSelectIndex = -1;


    ArrayList<CusRadioButton> cusRadioButtons = new ArrayList<CusRadioButton>();
    boolean isSelectCorrectAnswer = false;
    int isSelectIndex = -1;

    IOnSelectListener onSelectListener;

    public CusRadioGroup(Context context) {
        super(context);
    }

    public CusRadioGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        init();
    }


    /**
     * 監聽User選擇到的選項與結果
     * @param listener
     */
    public void SetOnSelectListener(IOnSelectListener listener) {
        onSelectListener = listener;
    }

    public void init() {
        this.setOnCheckedChangeListener((radioGroup, resId) -> {
            for (int pos = 0; pos < cusRadioButtons.size(); pos++) {
                if (cusRadioButtons.get(pos).getId() == resId) {
                    setSelect(pos, true);
                    break;
                }
            }
        });

        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            if (getChildAt(i) instanceof CusRadioButton) {
                cusRadioButtons.add((CusRadioButton) getChildAt(i));
            }
        }
        isInitFinish = true;
        if(initPhaseSelectIndex > -1){
            setSelect(initPhaseSelectIndex);
            initPhaseSelectIndex = -1;
        }
    }


    /**
     * 設定選項
     *
     * @param index
     */
    public void setSelect(int index) {
        if (isInitFinish)
            setSelect(index, false);
        else
            initPhaseSelectIndex = index;
    }

    protected void setSelect(int index, boolean isUserSelect) {
        isSelectIndex = index;
        this.check(getChildAt(index).getId());
        updateView(isUserSelect);
    }

    /**
     * 禁用並更新畫面
     */
    private void updateView(boolean triggerListener) {
        Drawable drawable;
        CusRadioButton cusRadioButton;
        for (int pos = 0; pos < cusRadioButtons.size(); pos++) {
            cusRadioButton = cusRadioButtons.get(pos);
            cusRadioButton.setEnabled(false);
            int resId = cusRadioButton.isCorrectAnswer ? R.drawable.detailyes : R.drawable.detailno;
            drawable = getResources().getDrawable(resId);
            cusRadioButton.setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null);

            if (cusRadioButton.isCorrectAnswer && isSelectIndex == pos) {
                isSelectCorrectAnswer = true;
            }
        }
        if (onSelectListener != null)
            onSelectListener.onSelect(isSelectIndex, isSelectCorrectAnswer);


    }

    /**
     * 重設功能
     */
    public void reset() {
        isSelectCorrectAnswer = false;
        isSelectIndex = -1;

        this.clearCheck();
        Drawable drawable;
        CusRadioButton cusRadioButton;
        for (int pos = 0; pos < cusRadioButtons.size(); pos++) {
            cusRadioButton = cusRadioButtons.get(pos);
            cusRadioButton.setEnabled(true);
            cusRadioButton.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        }

    }

    public interface IOnSelectListener {
        /**
         * 監聽User選擇的結果
         * @param index     User的選項(from 0)
         * @param result    選擇的結果(對/錯)
         */
        void onSelect(int index, boolean result);
    }

} // class close
