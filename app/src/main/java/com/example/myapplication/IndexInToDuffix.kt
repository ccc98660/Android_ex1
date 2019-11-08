package com.example.myapplication

import java.util.HashMap

import java.util.Stack
import java.util.ArrayList
import java.math.BigDecimal
import java.math.RoundingMode

object IndexInToDuffix {
    fun Houzhui(s: String): Stack<String> {
        val stacka = Stack<String>()   //存放操作数
        val stackb = Stack<String>()   //存放操作符
        //需要创建一个字符串存放数，不然2位数及以上会被拆开，不方便后续处理
        var temp = String()
        val hashMap = HashMap<String, Int>()
        hashMap["("] = 0// 设定优先级 +-优先级相同 */优先级相同
        hashMap["+"] = 1
        hashMap["-"] = 1
        hashMap["*"] = 2
        hashMap["/"] = 2
        for (i in 0 until s.length) {
            val c = s[i]  //获取第i个位置的字符
            val m = c + ""
            if (Character.isDigit(c) || c == '.') {
                if (i == s.length - 1) {
                    temp += m
                    stacka.push(temp)
                } else
                //不是第一个位置，要看前一个是不是数字或小数点
                //if(Character.isDigit(s.charAt(i-1))||s.charAt(i-1)=='.')
                //{
                    temp += m
                //}

                //stacka.push(m);
            }//如果c是字符，就将他直接放进a栈中
            else {
                if (temp !== "") {
                    stacka.push(temp)
                    temp = ""
                }  //这个判断是为了不让括号后紧接着数字的情况出错
                if (c == '(')
                    stackb.push(m)
                else if (c == ')') {
                    while (!stackb.isEmpty() && stackb.peek() != "(") {
                        val r = stackb.pop()
                        stacka.push(r)
                    }//遇到右括号，输出运算符堆栈中的运算符到操作数堆栈，直到遇到左括号为止
                    if (stackb.peek() == "(") stackb.pop()
                } else
                //加减乘除的情况
                {
                    //首先是加减，他们的优先级低于乘除，只有优先级大于等于栈顶才弹出
                    when (c) {
                        '+', '-' -> if (!stackb.isEmpty() && stackb.peek()!="+"&& stackb.peek()!="-") {
                            val t = stackb.pop()
                            stacka.push(t)
                            stackb.push(m)
                        } else {
                            stackb.push(m)
                        }
                        '*', '/' -> stackb.push(m)
                    }
                }
            }
        }
        while (!stackb.isEmpty()) {
            val q = stackb.pop()
            stacka.push(q)
        }
        return stacka
    }

    fun calc(stacka: Stack<String>)//计算逆波兰表达式
            : String {
        val arr = ArrayList<String>()
        while (!stacka.isEmpty()) {
            val t = stacka.pop()
            //System.out.println("t="+t);
            arr.add(t)
        }
        val arr1 = ArrayList<String>()
        for (i in arr.indices.reversed()) {
            val j = arr1.size
            when (arr[i]) {
                "+" -> {
                    val a = BigDecimal(arr1.removeAt(j - 2)).add(BigDecimal(arr1.removeAt(j - 2)))
                    arr1.add(a.toString())
                }
                "-" -> {
                    val b = BigDecimal(arr1.removeAt(j - 2)).subtract(BigDecimal(arr1.removeAt(j - 2)))
                    arr1.add(b.toString())
                }
                "*" -> {
                    val c = BigDecimal(arr1.removeAt(j - 2)).multiply(BigDecimal(arr1.removeAt(j - 2)))
                    arr1.add(c.toString())
                }
                "/" -> {
                    val d = BigDecimal(
                            arr1.removeAt(j - 2)).divide(BigDecimal(arr1.removeAt(j - 2)),6,RoundingMode.DOWN
                    )
                    arr1.add(d.toString())
                }

                else -> arr1.add(arr[i])
            }
        }
        return arr1[0]
    }
}