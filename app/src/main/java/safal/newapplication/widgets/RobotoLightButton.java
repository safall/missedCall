package safal.newapplication.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

import safal.newapplication.MainActivity;


public class RobotoLightButton extends Button {

    public RobotoLightButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setCustomTextStyle();

    }

    public RobotoLightButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCustomTextStyle();
    }

    public RobotoLightButton(Context context) {
        super(context);
        setCustomTextStyle();
    }

    private void setCustomTextStyle() {
        this.setTypeface(MainActivity.Fonts.ROBOT0_LIGHT);
        // setClickable(true);
    }
}
