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

package net.xaosdev.notable.spi;

import net.xaosdev.notable.api.NotebookInterpreter;

import java.io.File;

/**
 * This Service is used to create NotebookInterpreters as they are expected to have state.
 */
public interface InterpreterFactory {

    //region Interface

    /**
     * Acquires the Type of Interpreter produced by this Factory.
     * @return the Type of Interpreter.
     */
    Type getType();

    /**
     * Returns a String used to identify this Interpreter type to users.
     * @return a String used to identify this Interpreter type to users.
     */
    String getInterpreterName();

    /**
     * Used (only for FILE_BASED interpreters) to filter Files in a prompt for the user.
     * @return the String containing the File Filter.
     */
    String getFileFilter();

    /**
     * Used to acquire an instance of a NotebookInterpreter as NotebookInterpreters likely have state.
     * Factories are encouraged to perform some basic validation in this step.
     * @param target the File targeted by the user.  (Determined by Interpreter Type.)
     * @param workingDirectory a temporary working directory provided to the Interpreter for its use.
     * @param newNotebook a boolean indicating if a new notebook should be created at target.
     * @return the instanced NotebookInterpreter or null if the target was invalid.
     */
    NotebookInterpreter getInstance(final File target, final File workingDirectory, boolean newNotebook);

    //endregion

    //region Types

    /**
     * Used to indicate how the Interpreter processes data.
     */
    enum Type {
        /**
         * This interpreter reads from a singular file.
         */
        FILE_BASED,
        /**
         * This interpreter reads from a directory of files.
         */
        DIRECTORY_BASED
    }

    //endregion
}
