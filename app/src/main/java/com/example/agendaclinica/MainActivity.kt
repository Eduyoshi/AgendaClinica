package com.example.agendaclinica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    //declarando o recyclerView a utilizando o id criando no main layout
    private val rvList: RecyclerView by lazy{
        findViewById<RecyclerView>(R.id.rvList)
    }

    //declarando o adapter
    private val adapter = ContactAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindViews()
        updateList()
    }

    private fun bindViews(){
        rvList.adapter = adapter
        rvList.layoutManager = LinearLayoutManager(this)
    }

    private fun updateList(){
        adapter.updateList(
            //mokando a lista de contatos
            arrayListOf(
                Contact(
                "Eduardo",
                "(00)00000-0000",
                "img.png"
                ),
                Contact(
                "Eduardo",
                "(00)00000-0000",
                "img.png"
                ),
                Contact(
                "Eduardo",
                "(00)00000-0000",
                "img.png"
                )
            )
        )
    }
}