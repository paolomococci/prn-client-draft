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

package local.example.draft.ui.view;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import javax.annotation.PostConstruct;
import local.example.draft.retrieve.RestRetrieve;

/**
 *
 * @author paolo mococci
 */

@SpringComponent
@UIScope
@SpringView(name = HexStringRetrieveView.VIEW_NAME)
public class HexStringRetrieveView 
        extends VerticalLayout 
        implements View {
    
    private static final long serialVersionUID = -1988391038511295522L;
    public static final String TITLE_VIEW = "Hexadecimal String Retrieve";
    public static final String VIEW_NAME = "hexstrretrieve";
    
    private final Label label;    
    private final Label hexStrRetrieveLabel;
    private final Button retrieve;
    private final VerticalLayout content;
    
    private final RestRetrieve service;

    public HexStringRetrieveView() {
        super();
        this.label = new Label(TITLE_VIEW);
        this.retrieve = new Button("retrieve", VaadinIcons.ABACUS);
        this.hexStrRetrieveLabel = new Label("click and view here");
        this.content = new VerticalLayout(hexStrRetrieveLabel, retrieve);
        this.service = new RestRetrieve();
        /* action click */
        this.retrieve.addClickListener(listener -> {
            if (null != listener) {
                try {
                    this.hexStrRetrieveLabel
                            .setValue(service.hexStringUriResponse());
                } catch (Exception e) {
                    Notification.show("error occurred", 
                            Notification.Type.ERROR_MESSAGE);
                }
            }
        });
    }    
    
    @PostConstruct
    public void init() {
        label.addStyleName(ValoTheme.LABEL_H2);
        this.addComponents(label, content);
        content.setMargin(true);
        content.setSizeFull();
    }
    
    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        View.super.enter(event);
    }
}
