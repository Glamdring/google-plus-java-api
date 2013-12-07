##Google+ Java API

A Java client for the <a href="https://developers.google.com/+/api/">Google+ API</a>, based on <a href="http://www.springsource.org/spring-social">spring-social</a>.

This library is built ontop of spring-social and uses apache http components and jackson (see below the full list of dependencies)

###Usage

The way to use the API is:

```java
GooglePlusFactory factory = new GooglePlusFactory(clientId, clientSecret);
// the refreshListener is notified in case a new access token is obtained after the old one expires
Plus plus = factory.getApi(accessToken, refreshToken, refreshListener);
ActivityFeed activities = plus.getActivityOperations().list(userId);
```

The factory is thread-safe and is supposed to have a single instance in your application.

###OAuth2

Google+ uses OAuth2. Read through <a href="https://developers.google.com/+/api/oauth">the documentation</a> to get a clear picture. Here tokens are obtained as follows (in a web application):

```java
GooglePlusFactory factory = new GooglePlusFactory(clientId, clientSecret);
OAuth2Parameters oAuthParams = new OAuth2Parameters();
oAuthParams.setRedirectUri("http://yoursite.com/oauth/");
oAuthParams.setScope("https://www.googleapis.com/auth/plus.me
    https://www.googleapis.com/auth/plus.moments.write");
String url = factory.getOAuthOperations()
    .buildAuthenticateUrl(GrantType.AUTHORIZATION_CODE, oAuthParams);
response.sendRedirect(url);
```

After the user authorizes your app they will be redirected to your /oauth/ url. There you will receive a "code" parameter. You can exchange that code for an access token:

```java
AccessGrant accessGrant = factory.getOAuthOperations()
    .exchangeForAccess(code, oAuthParams.getRedirectUri(), null);
```

###Dependencies

This library depends on a couple of libraries. All of them are industry-standards - widely tested and adopted:

  * spring-social (base framework for social network API clients) (including spring-social-core, and transitively: spring-web, spring-core, spring-beans and spring-context)
  * apache http components (used for handling the http traffic)
  * jackson (json mapper)
  * joda-time (de-facto date-time standard)
  * slf4j (logging facade that delegates to whatever logger you use in your project)

The preferable way of using this is through maven, so that all transitive dependencies are fetched automatically.

###Download

You can download the .jar file from the <a href="https://github.com/Glamdring/google-plus-java-api/releases">Releases</a> section, or you can get it with maven:

    <dependency>
        <groupId>com.googlecode.googleplus</groupId>
        <artifactId>google-plus-java-api</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </dependency>

The repository you have to add is:

    <repository>
        <id>sonatype-oss</id>
        <url>https://oss.sonatype.org/content/groups/public</url>
    </repository>
