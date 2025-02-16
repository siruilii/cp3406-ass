package com.example.login01

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

// 数据库访问类
class DataBaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE, null, VERSION) {

    companion object {
        // 数据库名称
        const val DATABASE = "title.db"

        // 数据库版本号
        const val VERSION = 1

        // 创建用户表User
        const val CREATE_USER = """create table User (
            account text primary key,
            password text)"""
    }

    // 创建数据库
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_USER)
    }

    // 升级数据库
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("drop table if exists User")
        onCreate(db)
    }
}