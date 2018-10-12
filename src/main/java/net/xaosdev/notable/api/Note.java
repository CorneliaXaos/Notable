/*
 * Copyright 2018 Cornelia Ada Schultz
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package net.xaosdev.notable.api;

/**
 * A Note is the main atomic artifact within a Notebook.
 * This class contains methods for manipulating a Note and tracking that manipulation compared to what's stored on disk.
 */
public interface Note {

    //region Interface

    /**
     * Used to determine if this Note's content has been changed since
     * @return true if this Note differs from the version stored on disk.
     */
    boolean isModified();

    /**
     * Used to read the String contents of the Note.
     * @return the String containing the Note's contents.
     */
    String getContents();

    /**
     * Used to set the String contents of the Note.
     * @param contents the String containing the new contents.
     */
    void setContents(final String contents);

    /**
     * Used to acquire the contents of the Note as contained on disk.
     * @return the String containing the contents as on disk.
     */
    String getUnmodifiedContents();

    //endregion
}
