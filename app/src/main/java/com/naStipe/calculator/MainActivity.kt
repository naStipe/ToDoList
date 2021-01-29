

package com.naStipe.calculator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listOfToDos = mutableListOf<String>("Item 1", "Item 2", "Item 3")

        val listOfToDosView: RecyclerView = findViewById(R.id.listOfToDos)

        val myAdapter = MyAdapter(this)

        val myButton = findViewById<ImageButton>(R.id.addItemButton)

        val myEditText = findViewById<EditText>(R.id.editText)

        myButton.setOnClickListener {
            myAdapter.listOfToDos.add(myEditText.text.toString())
            myAdapter.notifyDataSetChanged()
        }

        myAdapter.setListOfToDos(listOfToDos)
        listOfToDosView.adapter = myAdapter
    }

    class MyAdapter(private val context: Context) : RecyclerView.Adapter<MyViewHolder> (){
        val listOfToDos = mutableListOf<String>()
        fun setListOfToDos(items: List<String>){
            listOfToDos.clear()
            listOfToDos.addAll(items)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false)
            return MyViewHolder(view)
        }

        override fun getItemCount(): Int {
            return listOfToDos.size
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.textView.text = listOfToDos[position]
        }
    }
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val textView = view.findViewById<TextView>(android.R.id.text1)
    }
}

