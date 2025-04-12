package com.chrisy.probonocases.ui.theme

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chrisy.probonocases.R

class CaseListActivity : AppCompatActivity() {
    private lateinit var recyclerViewCases: RecyclerView
    private lateinit var spinnerStatus: Spinner
    private lateinit var textViewFilterTitle: TextView
    private lateinit var viewEmptyCases: LinearLayout

    private lateinit var caseAdapter: CaseAdapter
    private var caseList: MutableList<Case> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_case_list)

        // Initialize views
        recyclerViewCases = findViewById(R.id.recyclerViewCases)
        spinnerStatus = findViewById(R.id.spinnerStatus)
        textViewFilterTitle = findViewById(R.id.textViewFilterTitle)
        viewEmptyCases = findViewById(R.id.viewEmptyCases)

        // Setup RecyclerView
        setupRecyclerView()

        // Setup Status Spinner
        setupStatusSpinner()

        // Load initial cases
        loadCases()
    }

    private fun setupRecyclerView() {
        caseAdapter = CaseAdapter(caseList)
        recyclerViewCases.layoutManager = LinearLayoutManager(this)
        recyclerViewCases.adapter = caseAdapter
    }

    private fun setupStatusSpinner() {
        // Define status filter options
        val statusOptions = arrayOf(
            "All Cases",
            "Open",
            "In Progress",
            "Closed"
        )

        // Create an ArrayAdapter using the string array and a default spinner layout
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            statusOptions
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Apply the adapter to the spinner
        spinnerStatus.adapter = adapter

        // Set spinner item selection listener
        spinnerStatus.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                // Update filter title
                textViewFilterTitle.text = "Showing: ${statusOptions[position]}"

                // Filter cases based on selected status
                filterCases(statusOptions[position])
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Do nothing
            }
        }
    }

    private fun loadCases() {
        // Simulate loading cases - replace with actual data retrieval
        caseList.addAll(listOf(
            Case("Pro Bono Case 1", "Description of first case", "Open"),
            Case("Pro Bono Case 2", "Description of second case", "In Progress"),
            Case("Pro Bono Case 3", "Description of third case", "Closed")
        ))

        updateUI()
    }

    private fun filterCases(status: String) {
        val filteredList = when (status) {
            "All Cases" -> caseList
            else -> caseList.filter { it.status == status }
        }

        caseAdapter.updateCases(filteredList)
        updateUI()
    }

    private fun updateUI() {
        // Show/hide empty state based on list content
        if (caseList.isEmpty()) {
            recyclerViewCases.visibility = View.GONE
            viewEmptyCases.visibility = View.VISIBLE
        } else {
            recyclerViewCases.visibility = View.VISIBLE
            viewEmptyCases.visibility = View.GONE
        }
    }
}

// Updated Case data class to include status
data class Case(
    val title: String,
    val description: String,
    val status: String
)

// Updated CaseAdapter
class CaseAdapter(
    private var cases: List<Case>
) : RecyclerView.Adapter<CaseAdapter.CaseViewHolder>() {

    class CaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.case_title)
        private val descriptionTextView: TextView = itemView.findViewById(R.id.case_description)
        private val statusTextView: TextView = itemView.findViewById(R.id.case_status)

        fun bind(case: Case) {
            titleTextView.text = case.title
            descriptionTextView.text = case.description
            statusTextView.text = case.status
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CaseViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_case, parent, false)
        return CaseViewHolder(view)
    }

    override fun onBindViewHolder(holder: CaseViewHolder, position: Int) {
        holder.bind(cases[position])
    }

    override fun getItemCount(): Int = cases.size

    fun updateCases(newCases: List<Case>) {
        cases = newCases
        notifyDataSetChanged()
    }
}