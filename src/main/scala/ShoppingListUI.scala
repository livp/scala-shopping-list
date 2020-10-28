import java.util.regex.Pattern

import Hello.{gui, panel, screen, window}
import com.googlecode.lanterna.{TerminalSize, TextColor}
import com.googlecode.lanterna.gui2.{BasicWindow, DefaultWindowManager, EmptySpace, GridLayout, Label, MultiWindowTextGUI, Panel, TextBox}
import com.googlecode.lanterna.screen.TerminalScreen
import com.googlecode.lanterna.terminal.DefaultTerminalFactory

object ShoppingListUI extends App {
  // Setup terminal and screen layers
  val terminal = new DefaultTerminalFactory().createTerminal()
  val screen = new TerminalScreen(terminal);
  screen.startScreen()

  // Create panel to hold components
  val panel = new Panel();
  panel.setLayoutManager(new GridLayout(2))
  panel.setPreferredSize(new TerminalSize(70, 10))



  InMemoryListEngine.populateSampleRequests

  InMemoryListEngine.requests().foreach(request => {
    val itemTextBox = new TextBox().setText(request._1.name).addTo(panel)
    itemTextBox.setPreferredSize(new TerminalSize(50, 1))
    val countTextBox = new TextBox()
      .setValidationPattern(Pattern.compile("[0-9]*"))
      .setText(request._2.toString)
      .addTo(panel)
  })

  val window = new BasicWindow();
  window.setComponent(panel)

  val gui = new MultiWindowTextGUI(screen, new DefaultWindowManager(), new EmptySpace(TextColor.ANSI.BLUE))
  gui.addWindowAndWait(window)

}
