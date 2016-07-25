package org.xman.xland.util.props;

import java.io.InputStream;
import java.util.Properties;

/**
 * Properties Util Class
 *
 * @author xiandeb
 */
public class PropsUtil {
  private Properties props = null;

  public PropsUtil(String filepath) {
    InputStream in = PropsUtil.class.getClassLoader()
      .getResourceAsStream(filepath);
    props = new Properties();
    try {
      props.load(in);
    } catch (Exception e) {
      new RuntimeException(e);
    }
  }

  public String getString(String key) {
    return this.getString(key, "");
  }

  public String getString(String key, String defaultVal) {
    return props.getProperty(key, defaultVal);
  }

  /**
   * if the key not found, 0 returned.
   */
  public Integer getInteger(String key) {
    return Integer.valueOf(this.getString(key, "0"));
  }

}
