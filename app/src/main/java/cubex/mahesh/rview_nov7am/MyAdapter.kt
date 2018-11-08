package cubex.mahesh.rview_nov7am

import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import java.io.File

class MyAdapter(var mActivity:MainActivity) :
        RecyclerView.Adapter<MyHolder>()
{
    var files:Array<File>?= null

    init {
        var path = "/storage/sdcard0/WhatsApp/Media/WhatsApp Images/"
        var file = File(path)
        if(!file.exists())
        {
            path = "/storage/emulated/0/WhatsApp/Media/WhatsApp Images/"
            file = File(path)
        }
       files =  file.listFiles()
    }


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyHolder {
        var linflater = LayoutInflater.from(mActivity)
        var v = linflater.inflate(R.layout.indiview,p0,
                false)
        return MyHolder(v)
    }

    override fun getItemCount(): Int {
        return files!!.size
    }

    override fun onBindViewHolder(p0: MyHolder, p1: Int) {

            var f_new = files!![p1]

            p0.iview!!.setImageURI(Uri.fromFile(f_new))
            p0.name!!.text  = f_new.name
            p0.size!!.text = f_new.length().toString()
            p0.del!!.setOnClickListener {
                f_new.delete()
                var path = "/storage/sdcard0/WhatsApp/Media/WhatsApp Images/"
                var file = File(path)
                if(!file.exists())
                {
                    path = "/storage/emulated/0/WhatsApp/Media/WhatsApp Images/"
                    file = File(path)
                }
                files =  file.listFiles()
                this.notifyDataSetChanged()
            }


    }

}