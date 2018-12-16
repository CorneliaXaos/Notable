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

package net.xaosdev.notable.api.schema;

import java.util.Map;
import java.util.Set;

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
     * Used to acquire a set of all Paths for a particular type of Notebook artifact.
     * These paths are NOT the actual file system paths, but the hierarchical path structure of artifacts contained
     * within a Notebook.  The paths are relative to the underlying data structure (usually a directory) containing
     * all of the specified artifacts.  An example subpath would be: "folder/note.md"
     * @param type the Type of Paths to acquire.
     * @return a Set of Paths containing all Paths for the specified Type.
     */
    Set<Path> getPaths(final Path.Type type);

    //endregion
}
