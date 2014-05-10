package com.googlecode.googleplus;

/**
 * Class containing configuration options for the underlying connection.
 *
 * Note: proxyHost and proxyPort can be also set via -Dhttp.proxyHost= and
 * -Dhttp.proxyPort= when starting the JVM
 *
 * @author bozho
 *
 */
public class GooglePlusConfiguration {

    private int readTimeout;
    private int connectTimeout;
    private String proxyHost;
    private int proxyPort;

    public int getReadTimeout() {
        return readTimeout;
    }
    public void setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
    }
    public int getConnectTimeout() {
        return connectTimeout;
    }
    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }
    public String getProxyHost() {
        return proxyHost;
    }
    public void setProxyHost(String proxyHost) {
        this.proxyHost = proxyHost;
    }
    public int getProxyPort() {
        return proxyPort;
    }
    public void setProxyPort(int proxyPort) {
        this.proxyPort = proxyPort;
    }
}
