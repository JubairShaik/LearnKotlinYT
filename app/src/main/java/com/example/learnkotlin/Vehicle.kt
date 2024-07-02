package com.example.learnkotlin

////understading Inheritance
////Parent class of car
//// converting into open class so that it can be inherited anywhere in the project !
//open class Vehicle {
//    var type: String? = null
//    var modelName: String? = null
//    var price: Int? = null
//
//    constructor()
//
//    constructor(type: String): this() {
//        this.type = type
//    }
//}

//num3 understading overloading and overriding


open class Vehicle {
    var type: String? = null
    var modelName: String? = null
    var price: Int? = null

    constructor()

    constructor(type: String): this() {
        this.type = type
    }

    open fun printinfo(){
        println("print of vehicle called")
    }


}
