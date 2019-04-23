package com.pangjie.service.wow

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import java.io.*
import java.nio.file.Files
import java.nio.file.Paths
import java.io.FileInputStream
import java.nio.ByteBuffer
import java.nio.file.Path


@RestController
@RequestMapping("/api/interface")
class Interface {


    @RequestMapping("files")
    fun files(file: MultipartFile) {

//        val reader = Files.newBufferedReader(files)
        file.originalFilename!!.split("/").forEach {
            println(it)
        }
/*        val bytes = file.bytes
        val path = Paths.get("E:\\桌面\\新建文件夹\\"+file.originalFilename)

        //保存在本地
        Files.write(path, bytes)*/
        var path = "E:\\桌面\\新建文件夹\\"+file.originalFilename
        var file2=  File(path)
        var fileP = file2.parentFile
        if(!fileP.exists()){
            fileP.mkdirs();
        }
        file2.createNewFile()
    }

    @RequestMapping("fileList")
    fun fileList(files: MutableList<MultipartFile>) {
        files.forEach {
            println(it.originalFilename)
            var path = "E:\\桌面\\新建文件夹\\"+it.originalFilename
            var file2=  File(path)
            var fileP = file2.parentFile
            if(!fileP.exists()){
                fileP.mkdirs();
            }
            println(file2.name)
            file2.createNewFile()
        }
    }

    @RequestMapping("test")
    fun test() { print("-----------------------") }
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

/*fun saveFile(file: MultipartFile) {
    val outputStream = FileOutputStream
    val channel = outputStream.getChannel()
    val buffer = ByteBuffer.allocate(1024)
    val string = "java nio"
    buffer.put(string.toByteArray())
    buffer.flip()     //此处必须要调用buffer的flip方法
    channel.write(buffer)
    channel.close()
    outputStream.close()
}*/

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