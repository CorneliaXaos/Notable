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
 * Used to identify objects within a Notebook.
 * Objects are identified by type and string subpath.
 */
public interface Path {

    //region Interface

    /**
     * Gets the type of this Path.
     * @return the Type of this Path.
     */
    Type getType();

    /**
     * Gets the subpath of this Path
     * @return the subpath of this path.
     */
    String getSubpath();

    /**
     * Sets the subpath of this Path.
     * @param subpath the string subpath
     */
    void setSubpath(final String subpath);

    /**
     * Returns true if the supplied Path is the same Type as this Path.
     * @param other the Path to compare to.
     * @return true if the other Path is the same Type as this Path, false otherwise.
     */
    boolean isSameType(final Path other);

    //endregion

    //region Types

    /**
     * The type of the object to refer in path.  This additional
     * parameter is added for convenience sake even though (usually) entries
     * will not have the same string subpath.
     */
    enum Type {
        /**
         * A Note
         * @see net.xaosdev.notable.api.schema.Note
         */
        NOTE
    }

    //endregion
}
