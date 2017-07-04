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

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class AnonymousClassesUI extends UI {

  /**
   * 
   */
  private static final long serialVersionUID = -4170274322690111521L;

  /**
   * This class is the Servlet entry point for the application.
   * 
   * @author JSP
   *
   */
  @WebServlet(urlPatterns = "/*", name = "AnonymousClassesUIServlet", asyncSupported = true)
  @VaadinServletConfiguration(ui = AnonymousClassesUI.class, productionMode = false)
  public static class AnonymousClassesUIServlet extends VaadinServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 6804122840488457954L;
  }

  @SuppressWarnings("serial")
  @Override
  protected void init(VaadinRequest vaadinRequest) {
    // Create the Layout to be used for the UI
    final VerticalLayout layout = new VerticalLayout();

    // The message to be handled goes here
    final TextField messageTextField = new TextField();
    messageTextField.setCaption("Type your message here:");

    // When the user clicks this button, the MessageHandler is used
    /// to handle the message
    Button handleButton = new Button("Handle Message");
    //
    // TODO: Exercise 1 - Add a new ClickListener implementation whose
    /// buttonClick() method:
    /// (a) Creates a message with the handleButton caption, and the messageTextField's value, and
    /// (b) Delegates to a MessageHandler implementation:
    /// - Use AbstractMessageHandler and implement the processMethod
    /// (c) Delegate to handle()
    //
    handleButton.addClickListener(new ClickListener() {
      @Override
      public void buttonClick(ClickEvent event) {
        // TODO: Exercise 1a code here
        // TODO: Exercise 1b code here
        // TODO: Exercise 1c code here
      }
    });

    // When the user clicks this button, the MessageProcessor is
    /// used to process the message.
    Button processButton = new Button("Process Message");
    //
    // TODO: Exercise 2 - Add a new ClickListener implementation whose
    /// implementation uses a lambda expression to provide the ClickListener.buttonClick()
    /// method:
    /// (a) Creates a message with the processButton caption, and the messageTextField's value, and
    /// (b) Delegates to a MessageProcessor implementation:
    /// - Flesh out the getter method called getMessageProcessor() to return a MessageProcessor implementation,
    /// (c) Delegate to getMessageProcessor().process()
    //
    processButton.addClickListener(dummyVariable -> {
      // TODO: Exercise 2a code here
      // TODO: Exercise 2b and 2c code here
      // TODO: Bonus exercise here
    });

    // When the user clicks this button, the MessageLogger is
    /// used to log the message.
    Button logButton = new Button("Log Message");
    //
    // TODO: Exercise 3 - Add a new ClickListener implementation whose
    /// implementation uses a lambda expression to provide the ClickListener.buttonClick()
    /// method:
    /// (a) Creates a message with the logButton caption, and the messageTextField's value, and
    /// (b) Delegates to a LogProcessor implementation:
    /// - Flesh out the getter method called getLogProcessor() to return a LogProcessor implementation,
    /// (c) Delegate to getLogProcessor().process()
    //
    logButton.addClickListener(dummyVariable -> {
      // TODO: Exercise 3a code here
      // TODO: Exercise 3b and 3c code here
    });

    // Add all of the components to the layout in one call.
    layout.addComponents(messageTextField, handleButton, processButton, logButton);

    // Set the content of this UI to the layout we have been working on
    setContent(layout);
  }

  /**
   * Private getter, returns a MessageProcessor implementation.
   * 
   * TODO: This getter accompanies Exercise 2b
   * 
   * @return MessageProcessor implementation
   */
  private MessageProcessor getMessageProcessor() {
    //
    // TODO: Exercise 2b code here
    return null;
  }

  /**
   * Private getter, returns a MessageLogger implementation.
   * 
   * TODO: This getter accompanies Exercise 3b
   * 
   * @return MessageLogger implementation
   */
  private MessageLogger getMessageLogger() {
    // TODO: Exercise 3b code here.
    // Use a lambda expression to call Logger.getAnonymousLogger()
    /// and log the message at Level.INFO.
    return null;
  }

  /**
   * Private getter, returns a MessageProcessor implementation
   * as a lambda expression.
   * 
   * TODO: Bonus exercise
   * 
   * @return MessageProcessor implementation
   */
  private MessageProcessor getMessageProcessorLambda() {
    // TODO: Bonus exercise code here.
    // Use Notification.show(), and Type.TRAY_NOTIFICATION so it
    /// displays in the Tray
    return null;
  }

}
