package all.stage.myapplication

import all.stage.myapplication.R.id.TVacueil
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import kotlinx.android.synthetic.main.activity_splash_screen.*


class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        Handler().postDelayed({
            var intent = Intent(this, StartActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }

    override fun onResume() {
        super.onResume()
        val anim = RotateAnimation(10f, 30f, 15f, 15f)
        anim.interpolator = LinearInterpolator()
        anim.repeatCount = 0
        anim.duration = 700

            tvImageAcuiell.startAnimation(anim)

       // tvImageAcuiell.setAnimation(null)
        TVacueil.startAnimation(AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left))
    }


}
