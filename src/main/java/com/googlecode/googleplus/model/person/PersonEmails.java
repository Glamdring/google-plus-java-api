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

/**
 *
 * @author jgreen
 */
public class PersonEmails {

    private static final String TYPE_GOOGLE = "account";
    private static final String TYPE_HOME = "home";
    private static final String TYPE_WORK = "work";
    private static final String TYPE_OTHER = "other";

    private String type;
    private String value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isGoogle() {
        return type != null && type.equals(TYPE_GOOGLE);
    }

    public boolean isHome() {
        return type != null && type.equals(TYPE_HOME);
    }

    public boolean isWork() {
        return type != null && type.equals(TYPE_WORK);
    }

    public boolean isOther() {
        return type != null && type.equals(TYPE_OTHER);
    }
}
