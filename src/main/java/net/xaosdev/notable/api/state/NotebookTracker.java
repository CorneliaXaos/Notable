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

import net.xaosdev.notable.api.processing.NotebookInterpreter;

import java.io.File;

/**
 * API for limited access to the NotebookTracker that manages the currently opened Notebook / Interpreter.
 */
public interface NotebookTracker {

    //region Interface

    /**
     * Gets the path of the currently opened Notebook / Interpreter or null if no notebook is opened.
     * @return the path of the current Notebook.
     */
    File getNotebookPath();

    /**
     * Gets the active NotebookInterpreter instance or null if no notebook is opened.
     * @return the active NotebookInterpreter.
     */
    NotebookInterpreter getActiveInterpreter();

    //endregion
}
