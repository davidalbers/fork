/*
 * Copyright 2014 Shazam Entertainment Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License.
 *
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.shazam.fork.runtime;

import com.android.ddmlib.testrunner.XmlTestRunListener;
import com.shazam.fork.io.FilenameCreator;
import com.shazam.fork.model.TestClass;

import java.io.File;

public class ForkXmlTestRunListener extends XmlTestRunListener {
    private final FilenameCreator filenameCreator;
    private final String pool;
    private final String serial;
    private final TestClass testClass;

    public ForkXmlTestRunListener(FilenameCreator filenameCreator, String pool, String serial, TestClass testClass) {
        this.filenameCreator = filenameCreator;
        this.pool = pool;
        this.serial = serial;
        this.testClass = testClass;
    }

    @Override
    protected File getResultFile(File reportDir) {
        return filenameCreator.createFileForTest(pool, serial, testClass);
    }
}
