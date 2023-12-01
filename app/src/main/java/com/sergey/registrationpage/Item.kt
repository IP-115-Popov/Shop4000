package com.sergey.registrationpage

import java.io.Serializable


class Item(val id: Int, val image:String, val title:String, val desc:String, val text:String, val price:Int)
    : Serializable {
}