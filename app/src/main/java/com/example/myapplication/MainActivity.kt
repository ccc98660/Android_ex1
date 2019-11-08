package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.myapplication.IndexInToDuffix.Houzhui
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var btn_0: Button? = null
    private var btn_1: Button? = null
    private var btn_2: Button? = null
    private var btn_3: Button? = null
    private var btn_4: Button? = null
    private var btn_5: Button? = null
    private var btn_6: Button? = null
    private var btn_7: Button? = null
    private var btn_8: Button? = null
    private var btn_9: Button? = null
    private var btn_point: Button? = null
    private var btn_plus: Button? = null
    private var btn_sub: Button? = null
    private var btn_multi: Button? = null
    private var btn_div: Button? = null
    private var btn_left: Button? = null
    private var btn_right: Button? = null

    private var btn_ac: Button? = null  //清空
    private var btn_del: Button? = null//删除
    private var btn_equals: Button? = null  //等号
    private var et_showview: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    fun initView() {
        btn_0 = findViewById<View>(R.id.btn_0) as Button
        btn_1 = findViewById<View>(R.id.btn_1) as Button
        btn_2 = findViewById<View>(R.id.btn_2) as Button
        btn_3 = findViewById<View>(R.id.btn_3) as Button
        btn_4 = findViewById<View>(R.id.btn_4) as Button
        btn_5 = findViewById<View>(R.id.btn_5) as Button
        btn_6 = findViewById<View>(R.id.btn_6) as Button
        btn_7 = findViewById<View>(R.id.btn_7) as Button
        btn_8 = findViewById<View>(R.id.btn_8) as Button
        btn_9 = findViewById<View>(R.id.btn_9) as Button
        btn_point = findViewById<View>(R.id.btn_point) as Button
        btn_div = findViewById<View>(R.id.btn_div) as Button
        btn_plus = findViewById<View>(R.id.btn_plus) as Button
        btn_sub = findViewById<View>(R.id.btn_sub) as Button
        btn_multi = findViewById<View>(R.id.btn_multi) as Button

        btn_left = findViewById<View>(R.id.btn_left) as Button
        btn_right = findViewById<View>(R.id.btn_right) as Button
        btn_equals = findViewById<View>(R.id.btn_equals) as Button

        btn_ac = findViewById<View>(R.id.btn_ac) as Button
        btn_del = findViewById<View>(R.id.btn_del) as Button


        btn_0!!.setOnClickListener(this)
        btn_1!!.setOnClickListener(this)
        btn_2!!.setOnClickListener(this)
        btn_3!!.setOnClickListener(this)
        btn_4!!.setOnClickListener(this)
        btn_5!!.setOnClickListener(this)
        btn_6!!.setOnClickListener(this)
        btn_7!!.setOnClickListener(this)
        btn_8!!.setOnClickListener(this)
        btn_9!!.setOnClickListener(this)
        btn_equals!!.setOnClickListener(this)
        btn_del!!.setOnClickListener(this)
        btn_right!!.setOnClickListener(this)
        btn_left!!.setOnClickListener(this)
        btn_multi!!.setOnClickListener(this)
        btn_sub!!.setOnClickListener(this)
        btn_plus!!.setOnClickListener(this)
        btn_div!!.setOnClickListener(this)
        btn_ac!!.setOnClickListener(this)
        btn_point!!.setOnClickListener(this)
        et_showview = findViewById<View>(R.id.msg) as TextView
    }

    override fun onClick(view: View) {
        var str = et_showview!!.text.toString()

        when (view.id) {
            R.id.btn_0 -> {
                str += "0"
                et_showview!!.text = str
            }
            R.id.btn_1 -> {
                str += "1"
                et_showview!!.text = str
            }
            R.id.btn_2 -> {
                str += "2"
                et_showview!!.text = str
            }
            R.id.btn_3 -> {
                str += "3"
                et_showview!!.text = str
            }
            R.id.btn_4 -> {
                str += "4"
                et_showview!!.text = str
            }
            R.id.btn_5 -> {
                str += "5"
                et_showview!!.text = str
            }
            R.id.btn_6 -> {
                str += "6"
                et_showview!!.text = str
            }
            R.id.btn_7 -> {
                str += "7"
                et_showview!!.text = str
            }
            R.id.btn_8 -> {
                str += "8"
                et_showview!!.text = str
            }
            R.id.btn_9 -> {
                str += "9"
                et_showview!!.text = str
            }
            R.id.btn_div -> if (str.length != 0) {
                str += "/"
                et_showview!!.text = str
            }

            R.id.btn_multi -> if (str.length != 0) {
                str += "*"
                et_showview!!.text = str
            }
            R.id.btn_point -> if (str.length != 0 && str[str.length - 1] >= '0' && str[str.length - 1] <= '9') {
                str += "."
                et_showview!!.text = str
            }
            R.id.btn_plus -> if (str.length != 0) {
                str += "+"
                et_showview!!.text = str
            }
            R.id.btn_sub -> if (str.length != 0) {
                str += "-"
                et_showview!!.text = str
            }
            //如果运算符和小数点不出现在首尾位置，可以添加进字符串里
            //小数点前一位必须是数字
            R.id.btn_left -> {
                str += "("
                et_showview!!.text = str
            }
            R.id.btn_right -> {
                str += ")"
                et_showview!!.text = str
            }
            R.id.btn_equals ->
                et_showview!!.text = IndexInToDuffix.calc(Houzhui(str))//输入结束，转为逆波兰表达式
            R.id.btn_del -> {
                str = str.substring(0, str.length - 1)
                et_showview!!.text = str
            }
            R.id.btn_ac -> {
                str = ""
                et_showview!!.text = str
            }
        }//如果字符串长度大于等于1，就前删一个字符
    }
}
