package space.dyenigma.util;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * origin/space.dyenigma.util
 *
 * @Description: 文件操作工具类
 * @Author: dingdongliang
 * @Date: 2016/4/2 18:47
 */
public class FileUtil {
    private static final Logger logger = Logger.getLogger(FileUtil.class);

    private static final int BUFFER = 1024;

    /**
     * @param strSourceFileName 指定的文件全路径名
     * @param strDestDir        拷贝到指定的文件夹
     * @return boolean  如果成功true;否则false
     * @Description : 拷贝文件
     * @author dingdongliang
     * @date 2018/2/20 19:39
     */
    public boolean copyTo(String strSourceFileName, String strDestDir) {
        File fileSource = new File(strSourceFileName);
        File fileDest = new File(strDestDir);

        // 如果源文件不存或源文件是文件夹
        if (!fileSource.exists() || !fileSource.isFile()) {
            logger.debug("源文件[" + strSourceFileName + "],不存在或是文件夹!");
            return false;
        }

        // 如果目标文件夹不存在
        if (!fileDest.isDirectory() || !fileDest.exists()) {
            if (!fileDest.mkdirs()) {
                logger.debug("目录文件夹不存，在创建目标文件夹时失败!");
                return false;
            }
        }

        try {
            String strAbsFilename = strDestDir + File.separator + fileSource.getName();

            FileInputStream fileInput = new FileInputStream(strSourceFileName);
            FileOutputStream fileOutput = new FileOutputStream(strAbsFilename);

            logger.debug("开始拷贝文件:");

            int count;

            long nWriteSize = 0;
            long nFileSize = fileSource.length();

            byte[] data = new byte[BUFFER];

            while (-1 != (count = fileInput.read(data, 0, BUFFER))) {

                fileOutput.write(data, 0, count);

                nWriteSize += count;

                long size = (nWriteSize * 100) / nFileSize;
                long t = nWriteSize;

                String msg;

                if (size <= 100 && size >= 0) {
                    msg = "\r拷贝文件进度:   " + size + "%   \t" + "\t   已拷贝:   " + t;
                    logger.debug(msg);
                } else if (size > 100) {
                    msg = "\r拷贝文件进度:   " + 100 + "%   \t" + "\t   已拷贝:   " + t;
                    logger.debug(msg);
                }

            }

            fileInput.close();
            fileOutput.close();

            logger.debug("拷贝文件成功!");
            return true;

        } catch (Exception e) {
            logger.debug("异常信息：[");
            logger.error(e);
            logger.debug("]");
            return false;
        }
    }

    /**
     * @param strFileName 指定绝对路径的文件名
     * @return boolean 如果删除成功true否则false
     * @Description : 删除指定的文件
     * @author dingdongliang
     * @date 2018/2/20 19:38
     */
    public boolean delete(String strFileName) {
        File fileDelete = new File(strFileName);

        if (!fileDelete.exists() || !fileDelete.isFile()) {
            logger.debug("错误: " + strFileName + "不存在!");
            return false;
        }

        return fileDelete.delete();
    }

    /**
     * @param strSourceFileName 是指定的文件全路径名
     * @param strDestDir        移动到指定的文件夹中
     * @return boolean 如果成功true; 否则false
     * @Description : 移动文件
     * @author dingdongliang
     * @date 2018/2/20 19:38
     */
    public boolean moveFile(String strSourceFileName, String strDestDir) {
        if (copyTo(strSourceFileName, strDestDir))
            return this.delete(strSourceFileName);
        else
            return false;
    }

    /**
     * @param strDir 要创建的文件夹名称
     * @return boolean 如果成功true;否则false
     * @Description : 创建文件夹
     * @author dingdongliang
     * @date 2018/2/20 19:38
     */
    public boolean makedir(String strDir) {
        File fileNew = new File(strDir);

        if (!fileNew.exists()) {
            logger.debug("文件夹不存在--创建文件夹");
            return fileNew.mkdirs();
        } else {
            logger.debug("文件夹存在");
            return true;
        }
    }

    /**
     * @param strDir 要删除的文件夹名称
     * @return boolean 成功true;否则false
     * @Description : 删除文件夹
     * @author dingdongliang
     * @date 2018/2/20 19:37
     */
    public boolean rmdir(String strDir) {
        File rmDir = new File(strDir);
        if (rmDir.isDirectory() && rmDir.exists()) {
            String[] fileList = rmDir.list();

            for (int i = 0; i < fileList.length; i++) {
                String subFile = strDir + File.separator + fileList[i];
                File tmp = new File(subFile);
                if (tmp.isFile())
                    tmp.delete();
                else if (tmp.isDirectory())
                    rmdir(subFile);
                else {
                    logger.debug("error!");
                }
            }
            rmDir.delete();
        } else
            return false;
        return true;
    }

    /**
     * @param path
     * @param response
     * @param allPath
     * @return void
     * @Description : 下载文件
     * @author dingdongliang
     * @date 2018/2/20 19:37
     */
    public static void downFile(String path, HttpServletResponse response, String allPath)
            throws IOException {
        BufferedInputStream bis;
        BufferedOutputStream bos;
        OutputStream fos;
        InputStream fis;
        File uploadFile = new File(allPath);
        fis = new FileInputStream(uploadFile);
        bis = new BufferedInputStream(fis);
        fos = response.getOutputStream();
        bos = new BufferedOutputStream(fos);
        response.addHeader("Content-disposition", "attachment;filename="
                + URLEncoder.encode(path, "utf-8"));
        int bytesRead;
        byte[] buffer = new byte[8192];
        while ((bytesRead = bis.read(buffer, 0, 8192)) != -1) {
            bos.write(buffer, 0, bytesRead);
        }
        bos.flush();
        fis.close();
        bis.close();
        fos.close();
        bos.close();
    }

    /**
     * @param filePath
     * @return byte[]
     * @Description : 读取二进制文件并且写入数组里
     * @author dingdongliang
     * @date 2018/2/20 19:37
     */
    public static byte[] getBytes4File(String filePath) {

        InputStream in = null;
        BufferedInputStream buffer = null;
        DataInputStream dataIn = null;
        ByteArrayOutputStream bos = null;
        DataOutputStream dos = null;
        byte[] bArray = null;
        try {
            in = new FileInputStream(filePath);
            buffer = new BufferedInputStream(in);
            dataIn = new DataInputStream(buffer);
            bos = new ByteArrayOutputStream();
            dos = new DataOutputStream(bos);
            byte[] buf = new byte[1024];
            while (true) {
                int len = dataIn.read(buf);
                if (len < 0)
                    break;
                dos.write(buf, 0, len);
            }
            bArray = bos.toByteArray();

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        } finally {
            try {
                if (in != null)
                    in.close();
                if (dataIn != null)
                    dataIn.close();
                if (buffer != null)
                    buffer.close();
                if (bos != null)
                    bos.close();
                if (dos != null)
                    dos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bArray;
    }
}
