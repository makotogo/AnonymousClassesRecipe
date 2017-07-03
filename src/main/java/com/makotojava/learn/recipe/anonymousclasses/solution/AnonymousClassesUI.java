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
package com.makotojava.learn.recipe.anonymousclasses.solution;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.annotation.WebServlet;

import com.makotojava.learn.recipe.anonymousclasses.AbstractMessageHandler;
import com.makotojava.learn.recipe.anonymousclasses.MessageHandler;
import com.makotojava.learn.recipe.anonymousclasses.MessageLogger;
import com.makotojava.learn.recipe.anonymousclasses.MessageProcessor;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
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
    // Exercise 1 - Add a new ClickListener implementation whose
    /// buttonClick() method:
    /// (a) Creates a message with the handleButton caption, and the messageTextField's value, and
    /// (b) Delegates to a MessageHandler implementation:
    /// - Use AbstractMessageHandler and implement the processMethod
    /// (c) Delegate to handle()
    //
    handleButton.addClickListener(new ClickListener() {
      @Override
      public void buttonClick(ClickEvent event) {
        // Exercise 1a code here
        String message = handleButton.getCaption() + ": " + messageTextField.getValue();
        // Exercise 1b code here
        MessageHandler messageHandler = new AbstractMessageHandler() {
          // Must instantiate any abstract methods in order
          /// to instantiate an abstract class
          @Override
          public void process(String message) {
            Notification.show(message);
          }
        };
        // Exercise 1c code here
        messageHandler.handle(message);
      }
    });

    // When the user clicks this button, the MessageProcessor is
    /// used to process the message.
    Button processButton = new Button("Process Message");
    //
    // Exercise 2 - Add a new ClickListener implementation whose
    /// implementation uses a lambda expression to provide the ClickListener.buttonClick()
    /// method:
    /// (a) Creates a message with the processButton caption, and the messageTextField's value, and
    /// (b) Delegates to a MessageProcessor implementation:
    /// - Flesh out the getter method called getMessageProcessor() to return a MessageProcessor implementation,
    /// (c) Delegate to getMessageProcessor().process()
    //
    processButton.addClickListener(dummyVariable -> {
      // Exercise 2a code here
      String message = processButton.getCaption() + ": " + messageTextField.getValue();
      // Exercise 2b and 2c code here
      getMessageProcessor().process(message);
      // Bonus exercise 4 here
      getMessageProcessorLambda().process(message);
    });

    // When the user clicks this button, the MessageLogger is
    /// used to log the message.
    Button logButton = new Button("Log Message");
    //
    // Exercise 3 - Add a new ClickListener implementation whose
    /// implementation uses a lambda expression to provide the ClickListener.buttonClick()
    /// method:
    /// (a) Creates a message with the logButton caption, and the messageTextField's value, and
    /// (b) Delegates to a LogProcessor implementation:
    /// - Flesh out the getter method called getLogProcessor() to return a LogProcessor implementation,
    /// (c) Delegate to getLogProcessor().process()
    //
    logButton.addClickListener(dummyVariable -> {
      // Exercise 3a code here
      String message = "Logged Message: " + messageTextField.getValue();
      // Exercise 3b and 3c code here
      getMessageLogger().log(message);
    });

    // Add all of the components to the layout in one call.
    layout.addComponents(messageTextField, handleButton, processButton, logButton);

    // Set the content of this UI to the layout we have been working on
    setContent(layout);
  }

  /**
   * Private getter, returns a MessageProcessor implementation.
   * 
   * This getter accompanies Exercise 2b
   * 
   * @return MessageProcessor implementation
   */
  private MessageProcessor getMessageProcessor() {
    //
    // Exercise 2b code here
    return new MessageProcessor() {
      @Override
      public void process(String message) {
        Notification.show(message);
      }
    };
  }

  /**
   * Private getter, returns a MessageLogger implementation.
   * 
   * This getter accompanies Exercise 3b
   * 
   * @return MessageLogger implementation
   */
  private MessageLogger getMessageLogger() {
    // Exercise 3b code here.
    // Use a lambda expression to call Logger.getAnonymousLogger()
    /// and log the message at Level.INFO.
    return message -> Logger.getAnonymousLogger().log(Level.INFO, message);
  }

  /**
   * Private getter, returns a MessageProcessor implementation
   * as a lambda expression.
   * 
   * Bonus exercise 4
   * 
   * @return MessageProcessor implementation
   */
  private MessageProcessor getMessageProcessorLambda() {
    // Bonus exercise 4 code here.
    // Use Notification.show(), and Type.TRAY_NOTIFICATION so it
    /// displays in the Tray
    return message -> Notification.show(message, Type.TRAY_NOTIFICATION);
  }

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
}
