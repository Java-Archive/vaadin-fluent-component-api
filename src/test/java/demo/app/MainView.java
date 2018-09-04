package demo.app;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import static demo.app.MainView.NAV_MAIN_VIEW;

@Route(NAV_MAIN_VIEW)
public class MainView extends Composite<VerticalLayout> {

  public static final String NAV_MAIN_VIEW = "main";

  public MainView() {
    getContent().add(new Span("Main view"));
  }
}
