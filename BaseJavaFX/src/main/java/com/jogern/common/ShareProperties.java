package com.jogern.common;

import com.jogern.common.util.IoUtil;
import com.jogern.common.util.TextUtil;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by jogern on 2018/12/8.
 */
public class ShareProperties {

      private static Map<String, String> sMap = new HashMap<>();
      private static final String Proper_name = "ShareProperties.properties";
      private static final File sShareFie;

      static {
            sShareFie = new File(Common.APP_DIR_PATH, Proper_name);
            if (sShareFie.exists()) {
                  Properties prop = new Properties();
                  InputStream in = null;
                  try {
                        in = new BufferedInputStream(new FileInputStream(sShareFie));
                        prop.load(in);
                        for (String key : prop.stringPropertyNames()) {
                              sMap.put(key, prop.getProperty(key));
                        }
                        in.close();
                  } catch (Exception e) {
                        e.printStackTrace();
                  } finally {
                        IoUtil.closeIn(in);
                  }
            }
      }

      /**
       * 设置键值
       * @param map
       */
      private static void setValue(Map<String, String> map) {
            ///保存属性到b.properties文件
            FileOutputStream oFile = null;
            try {
                  Properties prop = new Properties();
                  oFile = new FileOutputStream(sShareFie, false);
                  for (String key : map.keySet()) {
                        prop.setProperty(key, map.get(key));
                  }
                  prop.store(oFile, null);
                  oFile.close();
            } catch (Exception e) {
                  e.printStackTrace();
            } finally {
                  IoUtil.closeOut(oFile);
            }
      }

      public static String getString(String key, String defValue) {
            String result = sMap.get(key);
            if (TextUtil.isEmpty(result)) {
                  return defValue;
            }
            return result;
      }

      public static void setString(String key, String value) {
            sMap.put(key, value);
            setValue(sMap);
      }


}
