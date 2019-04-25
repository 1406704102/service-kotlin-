package com.pangjie.service.wow.controller

import com.pangjie.service.firm.repo.UserRepo
import com.pangjie.service.sys.controller.BaseCon
import com.pangjie.service.wow.bean.Interface
import com.pangjie.service.wow.repo.InterfaceRepo
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import java.io.*
import java.nio.file.Files
import java.nio.file.Paths
import java.io.FileInputStream
import java.util.*
import javax.servlet.http.HttpSession


@RestController
@RequestMapping("/api/interface")
class InterfaceCon(val interfaceRepo: InterfaceRepo, override val userRepo: UserRepo, session: HttpSession): BaseCon(session, userRepo) {


    /**
     * @description TODO:添加插件信息
     * @author pangjie___
     * @date 2019/4/24 0024
     * @return
     **/
    @RequestMapping("addInterFace")
    fun addInterFace(files: MutableList<MultipartFile>, session: HttpSession) {
/*        val attribute = session.getAttribute("id")
        val userId = attribute as Long*/
        val user = getUser()
        var wowInterface: Interface
        try {
            wowInterface = interfaceRepo.findByUserId(user.id)
            wowInterface.lastUpTime = Date()
        } catch (e: Exception) {
            wowInterface = Interface(0, user.id, user.userName, Date(), "E:\\桌面\\新建文件夹\\${user.id}")
        }
/*        wowInterface.userId = userId
        wowInterface.useName = userRepo.findUserById(userId).userName
        wowInterface.storageAddress = "E:\\桌面\\新建文件夹\\${wowInterface.userId}"
        wowInterface.lastUpTime = Date()*/
        fileList(files, "E:\\桌面\\新建文件夹\\${user.id}")
        interfaceRepo.save(wowInterface)
    }

    /**
    * @description TODO:获取当前用户的最后上传时间
    * @author pangjie___
    * @date 2019/4/25 0025
    * @return
    **/
    @RequestMapping("getLastUpTime")
    fun getLastUpTime(session: HttpSession): String {
        val attribute = session.getAttribute("id")
        val userId = attribute as Long
        val i: Interface
        try {
            i = interfaceRepo.findByUserId(userId)
            return i.lastUpTime.toString()
        } catch (e: Exception) {
            return "未上传插件!"
        }
    }

    /**
     * @description TODO:保存多文件
     * @author pangjie___
     * @date 2019/4/24 0024
     * @return
     **/
    @RequestMapping("fileList")
    fun fileList(files: MutableList<MultipartFile>, address: String) {
        files.forEach {
            val bytes = it.bytes
            val path = Paths.get("$address\\${it.originalFilename}")
            var file2 = File(path.toString())
            var fileP = file2.parentFile
            //没有文件夹
            if (!fileP.exists()) {
                fileP.mkdirs();
            }
            //保存在本地
            Files.write(path, bytes)
        }
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


    /**
     * @description TODO:复制文件夹下的所有内容到指定文件夹   copyFilesTo(File("C:\\Users\\pangjie___\\Desktop\\资源文件夹"), File("C:\\Users\\pangjie___\\Desktop\\目标文件夹"))
     * @author pangjie___
     * @date 2019/4/24 0024
     * @return
     **/
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
}