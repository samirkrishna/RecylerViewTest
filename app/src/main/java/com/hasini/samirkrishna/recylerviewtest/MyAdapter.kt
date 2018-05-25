package com.hasini.samirkrishna.recylerviewtest

import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.io.File
import java.util.zip.Inflater

class MyAdapter:RecyclerView.Adapter<MyHolder>{

    var mActivity:MainActivity?=null
    var files:Array<File>?=null
    constructor(mActivity:MainActivity)
    {
        this.mActivity=mActivity
        var path="storage/emulated/0/WhatsApp/Media/WhatsApp Images/"
        var file=File(path)
        if(!file.exists())
        {
            path="storage/sdcard0/WhatsApp/Media/WhatsApp Images/"
            file=File(path)
        }
        files=file.listFiles()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {//call only once
        var inflator=LayoutInflater.from(mActivity)
        var view=inflator.inflate(R.layout.indiview,parent,false)
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
    return files!!.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {

        var file=files?.get(position)
        holder.iview?.setImageURI(Uri.fromFile(file))
        holder.name?.setText(file?.name)
        holder.size?.setText(file?.length().toString())
        holder.del?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                file?.delete()
                var path="storage/emulated/0/WhatsApp/Media/WhatsApp Images/"
                var file=File(path)
                if(!file.exists())
                {
                    path="storage/sdcard0/WhatsApp/Media/WhatsApp Images/"
                    file=File(path)
                }
                files=file.listFiles()
                this@MyAdapter.notifyDataSetChanged()
            }
        })
    }
}