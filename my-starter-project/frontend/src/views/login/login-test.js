import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-text-field/src/vaadin-email-field.js';
import '@vaadin/vaadin-text-field/src/vaadin-password-field.js';
import '@vaadin/vaadin-login/src/vaadin-login-form.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';

class LoginTest extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
                
                
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%;">
 <h2 style="align-self: center" id="h2">Beverage Buddy Login</h2>
 <vaadin-text-field label="Email:" placeholder="User Email" id="emailInput" required="true" autofocus="true" style="width: 300px; align-self: center" invalid></vaadin-text-field>
 <vaadin-password-field label="Password:" placeholder="Password" id="passInput" required="true" style="width: 300px; align-self: center "></vaadin-password-field>
 <div id="div" style="width: 300px; align-self: center;">
  <vaadin-horizontal-layout style=" justify-content: space-evenly; " id="vaadinHorizontalLayout">
   <vaadin-button id="btnLogin" theme="raised primary">
     Login 
   </vaadin-button>
   <vaadin-button id="btnCancel" theme="raised secondary">
     Cancel 
   </vaadin-button>
  </vaadin-horizontal-layout>
 </div>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'login-test';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(LoginTest.is, LoginTest);
