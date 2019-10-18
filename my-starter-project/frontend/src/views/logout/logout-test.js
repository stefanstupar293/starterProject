import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-grid/src/vaadin-grid.js';

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
 <div id="div" style="width: 200px; align-self: center;">
  <vaadin-horizontal-layout id="vaadinHorizontalLayout" style=" justify-content: space-evenly; " content="Logout">
   <vaadin-button id="btnLogout">
     Logout 
   </vaadin-button>
   <vaadin-button id="btnReturn" theme="raised primary">
     Cancel 
   </vaadin-button>
  </vaadin-horizontal-layout>
 </div>
 <vaadin-grid id="msggrid"></vaadin-grid>
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
