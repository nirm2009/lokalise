package main

import (
	"fmt"
	"github.com/nicksnyder/go-i18n/v2/i18n"
	"golang.org/x/text/language"
)

var localizer *i18n.Localizer
var bundle *i18n.Bundle

func init() {
	//bundle = i18n.NewBundle(language.English)

	// L10n using message files //////////////////////////
	//bundle.RegisterUnmarshalFunc("json", json.Unmarshal)
	//bundle.LoadMessageFile("resources/en.json")
	//bundle.LoadMessageFile("resources/fr.json")
	//
	//localizer = i18n.NewLocalizer(bundle, language.English.String(), language.French.String())
	//////////////////////////////////////////////////////

	// Use HTTP requests for l10n ////////////////////////
	//http.HandleFunc("/setlang/", SetLangPreferences)
	//http.HandleFunc("/localize/", Localize)
	//
	//http.ListenAndServe(":8080", nil)
	//////////////////////////////////////////////////////
}

func main() {
	// Elementary l10n ///////////////////////////////////
	messageEn := i18n.Message {
		ID: "hello",
		Other: "Hello!",
	}
	messageFr := i18n.Message {
		ID: "hello",
		Other: "Bonjour!",
	}

	bundle := i18n.NewBundle(language.English)
	bundle.AddMessages(language.English, &messageEn)
	bundle.AddMessages(language.French, &messageFr)

	localizer := i18n.NewLocalizer(bundle,
								   language.French.String(),
								   language.English.String())

	localizeConfig := i18n.LocalizeConfig {
		MessageID: "hello",
	}

	localization, _ := localizer.Localize(&localizeConfig)

	fmt.Println(localization)
	//////////////////////////////////////////////////////

	// Default message ///////////////////////////////////
	//defaultmessageEn := i18n.Message{
	//	ID: "welcome",
	//	Other: "Welcome to my app!",
	//}
	//
	//localizeConfigWithDefault := i18n.LocalizeConfig {
	//	MessageID: "welcome",
	//	DefaultMessage: &defaultmessageEn,
	//}
	//
	//localizationReturningDefault, _ := localizer.Localize(&localizeConfigWithDefault)
	//
	//fmt.Println(localizationReturningDefault)
	//////////////////////////////////////////////////////

	// L10n using message files //////////////////////////
	//localizeConfigWelcome := i18n.LocalizeConfig{
	//	MessageID: "welcome",
	//}
	//
	//localizationUsingJson, _ := localizer.Localize(&localizeConfigWelcome)
	//
	//fmt.Println(localizationUsingJson)
	//////////////////////////////////////////////////////

	// Using placeholders ////////////////////////////////
	//bundle := i18n.NewBundle(language.English)
	//localizer := i18n.NewLocalizer(bundle, language.English.String())
	//
	//messageWithPlaceholder := &i18n.Message{
	//	ID: "greeting",
	//	Other: "Hello {{.Name}}!",
	//}
	//
	//localization, _ :=
	//	localizer.Localize(&i18n.LocalizeConfig {
	//		DefaultMessage: messageWithPlaceholder,
	//		TemplateData: map[string]string {
	//			"Name": "Dasun",
	//		},
	//	})
	//
	//fmt.Println(localization)
	//////////////////////////////////////////////////////

	// Using placeholders > Custom template delimiter ////
	//bundle := i18n.NewBundle(language.English)
	//localizer := i18n.NewLocalizer(bundle, language.English.String())
	//
	//messageWithCustomTemplateDelimiter := &i18n.Message{
	//	ID: "greeting",
	//	LeftDelim: "<<",
	//	RightDelim: ">>",
	//	Other: "Hello <<.Name>>!",
	//}
	//
	//localization, _ :=
	//	localizer.Localize(&i18n.LocalizeConfig {
	//		DefaultMessage: messageWithCustomTemplateDelimiter,
	//		TemplateData: map[string]string {
	//			"Name": "Dasun",
	//		},
	//	})
	//
	//fmt.Println(localization)
	//////////////////////////////////////////////////////

	// Pluralization /////////////////////////////////////
	//bundle := i18n.NewBundle(language.English)
	//localizer := i18n.NewLocalizer(bundle, language.English.String())
	//
	//var messageWithPlurals = &i18n.Message{
	//	ID:    "dogrescue",
	//	One:   "{{.Name}} rescued {{.Count}} dog.",
	//	Other: "{{.Name}} rescued {{.Count}} dogs.",
	//}
	//
	//translationOne, _ :=
	//	localizer.Localize(&i18n.LocalizeConfig{
	//		DefaultMessage: messageWithPlurals,
	//		TemplateData: map[string]interface{}{
	//			"Name":  "Ryan Reynolds",
	//			"Count": 1,
	//		},
	//		PluralCount: 1,
	//	})
	//
	//translationMany, _ :=
	//	localizer.Localize(&i18n.LocalizeConfig{
	//		DefaultMessage: messageWithPlurals,
	//		TemplateData: map[string]interface{}{
	//			"Name":  "Kaley Cuoco",
	//			"Count": 2,
	//		},
	//		PluralCount: 2,
	//	})
	//
	//fmt.Println(translationOne)
	//fmt.Println(translationMany)
	//////////////////////////////////////////////////////

	// Date and time > Get current date and time /////////
	//currentTime := time.Now()
	//fmt.Println("Current date-time is:", currentTime.String())
	//////////////////////////////////////////////////////

	// Date and time > Date and time formatting //////////
	//	Mon Jan 2 15:04:05 -0700 MST 2006
	//formattedTime := currentTime.Format("15:04:05 Mon 2 Jan 2006")
	//fmt.Println("Formatted current date-time is:", formattedTime)
	//////////////////////////////////////////////////////
}

//// Use HTTP requests for l10n //////////////////////
//func SetLangPreferences(_ http.ResponseWriter, request *http.Request) {
//	lang := request.FormValue("lang")
//	accept := request.Header.Get("Accept-Language")
//	localizer = i18n.NewLocalizer(bundle, lang, accept)
//}
//
//func Localize(responseWriter http.ResponseWriter, request *http.Request) {
//	valToLocalize := request.URL.Query().Get("msg")
//
//	localizeConfig := i18n.LocalizeConfig{
//		MessageID: valToLocalize,
//	}
//
//	localization, _ := localizer.Localize(&localizeConfig)
//
//	fmt.Fprintln(responseWriter, localization)
//}
//////////////////////////////////////////////////////
