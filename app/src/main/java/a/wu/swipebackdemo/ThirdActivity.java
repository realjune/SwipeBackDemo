package a.wu.swipebackdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.ziv.swipebackexample.utils.AndroidBug5497Workaround;
import com.example.ziv.swipebackexample.utils.StateBarTranslucentUtils;

/**
 * Created by JiaQing on 2016/7/17.
 * 如果设置全屏后,没有android:fitsSystemWindows=true这个属性，点击输入框后会出现输入框被输入法挡住的问题
 */
public class ThirdActivity extends  BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
       // AndroidBug5497Workaround.assistActivity(this);
        initView();
        initData();
    }

    @Override
    protected void initView() {
       // super.initView();
        mToolBar = (Toolbar) findViewById(R.id.toolbar);
        //设置状态栏透明
        StateBarTranslucentUtils.setStateBarTranslucent(this);

        //获得状态栏高度
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        int stateBarHeight =  getResources().getDimensionPixelSize(resourceId);
        //设置margin
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mToolBar.getLayoutParams();
        layoutParams.setMargins(0, stateBarHeight, 0, 0);
        mToolBar.setLayoutParams(layoutParams);

    }

    public void next(View view){
        startActivity(new Intent(context,FourthActivity.class));
    }



    public void dynamicAdjustmentHeight(View view){

        AndroidBug5497Workaround.assistActivity(this);

    }

}
