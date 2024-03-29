package dev.roeeyn.neonergia.di

import dev.roeeyn.neonergia.ui.introduction.IntroductionMvp
import dev.roeeyn.neonergia.ui.introduction.IntroductionPresenter
import dev.roeeyn.neonergia.ui.permissions_requests.PermissionRequestMvp
import dev.roeeyn.neonergia.ui.permissions_requests.PermissionRequestPresenter
import dev.roeeyn.neonergia.ui.splash.SplashMvp
import dev.roeeyn.neonergia.ui.splash.SplashPresenter
import dev.roeeyn.neonergia.ui.terms_and_conditions.TermsMvp
import dev.roeeyn.neonergia.ui.terms_and_conditions.TermsPresenter
import org.koin.dsl.module.applicationContext

class ActivityModule {
    companion object {
        fun providePresenters() = applicationContext {
            bean { SplashPresenter<SplashMvp.View>(get()) as SplashMvp.Presenter<SplashMvp.View> }
            bean { IntroductionPresenter<IntroductionMvp.View>(get()) as IntroductionMvp.Presenter<IntroductionMvp.View> }
            bean { TermsPresenter<TermsMvp.View>(get()) as TermsMvp.Presenter<TermsMvp.View> }
            bean { PermissionRequestPresenter<PermissionRequestMvp.View>(get()) as PermissionRequestMvp.Presenter<PermissionRequestMvp.View> }
        }
    }
}