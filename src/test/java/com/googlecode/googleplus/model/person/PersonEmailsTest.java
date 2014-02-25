/*
 * Copyright 2014 jgreen.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.googlecode.googleplus.model.person;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author jgreen
 */
public class PersonEmailsTest {

    @Test
    public void testTypeIsGoogle() {
        PersonEmails google = new PersonEmails();
        google.setType("account");
        Assert.assertTrue(google.isGoogle());
        Assert.assertFalse(google.isHome());
        Assert.assertFalse(google.isWork());
        Assert.assertFalse(google.isOther());
    }

    @Test
    public void testTypeIsHome() {
        PersonEmails google = new PersonEmails();
        google.setType("home");
        Assert.assertFalse(google.isGoogle());
        Assert.assertTrue(google.isHome());
        Assert.assertFalse(google.isWork());
        Assert.assertFalse(google.isOther());
    }

    @Test
    public void testTypeIsWork() {
        PersonEmails google = new PersonEmails();
        google.setType("work");
        Assert.assertFalse(google.isGoogle());
        Assert.assertFalse(google.isHome());
        Assert.assertTrue(google.isWork());
        Assert.assertFalse(google.isOther());
    }

    @Test
    public void testTypeIsOther() {
        PersonEmails google = new PersonEmails();
        google.setType("other");
        Assert.assertFalse(google.isGoogle());
        Assert.assertFalse(google.isHome());
        Assert.assertFalse(google.isWork());
        Assert.assertTrue(google.isOther());
    }
}
