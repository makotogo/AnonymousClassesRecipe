/*
 * Copyright 2017 Makoto Consulting Group, Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.makotojava.learn.recipe.anonymousclasses;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Abstract class that handles messages, but only the
 * MessageLogger aspect.
 * 
 * The MessageProcessor aspect is left to subclasses,
 * as it is less predictable what that functionality may look like.
 * 
 * @author JSP
 *
 */
public abstract class AbstractMessageHandler implements MessageHandler {

  private static final Logger log = Logger.getLogger(AbstractMessageHandler.class.getName());

  /**
   * @see com.makotojava.learn.recipe.anonymousclasses.solution.MessageProcessor#process(java.lang.String)
   */
  @Override
  public abstract void process(String message);

  /**
   * @see com.makotojava.learn.recipe.anonymousclasses.solution.MessageLogger#log(java.lang.String)
   */
  @Override
  public void log(String message) {
    log(Level.INFO, "log(): " + message);
  }

  /**
   * Allows finer level of control over the logging.
   * 
   * @param logLevel
   *          The exact Level at which to log the message.
   * 
   * @param message
   *          The message to be logged.
   */
  public void log(Level logLevel, String message) {
    log.log(logLevel, message);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.makotojava.learn.recipe.anonymousclasses.MessageHandler#handle(java.lang.String)
   */
  @Override
  public void handle(String message) {
    log("handle(): " + message);
    process("process(): " + message);
  }

}
