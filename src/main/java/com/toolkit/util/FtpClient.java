package com.toolkit.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

public class FtpClient {

    public FtpClient(String ip, int port, String userName, String password) {
	this.ip = ip;
	this.port = port;
	this.userName = userName;
	this.password = password;
    }

    private String ip;
    private int port;
    private String userName;
    private String password;
    FTPClient client = new FTPClient();

    /**
     * 连接到FTP服务器
     * 
     * @return
     */
    public boolean connect() {
	try {
	    client.connect(ip, port);
	    client.login(userName, password);
	    int code = client.getReplyCode();
	    if (FTPReply.isPositiveCompletion(code))
		return true;
	    client.disconnect();
	} catch (SocketException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return false;
    }

    /**
     * 下载文件
     * 
     * @param filePath文件路径
     * @return
     */
    public synchronized OutputStream download(String filePath) {
	try {
	    FTPFile[] ftpFileArr = client.listFiles(filePath);
	    if (ftpFileArr.length == 1) {
		FTPFile ftpfile = ftpFileArr[0];
		if (ftpfile.isFile()) {
		    OutputStream os = new ByteArrayOutputStream();
		    boolean tf = client.retrieveFile(filePath, os);
		    if (tf)
			return os;
		}
	    }
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return null;
    }

    /**
     * 上传文件
     * 
     * @param path     远程文件夹路径
     * @param fileName 文件名
     * @param is       io流
     * @return
     */
    public synchronized boolean upload(String path, String fileName, InputStream is) {
	try {
	    client.changeWorkingDirectory(path);
	    client.setBufferSize(1024);
	    client.enterLocalPassiveMode();
	    client.setFileType(FTPClient.BINARY_FILE_TYPE);
	    boolean tf = client.storeFile(fileName, is);
	    is.close();
	    return tf;
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return false;
    }

    /**
     * 删除文件
     * 
     * @param path     文件所在的文件夹
     * @param fileName 文件名
     * @return
     */
    public synchronized boolean deleteFile(String path, String fileName) {
	try {
	    // 切换FTP目录
	    client.changeWorkingDirectory(path);
	    int code = client.dele(fileName);
	    if (FTPReply.isPositiveCompletion(code))
		return true;
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return false;
    }

    /**
     * 退出FTP服务器
     * 
     * @return
     */
    public synchronized boolean logout() {
	try {
	    return client.logout();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return false;
    }

    public String getIp() {
	return ip;
    }

    public void setIp(String ip) {
	this.ip = ip;
    }

    public int getPort() {
	return port;
    }

    public void setPort(int port) {
	this.port = port;
    }

    public String getUserName() {
	return userName;
    }

    public void setUserName(String userName) {
	this.userName = userName;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }
}