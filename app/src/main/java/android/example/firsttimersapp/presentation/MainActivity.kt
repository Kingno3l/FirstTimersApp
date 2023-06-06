package android.example.firsttimersapp.presentation

import android.app.Dialog
import android.example.firsttimersapp.R
import android.example.firsttimersapp.databinding.ActivityMainBinding
import android.example.firsttimersapp.databinding.LayoutFormBinding
import android.example.firsttimersapp.domain.FirstTimer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var formDialog: Dialog
    private lateinit var adapter: FirstTimerAdapter
    private val firstTimerList = mutableListOf<FirstTimer>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.rvFirstTimers.layoutManager = layoutManager

        firstTimerList.addAll(
            listOf(
                FirstTimer("jonah Idowu", "+23480902323", "idowujonah@lw.com", "10 idowu street, guzape, abuja", "pray for Nigeria"),
                FirstTimer("jonah Idowu", "+23480902323", "idowujonah@lw.com", "10 idowu street, guzape, abuja", "pray for Nigeria"),
                FirstTimer("jonah Idowu", "+23480902323", "idowujonah@lw.com", "10 idowu street, guzape, abuja", "pray for Nigeria")
            )
        )

        adapter = FirstTimerAdapter(firstTimerList)
        binding.rvFirstTimers.adapter = adapter

        binding.fab.setOnClickListener {
            showFormDialog()
        }
    }

    private fun showFormDialog(){

        val formDialogBinding = LayoutFormBinding.inflate(layoutInflater)
        val formDialogView = formDialogBinding.root

        val etFullName = formDialogBinding.etFullName
        val etPhoneNumber = formDialogBinding.etPhoneNumber
        val etEmail = formDialogBinding.etEmail
        val etAddress = formDialogBinding.etAddress
        val etQuestions = formDialogBinding.etQuestions
        val btnSubmit = formDialogBinding.btnSubmit
        btnSubmit.setOnClickListener {
            val fullName = etFullName.text.toString()
            val phoneNumber = etPhoneNumber.text.toString()
            val email = etEmail.text.toString()
            val address = etAddress.text.toString()
            val questions = etQuestions.text.toString()

            val firstTimer = FirstTimer(fullName, phoneNumber, email, address, questions)
            firstTimerList.add(firstTimer)
            adapter.notifyItemInserted(firstTimerList.size - 1)

            formDialog.dismiss() // Dismiss the dialog after submitting
        }

        formDialog = Dialog(this)
        formDialog.setContentView(formDialogView)

        // Adjust the width of the dialog
        val window = formDialog.window
        window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)

        formDialog.show()
    }
}
