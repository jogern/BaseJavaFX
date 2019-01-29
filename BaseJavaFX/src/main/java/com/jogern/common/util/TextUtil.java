package com.jogern.common.util;

/**
 * Created by jogern on 2018/12/8.
 */
public class TextUtil {

      private TextUtil() { }


      public static boolean isEmpty(CharSequence text) {
            return text == null || text.length() <= 0;
      }
}
