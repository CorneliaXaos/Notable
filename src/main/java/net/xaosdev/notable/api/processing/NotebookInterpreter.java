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

package net.xaosdev.notable.api.processing;

import net.xaosdev.notable.api.schema.Notebook;
import net.xaosdev.notable.api.schema.Path;

/**
 * This interface is used to read and write notebooks to and from disk.
 * Notebook API objects (i.e. Notebook, Note, etc.) should NOT be recreated at subsequent calls as it is expected that
 * modifications to the returned references be visible to the Interpreter instance and saved to long-term memory when
 * the Interpreter is instructed to sync.
 */
public interface NotebookInterpreter {

    //region Interface

    /**
     * Called once to ask the Interpreter to process the targeted Notebook for minimal operating information.
     * i.e. Create a Notebook book, gather filesystem references, etc.
     * @return true if successful, false otherwise.
     */
    boolean initialize();

    /**
     * Called to instruct the Interpreter to write out updated information to the FileSystem.
     * This call should update the long-term memory with the changes made internally by Notable.  This likely means
     * updating the Notebook reference, and performing CRUD operations on Notebook artifacts.
     * @return true if successful, false otherwise.
     */
    boolean sync();

    /**
     * Used to acquire the Notebook reference created by this interpreter.
     * @return the Notebook reference.
     */
    Notebook getNotebook();

    /**
     * Used to create a new Schema object within the targeted Notebook.
     * @param path the path of the new object.
     * @return the new Schema object, or null if an error occurred
     */
    Object create(final Path path);

    /**
     * Used to acquire a reference to a Schema object contained within the targeted Notebook.
     * @param path the Path identifying the Schema object
     * @return the acquired object or null if the targeted Notebook does not contain an object at the specified path.
     */
    Object get(final Path path);

    /**
     * Instructs the Interpreter to move a Schema Object from one Path to another.
     * @param from the path to move from.
     * @param to the path to move to.
     * @return false if any of the paths are invalid, the paths do not refer to the same type, or the operation failed;
     * true otherwise.
     */
    boolean move(final Path from, final Path to);

    /**
     * Instructs the Interpreter to delete a Schema Object at a specified Path.
     * @param path the path of the object to delete.
     * @return false if the path is invalid or the operation failed, true otherwise.
     */
    boolean delete(final Path path);

    //endregion
}
