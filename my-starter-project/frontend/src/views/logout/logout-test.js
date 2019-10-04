import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';

class LogoutTest extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%; align-self: center;" id="vaadinVerticalLayout">
 <h2 id="h2" style="align-self: center">Are you sure you want to logout?</h2>
 <vaadin-horizontal-layout id="vaadinHorizontalLayout" style=" align-self: center;" content="Logout">
  <vaadin-button id="btnLogout">
   Logout
  </vaadin-button>
  <vaadin-horizontal-layout theme="spacing" id="vaadinHorizontalLayout1" style="width: 40px;"></vaadin-horizontal-layout>
  <vaadin-button id="btnReturn" theme="raised primary">
   Cancel
  </vaadin-button>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'logout-test';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(LogoutTest.is, LogoutTest);