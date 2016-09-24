package safal.newapplication.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;


import safal.newapplication.MainActivity;


public class RobotoRegularEditText extends EditText {

	public RobotoRegularEditText(Context context, AttributeSet attrs,
								 int defStyle) {
		super(context, attrs, defStyle);
		setCustomTextStyle();

	}

	public RobotoRegularEditText(Context context, AttributeSet attrs) {
		super(context, attrs);
		setCustomTextStyle();
	}

	public RobotoRegularEditText(Context context) {
		super(context);
		setCustomTextStyle();
	}

	private void setCustomTextStyle() {
		this.setTypeface(MainActivity.Fonts.ROBOTO_REGULAR);
		// setClickable(true);
	}
}
