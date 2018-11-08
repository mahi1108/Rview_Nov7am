package cubex.mahesh.rview_nov7am

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.indiview.view.*

class MyHolder(v:View) : RecyclerView.ViewHolder(v)
{
    var iview:ImageView? = null
    var name:TextView? = null
    var size:TextView? = null
    var del:Button? = null
   init {
       iview = v.iview
       name = v.name
       size = v.size
       del = v.del
   }

}