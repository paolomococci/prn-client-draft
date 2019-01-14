/**
 *
 * Copyright 2018 paolo mococci
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
 *
 */

package local.example.draft.ui.view

import com.vaadin.navigator.View
import com.vaadin.navigator.ViewChangeListener
import com.vaadin.spring.annotation.SpringComponent
import com.vaadin.spring.annotation.SpringView
import com.vaadin.spring.annotation.UIScope
import com.vaadin.ui.Label
import com.vaadin.ui.VerticalLayout
import com.vaadin.ui.themes.ValoTheme
import javax.annotation.PostConstruct

@SpringComponent
@UIScope
@SpringView(name = WelcomeView.VIEW_NAME)
class WelcomeView : VerticalLayout(), View {

    private val label: Label
    private val content: VerticalLayout

    init {
        this.label = Label(TITLE_VIEW)
        this.content = VerticalLayout()
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
        private const val serialVersionUID = -5708192920815457495L
        const val TITLE_VIEW = "Welcome"
        const val VIEW_NAME = ""
    }
}
