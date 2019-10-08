import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-combo-box/src/vaadin-combo-box-item.js';

class Test123 extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-combo-box-item></vaadin-combo-box-item>
`;
    }

    static get is() {
        return 'test-123';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(Test123.is, Test123);
