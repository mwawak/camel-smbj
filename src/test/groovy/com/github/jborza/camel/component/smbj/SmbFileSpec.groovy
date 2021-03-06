/**
 *  Copyright [2018] [Juraj Borza]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.jborza.camel.component.smbj

import spock.lang.Specification

class SmbFileSpec extends Specification {
    def "should correctly process constructor"() {
        expect:
        def file = new SmbFile(isDirectory, fileName, fileLength, lastModified, isArchive, isHidden, isReadonly, isSystem)
        file.isDirectory() == isDirectory
        file.getFileName() == fileName
        file.getFileLength() == fileLength
        file.lastModified == lastModified
        file.isArchive() == isArchive
        file.isHidden() == isHidden
        file.isReadOnly() == isReadonly
        file.isSystem() == isSystem

        where:
        isDirectory | fileName   | fileLength   | lastModified   | isArchive | isHidden | isReadonly | isSystem
        true        | "file.fil" | 12345678910L | 1261207195000L | true      | true     | true       | true
        false       | "file.fil" | 123L         | 1261207195000L | true      | false    | false      | false
        false       | "file.fil" | 123L         | 1261207195000L | false     | true     | false      | true
    }
}
