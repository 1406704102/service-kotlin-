package com.pangjie.service.wow

import java.io.*

class Interface {
}

fun main(args: Array<String>) {
/*    val file = File("C:\\aow_drv.log")
*//*    BufferedReader(FileReader(file)).use {
        var line: String
        while (true) {
            line = it.readLine() ?: break
            println(line)
        }
    }*//*
//    file.readLines().forEach(::println)
    val file2 = File("C:\\Users\\pangjie___\\Desktop\\")
//    file2.createNewFile()
    file.copyTo(file2, overwrite = true, bufferSize = 1024)*/

    copyFilesTo(File("C:\\Users\\pangjie___\\Desktop\\资源文件夹"), File("C:\\Users\\pangjie___\\Desktop\\目标文件夹"))
}
fun copyFilesTo(srcDir: File, destDir: File): Boolean {
    if (!srcDir.isDirectory || !destDir.isDirectory) return false// 判断是否是目录
    if (!destDir.exists()) return false
//        destDir.createNewFile()
//        return false// 判断目标目录是否存在
    val srcFiles = srcDir.listFiles()
    srcFiles.forEach {
        if (it.isFile) {
            val destFile = File("${destDir.path}/${it.name}")
            println(destFile)
            copyFileTo(it, destFile)
        } else {
            val theDestDir = File("${destDir.path}/${it.name}")
//            println(it)
//            println(theDestDir)
            theDestDir.mkdir()
            copyFilesTo(it, theDestDir)
        }
    }

    return true
}
fun copyFileTo(srcFile: File, destFile: File): Boolean {
    return if (srcFile.isDirectory || destFile.isDirectory) {
        false
    } else {
        val fis = FileInputStream(srcFile)
        val fos = FileOutputStream(destFile)
        fis.copyTo(fos)
        fos.flush()
        fis.close()
        fos.close()
        true
    }
}