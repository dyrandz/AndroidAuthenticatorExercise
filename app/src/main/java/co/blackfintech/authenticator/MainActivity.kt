package co.blackfintech.authenticator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import co.blackfintech.authenticator.util.SessionStore
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    supportActionBar?.hide()
    logoutButton.onClick {

      alert("Are you sure you want to logout?", "Confirmation"){
        yesButton { logout() }
        noButton {}
      }.show()
    }
  }

  private fun logout(){

    startActivity<LoginActivity>()

    SessionStore().clearEmail(this)
    finish()

  }
}
