package vn.edu.vlu.myapplication
import android.graphics.Color
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val edtEmail = findViewById<EditText>(R.id.edtEmail)
        val edtPassword = findViewById<EditText>(R.id.edtPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvStatus = findViewById<TextView>(R.id.tvStatus)

        btnLogin.setOnClickListener {
            val email = edtEmail.text.toString().trim()
            val password = edtPassword.text.toString()

            when {
                email.isEmpty() && password.isEmpty() -> showError(tvStatus, "Vui lòng nhập Email và Mật khẩu!")
                email.isEmpty() -> showError(tvStatus, "Email không được để trống!")
                password.isEmpty() -> showError(tvStatus, "Mật khẩu không được để trống!")
                !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> showError(tvStatus, "Email không đúng định dạng!")
                password.length < 6 -> showError(tvStatus, "Mật khẩu phải có ít nhất 6 ký tự!")
                else -> {
                    tvStatus.setTextColor(Color.parseColor("#2E7D32"))
                    tvStatus.text = "Xác thực thành công!"
                }
            }
        }
    }

    private fun showError(tv: TextView, msg: String) {
        tv.setTextColor(Color.RED)
        tv.text = msg
    }
}