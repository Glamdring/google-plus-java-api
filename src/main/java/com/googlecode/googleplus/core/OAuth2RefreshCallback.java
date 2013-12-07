package com.googlecode.googleplus.core;

/**
 * Interface for internal use
 *
 * @author bozho
 *
 */
public interface OAuth2RefreshCallback {

    /**
     * Attempts to refresh the token
     * @return the new access token
     */
    String refreshToken();
}
