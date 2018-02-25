package com.huangbin.gsarts.util.ftp;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPReply;

import java.io.*;

/**
 * Created by huangbin on 2017/10/30.
 */

@Slf4j
public class FTPUploader {


    /**
     * 本地字符编码
     */
    public static String LOCAL_CHARSET = "GBK";

    // FTP协议里面，规定文件名编码为iso-8859-1
    public static String SERVER_CHARSET = "ISO-8859-1";

    public static FTPClient ftp;

    /**
     * Description: 向FTP服务器上传文件
     *
     * @param ip
     * @param port     FTP服务器端口
     * @param userName FTP登录账号
     * @param password FTP登录密码
     * @param path     FTP服务器保存目录
     * @param fileName 上传到FTP服务器上的文件名
     * @param input    输入流
     * @param fileUrl  要创建的新文件夹
     * @return 成功返回true，否则返回false
     */
    public static boolean uploadFile(String ip, int port, String userName, String password, String path, String fileName, InputStream input, String fileUrl) {
        boolean success = false;
        try {
            int reply;

            ftp = new FTPClient();
            ftp.connect(ip, port);//连接FTP服务器
            boolean connected = ftp.isConnected();
            if (!connected) {
                return connected;
            }
            //如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
            boolean loginStatus = ftp.login(userName, password);//登录
            ftp.setDataTimeout(1000 * 60 * 30);   //设置传输超时（30分钟）
            ftp.setConnectTimeout(60000);       //连接超时为60秒
            String multiDirectory = fileUrl;
            log.info("multiDirectory--------------" + fileUrl);
            boolean result = createMultiDirectory(ftp, multiDirectory);
            log.info("result--------------" + result);
            //判断ftp连接回复

            ftp.changeWorkingDirectory(path);
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            fileName = new String(fileName.getBytes("GBK"), "iso-8859-1");// 转换后的目录名或文件名。
            ftp.storeFile(fileName, input);

            input.close();
            ftp.logout();
            success = true;
//            int replyCode = ftp.getReply();
//            log.info("replyCode--------------" + replyCode);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {

                    log.info("ftp.isConnected()--------------" + ftp.isConnected());
                    ftp.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        log.info("ftp.success()--------------" + success);
        return success;
    }

    public boolean upLoadFile(String ip, int port, String userName, String password, File file, String path, String fileName) throws IOException {
        boolean result = false;
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(ip, port);
            ftpClient.login(userName, password);
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);


            // make directory
            if (path != null && !"".equals(path.trim())) {
                String[] pathes = path.split("/");
                for (String onepath : pathes) {
                    if (onepath == null || "".equals(onepath.trim())) {
                        continue;
                    }
                    onepath = new String(onepath.getBytes("GBK"), "iso-8859-1");
                    if (!ftpClient.changeWorkingDirectory(onepath)) {
                        ftpClient.makeDirectory(onepath);
                        ftpClient.changeWorkingDirectory(onepath);
                    }
                }
            }


            result = ftpClient.storeFile(new String(fileName.getBytes("GBK"), "iso-8859-1"), new FileInputStream(file));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ftpClient.logout();
        }
        return result;
    }

    /**
     * Description: 向FTP服务器上传文件
     *
     * @param urls
     * @param port      FTP服务器端口
     * @param userName  FTP登录账号
     * @param password  FTP登录密码
     * @param path      FTP服务器保存目录
     * @param fileNames
     * @param input     输入流
     * @param fileUrls
     * @return 成功返回true，否则返回false
     */
    public static boolean uploadFiles(String urls[], int port, String userName, String password, String path, String fileNames[], InputStream input, String fileUrls[]) {
        boolean success = false;
        try {
            int reply;
            for (int i = 0; i < urls.length; i++) {
                ftp.connect(urls[i], port);//连接FTP服务器
                //如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
                boolean loginStatus = ftp.login(userName, password);//登录
                ftp.setDataTimeout(1000 * 60 * 30);   //设置传输超时（30分钟）
                ftp.setConnectTimeout(60000);       //连接超时为60秒

                if (loginStatus) {
                    int s = ftp.sendCommand("OPTS UTF8", "ON");
                    boolean replyStatus = FTPReply.isPositiveCompletion(s);
                    if (replyStatus) {
                        LOCAL_CHARSET = "UTF-8";
                    }
                    ftp.setControlEncoding(SERVER_CHARSET);
                    ftp.enterLocalPassiveMode();// 设置被动模式
                }
                String multiDirectory = fileUrls[i];
                boolean result = createMultiDirectory(ftp, multiDirectory);
                reply = ftp.getReplyCode();
                if (!FTPReply.isPositiveCompletion(reply)) {
                    ftp.disconnect();
                    return success;
                }
                ftp.changeWorkingDirectory(path);
                ftp.setFileType(FTP.BINARY_FILE_TYPE);
                fileNames[i] = new String(fileNames[i].getBytes(LOCAL_CHARSET), SERVER_CHARSET);
                ftp.storeFile(fileNames[i], input);
                input.close();
                ftp.logout();
                ftp.reinitialize();//上传完毕后需要初始化一下配置 不然要出现中文乱码
                success = true;
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return success;
    }


    /**
     * @param fileUrl  文件相对路径
     * @param ip       ftp ip地址
     * @param port     ftp端口
     * @param userName 用户名
     * @param password 密码
     * @param ftpUrl   ftp根路径
     * @param fileName 保存的文件名
     * @param dirStr   保存在ftp的文件路径
     * @return
     */
    public static boolean uploadFileToFtp(String fileUrl, String ip, int port, String userName, String password, String ftpUrl, String fileName, String dirStr) {
        boolean flag = true;
        //如果文件夹不存在 创建文件夹
        File file = new File(fileUrl);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            flag = uploadFile(ip, port, userName, password, ftpUrl, fileName, fileInputStream, dirStr);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return flag;
    }


    /**
     * @param fileUrls 多个文件路径
     * @param ip       ftp ip地址
     * @param port     ftp端口
     * @param userName 用户名
     * @param password 密码
     * @param ftpUrl   ftp根路径
     * @param fileName 保存的文件名
     * @param dirStr
     * @return
     */
    public static boolean uploadFilesToFtp(String fileUrls[], String ip, int port, String userName, String password, String ftpUrl, String fileName, String dirStr) {
        boolean flag = true;

        for (String fileUrl : fileUrls) {
            //如果文件夹不存在 创建文件夹
            File dir = new File(fileUrl);
            try {
                FileInputStream in = new FileInputStream(dir);
                flag = uploadFile(ip, port, userName, password, ftpUrl, fileName, in, dirStr);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    /**
     * @param ftpClient
     * @param multiDirectory
     * @return 远程FTP服务器创建多级目录，创建目录失败或发生异常则返回false
     */
    private static boolean createMultiDirectory(FTPClient ftpClient, String multiDirectory) {
        boolean bool = false;
        try {
            String[] dirs = multiDirectory.split("/");
            ftpClient.changeWorkingDirectory("/");
            ftp.setControlEncoding("UTF-8");//注意编码格式
            FTPClientConfig conf = new FTPClientConfig(FTPClientConfig.SYST_UNIX);
            conf.setServerLanguageCode("zh");//中文
            //按顺序检查目录是否存在，不存在则创建目录
            for (int i = 1; dirs != null && i < dirs.length; i++) {
                if (!ftpClient.changeWorkingDirectory(dirs[i])) {
                    if (ftpClient.makeDirectory(dirs[i])) {
                        if (!ftpClient.changeWorkingDirectory(dirs[i])) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
            }

            bool = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return bool;
        }
    }

}
