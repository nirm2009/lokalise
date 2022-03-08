//
//  iOSSwiftI18nApp.swift
//  iOSSwiftI18n
//
//  Created by Dasun on 2022-03-06.
//

import SwiftUI
import Lokalise

@main
struct iOSSwiftI18nApp: App {
    init() {
        // OTA /////////////////////////////////////////////
//        Lokalise.shared.setProjectID("<your-project-id>", token:"<your-sdk-token>")
//        Lokalise.shared.swizzleMainBundle()
//
//        NotificationCenter.default.addObserver(forName: UIApplication.didBecomeActiveNotification, object: nil, queue: .main) { _ in
//            Lokalise.shared.checkForUpdates { (updated, errorOrNil) in
//                print("Updated: \(updated)\nError: \(errorOrNil)")
//            }
//        }
        // /////////////////////////////////////////////////
        
//        print(NSLocalizedString("welcome_screen_title", comment: ""))  // 1
//        print(String(localized: "login_button"))  // 2
//        print("""
//        \("welcome_screen_title"~)
//        \("login_button"~)
//        """)
        
        // Pluralization //////////////////
//        print(countApples(of: 0))
//        print(countApples(of: 1))
//        print(countApples(of: 3))
//        print(countApples(of: 16))
        // ////////////////////////////////
        
        // Date and time //////////////////////////////////
//        let currentDate = Date()
//        let dateFormatter = DateFormatter()
//        dateFormatter.locale = Locale(identifier: "ru")
//        dateFormatter.dateStyle = DateFormatter.Style.medium
//        dateFormatter.timeStyle = DateFormatter.Style.medium
//
//        print(dateFormatter.string(from: currentDate))
        // ////////////////////////////////////////////////
    }
    
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
    
    // didFinishLaunchingWithOptions as an alternative /////////////
//    @UIApplicationDelegateAdaptor(AppDelegate.self) var appDelegate
    // ////////////////////////////////////////////////////////////
}

// Introduce a custom postfix operator
postfix operator ~
postfix func ~ (string: String) -> String {
    return NSLocalizedString(string, comment: "")
}

// didFinishLaunchingWithOptions as an alternative ////////////////////////////////////
//class AppDelegate: NSObject, UIApplicationDelegate {
//    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey : Any]? = nil) -> Bool {
//
////        print(NSLocalizedString("welcome_screen_title", comment: ""))
////        print(String(localized: "login_button")) // New in Xcode 13
////        print("""
////        \("welcome_screen_title"~)
////        \("login_button"~)
////        """)
//
//        // OTA - didFinishLaunchingWithOptions alternative ///////////////
//        Lokalise.shared.setProjectID("<your-project-id>", token:"<your-sdk-token>")
//        Lokalise.shared.swizzleMainBundle()
//
//        NotificationCenter.default.addObserver(forName: UIApplication.didBecomeActiveNotification, object: nil, queue: .main) { _ in
//            Lokalise.shared.checkForUpdates { (updated, errorOrNil) in
//                print("Updated: \(updated)\nError: \(errorOrNil)")
//            }
//        }
//        // ///////////////////////////////////////////////////////////////
//
//        return true
//    }
//}

// ///////////////////////////////////////////////////////////////////////////////////

// Pluralization ////////////////////////////////////////
func countApples(of quantity: Int) -> String {
    // Retrieves the localized string for the 'apple_count' key from Localizable.stringdict
    let localizedFormatStr = NSLocalizedString("apple_count", comment: "")
    
    // Uses localizedFormatStr as a format string template and substitutes the value in quantity variable to it
    return String(format: localizedFormatStr, quantity)
}
// //////////////////////////////////////////////////////
