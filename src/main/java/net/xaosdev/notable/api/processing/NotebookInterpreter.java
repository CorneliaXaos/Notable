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
 * the Interpreter is instructed to do so.
 *
 * Interpreters are "instantaneous operation".  That is to say, when they are instructed to create, get, update, move,
 * or delete they should attempt to perform these operations immediately.  Failure is, usually, indicated via a return
 * value of null or false.  In NO case should an exception be thrown by one of these methods (use the appropriate
 * failure reporting method).
 *
 * Additionally, initialization of an Interpreter should happen during its construction.  That is, they should acquire
 * all their state and resources when they are constructed as this will be their main opportunity to do so (unless
 * a lazy-loading paradigm is implemented instead; the CRUD operations listed above are considered blocking with an
 * indefinite progress).  Constructors may throw exceptions as a means of reporting failure to initialize an
 * interpreter.  Obviously, they should ensure any resources they've acquired have been freed prior to doing so!
 */
public interface NotebookInterpreter {

    //region Interface

    /**
     * Used to acquire the Notebook reference created by this interpreter.
     * @return the Notebook reference.
     */
    Notebook getNotebook();

    /**
     * Used to instruct the Interpreter to update teh Notebook reference on disk.
     * @return true if the operation was successful, false otherwise.
     */
    boolean updateNotebook();

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
     * Instructs the Interpreter to write out the schema object pointed to by the Path.  I.e. write out the contents
     * of a modified Note and mark it as no-longer being modified when the operation is successful.
     * @param path the Path identifying the Schema object.
     * @return true if the update operation was a success, false if the Path was invalid or a failure occurred.
     */
    boolean update(final Path path);

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

    /**
     * Used to instruct the interpreter to release resources and shutdown.
     */
    void close();

    //endregion
}
