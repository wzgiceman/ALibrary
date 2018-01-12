# Android常用开发工具类

## 应用工具类  [ **`AbAppUtil`**](https://github.com/wzgiceman/ALibrary/blob/master/src/main/java/com/ab/util/AbAppUtil.java)
* 读取application 节点  meta-data 信息`readMetaDataFromApplication`
* 打开并安装文件 `installApk`
* 卸载程序 `uninstallApk`
* 用来判断服务是否运行 `isServiceRunning`
* 停止服务  `stopRunningService`
* 判断网络是否有效 `isNetworkAvailable`
* Gps是否打开 `isGpsEnabled`
* 判断当前网络是否是移动数据网络 `isMobile`
* 导入数据库 `importDatabase`
* 获取屏幕尺寸与密度 `getDisplayMetrics`
* 打开键盘 `showSoftInput`
* 关闭键盘事件 `closeSoftInput`
* 获取包信息 `getPackageInfo`
* 获取当前版本号 `getVersionName`
* 获取开发版本号 `getVersionCode`
* 是否存在该包名的应用 `exitAppBy`


## 日期处理类  [**`AbDateUtil`**](https://github.com/wzgiceman/ALibrary/blob/master/src/main/java/com/ab/util/AbDateUtil.java)
* String类型的日期时间转化为Date类型 `getDateByFormat`
* 获取偏移之后的Date `getDateByOffset`
* 获取指定日期时间的字符串(可偏移) `getStringByOffset`
* Date类型转化为String类型(可偏移) `getStringByOffset`
* Date类型转化为String类型 `getStringByFormat`
* 获取指定日期时间的字符串,用于导出想要的格式 `getStringByFormat`
* 获取milliseconds表示的日期时间的字符串 `getStringByFormat`
* 获取表示当前日期时间的字符串 `getCurrentDate`
* 获取表示当前日期时间的字符串(可偏移) `getCurrentDateByOffset`
* 计算两个日期所差的天数 `getOffectDay`
* 计算两个日期所差的小时数 `getOffectHour`
* 计算两个日期所差的分钟数 `getOffectMinutes`
* 获取本周一 `getFirstDayOfWeek`
* 获取本周日 `getLastDayOfWeek`
* 获取本周的某一天 `getDayOfWeek`
* 获取本月第一天 `getFirstDayOfMonth`
* 获取本月最后一天 `getLastDayOfMonth`
* 获取表示当前日期的0点时间毫秒数 `getFirstTimeOfDay`
* 获取表示当前日期24点时间毫秒数 `getLastTimeOfDay`
* 判断是否是闰年 `isLeapYear`
* 根据时间返回格式化后的时间的描述. 小于1小时显示多少分钟前 大于1小时显示今天＋实际日期，大于今天全部显示实际时间`formatDateStr2Desc`
* 取指定日期为星期几 `getWeekNumber`
* 根据给定的日期判断是否为上下午 `getTimeQuantum`
* 根据给定的毫秒数算得时间的描述 `getTimeDescription`
* 解析时间按照小时：分：秒格式输出 `getTime`


## 文件操作类 [**`AbFileUtil`**](https://github.com/wzgiceman/ALibrary/blob/master/src/main/java/com/ab/util/AbFileUtil.java)
* 通过文件的网络地址从SD卡中读取图片，如果SD中没有则自动下载并保存 `getBitmapFromSD`
* 通过文件的本地地址从SD卡读取图片 `getBitmapFromSD`
* 通过文件的本地地址从SD卡读取图片 `getBitmapFromSD`
* 将图片的byte[]写入本地文件 `getBitmapFromByte`
* 根据URL从互连网获取图片 `getBitmapFromURL`
* 获取src中的图片资源 `getBitmapFromSrc`
* 获取Asset中的图片资源 `getBitmapFromAsset` `getDrawableFromAsset`
* 下载网络文件到SD卡中.如果SD中存在同名文件将不再下载 `downloadFile`
* 获取网络文件的大小 `getContentLengthFromUrl`
* 获取文件名，通过网络获取 `getRealFileNameFromUrl`
* 获取真实文件名（xx.后缀），通过网络获取 `getRealFileName`
* 获取文件名（不含后缀） `getCacheFileNameFromUrl`
* 获取文件名（.后缀），外链模式和通过网络获取 `getCacheFileNameFromUrl`
* 获取文件后缀，本地 `getMIMEFromUrl`
* 从sd卡中的文件读取到byte `getByteArrayFromSD`
* 将byte数组写入文件 `writeByteArrayToSD`
* SD卡是否能用 `isCanUseSD`
* 计算sdcard上的剩余空间 `freeSpaceOnSD`
* 根据文件的最后修改时间进行排序 `FileLastModifSort`
* 删除所有缓存文件 `clearDownloadFile`
* 读取Assets目录的文件内容 `readAssetsByName`
* 读取Raw目录的文件内容 `readRawByName`
* 解压缩功能. 将zipFile文件解压到folderPath目录下 `upZipFile`
* 给定根目录，返回一个相对路径所对应的实际文件名.（压缩文件)  `getRealFileName`
* 打开pdf文件 `openPdfFile`
* 删除文件，可以是单个文件或文件夹 `delete`
* 删除单个文件 `deleteFile`
* 删除目录（文件夹）以及目录下的文件 `deleteDirectory`
* 获取下载根目录 `getDownloadRootDir`
* 获取图片下载根目录  `getImageDownloadDir`
* 获取文件下载根目录`getFileDownloadDir`
* 本地缓存的目录 `getCacheDownloadDir`
* 本地数据库目录 `getDbDownloadDir`
* 缓存中可用的大小 `getFreeSdSpaceNeededToCache`


## 图形处理类 [**`AbGraphicUtil`**](https://github.com/wzgiceman/ALibrary/blob/master/src/main/java/com/ab/util/AbGraphicUtil.java)
* 获取字符的所在位置（按像素获取最大能容纳的）`subStringLength`
* 获取文字的像素宽 `getStringWidth`
* 获得文字的宽度 `getDesiredWidth`
* 获取文字的高度 `getDesiredHeight`
* 字符解析成行 `getDrawRowStr`
* 获取这段文本多少行 `getDrawRowCount`
* 绘制文本，支持换行 `drawText`


## 图片处理类 [**`AbImageUtil`**](https://github.com/wzgiceman/ALibrary/blob/master/src/main/java/com/ab/util/AbImageUtil.java)
* 解析bitmap `getBitmapByte`
* 直接获取互联网上的图片 `getBitmap`
* 获取原图 `getBitmap`
* 缩放图片.压缩 `scaleImg`
* 缩放图片,不压缩的缩放
* 裁剪图片 `cutImg`
* Drawable转Bitmap `drawableToBitmap`
* Bitmap对象转换Drawable对象. `bitmapToDrawable`
* Bitmap对象转换TransitionDrawable对象 `bitmapToTransitionDrawable`
* Drawable对象转换TransitionDrawable对象 `drawableToTransitionDrawable`
* 将Bitmap转换为byte[] `bitmap2Bytes`
* 获取Bitmap大小 `getByteCount`
* 将byte[]转换为Bitmap `bytes2Bimap`
* 将View转换为Drawable.需要最上层布局为Linearlayout `view2Drawable`
* 将View转换为Bitmap.需要最上层布局为Linearlayout `view2Bitmap`
* 将View转换为byte[] `view2Bytes`
* 旋转Bitmap为一定的角度 `rotateBitmap`
* 旋转Bitmap为一定的角度并四周暗化处理 `rotateBitmapTranslate`
* 转换图片转换成圆形 `toRoundBitmap`
* 转换图片转换成圆形通过指定的弧度 `toRoundBitmap`
* 转换图片转换成镜面效果的图片 `toReflectionBitmap`
* 释放Bitmap对象 `releaseBitmap`
* 释放Bitmap数组 `releaseBitmapArray`
* 简单的图像的特征值，用于缩略图找原图比较好 `getHashCode`
* 图像的特征值颜色分布 将颜色分4个区，0,1,2,3 区组合共64组，计算每个像素点属于哪个区 `getColorHistogram`
* 计算"汉明距离"（Hamming distance）`hammingDistance`
* 灰度值计算 `rgbToGray`
* 压缩图片 `compressBitmap`
* 根据URI获取图片物理路径 `getAbsoluteImagePath`

## 日志工具类 [**`AbLogUtil`**](https://github.com/wzgiceman/ALibrary/blob/master/src/main/java/com/ab/util/AbLogUtil.java)

## 数学处理类 [**`AbMathUtil`**](https://github.com/wzgiceman/ALibrary/blob/master/src/main/java/com/ab/util/AbMathUtil.java)
* 四舍五入  `round`
* 字节数组转换成16进制串 `byte2HexStr`
* 二进制转为十六进制 `binaryToHex`
* 一维数组转为二维数组 `arrayToMatrix`
* 二维数组转为一维数组 `matrixToArray`
* int数组转换为double数组 `intToDoubleArray`
* int二维数组转换为double二维数组. `intToDoubleMatrix`
* 计算数组的平均值 `average`
* 点在直线上 `pointAtSLine`
* 点在线段上 `pointAtELine`
* 两条直线相交 `LineAtLine`
* 线段与线段相交 `eLineAtELine`
* 点在矩形内 `pointAtRect`
* 矩形在矩形内 `rectAtRect`
* 圆心在矩形内 `circleAtRect`
* 获取两点间的距离 `getDistance`
* 矩形碰撞检测 参数为x,y,width,height `isRectCollision`


## MD5加密 [**`AbMd5`**](https://github.com/wzgiceman/ALibrary/blob/master/src/main/java/com/ab/util/AbMd5.java)
* MD5加密 `MD5`


## 保存到 SharedPreferences 的数据 [**`AbSharedUtil`**](https://github.com/wzgiceman/ALibrary/blob/master/src/main/java/com/ab/util/AbSharedUtil.java)

## 字符串处理类 [**`AbStrUtil`**](https://github.com/wzgiceman/ALibrary/blob/master/src/main/java/com/ab/util/AbStrUtil.java)
* 给填写搜索单词的关键词显示 特殊颜色 `changeTextColor`
* 将null转化为“” `parseEmpty`
* 判断一个字符串是否为null或空值 `isEmpty`
* 集合是否为空 `isEmpty`
* 获取字符串中文字符的长度（每个中文算2个字符） `chineseLength`
* 获取字符串的长度 `strLength`
* 获取指定长度的字符所在位置 `subStringLength`
* 手机号格式验证 `isMobileNo`
* 是否只是字母和数字 `isNumberLetter`
* 是否只是数字 `isNumber`
* 是否是邮箱 `isEmail`
* 是否是中文 `isChinese`
* 是否包含中文 `isContainChinese`
* 是否包含中文数字字母的用户名 `isConintChinseUser`
* 从输入流中获得String `convertStreamToString`
* 标准化日期时间类型的数据，不足两位的补0 `dateTimeFormat`
* 不足2个字符的在前面补“0” `strFormat2`
* 截取字符串到指定字节长度 `cutString`
* 截取字符串从第一个指定字符 `cutStringFromChar`
* 获取字节长度 `strlen`
* 获取大小的描述 `getSizeDesc`
* ip地址转换为10进制数 `ip2int`

## View工具类 [**`AbViewUtil`**](https://github.com/wzgiceman/ALibrary/blob/master/src/main/java/com/ab/util/AbViewUtil.java)
* 测量这个view `measureView`
* 获得这个View的宽度 `getViewWidth`
* 获得这个View的高度 `getViewHeight`
* 从父亲布局中移除自己 `removeSelfFromParent`
* dip转换为px `dip2px`
* px转换为dip `px2dip`
* sp转换为px `sp2px`
* px转换为sp `px2sp`
* 根据屏幕大小缩放 `scale`
* 根据屏幕大小缩放 `scale`
* TypedValue官方源码中的算法，任意单位转换为PX单位 `applyDimension`
* View树递归调用做适配 `scaleContentView`
* 按比例缩放View，以布局中的尺寸为基准 `scaleView`
* 缩放文字大小 `setSPTextSize`
* 缩放文字大小,这样设置的好处是文字的大小不和密度有关 `setTextSize`
* 缩放文字大小 `setTextSize`
* 设置View的PX尺寸 `setViewSize`
* 设置PX padding. `setPadding`
* 设置 PX margin `setMargin`


