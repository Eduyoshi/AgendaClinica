package com.example.agendaclinica

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//Criando o Adapter para o gerenciamento da lista de contatos
//Passando o ViewHolder como tipo do Adapter
class ContactAdapter: RecyclerView.Adapter<ContactAdapter.ContactAdapterViewHolder>() {

    private val list: MutableList<Contact> = mutableListOf()
    //cria os item para posterior população
    //criação da view e inflando o layout do item
    //retorna o adapter com a view como construtor
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false)
        return ContactAdapterViewHolder(view)
    }

    //função que popula o item na lista do recyclerview
    override fun onBindViewHolder(holder: ContactAdapterViewHolder, position: Int) {
        //verificando o item da lista
        holder.bind(list[position])
    }

    //função que obtem o numero de item da lista
    override fun getItemCount(): Int {
        return list.size
    }

    //criando função responsavel por dar um update na lista a ser mostrada
    //notifyDataSetChanged() notifica o adapter que houve mudança
    fun updateList(list:List<Contact>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    //criando o ViewHolder para gerenciamento dos itens da lista
    //utilizando o item view no construtor
    //criando a função bind para popular através do onBindViewHolder
    class ContactAdapterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val tvName: TextView = itemView.findViewById(R.id.tv_name)
        private val tvPhone: TextView = itemView.findViewById(R.id.tv_phone)
        private val ivPhoto: ImageView = itemView.findViewById(R.id.iv_photo)

        //populando com os atributos de cada item da lista
        fun bind(contact:Contact){
            tvName.text = contact.name
            tvPhone.text = contact.phone

        }
    }
}