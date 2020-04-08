package com.max.template.manager

interface Storage {
    fun setString(key: String, value: String)
    fun getString(key: String): String
}