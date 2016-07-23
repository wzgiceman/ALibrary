/*
 * Copyright (C) 2012 www.amsoft.cn
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ab.global;

import java.io.File;

// TODO: Auto-generated Javadoc
/**
 * © 2012 amsoft.cn 名称：AbAppConfig.java 描述：初始设置类.
 *
 * @author 还如一梦中
 * @version v1.0 @date：2014-07-03 下午1:33:39
 */
public class AbAppConfig {

	/** UI设计的基准宽度. */
	public static int UI_WIDTH = 720;

	/** UI设计的基准高度. */
	public static int UI_HEIGHT = 1080;

	/** 默认 SharePreferences文件名. */
	public static String SHARED_PATH = "app_share";

	/** 默认下载文件地址. */
	public static String DOWNLOAD_ROOT_DIR = "Android" + File.separator + "data";

	/** 默认下载图片文件地址. */
	public static String DOWNLOAD_IMAGE_DIR = "images";

	/** 默认下载文件地址. */
	public static String DOWNLOAD_FILE_DIR = "files";

	/** APP缓存目录. */
	public static String CACHE_DIR = "caches";

	/** DB目录. */
	public static String DB_DIR = "db";
}
