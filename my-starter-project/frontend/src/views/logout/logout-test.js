import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-combo-box/src/vaadin-combo-box.js';

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
 <vaadin-combo-box style="align-self: center; width: 300px"></vaadin-combo-box>
 <vaadin-button id="btnAddAuthors" style="align-self: center; " theme="raised primary">
   Get Authors 
 </vaadin-button>
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
