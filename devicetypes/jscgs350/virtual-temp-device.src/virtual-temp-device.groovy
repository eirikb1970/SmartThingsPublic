/**
 *  Virtuell temperatur for Fibaro multisensor
 *
 *  Copyright 2018 Eirik Klouman Berg
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 */
definition(
    name: "Virtual Temp Device",
    singleInstance: true,
    namespace: "jscgs350",
    author: "jscgs350",
    description: "Virtual Temp Device",
    category: "My Apps",
    iconUrl: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience.png",
    iconX2Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png")

preferences {
    page(name: "mainPage", title: "Virtual Temp Devices", install: true, uninstall: true,submitOnChange: true) {
            section {
                    app(name: "childRules", appName: "Virtual Temp Device Child", namespace: "jscgs350", title: "Create Virtual Temp Device...", multiple: true)
            }
    }
}

def installed() {
    initialize()
}

def updated() {
    unsubscribe()
    initialize()
}

def initialize() {
    childApps.each {child ->
            log.info "Installed Virtual Devices: ${child.label}"
    }
}
