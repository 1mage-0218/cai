package com.test.project

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment

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
 * @date
 * @description
 */
class WordFragment : Fragment() {
    private var tv_name: TextView? = null
    private var btn1: Button? = null
    private var btn3: Button? = null
    private val a = 0
    private var tv_num: TextView? = null
    private var iv: ImageView? = null
    private var btn11: TextView? = null
    private var btn12: TextView? = null
    private var btn13: TextView? = null
    private var btn14: TextView? = null
    private var isvisible = false
    private var m1: String? = null

    @Nullable
    override fun onCreateView(inflater: LayoutInflater, @Nullable container: ViewGroup?, @Nullable savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_word, container, false)
        initView(view)
        return view
    }

    override fun onActivityCreated(@Nullable savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        isvisible = true
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        pan(isVisibleToUser)
    }

    private fun initView(view: View) {
        tv_name = view.findViewById(R.id.tv_name)
        tv_num = view.findViewById(R.id.tv_num)
        iv = view.findViewById(R.id.iv)
        btn11 = view.findViewById(R.id.btn11)
        btn12 = view.findViewById(R.id.btn12)
        btn13 = view.findViewById(R.id.btn13)
        btn14 = view.findViewById(R.id.btn14)
        btn1 = view.findViewById(R.id.btn1)
        btn3 = view.findViewById(R.id.btn3)
        if (arguments != null) {
            val activity = activity as WordActivity?
            val bean = requireArguments().getSerializable("myValue") as WordBean?
            tv_name!!.text = bean!!.name
            btn11!!.text = bean.des1
            btn12!!.text = bean.des2
            btn13!!.text = bean.des3
            btn14!!.text = bean.des4
            tv_num!!.text = "${bean.pos}/${activity!!.mAllList!!.size}"
            iv!!.setImageResource(bean.pic)

            m1 = when (bean.ans) {
                0 -> bean.des1
                1 -> bean.des2
                2 -> bean.des3
                else -> bean.des4
            }
            btn3!!.setOnClickListener(View.OnClickListener {
                btn3!!.setText(m1)
                activity!!.isRight = true
            })
            btn1!!.setOnClickListener(View.OnClickListener {
                val ans = bean.ans
                if (ans <= 1) {
                    btn13!!.setVisibility(View.GONE)
                    btn14!!.setVisibility(View.GONE)
                } else {
                    btn11!!.setVisibility(View.GONE)
                    btn12!!.setVisibility(View.GONE)
                }
                activity!!.isLeft = true
            })
            btn11!!.setOnClickListener(View.OnClickListener {
                if (bean.ans == 0) {
                    val activity = getActivity() as WordActivity?
                    activity!!.setNext()
                } else {
                    startActivity(Intent(context, FailActivity::class.java))
                    getActivity()?.finish()
                }
            })
            btn12!!.setOnClickListener(View.OnClickListener {
                if (bean.ans == 1) {
                    val activity = getActivity() as WordActivity?
                    activity!!.setNext()
                } else {
                    startActivity(Intent(context, FailActivity::class.java))
                    getActivity()?.finish()
                }
            })
            btn13!!.setOnClickListener(View.OnClickListener {
                if (bean.ans == 2) {
                    val activity = getActivity() as WordActivity?
                    activity!!.setNext()
                } else {
                    startActivity(Intent(context, FailActivity::class.java))
                    getActivity()?.finish()
                }
            })
            btn14!!.setOnClickListener(View.OnClickListener {
                if (bean.ans == 3) {
                    val activity = getActivity() as WordActivity?
                    activity!!.setNext()
                } else {
                    startActivity(Intent(context, FailActivity::class.java))
                    getActivity()?.finish()
                }
            })
        }
    }

    fun pan(visble: Boolean) {
        if (isvisible && visble) {
            val activity = activity as WordActivity?
            if (activity!!.isLeft) {
                btn1!!.visibility = View.GONE
            } else {
                btn1!!.visibility = View.VISIBLE
            }
            if (activity.isRight) {
                btn3!!.visibility = View.GONE
            } else {
                btn3!!.visibility = View.VISIBLE
            }
        }
    }

    companion object {
        fun newInstance(value: WordBean?): WordFragment {
            val fragment = WordFragment()
            val args = Bundle()
            args.putSerializable("myValue", value)
            fragment.arguments = args
            return fragment
        }
    }
}