package com.chrisy.probonocases.ui.theme

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.chrisy.probonocases.R

class CaseDetailActivity : AppCompatActivity() {

    // Define view references
    private lateinit var textViewCaseTitle: TextView
    private lateinit var textViewCaseDescription: TextView
    private lateinit var textViewCaseStatus: TextView
    private lateinit var textViewJudgeName: TextView
    private lateinit var textViewLawyerName: TextView
    private lateinit var textViewCaseDetails: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_case_detail)

        // Initialize view references
        textViewCaseTitle = findViewById(R.id.textViewCaseTitle)
        textViewCaseDescription = findViewById(R.id.textViewCaseDescription)
        textViewCaseStatus = findViewById(R.id.textViewCaseStatus)
        textViewJudgeName = findViewById(R.id.textViewJudgeName)
        textViewLawyerName = findViewById(R.id.textViewLawyerName)
        textViewCaseDetails = findViewById(R.id.textViewCaseDetails)

        // Enable back button in action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Get case data from intent
        val caseId = intent.getStringExtra("CASE_ID") ?: ""
        val caseTitle = intent.getStringExtra("CASE_TITLE") ?: ""
        val caseDescription = intent.getStringExtra("CASE_DESCRIPTION") ?: ""
        val caseStatus = intent.getStringExtra("CASE_STATUS") ?: ""

        // Set action bar title
        supportActionBar?.title = caseTitle

        // Display case information
        textViewCaseTitle.text = caseTitle
        textViewCaseDescription.text = caseDescription
        textViewCaseStatus.text = "Status: $caseStatus"

        // For demonstration purposes, setting some mock data for judges and lawyers
        setupCaseParticipants(caseId)
    }

    private fun setupCaseParticipants(caseId: String) {
        // Mock data - in a real app, you would fetch this based on the caseId
        val judgeName = "Judge Maria Rodriguez"
        val lawyerName = "Atty. John Smith"

        textViewJudgeName.text = judgeName
        textViewLawyerName.text = lawyerName

        // Additional case details
        textViewCaseDetails.text = """
            Court: Superior Court of California
            Filed: March 15, 2025
            Next Hearing: May 10, 2025
            Case Type: Civil Rights
        """.trimIndent()
    }

    // Handle back button click
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}