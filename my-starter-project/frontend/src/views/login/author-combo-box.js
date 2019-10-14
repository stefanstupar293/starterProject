import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-combo-box/src/vaadin-combo-box.js';

class AuthorComboBox extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%; ">
 <h3 style="align-self:center;">Choose an Author:</h3>
 <vaadin-combo-box style="align-self:center;"></vaadin-combo-box>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'author-combo-box';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(AuthorComboBox.is, AuthorComboBox);