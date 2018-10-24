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

/**
 * The SchemaFactory object is used by plugins and the core to create Schema Objects (Notebook, Note, etc.)
 */
public interface SchemaFactory {

    //region Interface

    /**
     * Creates a new Notebook instance for use.
     * @return a new Notebook instance.
     */
    Notebook newNotebook();

    /**
     * Creates a new Note instance for use.
     * The initial contents of this Note are empty.
     * @return a new Note instance.
     */
    Note newNote();

    /**
     * Creates a new Note instance for use with the specified initial contents.
     * @param initialContents the contents of the new Note.
     * @return a new Note instance with initial contents.
     */
    Note newNote(final String initialContents);

    //endregion
}
