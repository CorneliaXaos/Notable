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

import java.util.List;
import java.util.Map;

/**
 * A Notebook is the primary representation used to interact with user generated content.
 *
 * A Notebook does not contain any Notebook artifacts (i.e Notes, Assets, or other files) directly, but rather serves as
 * an access point for retrieving metadata and Notebook artifacts.
 */
public interface Notebook {

    //region Interface

    /**
     * Used to acquire a String->String Map for storing Notebook Metadata.
     * @return the String->String Map for storing Notebook Metadata.
     */
    Map<String, String> getMetadata();

    /**
     * Used to acquire a hierarchical listing of all Notes within a Notebook.
     * These paths are NOT the actual file system paths, but the hierarchical path structure of notes contained
     * within a Notebook.  The paths are relative to the underlying data structure (usually a directory) containing
     * all Notes.  An example path would be: "folder/note.md"
     * @return a List of Strings containing the note paths.
     */
    List<String> getNotePaths();

    //endregion
}
