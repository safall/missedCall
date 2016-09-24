package safal.newapplication.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import safal.newapplication.MainActivity;


public class RobotoRegularTextView extends TextView {

	public RobotoRegularTextView(Context context, AttributeSet attrs,
								 int defStyle) {
		super(context, attrs, defStyle);
		setCustomTextStyle();

	}

	public RobotoRegularTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		setCustomTextStyle();
	}

	public RobotoRegularTextView(Context context) {
		super(context);
		setCustomTextStyle();
	}

	private void setCustomTextStyle() {
		this.setTypeface(MainActivity.Fonts.ROBOTO_REGULAR);
		// setClickable(true);
	}
}
