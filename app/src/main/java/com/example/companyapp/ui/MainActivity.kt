package com.example.companyapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.companyapp.BottomSheet
import com.example.companyapp.model.Member
import com.example.companyapp.R
import com.example.companyapp.adapter.DialogAdapter
import com.example.companyapp.adapter.MembersAdapter
import com.example.companyapp.databinding.ActivityMainBinding
import com.example.companyapp.model.DialogModel
import com.example.companyapp.model.DummyData
import kotlinx.android.synthetic.main.dialog_recycler.view.*
import kotlinx.android.synthetic.main.item_person.view.*
import kotlinx.android.synthetic.main.item_rv_dialog.view.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var memberList: ArrayList<Member>

    private lateinit var popupMenu: PopupMenu

    private lateinit var rvAdapter : MembersAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val resources = resources
        val text = resources.getString(R.string.member, 14)
        binding.textViewMembers.text = text
        createPopupMenu()
//        val bottomSheet = BottomSheet(this)
//        bottomSheet.showBottomDialog()

        popupMenuClickListener()

        setAdapter()
    }


    private fun createPopupMenu() {

        popupMenu = PopupMenu(this, binding.imageViewMenu)

        popupMenu.inflate(R.menu.menu)

        popupMenu.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.define -> {

                    val builder = AlertDialog.Builder(this).create()
                    val customLayout = layoutInflater.inflate(R.layout.dialog_recycler,null)

                    builder.setView(customLayout)



                    val adapter = DialogAdapter(DummyData.dialogList)
                    customLayout.rootView.recyclerView.adapter = adapter


                    customLayout.rootView.defineButton.setOnClickListener {
                            //binding.recyclerView.rootView.textViewCompanyManager.visibility = View.VISIBLE
//                              val layoutInflater = layoutInflater.inflate(R.layout.item_person,null)
//                              layoutInflater.textViewCompanyManager.visibility = View.VISIBLE
                        for (index in DummyData.dialogList.indices) {
                            if (DummyData.dialogList.get(index).checked) {
                                DummyData.dialogList.get(index)?.checked = true
                            }
                        }


                        builder.dismiss()

                        rvAdapter.notifyDataSetChanged()



                    }



                    builder.show()
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


       // memberList.set(0,Member(check = false))

        rvAdapter = MembersAdapter(DummyData.dialogList)
      //  rvAdapter.notifyDataSetChanged()
        val linearLayoutManager = LinearLayoutManager(this)

        binding.recyclerView.apply {
            layoutManager = linearLayoutManager
            adapter = rvAdapter
        }
    }







}
