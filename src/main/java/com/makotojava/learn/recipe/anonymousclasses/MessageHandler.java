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

/**
 * Contract that defines how to hand off a String message to be
 * handled.
 * 
 * @author JSP
 *
 */
public interface MessageHandler extends MessageLogger, MessageProcessor {

  /**
   * Handle the specified message
   * 
   * @param message
   *          The message to be handled.
   */
  public void handle(String message);
}
