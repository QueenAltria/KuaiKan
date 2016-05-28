package com.jiang.kuaikan.views;

/**
 * Created by Administrator on 2016/5/27.
 */
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;

import com.jiang.kuaikan.R;

public class CustomGridView extends GridView{

    public CustomGridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

    }
    public CustomGridView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }
    public CustomGridView(Context context) {
        super(context);

    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int expandSpec = MeasureSpec.makeMeasureSpec(
                Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);

    }
}
