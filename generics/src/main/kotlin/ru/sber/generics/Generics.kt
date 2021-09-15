package ru.sber.generics

import java.util.*

// 1.
fun <T1, T2> compare(p1: Pair<T1, T2>, p2: Pair<T1, T2>): Boolean {
    return p1.first == p2.first && p1.second == p2.second
}

// 2.
fun <T : Comparable<T>> countGreaterThan(anArray: Array<T>, elem: T): Int {
    var counter = 0
    for (i in anArray) {
        if (elem < i) counter++
    }
    return counter
}

// 3.
class Sorter<T : Comparable<T>> {
    val list: MutableList<T> = mutableListOf()

    fun add(value: T) {
        list.add(value)
        for (i in list.lastIndex downTo 1) {
            val cur = list[i]
            val prev = list[i - 1]
            if (cur < prev) {
                list[i] = prev
                list[i - 1] = cur
            } else break
        }
    }
}

// 4.
class Stack<T> {
    private val stack = mutableListOf<T>()

    fun isEmpty(): Boolean {
        return stack.isEmpty()
    }

    fun push(value: T): T {
        stack.add(value)
        return value
    }

    fun pop(): T {
        if (stack.isNotEmpty()) {
            return stack.removeLast()
        } else throw EmptyStackException()
    }
}