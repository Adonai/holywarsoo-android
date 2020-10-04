package com.kanedias.holywarsoo

import android.app.Application
import android.content.Context
import ca.psiphon.PsiphonTunnel
import com.kanedias.holywarsoo.service.*
import org.acra.ACRA
import org.acra.annotation.AcraCore
import org.acra.annotation.AcraDialog
import org.acra.annotation.AcraMailSender
import org.acra.data.StringFormat


/**
 * Main application class.
 * Place to initialize all data prior to launching activities.
 *
 * @author Kanedias
 *
 * Created on 2019-12-27
 */
@AcraDialog(resIcon = R.drawable.ic_launcher_round, resText = R.string.app_crashed, resCommentPrompt = R.string.leave_crash_comment, resTheme = R.style.FireTheme)
@AcraMailSender(mailTo = "kanedias@xaker.ru", resSubject = R.string.app_crash_report, reportFileName = "crash-report.json")
@AcraCore(buildConfigClass = BuildConfig::class, reportFormat = StringFormat.JSON, alsoReportToAndroidFramework = true)
class MainApplication : Application() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)

        // init crash reporting
        ACRA.init(this)
    }

    override fun onCreate() {
        super.onCreate()

        Config.init(this)
        Network.init(this)
        CensorshipCircumvention.init(this)
        Database.init(this)
        SmiliesCache.init(this)
    }
}
