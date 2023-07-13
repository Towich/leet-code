package com.company

import kotlin.test.assertEquals

fun goUpDir(inString: String): String {
    var resultStr = ""

    resultStr = inString.dropLast(3)

    var iter = resultStr.length - 1

    while(iter >= 0 && resultStr[iter] != '/'){
        resultStr = resultStr.dropLast(1)
        iter--
    }

    return resultStr.dropLast(1)
}

fun getPath(inStringNotPrepared: String): String {
    var currFolder = ""
    var currDirectory = ""

    val inString = inStringNotPrepared.replace("//", "/")

    for (i in inString.indices){
        if(inString[i] == '/'){
            currDirectory += currFolder
            currDirectory += inString[i]
            currFolder = ""
        }
        else if(inString[i] == '.' && inString[i+1] == '.'){
            currDirectory = goUpDir(currDirectory)
            continue
        }
        else if(inString[i] == '.'){
            continue
        }
        else{
            currFolder += inString[i]
        }
    }

    return if(currDirectory.last() == '/' && currDirectory.length > 1)
        currDirectory.dropLast(1)
    else
        currDirectory
}

fun main(){

//    val input = readLine()
//    println(getPath(input!!))
    assertEquals("/home/foo/my/year", goUpDir("/home/foo/my/year/ggrewrwefdsfsdg/.."))

    assertEquals("/home", getPath("/home/"))
    assertEquals("/", getPath("/../"))
    assertEquals("/home/foo", getPath("/home//foo/"))
}