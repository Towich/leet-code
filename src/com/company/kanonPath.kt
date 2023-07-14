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

/*
        /home/root/yandex/..    --->    /home/root

        read after '/' until '/' or last symbol

        currDir = "/home/root/yandex"
        currFolder = ".."

        currFolder == "." ?
            yes: clear currFolder and continue
        currFolder == ".." ?
            yes: we have to remove last directory in currDir with separator '/', clear currFolder
        else
            add '/' and currFolder to end of currDir

 */

fun getDir(inString: String): String {
    var currFolder = ""
    var currDir = ""
    var strPrepared = ""

    var l = 0
    while(l < inString.length){
        if(inString[l] == '/'){
            while(l < inString.length && inString[l] == '/'){
                l++
            }
            strPrepared += '/'
        }
        else{
            strPrepared += inString[l]
            l++
        }
    }
//    strPrepared = inString.replace("//", "/")

    if(strPrepared.last() == '/')
        strPrepared = strPrepared.dropLast(1)

    var i = 0
    while(i < strPrepared.length){
        val currSym = strPrepared[i]

        if(i == strPrepared.length-1){
            currFolder += currSym
        }

        if(currSym == '/' || i == strPrepared.length-1){

            if(currFolder == "."){

            }
            else if(currFolder == ".."){

                var symbolsToRemove = 0
                for(k in currDir.indices){
                    if(currDir[currDir.length-1-k] != '/') {
                        symbolsToRemove++
                    }
                    else{
                        break
                    }
                }

                currDir = currDir.dropLast(symbolsToRemove+1)
            }
            else{
                if(i != 0)
                    currDir += "/$currFolder"
            }

            currFolder = ""
        }
        else{
            currFolder += currSym
        }
        i++
    }

    return if(currDir == "")
        "/"
    else
        currDir

}

fun main(){

//    val input = readLine()
//    println(getDir(input!!))
    assertEquals("/home/foo", getDir("/home/foo/fsdg/.."))
    assertEquals("/home", getDir("/home/"))
    assertEquals("/", getDir("/../"))
    assertEquals("/home/foo", getDir("/home//foo/"))
    assertEquals("/home", getDir("/home/foo/gdfgdr/../../"))
    assertEquals("/home", getDir("/home/foo/gdfgdr/../.././"))
    assertEquals("/", getDir("//////"))
}