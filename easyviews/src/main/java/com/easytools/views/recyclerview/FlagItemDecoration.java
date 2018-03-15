package com.easytools.views.recyclerview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.easytools.views.R;

/**
 * package: com.easytools.views.recyclerview.FlagItemDecoration
 * author: gyc
 * description:带标签的分割线
 * time: create at 2017/5/26 12:07
 */

public class FlagItemDecoration extends RecyclerView.ItemDecoration {
    private Paint mPaint;
    private Bitmap mIcon;
    private float mFlagLeft;

    public FlagItemDecoration(Context context) {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.RED);


        mIcon = BitmapFactory.decodeResource(context.getResources(), R.drawable.hotsale);
        mFlagLeft = context.getResources().getDimension(R.dimen.flag_left);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State
            state) {
//        super.getItemOffsets(outRect, view, parent, state);
        //第一个ItemView不需要在上面绘制分割线
        if (parent.getChildAdapterPosition(view) == 0){
            outRect.top = 0;
        } else {
            outRect.top = 2;
        }
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View view = parent.getChildAt(i);
            int index = parent.getChildAdapterPosition(view);
            float top = view.getTop();
            if (index < 3) {
                c.drawBitmap(mIcon, mFlagLeft, top, mPaint);
            }
        }
    }
}