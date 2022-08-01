package com.example.companyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.PopupMenu
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.companyapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    //private lateinit var memberList: MutableList<Member>

    private lateinit var popupMenu: PopupMenu

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

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
                    // alert dialog açılacka
                    true
                }
                R.id.delete -> {
                    Toast.makeText(this, "delete clicked", Toast.LENGTH_LONG).show()
                    true
                }
                R.id.report -> {
                    Toast.makeText(this, "report clicked", Toast.LENGTH_LONG).show()
                    true

                }
                R.id.edit -> {
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
        memberList.add(Member("dfwakdwa","gwagaw",R.drawable.dicaprio))
        memberList.add(Member("dfwakdwa","gwagaw",R.drawable.dicaprio))
        memberList.add(Member("dfwakdwa","gwagaw",R.drawable.dicaprio))
        memberList.add(Member("dfwakdwa","gwagaw",R.drawable.dicaprio))
        memberList.add(Member("dfwakdwa","gwagaw",R.drawable.dicaprio))

        val rvAdapter = MembersAdapter(memberList)

        val linearLayoutManager = LinearLayoutManager(this)

        binding.recyclerView.apply {
            layoutManager = linearLayoutManager
            adapter = rvAdapter
        }
    }
}
