package com.lx.car.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.lx.car.car.R;


public class RatingBarView extends LinearLayout {

    public interface OnRatingListener {

        void onRating(Object bindObject, int RatingScore);
    }

    private boolean mClickable = false;// 默认不可点击

    private int maxStars = 5;// 默认最大星星数量5

    private boolean starAnim = false;// 默认点击无动画效果

    private float starPadding = getDpValue(3);// 默认星星之间的间隔

    private Drawable starEmptyDrawable;// 未选中效果图

    private Drawable starFillDrawable;// 选中效果图

//	private float starImageSize = getDpValue(18);// 默认星星大小

    private OnRatingListener onRatingListener;

    private Object bindObject;

    private int star;// 评价星星数

    public void setClickable(boolean clickable) {

        this.mClickable = clickable;
    }

    public RatingBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOrientation(LinearLayout.HORIZONTAL);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.RatingBarView);
//		starImageSize = ta.getDimension(R.styleable.RatingBarView_starImageSize, getDpValue(24));
        maxStars = ta.getInteger(R.styleable.RatingBarView_starCount, 5);
        starEmptyDrawable = ta.getDrawable(R.styleable.RatingBarView_starEmpty);
        starFillDrawable = ta.getDrawable(R.styleable.RatingBarView_starFill);
        starPadding = ta.getDimension(R.styleable.RatingBarView_starPadding, getDpValue(3));
        mClickable = ta.getBoolean(R.styleable.RatingBarView_starClickable, false);
        starAnim = ta.getBoolean(R.styleable.RatingBarView_starAnim, false);
        ta.recycle();

        for (int i = 0; i < maxStars; ++i) {
            ImageView imageView = getStarImageView(context, attrs);
            imageView.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {

                    if (mClickable) {
                        star = indexOfChild(v) + 1;
                        setStar(star, starAnim);
                        if (onRatingListener != null) {
                            onRatingListener.onRating(bindObject, star);
                        }
                    }
                }
            });
            addView(imageView);
        }
    }

    private ImageView getStarImageView(Context context, AttributeSet attrs) {

        ImageView imageView = new ImageView(context);
//		ViewGroup.LayoutParams para = new ViewGroup.LayoutParams(Math.round(starImageSize), Math.round(starImageSize));
        ViewGroup.LayoutParams para = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        imageView.setLayoutParams(para);
        imageView.setPadding(0, 0, (int) starPadding, 0);
        imageView.setImageDrawable(starEmptyDrawable);
//		imageView.setMaxWidth(10);
//		imageView.setMaxHeight(10);
        return imageView;
    }

    // 设置星星数
    public void setStar(int star, boolean isAnimated) {

        star = star > this.maxStars ? this.maxStars : star;
        star = star < 0 ? 0 : star;
        for (int i = 0; i < star; ++i) {
            ((ImageView) getChildAt(i)).setImageDrawable(starFillDrawable);
            if (isAnimated) {
                ScaleAnimation sa = new ScaleAnimation(0, 0, 1, 1);
                getChildAt(i).startAnimation(sa);
            }
        }
        for (int i = this.maxStars - 1; i >= star; --i) {
            ((ImageView) getChildAt(i)).setImageDrawable(starEmptyDrawable);
        }
    }

    public int getStar() {

        return star;
    }

    public void setStarFillDrawable(Drawable starFillDrawable) {

        this.starFillDrawable = starFillDrawable;
    }

    public void setStarEmptyDrawable(Drawable starEmptyDrawable) {

        this.starEmptyDrawable = starEmptyDrawable;
    }

    public void setMaxStars(int maxStars) {

        this.maxStars = maxStars;
    }

    public int getMaxStars() {

        return maxStars;
    }

//	public void setStarImageSize(float starImageSize) {
//
//		this.starImageSize = starImageSize;
//	}

    public void setBindObject(Object bindObject) {

        this.bindObject = bindObject;
    }

    public void setOnRatingListener(OnRatingListener onRatingListener) {

        this.onRatingListener = onRatingListener;
    }

    private int getDpValue(int px) {

        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, px, getResources().getDisplayMetrics());
    }
}