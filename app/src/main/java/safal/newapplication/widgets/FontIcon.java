package safal.newapplication.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import safal.newapplication.MainActivity;


public class FontIcon extends TextView {

    public FontIcon(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setRegularFont();
    }

    public FontIcon(Context context, AttributeSet attrs) {
        super(context, attrs);
        setRegularFont();

    }

    public FontIcon(Context context) {
        super(context);
        setRegularFont();
    }

    public FontIcon(Context context, boolean isBold) {
        super(context);

    }

    public void setRegularFont() {
        setTypeface(MainActivity.Fonts.FONT_ICON);
    }


    public void setOnTouchListener(OnClickListener onClickListener) {
    }
}
