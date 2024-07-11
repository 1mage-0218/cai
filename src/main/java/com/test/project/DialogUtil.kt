package com.test.project

import android.app.Dialog
import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.EditText
import android.widget.TextView

/**
 * ━━━━━━神兽出没━━━━━━
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃  神兽保佑
 * 　　　　┃　　　┃  代码无bug
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━感觉萌萌哒━━━━━━
 *
 * @author hao
 * @date 2018/12/15
 * @description
 */
object DialogUtil {
    /**
     * 显示常规弹窗
     * @param context
     * @param listener 点击确认回调
     * @return
     */
    fun showCustomDialog(context: Context?, listener: OnCustomClickListener): Dialog {
        val view = LayoutInflater.from(context).inflate(R.layout.dialog_delete, null)
        val tv_dialog_ident_name = view.findViewById<View>(R.id.tv_dialog_ident_name) as EditText
        val tv_cancel = view.findViewById<View>(R.id.tv_cancel) as TextView
        val tv_confirm = view.findViewById<View>(R.id.tv_confirm) as TextView
        val dialog = Dialog(context!!, R.style.ActionSheetDialogStyle)
        val window = dialog.window
        window!!.setContentView(view)
        window.setGravity(Gravity.CENTER)
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT)
        dialog.setCanceledOnTouchOutside(false)
        tv_cancel.setOnClickListener { dialog.dismiss() }
        tv_confirm.setOnClickListener {
            listener.onClick(tv_dialog_ident_name.text.toString().toInt())
            dialog.dismiss()
        }
        dialog.show()
        return dialog
    }

    interface OnCustomClickListener {
        fun onClick(num: Int)
    }
}