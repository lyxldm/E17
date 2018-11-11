package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016091900545911";

    // 商户私钥，您的PKCS8格式RSA2私钥
    /*public static String merchant_private_key = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQC2D7eJ4BM3nQ1N"
+"k5OONEWQB62NXdJRfWgf+n/0+K131U3pxz0gx0RMbLQ34TJJdYoPh/RU8MDo5UqC"
+"Q6pNPKwbG3DH3MB0aYA73cPCsAQZxSZkPwZ0jNLq3p+HwWVSlapIEhA3AI5sCNlb"
+"JLqZbPjZmdKbcBGBxAXdVZhhpTOBlto0Joa76Vp7+yQTVXSvi/VUoIvbYIVeUaq1"
+"lm1+379Qr0HuZCerj6VjywgQ9FC7NZcM4XcjPQi3j7/SaePXgo0svEVNVY+69P5S"
+"V1uCbZ3I7Au3Gpo2Sm//bQoZfS4F73Fr6wuxfv2NtB1RyfGQwp4qYpfvPjXNGOL0"
+"/fEAoJIHAgMBAAECggEBAIX/HVvZ0usMqVzecCyqpkQyknbIheI6Rae7q++2E55u"
+"HPEiFgiJAOiq3R1/no5YdyulKZxWsfT3xZYIjVBZhmZRFPnUrMVBXQMy3kDtYadB"
+"5lbD2FFx0E7TWWEGYzecNf7jZJHG1AwJm0gsyTXg8WrefxauLgRvLM3RkNzVRQpr"
+"qWeHDrbzboL7V9KBgyEhoyLjPm74sL8ZK+WViHxoqkWWNmUpo4sUwg4NYKLGTuv4"
+"McKL7G6p0QL/vdTjm+5O7TJHtnI6UwcRrw+W5rvNulzGwaA4ZX5F35WtEEnOi7kw"
+"kx4dB8Dq9CTtZDT3JYpkZy0bJgvZcOA+AqvPgCC/s6ECgYEA5njRfXtyreXcaoWc"
+"q0hTBDaoyzK9iI3UOcc37/KXlrumA2XdGKTijSsYwkdU3yaG6cS6V6B1/mjFuakN"
+"jZ/CkSvykTaHpRuTG6pDIaQw65j4aT5oyqnQN++zBu+FaXVP6865uNrGtzxDyFoy"
+"8Wb/b1S3ogCMygwgreRGSgThftcCgYEAyjovnNwZzxvH9LyVfU7ukuioo7d0QgHo"
+"PFNzWm33Ki2oMFme/FyS8dAtK9bSj3RSo2VH/zZnRrN557yKsS+pjCu66yyj2AHz"
+"tZyUA8LhbLd8HyLLhWQSFDUWP7zGeyDoOyHhhIbEIuMLB6HB7H3BwJO6Qs3WhU9z"
+"hiWJhsQ2EFECgYEAnwqWvfn3XEt3/EYxo/0n1IuHlZlxM49z+V8hmcKVmx3o5QVh"
+"OoVmFTa9QiwJRGiIxz7LvHZtll9kuscPJEEv+hAStuSjXGuX64pmAwwT+jC4k5/O"
+"nrPqjP8rUsjtDqY2vaoNfaPzZzT+LX8ZEn8aHBChG/k3LqKJ1pXlb2TI20cCgYAP"
+"HFPsc6HWEOxbBDBjYZ+ACLR5Lz8Xo47X2yB2dFsQosK7gibYEo7EVNrbOL0ZDQcT"
+"wICluEn1RXnpb/QpEzenCql34ykG/fZY7q88rLYtanRy2yW7/ONA8UqNTqzCDI5t"
+"xLVWMr+7H532XwbfhfIRUriLP1g1M9+c+XcSQ90KUQKBgQDJwi/MpduRNk1jwtur"
+"LYfA9ohu18wTdsmyr7MxDjTfqc4/nN2T+qmqy6K8yD1KEjhbtprOZnig8D9eSoj/"
+"/Zxc/MEsSjHK7wUwzrR1RFqUVjC6E5wvq6BmfZqgKrvMFC9VN1r9IbSDHKlPQhFS"
+"e4t/fsldCxdImZix5/vcaNSHbg==";*/

    /*沙箱商户私钥，您的PKCS8格式RSA2私钥*/
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDQECAfgen2eJzX"+
            "LJuT3xiq/pI78lqioe0mflSyKcRs2bViYreismRN37mPTP7KKzD7g1o8gtc1xWfm"+
            "4jX0ul/ilGtFhjAnUJC+E+Ww46zGUFCel4TPumIo5mKewz6Mkdbjci2bxgEihp+G"+
            "OoJXaU/77eDYfbi+I8U9+NhX6PQp8B7uarxCMc3DZWWmwIBWr3biKynX8wbEg+Q2"+
            "ij6QOUw/Pb7FImj9pWvuH9f0fsxpFgIORb0BJcjGII8EI61r8AIX6l7sCqcUPvWF"+
            "k5yd6hvrgLBnGUReSk87CNL8XwtytfABu8mBgRT0+0I/XQWhlqZsSMSiAbDhuZLm"+
            "q7WfH3MPAgMBAAECggEBAMBoiSxZ+cDiXThnmiAvSiKndRhW0RZg5Gyamzx/f5Sh"+
            "6Clp3SRqEHQrlvA8ZcsUEiIloIchAGBLhABx5S/CQvXIB0OuCk3xJUmCIQFqKtbi"+
            "YwumVz26wRfNphnnuKpKHA0OA7twapBBKrj41px7WWpC25GZAgVkEv1yaK8zUMiO"+
            "Bw3lmzCkkLX8HM8Nkv0NFf52UEnWAi+5yLQ6m9sp3NfTzoblzm7hW22tUJYjI4KQ"+
            "QQVAUiao/CXZ5XNu1gokd73c9LDweBczKBu+J607XvAEHpet/fQb4qDIk24YeYXr"+
            "gvWJe7ph6IvzLXZLjzetubk+Svg59SZS9iI4k9Ll/BECgYEA/8716cwR8smMCQY2"+
            "Xkl+hkdQXVu1aYXZVfi/Oyu7FmoGmch+mv+U2DE+j4kcliqRtuJbnrCaj7HcCEcn"+
            "FNL+ZvqZb10UrwEHwBPdJxLqE/MhWSJFJfHjm4yhSodMf3JZ1V5J3YrQs0lUvrMq"+
            "rmBf3rSFZdrlrjjhrN4xcNrT60sCgYEA0DgDDFZyCCl74ZovYDnqJCGXNicB6X07"+
            "eJBQ6fCNwSz2TfTs6HlbGqgWGUYAmudKxd0y4jYa7+P6iqcJnd+RJaTAbiTS1n7h"+
            "WJwE7TyoRcLzggiVV96Vy+HJ4BpBuwnKtcpHVHl5YY2GqK3KQUa31Z6A6Kn6DVHa"+
            "jskY/4D3GM0CgYEA5UIndJx27X+iKChQK5p0cYWSSck6QdM6n+kqAa7EombteX+N"+
            "r/4k+MjRh7RbUV3fb+dYM1WVf/jn+OdD6E7cv5ASWRMzyVAEESn8RtuVu8FnfsnO"+
            "7R3nXe3gU7oEXiguyKITUyDov/WVpL9QHi2zXhWthEZ1F/pUjygnaTxFNxcCgYBF"+
            "dHmn0uokyNm27nyhJ5BvzvimqqpbnVeKJvGmp4RRjNL4PBwOi/SU1r7QXWZ0RXTO"+
            "vbNse8nOfYikWYW+sMW0/djmpMfjnt1CdoC6NgKXiqk5le1jKy9inAWACKImZuTE"+
            "cR4MEp0nqlLhz17pGVLXIhE0CwcLDGPQP0pkaDuEfQKBgHxPLdCQsP22ZwmqRW+7"+
            "uVtd2ytJqDFm/PcShp050awZvGlKEjoRVttDPdiPFyXFyolQwoBJqEbcy0xqHIMo"+
            "JcWj/BUtR4bIAgVNLfxizA/eVIwqIZuLcsifh7DuDnqfH/MYBvJkkQtQ3TTwMcNw"+
            "ZJDsnSiHqH1cIaZ3yvSeXaM+";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEApdWfgJgfmhGNToRdVYfjHH2eTkyg3DwCT3V+RuCBCoXxc744k6X8sOV/iyV44TAUaFgzjzPGcgdjbLsO2IvQTWUl4gzwrf6FrEeDGYAYQ+k5K/Yi0CvwSr1pQ3nL6M+Zpzh4tw5faMlDjT5jJG9TIMTKgnYTpSjINFc3gZrWLwUQ6lDp5WVfr6nHFPex6qPqVWRYTNkt5crUNw5nVpJW3BfM4nbtKGRsAA72l1oZZVzoSkkq/qg5wYuYER7EwsCg5V48Ru58RRYI8rxvlukj4yobQV5WUrDkvngpTWa3h6IBIGoDVVeDzZZH3EVVT4fVzhQhdwe4pADW8J3M9joGgQIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "/alipay.trade.page.pay-JAVA-UTF-8/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://39.107.70.161:8884/clearbar";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

	/*// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipay.com/gateway.do";
	*/

    /*沙箱支付宝网关*/
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";


    // 支付宝网关
    public static String log_path = "D:\\支付宝";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

