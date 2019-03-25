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
@SpringView
class ErrorView : VerticalLayout(), View {

    val label = Label(TITLE_VIEW)

    @PostConstruct
    fun init() {
        label.addStyleName(ValoTheme.LABEL_FAILURE)
        this.addComponent(label)
    }

    override fun enter(event: ViewChangeListener.ViewChangeEvent?) {}

    companion object {
        private const val serialVersionUID = 3777541009115042345L
        private const val TITLE_VIEW = "Error View"
    }
}
