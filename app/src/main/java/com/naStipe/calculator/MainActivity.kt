package com.naStipe.calculator

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    val prefs: PersistentModule = PrefsModule(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listOfToDos: MutableSet<String> = prefs.getItems()

        val listOfToDosView: RecyclerView = findViewById(R.id.listOfToDos)

        val myAdapter = MyAdapter(this)

        val myButton = findViewById<ImageButton>(R.id.addItemButton)

        val myEditText = findViewById<EditText>(R.id.editText)


        myButton.setOnClickListener {
            myAdapter.listOfToDos.add(myEditText.text.toString())

            prefs.addItem(myEditText.text.toString())

            myAdapter.notifyDataSetChanged()
        }

        listOfToDosView.setOnLongClickListener {

            return@setOnLongClickListener false
        }

        myAdapter.setListOfToDos(listOfToDos)
        listOfToDosView.adapter = myAdapter
    }

    class MyAdapter(private val context: Context) : RecyclerView.Adapter<MyViewHolder>() {
        val listOfToDos = mutableListOf<String>()
        fun setListOfToDos(items: Collection<String>) {
            listOfToDos.clear()
            listOfToDos.addAll(items)
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val view = LayoutInflater.from(context).inflate(R.layout.recyclerview_items_with_menu, parent, false)
            return MyViewHolder(view)
        }

        override fun getItemCount(): Int {
            return listOfToDos.size
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.textView.text = listOfToDos[position]
            holder.textView.setOnCreateContextMenuListener { menu, v, menuInfo ->

                menu?.add(Menu.NONE, 1, 1, "Delete")
                        ?.setOnMenuItemClickListener {
                            removeItemAt(position)
                            return@setOnMenuItemClickListener true
                        }
            }
        }

        private fun removeItemAt(position: Int) {
            listOfToDos.removeAt(position)
            notifyDataSetChanged()
        }
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView = view.findViewById<TextView>(R.id.text)
        val deleteButton = view.findViewById<ImageView>(R.id.delete)
    }
}

