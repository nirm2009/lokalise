//
//  ContentView.swift
//  iOSSwiftI18n
//
//  Created by Dasun on 2022-03-06.
//

import SwiftUI
import Localize_Swift

struct ContentView: View {
// Language Select /////////////////////////////
    @State var localizedWelcomeText = "welcome_screen_title".localized()
    var body: some View {
        VStack {
            Button("English") {
                Localize.setCurrentLanguage("en")

                self.localizedWelcomeText = "welcome_screen_title".localized()
            }
            Button("German") {
                Localize.setCurrentLanguage("de")

                self.localizedWelcomeText = "welcome_screen_title".localized()
            }
            Button("Russian") {
                Localize.setCurrentLanguage("ru")

                self.localizedWelcomeText = "welcome_screen_title".localized()
            }

            Text(localizedWelcomeText)
        }
        
        // OTA //////////////////////////
//        Text(NSLocalizedString("welcome_screen_title", comment: ""))
        // //////////////////////////////
    }
// /////////////////////////////////////////////
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
