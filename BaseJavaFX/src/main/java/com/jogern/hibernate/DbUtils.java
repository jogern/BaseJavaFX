package com.jogern.hibernate;


import com.jogern.common.Common;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Create on 2018/10/16.
 * @author jogern
 */

public class DbUtils {


      private static SessionFactory mFactory;

      /** 数据库是否有使用 */
      public static boolean isUseing() {
            return mFactory != null;
      }

      /** 得到数据的会话 */
      public static Session getDbSession() {
            if (mFactory == null) {
                  Configuration configuration = new Configuration();
                  configuration.configure("/hibernate.cfg.xml");
                  configuration.setProperty("hibernate.connection.url", "jdbc:sqlite:" + Common.DB_PATH);
                  mFactory = configuration.buildSessionFactory();
            }
            return mFactory.openSession();
      }

      /** 保存对象到数据库 */
      public static void saveObj(Object obj) {
            Session dbSession = getDbSession();
            Transaction transaction = dbSession.beginTransaction();
            dbSession.save(obj);
            transaction.commit();
      }


}
