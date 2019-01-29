package com.jogern.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by jogern on 2018/12/8.
 */
public class IoUtil {

      private IoUtil() { }


      public static void closeIn(InputStream in) {
            if (in != null) {
                  try {
                        in.close();
                  } catch (IOException e) {
                        e.printStackTrace();
                  }
            }
      }

      public static void closeOut(OutputStream out) {
            if (out != null) {
                  try {
                        out.close();
                  } catch (IOException e) {
                        e.printStackTrace();
                  }
            }
      }

      public static void close(InputStream in, OutputStream out) {
            closeIn(in);
            closeOut(out);
      }

      public static void close(OutputStream out, InputStream in) {
            closeOut(out);
            closeIn(in);
      }


}
