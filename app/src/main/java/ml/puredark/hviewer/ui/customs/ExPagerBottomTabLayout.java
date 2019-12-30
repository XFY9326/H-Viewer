package ml.puredark.hviewer.ui.customs;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;

import androidx.core.graphics.drawable.DrawableCompat;

import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.PageNavigationView;
import me.majiajie.pagerbottomtabstrip.item.NormalItemView;
import ml.puredark.hviewer.R;

/**
 * Created by PureDark on 2016/10/12.
 */

public class ExPagerBottomTabLayout extends PageNavigationView {
    private TypedArray typedArray;

    public ExPagerBottomTabLayout(Context context) {
        super(context);
    }

    public ExPagerBottomTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (isInEditMode()) {
            typedArray = context.obtainStyledAttributes(attrs, R.styleable.ExPagerBottomTabLayout);
            preview(context, typedArray);
        }
    }

    public ExPagerBottomTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (isInEditMode()) {
            typedArray = context.obtainStyledAttributes(attrs, R.styleable.ExPagerBottomTabLayout);
            preview(context, typedArray);
        }
    }

    public void preview(Context context, TypedArray a) {
        final String tabStrArr = a.getString(R.styleable.ExPagerBottomTabLayout_bottomTabTitleArray);
        final String[] tabRealStrArr = getTabRealStrArr(tabStrArr);
        TypedValue typedValue = new TypedValue();
        TypedArray colorType = context.obtainStyledAttributes(typedValue.data, new int[]{R.attr.colorPrimaryDark});
        int color = colorType.getColor(0, 0);
        a.recycle();
        CustomBuilder builder = this.custom();
        for (int i = 0; i < tabRealStrArr.length; i++) {
            String tabTitle = tabRealStrArr[i];
            Drawable icon = null;
            switch (i) {
                case 0:
                    icon = a.getDrawable(R.styleable.ExPagerBottomTabLayout_bottomTab1);
                    break;
                case 1:
                    icon = a.getDrawable(R.styleable.ExPagerBottomTabLayout_bottomTab2);
                    break;
                case 2:
                    icon = a.getDrawable(R.styleable.ExPagerBottomTabLayout_bottomTab3);
                    break;
                case 3:
                    icon = a.getDrawable(R.styleable.ExPagerBottomTabLayout_bottomTab4);
                    break;
                case 4:
                    icon = a.getDrawable(R.styleable.ExPagerBottomTabLayout_bottomTab5);
                    break;
            }
            NormalItemView normalItemView = new NormalItemView(context);
            normalItemView.setTitle(tabTitle);
            if (icon != null) {
                Drawable wrappedDrawable1 = DrawableCompat.wrap(icon);
                DrawableCompat.setTint(wrappedDrawable1, 0xFF696969);
                normalItemView.setDefaultDrawable(wrappedDrawable1);

                Drawable wrappedDrawable2 = DrawableCompat.wrap(icon);
                DrawableCompat.setTint(wrappedDrawable2, color);
                normalItemView.setSelectedDrawable(wrappedDrawable2);
            }
            builder.addItem(normalItemView);
        }
        NavigationController controller = builder.build();
        int currItem = a.getInt(R.styleable.ExPagerBottomTabLayout_bottomCurrItem, 0);
        controller.setSelect(currItem);
        colorType.recycle();
    }

    private String[] getTabRealStrArr(String tabStrArr) {
        if (tabStrArr != null && !tabStrArr.equals(""))
            return tabStrArr.split(",");
        else
            return new String[0];
    }

}
