package com.googlecode.googleplus;

import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Parameters;

import com.google.common.collect.Lists;

public class ManualTest {

    public static void main(String[] args) {
        String secret = "<secret>";
        String id = "<id>";
        OAuth2Parameters oAuthParams = new OAuth2Parameters();
        oAuthParams.setRedirectUri("<https-url>/googleplus/authenticate");
        oAuthParams.setScope("https://www.googleapis.com/auth/plus.me https://www.googleapis.com/auth/plus.moments.write");
        oAuthParams.put("access_type", Lists.newArrayList("offline"));

        GooglePlusFactory factory = new GooglePlusFactory(id, secret);

        // Uncomment parts of the code below to simulate the whole flow
        // 1. Get the redirect url
        // 2. Open the url in the browser, authenticate, and copy the authorization code from the reidrected url
        // 3. Paste the code and exchange it for tokens.
        // 4. Copy the tokens and use it for getApi(..)

//        String url = factory.getOAuthOperations().buildAuthenticateUrl(oAuthParams);
//        System.out.println(url);

//        AccessGrant grant = factory.getOAuthOperations().exchangeForAccess("<code>", oAuthParams.getRedirectUri(), null);
//        System.out.println(grant.getAccessToken());
//        System.out.println(grant.getRefreshToken());

//        Plus plus = factory.getApi("<token>");
//        Person person = plus.getPeopleOperations().get("me");
//        System.out.println(person.getName().getFamilyName());
    }
}
