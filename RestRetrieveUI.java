/**
 * 
 * Copyright 2018 paolo mococci
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * 	   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package local.example.draft.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.spring.navigator.SpringNavigator;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import javax.annotation.PostConstruct;
import local.example.draft.ui.view.DoubleRetrieveView;
import local.example.draft.ui.view.ErrorView;
import local.example.draft.ui.view.WelcomeView;
import local.example.draft.ui.view.HexStringRetrieveView;
import local.example.draft.ui.view.LongRetrieveView;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author paolo mococci
 */

@SpringViewDisplay
@SpringUI(path = "/")
@Theme(value = "valo")
@Title(value = RestRetrieveUI.TITLE)
public class RestRetrieveUI 
        extends UI 
        implements ViewDisplay {
    
    private static final long serialVersionUID = 4292985642137989544L;
    protected static final String TITLE = "Pseudo Random Client";
    protected static final String HTML_TITLE = "<h1><em>Pseudo Random Client</em></h1>";
    protected static final float SIZE_PANEL = 1.0F;
    
    private final Label title;
    private final CssLayout nav;
    private final VerticalLayout main;
    private Panel panel;
    
    @Autowired
    SpringNavigator springNavigator;

    @Autowired
    public RestRetrieveUI() {
        super();
        title = new Label(HTML_TITLE, ContentMode.HTML);
        nav = new CssLayout();
        main = new VerticalLayout();
    }
    
    @PostConstruct
    public void init() {
        springNavigator.setErrorView(ErrorView.class);
        panel = new Panel();
        panel.setSizeFull();
    }

    @Override
    protected void init(VaadinRequest request) 
            throws ExceptionInInitializerError {
        nav.addStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
        nav.addComponent(setNavButton(WelcomeView.TITLE_VIEW, WelcomeView.VIEW_NAME));
        nav.addComponent(setNavButton(DoubleRetrieveView.TITLE_VIEW, DoubleRetrieveView.VIEW_NAME));
        nav.addComponent(setNavButton(LongRetrieveView.TITLE_VIEW, LongRetrieveView.VIEW_NAME));
        nav.addComponent(setNavButton(HexStringRetrieveView.TITLE_VIEW, HexStringRetrieveView.VIEW_NAME));
        nav.setVisible(true);
        main.setSizeFull();
        main.addComponents(title, nav, panel);
        main.setExpandRatio(panel, SIZE_PANEL);
        this.setContent(main);
    }

    @Override
    public void showView(View view) {
        panel.setContent((Component)view);
    }
    
    private Button setNavButton(String title, String viewName) {
        Button button = new Button(title);
        button.addClickListener(listener -> {
            this.getUI().getNavigator().navigateTo(viewName);
        });
        return button;
    }
}
