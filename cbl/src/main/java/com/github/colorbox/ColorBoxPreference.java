package com.github.colorbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;

public class ColorBoxPreference extends Preference {

    private Context mContext;
    private int mSelectedColor;
    private int mTheme;

    public ColorBoxPreference(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    private ColorBoxPreference(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        mContext = context;

        mSelectedColor = ColorBox.getColor(getKey(), mContext);

        setSummary(ColorBox.getHexadecimal(mSelectedColor).toUpperCase());
        setLayoutResource(R.layout.preference);

        //getting setTheme attr value to determine the ColorBox theme
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ThemeValue, ColorBox.THEME_DEFAULT,
                ColorBox.THEME_DEFAULT);

        int themeValue;

        try {
            themeValue = a.getInteger(R.styleable.ThemeValue_setTheme, ColorBox.THEME_DEFAULT);
        } finally {
            a.recycle();
        }

        mTheme = themeFromPreference(themeValue);
    }

    //determine the theme of the ColorBox
    private static int themeFromPreference(int value) {

        switch (value) {
            default:
            case ColorBox.THEME_DEFAULT:
                return ColorBox.LIGHT;

            case ColorBox.THEME_DARK:
                return ColorBox.DARK;

            case ColorBox.THEME_BLACK:
                return ColorBox.BLACK;
        }
    }

    @Override
    protected void onBindView(View view) {
        super.onBindView(view);

        view.findViewById(R.id.icon).setBackground(Utils.round(mContext.getResources(), false, android.R.dimen.app_icon_size, mSelectedColor));
    }

    @Override
    protected void onClick() {
        super.onClick();

        ColorBox.showColorBoxPreference(getKey(), mContext, mTheme);
    }
}
