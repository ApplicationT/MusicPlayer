package com.example.xiamin.musicplayer.Activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.xiamin.musicplayer.R;

/**
 * Created by Xiamin on 2016/8/27.
 */
public class WelcomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View view = View.inflate(this, R.layout.welcome, null);
        setContentView(view);
        /**
         * 改成放大的属性动画
         */
        ObjectAnimator animtorAlpha = ObjectAnimator.ofFloat(view,"alpha",0.1f,1f);
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(view, "scaleX", 1f, 1.0f);
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(view, "scaleY", 1f, 1.0f);

        AnimatorSet set = new AnimatorSet();
        set.setDuration(1000).play(animatorX).with(animatorY).with(animtorAlpha);
        set.start();

        set.addListener(new AnimatorListenerAdapter()
        {

            @Override
            public void onAnimationEnd(Animator animation)
            {

                startActivity(new Intent(WelcomeActivity.this, MusicActivity.class));
                WelcomeActivity.this.finish();
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
            }
        });

    }
}
