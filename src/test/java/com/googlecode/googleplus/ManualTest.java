package com.googlecode.googleplus;

import org.springframework.social.oauth2.OAuth2Parameters;

import com.googlecode.googleplus.model.person.Person;

public class ManualTest {

    public static void main(String[] args) {
        String secret = "<secret>";
        String id = "<id>";
        OAuth2Parameters oAuthParams = new OAuth2Parameters();
        oAuthParams.setRedirectUri("<https-url>/googleplus/authenticate");
        oAuthParams.setScope("https://www.googleapis.com/auth/plus.me https://www.googleapis.com/auth/plus.moments.write");

        GooglePlusFactory factory = new GooglePlusFactory(id, secret);

        // Uncomment parts of the code below to simulate the whole flow
        // 1. Get the redirect url
        // 2. Open the url in the browser, authenticate, and copy the authorization code from the reidrected url
        // 3. Paste the code and exchange it for tokens.
        // 4. Copy the tokens and use it for getApi(..)

//        String url = factory.getOAuthOperations().buildAuthenticateUrl(oAuthParams);
//        System.out.println(url);

//        AccessGrant grant = factory.getOAuthOperations().exchangeForAccess("4/SFP8aeNosDMP5-FHagd4tn3DJ1dE.EmQMHn3p7p0eOl05ti8ZT3afWTlLjAI", oAuthParams.getRedirectUri(), null);
//        System.out.println(grant.getAccessToken());
//        System.out.println(grant.getRefreshToken());

//        Plus plus = factory.getApi("");
//        Person person = plus.getPeopleOperations().get("me");
//        System.out.println(person.getName().getFamilyName());
    }
}
