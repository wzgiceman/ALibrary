package com.ab.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.content.Context;
import android.media.MediaRecorder;
import android.os.Environment;
import android.util.Log;

/**
 * 录音帮助类
 * 
 * @author WZG
 *
 */
public class RecordUtils {
	/** 是否暂停标志位 **/
	private boolean isPause;
	/** 在暂停状态中 **/
	private boolean inThePause;
	/** 是否停止录音 **/
	private boolean isStopRecord;
	/** 录音保存路径文件夹 **/
	private File myRecAudioDir;
	private MediaRecorder mMediaRecorder;
	/** 记录需要合成的几段amr语音文件 **/
	private ArrayList<String> list;
	/** 当前录音文件 **/
	private File myRecAudioFile;
	/** 后缀名 **/
	private final String SUFFIX = ".amr";
	private Context context;

	public RecordUtils(Context context) {
		list = new ArrayList<String>();
		this.context = context;
		initRoute();
	}

	/**
	 * 开始录音
	 */
	public void startRecord() {
		list.clear();
		start();
	}

	/**
	 * 暂停录音
	 */
	public void pauseRecord() {
		isPause = true;
		// 当前正在录音的文件名，全程
		list.add(myRecAudioFile.getPath());
		inThePause = true;
		recodeStop();
	}

	/**
	 * 重新开始录音
	 */
	public void reStartRecord() {
		start();
		inThePause = false;
	}

	/**
	 * 结束录音
	 *
	 */
	public File stopRecord() {
		File resultePath = null;
		// 这里写暂停处理的 文件！加上list里面 语音合成起来
		if (isPause) {
			// 在暂停状态按下结束键,处理list就可以了
			if (inThePause) {
				resultePath = getInputCollection(list, false);
			}
			// 在正在录音时，处理list里面的和正在录音的语音
			else {
				list.add(myRecAudioFile.getPath());
				recodeStop();
				resultePath = getInputCollection(list, true);
			}
			// 还原标志位
			isPause = false;
			inThePause = false;
		}
		// 若录音没有经过任何暂停
		else {
			if (myRecAudioFile != null) {
				// 停止录音
				mMediaRecorder.stop();
				mMediaRecorder.release();
				mMediaRecorder = null;
				resultePath = myRecAudioFile;
			}
		}
		isStopRecord = true;
		return resultePath;
	}

	public boolean isPause() {
		return isPause;
	}

	public void setPause(boolean isPause) {
		this.isPause = isPause;
	}

	public boolean isInThePause() {
		return inThePause;
	}

	public void setInThePause(boolean inThePause) {
		this.inThePause = inThePause;
	}

	public boolean isStopRecord() {
		return isStopRecord;
	}

	public void setStopRecord(boolean isStopRecord) {
		this.isStopRecord = isStopRecord;
	}

	/**
	 * 初始化路径
	 */
	private void initRoute() {
		// 判断sd Card是否插入
		boolean sdcardExit = Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED);
		// 取得sd card路径作为录音文件的位置
		if (sdcardExit) {
			myRecAudioDir = new File(AbFileUtil.getDownloadRootDir(context), "Record");
			if (!myRecAudioDir.exists()) {
				myRecAudioDir.mkdirs();
			}
		}
		isStopRecord = true;
	}

	/**
	 * 开始录音
	 */
	private void start() {
		try {
			String mMinute1 = getTime();
			myRecAudioFile = new File(myRecAudioDir, mMinute1 + SUFFIX);
			mMediaRecorder = new MediaRecorder();
			// 设置录音为麦克风
			mMediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
			mMediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.RAW_AMR);
			mMediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
			// 录音文件保存这里
			mMediaRecorder.setOutputFile(myRecAudioFile.getAbsolutePath());
			mMediaRecorder.prepare();
			mMediaRecorder.start();
			isStopRecord = false;
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	/**
	 * 结束录音 銷毀錄音对象
	 */
	private void recodeStop() {
		if (mMediaRecorder != null && !isStopRecord) {
			// 停止录音
			mMediaRecorder.stop();
			mMediaRecorder.release();
			mMediaRecorder = null;
		}
	}

	/**
	 * 得到当前时间-作為錄音的名字
	 * 
	 * @return
	 */
	private String getTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日HH：mm：ss");
		Date curDate = new Date(System.currentTimeMillis());// 获取当前时间
		return formatter.format(curDate);
	}

	/**
	 * @param isAddLastRecord
	 *            是否需要添加list之外的最新录音，一起合并
	 * @return 将合并的流用字符保存
	 */
	private File getInputCollection(List<String> list, boolean isAddLastRecord) {
		String mMinute1 = getTime();
		// 创建音频文件,合并的文件放这里
		File file1 = new File(myRecAudioDir, mMinute1 + SUFFIX);
		FileOutputStream fileOutputStream = null;
		if (!file1.exists()) {
			try {
				file1.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			fileOutputStream = new FileOutputStream(file1);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// list里面为暂停录音 所产生的 几段录音文件的名字，中间几段文件的减去前面的6个字节头文件
		for (int i = 0; i < list.size(); i++) {
			File file = new File((String) list.get(i));
			Log.d("list的长度", list.size() + "");
			try {
				FileInputStream fileInputStream = new FileInputStream(file);
				byte[] myByte = new byte[fileInputStream.available()];
				// 文件长度
				int length = myByte.length;

				// 头文件
				if (i == 0) {
					while (fileInputStream.read(myByte) != -1) {
						fileOutputStream.write(myByte, 0, length);
					}
				}

				// 之后的文件，去掉头文件就可以了
				else {
					while (fileInputStream.read(myByte) != -1) {

						fileOutputStream.write(myByte, 6, length - 6);
					}
				}

				fileOutputStream.flush();
				fileInputStream.close();
				System.out.println("合成文件长度：" + file1.length());

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		// 结束后关闭流
		try {
			fileOutputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 合成一个文件后，删除之前暂停录音所保存的零碎合成文件
		deleteListRecord(isAddLastRecord);
		return file1;

	}

	/**
	 * 删除
	 * 
	 * @param isAddLastRecord
	 */
	private void deleteListRecord(boolean isAddLastRecord) {
		for (int i = 0; i < list.size(); i++) {
			File file = new File((String) list.get(i));
			if (file.exists()) {
				file.delete();
			}
		}
		// 正在暂停后，继续录音的这一段音频文件
		if (isAddLastRecord) {
			myRecAudioFile.delete();
		}
	}
}
