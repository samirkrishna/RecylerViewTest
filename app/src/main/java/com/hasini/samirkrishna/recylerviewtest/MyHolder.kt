package com.hasini.samirkrishna.recylerviewtest

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class MyHolder : RecyclerView.ViewHolder{

    var iview:ImageView?=null
    var name:TextView?=null
    var size:TextView?=null
    var del:ImageView?=null
    constructor(v:View) : super(v) {

        iview=itemView.findViewById(R.id.iv1)
        name=itemView.findViewById(R.id.tv1)
        size=itemView.findViewById(R.id.tv2)
        del=itemView.findViewById(R.id.del)
    }

}