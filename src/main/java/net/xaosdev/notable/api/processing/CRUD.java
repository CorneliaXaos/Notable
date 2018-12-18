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

import net.xaosdev.notable.api.schema.Path;

/**
 * An interface representing the CRUD-like actions that can be taken on Notebook artifacts.
 */
public interface CRUD<T> {

    //region Interface

    /**
     * Used to create a new Schema object at the specified path..
     * @param path the path of the new object.
     * @return the new Schema object, or null if an error occurred
     */
    T create(final Path path);

    /**
     * Used to acquire a reference to a Schema object contained at the specified path.
     * @param path the Path identifying the Schema object
     * @return the acquired object or null if the targeted Notebook does not contain an object at the specified path.
     */
    T get(final Path path);

    /**
     * Used to write out the schema object pointed to by the Path.  I.e. write out the contents
     * of a modified Note and mark it as no-longer being modified when the operation is successful.
     * @param path the Path identifying the Schema object.
     * @return true if the update operation was a success, false if the Path was invalid or a failure occurred.
     */
    boolean update(final Path path);

    /**
     * Used to move a Schema Object from one Path to another.
     * @param from the path to move from.
     * @param to the path to move to.
     * @return false if any of the paths are invalid or the operation failed, true otherwise.
     */
    boolean move(final Path from, final Path to);

    /**
     * Used to delete a Schema Object at a specified Path.
     * @param path the path of the object to delete.
     * @return false if the path is invalid or the operation failed, true otherwise.
     */
    boolean delete(final Path path);

    //endregion
}
