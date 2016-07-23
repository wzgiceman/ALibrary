package com.ab.util;

import android.os.Environment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * 日志工具，主要记录错误日志，方便在设备上查看
 * 
 * @author lucher
 * 
 */
public class LogErrorUtil {
	/**
	 * sdcard路径
	 */
	public static final String SDCARD_PATH = Environment.getExternalStorageDirectory() + File.separator;

	/**
	 * 文件存储路径
	 */
	public static final String FILE_SAVE_DIR = "Android/data/com.zaodao/log/";

	/**
	 * 文件存储全路径
	 */
	public static final String FULL_CACHE_DIR = SDCARD_PATH + FILE_SAVE_DIR;


	/**
	 * 写下日志
	 * 
	 * @param log
	 *            日志内容
	 */
	public static void log(String log) {
		String currentTime = AbDateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss");
		currentTime = "************" + currentTime + "************\n";
		log = toUtf8(log) + "\n";

		File logFile = checkLogFile();
		if (logFile == null)
			return;

		try {
			FileWriter fw = new FileWriter(logFile, true); // 日志以插入而非替换方式写入
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(currentTime);
			bw.write(log);
			bw.close();
			fw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * 检查日志文件是否存在，没有则创建
	 */
	public static File checkLogFile() {
		File logFile = null;
		String logFileName = "error-" +  AbDateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss")+ ".log";
		if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
			File folder = new File(FULL_CACHE_DIR); // 创建文件夹
			logFile = new File(FULL_CACHE_DIR, logFileName); // 创建log文件
			if (!folder.exists()) {
				folder.mkdirs();
			}
			if (!logFile.exists()) {
				try {
					logFile.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}

		return logFile;
	}

	public static String toUtf8(String str) {
		try {
			return new String(str.getBytes("UTF-8"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}
}
