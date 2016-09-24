package safal.newapplication.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;


import safal.newapplication.MainActivity;


public class BrandonGrotesqueTextView extends TextView {

	public BrandonGrotesqueTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		setCustomTextStyle();

	}

	public BrandonGrotesqueTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		setCustomTextStyle();
	}

	public BrandonGrotesqueTextView(Context context) {
		super(context);
		setCustomTextStyle();
	}

	private void setCustomTextStyle() {
		this.setTypeface(MainActivity.Fonts.Brandon_Grotesque);
		// setClickable(true);
	}
}
