package com.rocketmoon.draganddrop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.rocketmoon.draganddrop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    data class SampleData(val title: String)

    private var sampleList = arrayListOf(
        SampleData("메뉴"), SampleData("탭"),
        SampleData("공지사항"), SampleData("호출 목록")
    )

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mAdapter: MainListAdapter
    private var mItemTouchHelper: ItemTouchHelper? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mAdapter = MainListAdapter()
        val mCallback = ItemTouchHelperCallback(mAdapter)
        mItemTouchHelper = ItemTouchHelper(mCallback)
        mItemTouchHelper?.attachToRecyclerView(mBinding.rvMain) // ItemTouchHelper를 RecyclerView에 연결
        mAdapter.setData(sampleList)

        mBinding.rvMain.adapter = mAdapter
        mBinding.rvMain.layoutManager = LinearLayoutManager(this)

        mAdapter.itemDragListener(object : ItemStartDragListener{
            override fun onDropActivity(
                initList: ArrayList<SampleData>,
                changeList: ArrayList<SampleData>
            ) {
                // TODO : 드랍됐을 때 처리
            }
        })
    }
}