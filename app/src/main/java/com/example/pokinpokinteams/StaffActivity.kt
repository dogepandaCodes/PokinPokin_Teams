package com.example.pokinpokinteams

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class StaffActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_staff)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerRecords)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val records = mutableListOf(
            ExchangeRecord(phone = "138-1234-5678", points = 2, time = "2026-01-04 14:30"),
            ExchangeRecord(phone = "139-8765-4321", points = 1, time = "2026-01-04 15:45")
        )

        recyclerView.adapter = ExchangeRecordAdapter(records)

        findViewById<android.view.View>(R.id.btnNewExchange).setOnClickListener {
            startActivity(Intent(this, NewExchangeActivity::class.java))
        }
    }
}


