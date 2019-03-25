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

package local.example.draft.ui.view

import com.vaadin.icons.VaadinIcons
import com.vaadin.navigator.View
import com.vaadin.navigator.ViewChangeListener
import com.vaadin.spring.annotation.SpringComponent
import com.vaadin.spring.annotation.SpringView
import com.vaadin.spring.annotation.UIScope
import com.vaadin.ui.Button
import com.vaadin.ui.Label
import com.vaadin.ui.Notification
import com.vaadin.ui.VerticalLayout
import com.vaadin.ui.themes.ValoTheme
import javax.annotation.PostConstruct
import local.example.draft.retrieve.RestRetrieve

@SpringComponent
@UIScope
@SpringView(name = HexStringRetrieveView.VIEW_NAME)
class HexStringRetrieveView : VerticalLayout(), View {

    private val label: Label
    private val hexStrRetrieveLabel: Label
    private val retrieve: Button
    private val content: VerticalLayout

    private val service: RestRetrieve

    init {
        this.label = Label(TITLE_VIEW)
        this.retrieve = Button("retrieve", VaadinIcons.ABACUS)
        this.hexStrRetrieveLabel = Label("click and view here")
        this.content = VerticalLayout(hexStrRetrieveLabel, retrieve)
        this.service = RestRetrieve()
        /* action click */
        this.retrieve.addClickListener { listener ->
            if (null != listener) {
                try {
                    this.hexStrRetrieveLabel.value = service.hexStringUriResponse()
                } catch (e: Exception) {
                    Notification.show("error occurred",
                            Notification.Type.ERROR_MESSAGE)
                }

            }
        }
    }

    @PostConstruct
    fun init() {
        label.addStyleName(ValoTheme.LABEL_H2)
        this.addComponents(label, content)
        content.setMargin(true)
        content.setSizeFull()
    }

    override fun enter(event: ViewChangeListener.ViewChangeEvent?) = super.enter(event)

    companion object {
        private const val serialVersionUID = -1988391038511295522L
        const val TITLE_VIEW = "Hexadecimal String Retrieve"
        const val VIEW_NAME = "hexstrretrieve"
    }
}
