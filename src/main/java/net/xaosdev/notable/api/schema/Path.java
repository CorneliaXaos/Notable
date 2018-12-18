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
     * Gets the subpath of this Path
     * @return the subpath of this path.
     */
    String getSubpath();

    /**
     * Sets the subpath of this Path.
     * @param subpath the string subpath
     */
    void setSubpath(final String subpath);

    //endregion
}
