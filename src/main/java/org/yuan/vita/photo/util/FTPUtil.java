package org.yuan.vita.photo.util;

import java.io.File;
import java.io.Closeable;
import java.io.InputStream;
import java.io.FileInputStream;

import java.util.Arrays;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;

public class FTPUtil {

  /**
   *  将本地文件上传到FTP
   */
  public static boolean upload(String filePath, String dirPath, String fileName) {
    File file = new File(filePath);
    InputStream stream = null;

    try {
      stream = new FileInputStream(file);
      return upload(stream, dirPath, fileName);
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      close(stream);
    }

    return false;
  }
  
  /**
   *  将文件上传到FTP
   */
  public static boolean upload(InputStream stream, String dirPath, String fileName) {
    FTPClient ftpClient = login();

    try {
      // 检测目录是否存在
      boolean success = exists(dirPath);
      if(!success) {
        success = create(dirPath);
      }
      if(!success) {
        return false;
      }
      
      // 检测文件是否存在
      success = exists(dirPath, fileName);
      if(success) {
        return false;
      }

      // 上传文件
      success = ftpClient.storeFile(dirPath + File.separator + fileName, stream); 
      return success;
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      close(ftpClient);
    }
    
    return false;

  }

  /**
   *  创建目录
   */
  public static boolean create(String dirPath) {
    FTPClient ftpClient = login();

    try {
      boolean success = ftpClient.makeDirectory(dirPath);
      return success;
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      close(ftpClient);
    }

    return false;
  }

  /**
   *  删除目录
   */
  public static boolean delete(String dirPath) {
    FTPClient ftpClient = login();

    try {
      boolean success = ftpClient.removeDirectory(dirPath);
      return success;
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      close(ftpClient);
    }

    return false;
  }

  /**
   *  删除文件
   */
  public static boolean delete(String dirPath, String fileName) {
    FTPClient ftpClient = login();

    try {
      boolean success = ftpClient.deleteFile(dirPath + File.separator + fileName);
      return success;
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      close(ftpClient);
    }

    return false;
  }

  /**
   * 判断目录是否存在
   */
  public static boolean exists(String dirPath) {
    FTPClient ftpClient = login();

    try {
      boolean success = ftpClient.changeWorkingDirectory(dirPath);
      if(success) {
        ftpClient.changeWorkingDirectory("/");
      }
      return success;
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      close(ftpClient);
    }
    return false;
  }

  /**
   *  判断文件是否存在
   */
  public static boolean exists(String dirPath, String fileName) {
    //System.out.println(String.format("dirPath[%s],fileName[%s]", dirPath, fileName));
    FTPClient ftpClient = login();

    try {
      ftpClient.changeWorkingDirectory(dirPath);
      String[] listNames = ftpClient.listNames();
      ftpClient.changeWorkingDirectory("/");
      if(listNames == null || listNames.length == 0) {
        return false;
      }
      else {
        //System.out.println("listNames: " + Arrays.toString(listNames));
        for(String name : listNames) {
          if(name.equals(fileName)) {
            return true;
          }
        }
      }
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      close(ftpClient);
    }

    return false;
  }

  /**
   *  连接FTP
   */
  private static FTPClient login() {
    int port = Integer.parseInt(FTPUtil.port);
    FTPClient ftpClient = new FTPClient();
    FTPClientConfig config = new FTPClientConfig();
    ftpClient.configure(config);

    try {
      ftpClient.connect(host, port);

      int reply = ftpClient.getReplyCode();
      if(!FTPReply.isPositiveCompletion(reply)) {
        ftpClient.disconnect();
        return null;
      }

      if(!ftpClient.login(username, password)) {
        ftpClient.logout();
        return null;
      }

      ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
    } catch(Exception e) {
      e.printStackTrace();
    }

    return ftpClient;
  }

  /**
   *  关闭FTP
   */
  private static boolean close(FTPClient ftpClient) {
    if(ftpClient == null) {
      return false;
    }
   
    try {
      if(ftpClient.isConnected()) {
        ftpClient.disconnect();
        return true;
      }
    } catch(Exception e) {
      e.printStackTrace();
    }

    return false;
  }

  /**
   *  关闭流
   */
  private static boolean close(Closeable stream) {
    if(stream == null) {
      return false;
    }
    
    try {
      stream.close();
      return true;
    } catch(Exception e) {
      e.printStackTrace(); 
    }

    return false;
  }


  /** 主机名 */
  private static String host = "localhost";
  /** 端口号 */
  private static String port = "22";
  /** 登录帐号 */
  private static String username = "root";
  /** 登录密码 */
  private static String password = "root";
}
