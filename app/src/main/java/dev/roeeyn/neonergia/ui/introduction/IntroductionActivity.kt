package dev.roeeyn.neonergia.ui.introduction

import android.content.Intent
import android.os.Bundle
import android.util.TypedValue
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import dev.roeeyn.neonergia.R
import dev.roeeyn.neonergia.ui.base.BaseActivity
import dev.roeeyn.neonergia.ui.permissions_requests.PermissionRequestActivity

import kotlinx.android.synthetic.main.activity_introduction.*
import kotlinx.android.synthetic.main.content_introduction.*
import org.koin.android.ext.android.inject

class IntroductionActivity : BaseActivity(), IntroductionMvp.View {

    private val mPresenter: IntroductionMvp.Presenter<IntroductionMvp.View> by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_introduction)
        mPresenter.onAttach(this)

        // TODO teh text need to be changed from 20sp to 18 to fitting well on screen
        // "@string/intro_text_1"

        fab.setOnClickListener { mPresenter.onNextClick() }
    }

    override fun changeCardText() {
        intro_text.text = getString(R.string.intro_text_2)
        intro_text.setTextSize(TypedValue.COMPLEX_UNIT_SP,18.0f)

    }

    override fun goToNextScreen() {
        startActivity(Intent(this, PermissionRequestActivity::class.java))
    }

    override fun isLastText(): Boolean = intro_text.text == getString(R.string.intro_text_2)


}
