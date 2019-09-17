//<link rel="import" href="../../../bower_components/polymer/polymer.html">
//<link rel="import" href="../../components/buttons-bar.html">
//<link rel="import" href="../../../bower_components/vaadin-button/src/vaadin-button.html">

import '@vaadin/polymer/polymer.js';
import {ButtonsBar, html} from '@components/components/buttons-bar.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';


   class LoginButtonsBar extends PolymerElement {
    static get template() {
        return html`
    <div>
		<buttons-bar no-top-shadow style="width: 100%;">
		 <vaadin-button id="btnSwitch" slot="left" theme="raised ">
		   Register 
		 </vaadin-button>
		 <vaadin-button id="btnForget" slot="left" theme="raised tertiary small">
		   Forgot password 
		 </vaadin-button>
		 <vaadin-button id="btnSubmit" slot="right" theme="raised primary">
		   Submit 
		 </vaadin-button>
		</buttons-bar>
    </div>`;
        }

//    <script>
       
            static get is() {
                return 'login-buttons-bar';
            }
            static get properties() {
                return {
                    // Declare your properties here.
                };
            }
   }    
        customElements.define(LoginButtonsBar.is, LoginButtonsBar);
//    </script>

