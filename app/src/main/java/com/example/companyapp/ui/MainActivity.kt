package com.example.companyapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.companyapp.model.Member
import com.example.companyapp.R
import com.example.companyapp.adapter.DialogAdapter
import com.example.companyapp.adapter.MembersAdapter
import com.example.companyapp.databinding.ActivityMainBinding
import com.example.companyapp.model.DialogModel
import kotlinx.android.synthetic.main.dialog_recycler.view.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    //private lateinit var memberList: MutableList<Member>

    private lateinit var popupMenu: PopupMenu

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val resources = resources
        val text = resources.getString(R.string.member, 14)
        binding.textViewMembers.text = text
        createPopupMenu()

        popupMenuClickListener()

        setAdapter()
    }

    private fun createPopupMenu() {

        popupMenu = PopupMenu(this, binding.imageViewMenu)

        popupMenu.inflate(R.menu.menu)

        popupMenu.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.define -> {

                    val builder = AlertDialog.Builder(this)
                    val customLayout = layoutInflater.inflate(R.layout.dialog_recycler,null)

                    builder.setView(customLayout)

                    val dialogList = arrayListOf<DialogModel>()
                    dialogList.add(DialogModel(false,R.drawable.ben,"Muhammet","Software engineer"))
                    dialogList.add(DialogModel(false,R.drawable.brad,"brad","actor"))
                    dialogList.add(DialogModel(false,R.drawable.dicaprio,"dicaprio","actor"))
                    dialogList.add(DialogModel(false,R.drawable.max,"max","f1 driver"))
                    val adapter = DialogAdapter(dialogList)
                    customLayout.rootView.recyclerView.adapter = adapter



                    builder.create().show()
                    true
                }
                R.id.edit -> {
                    Toast.makeText(this, "delete clicked", Toast.LENGTH_LONG).show()
                    true
                }
                R.id.delete -> {
                    Toast.makeText(this, "report clicked", Toast.LENGTH_LONG).show()
                    true

                }
                R.id.reports -> {
                    Toast.makeText(this, "other clicked", Toast.LENGTH_LONG).show()
                    true
                }
                else -> {
                    true
                }
            }
        }
    }

    private fun popupMenuClickListener() {
        binding.imageViewMenu.setOnClickListener {
            try {
                val popup = PopupMenu::class.java.getDeclaredField("mPopup")
                popup.isAccessible = true
                val menu = popup.get(popupMenu)
                menu.javaClass.getDeclaredMethod("setForceShowIcon", Boolean::class.java)
                    .invoke(menu, true)
            } catch (e: Exception) {
                Log.d("error", e.toString())
            } finally {
                popupMenu.show()
            }
            true
        }
    }

    private fun setAdapter() {
        val memberList = mutableListOf<Member>()
        memberList.add(Member("Dicaprio", "actor", R.drawable.dicaprio))
        memberList.add(Member("Brad pitt", "actor", R.drawable.brad))
        memberList.add(Member("Muhammet", "software engineer", R.drawable.ben))
        memberList.add(Member("John", "designer", R.drawable.dicaprio))
        memberList.add(Member("Verstappen", "F1 Driver", R.drawable.max))

        val rvAdapter = MembersAdapter(memberList)

        val linearLayoutManager = LinearLayoutManager(this)

        binding.recyclerView.apply {
            layoutManager = linearLayoutManager
            adapter = rvAdapter
        }
    }


}
