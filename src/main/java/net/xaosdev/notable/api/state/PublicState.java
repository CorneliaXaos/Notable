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

package net.xaosdev.notable.api.state;

import net.xaosdev.notable.api.schema.SchemaFactory;

/**
 * Provides access to objects of interest to the entire application.  The PublicState acts as a filtered window into
 * the application state for Plugins and external code.
 */
public interface PublicState {

    //region Interface

    /**
     * Gets the NotebookTracker instance used for tracking the currently opened Notebook / Interpreter.
     * @return the NotebookTracker instance.
     */
    NotebookTracker getNotebookTracker();

    /**
     * Gets the SchemaFactory instance used for the creation of new Schema objects.
     * @return the SchemaFactory instance for application use.
     */
    SchemaFactory getSchemaFactory();

    //endregion
}
