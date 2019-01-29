package com.jogern.common;

import java.io.File;

/**
 * Created by jogern on 2018/12/8.
 */
public class Common {

      private static final String DIR = ".Diagnosis";
      /** app保存的路径 */
      public static final  String APP_DIR_PATH;
      /** sqlite数据库的路径 */
      public static final  String DB_PATH;

      static {
            File file = new File(System.getProperty("user.home"), DIR);
            if (!file.exists()) {
                  file.mkdirs();
            }
            APP_DIR_PATH = file.getAbsolutePath();
            DB_PATH = APP_DIR_PATH + File.separator + "temp_db.db";
      }


}
