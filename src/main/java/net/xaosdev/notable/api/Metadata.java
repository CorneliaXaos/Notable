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
 * This is an enumeration used to track the metadata keys provided by Notable.
 * Plugin developers creating their own metadata keys should follow the package naming method for creating keys.
 */
public enum Metadata {

    //region Enumerations

    /**
     * The name of the Notebook, assigned by the user during creation.
     */
    NOTEBOOK_NAME("net.xaosdev.notable.api.Metadata.NOTEBOOK_NAME"),
    /**
     * The last version of Notable used to edit the Notebook.
     */
    LAST_EDITED_VERSION("net.xaosdev.notable.api.Metadata.LAST_EDITED_VERSION");

    //endregion

    //region Fields

    /**
     * The Metadata key.
     */
    private final String key;

    //endregion

    //region Constructors

    /**
     * Constructs the enumeration.
     * @param key the String key.
     */
    Metadata(final String key) {
        this.key = key;
    }

    //endregion

    //region Interface

    @Override
    public String toString() {
        return this.key;
    }

    //endregion
}
